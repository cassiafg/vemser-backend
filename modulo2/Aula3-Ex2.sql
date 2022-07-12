--Aula 3
--Exercício 2

SELECT *
  FROM VEMSER_CASSIA.PESSOA p 
  
 SELECT *
   FROM VEMSER_CASSIA.CONTATO c 
   
SELECT *
   FROM VEMSER_CASSIA.PESSOA_X_PESSOA_ENDERECO pxpe 

SELECT *
   FROM VEMSER_CASSIA.ENDERECO_PESSOA ep 
   
--Fazer um cross join entre Pessoa e Contato
SELECT P.NOME 
     , c.Numero
FROM             VEMSER_CASSIA.PESSOA  p
  CROSS JOIN     VEMSER_CASSIA.CONTATO c
  
--Fazer um inner join entre tabela Pessoa e Contato
SELECT p.Nome
     , c.Numero
  FROM CONTATO c
  INNER JOIN PESSOA p ON (p.ID_PESSOA = c.ID_PESSOA)
  
--Fazer um inner join entre tabela Pessoa, PESSOA_X_PESSOA_ENDERECO E Endereco_Pessoa
SELECT p.Nome
     , pxpe.ID_ENDERECO
     , ep.Logradouro
  FROM PESSOA p
  INNER JOIN PESSOA_X_PESSOA_ENDERECO pxpe ON(p.ID_PESSOA = pxpe.ID_PESSOA)
  INNER JOIN ENDERECO_PESSOA ep ON (pxpe.ID_ENDERECO = ep.ID_ENDERECO)
  
--Fazer um inner join entre todas as tabelas (começando por Pessoa)
SELECT p.Nome
     , c.Numero
     , pxpe.ID_ENDERECO
     , ep.Logradouro
  FROM PESSOA p
  INNER JOIN CONTATO c ON (p.ID_PESSOA = c.ID_PESSOA)
  INNER JOIN PESSOA_X_PESSOA_ENDERECO pxpe ON (p.ID_PESSOA = pxpe.ID_PESSOA)
  INNER JOIN ENDERECO_PESSOA ep ON (pxpe.ID_ENDERECO = ep.ID_ENDERECO)
  
--Fazer um left join entre tabela Pessoa e Contato
SELECT p.Nome
     , c.Numero
  FROM PESSOA p
  LEFT OUTER JOIN CONTATO c ON (p.ID_PESSOA = c.ID_PESSOA)

  
--Fazer um left join entre tabela Pessoa e PESSOA_X_PESSOA_ENDERECO E Endereco_Pessoa
SELECT p.Nome
     , pxpe.ID_ENDERECO
     , ep.Logradouro
  FROM PESSOA p
  LEFT OUTER JOIN PESSOA_X_PESSOA_ENDERECO pxpe ON(p.ID_PESSOA = pxpe.ID_PESSOA)
  LEFT OUTER JOIN ENDERECO_PESSOA ep ON (pxpe.ID_ENDERECO = ep.ID_ENDERECO)
  
--Fazer um left join entre todas as tabelas (começando por pessoa)
SELECT 
     p.Nome,
     c.Numero,
     pxpe.ID_ENDERECO,
     ep.Logradouro
FROM 
     PESSOA p
     LEFT OUTER JOIN CONTATO c 
         ON (p.ID_PESSOA = c.ID_PESSOA)
     LEFT OUTER JOIN PESSOA_X_PESSOA_ENDERECO pxpe 
         ON (p.ID_PESSOA = pxpe.ID_PESSOA)
     LEFT OUTER JOIN ENDERECO_PESSOA ep 
         ON (pxpe.ID_ENDERECO = ep.ID_ENDERECO)
