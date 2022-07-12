--Homework 3--

--Fazer um RIGHT OUTER JOIN entre tabelas:
  --Pessoa e Contato
SELECT 
     p.Nome, 
     c.Numero
FROM 
     PESSOA p 
     RIGHT OUTER JOIN CONTATO c 
          ON (p.ID_PESSOA = c.ID_PESSOA)

  --Pessoa, PESSOA_X_PESSOA_ENDERECO e Endereco_Pessoa
SELECT 
     p.Nome, 
     pxpe.ID_ENDERECO, 
     ep.Logradouro
FROM 
     PESSOA p 
     RIGHT OUTER JOIN PESSOA_X_PESSOA_ENDERECO pxpe 
          ON(p.ID_PESSOA = pxpe.ID_PESSOA)
     RIGHT OUTER JOIN ENDERECO_PESSOA ep 
          ON (pxpe.ID_ENDERECO = ep.ID_ENDERECO)

  --Todas as tabelas (começano por pessoa)
SELECT 
     p.Nome, 
     c.Numero, 
     pxpe.ID_ENDERECO, 
     ep.Logradouro
FROM 
     PESSOA p 
     RIGHT OUTER JOIN CONTATO c 
          ON (p.ID_PESSOA = c.ID_PESSOA)
     RIGHT OUTER JOIN PESSOA_X_PESSOA_ENDERECO pxpe 
          ON (p.ID_PESSOA = pxpe.ID_PESSOA)
     RIGHT OUTER JOIN ENDERECO_PESSOA ep 
          ON (pxpe.ID_ENDERECO = ep.ID_ENDERECO)

--Fazer um OUTER FULL JOIN entre tabelas:
  --Pessoa e Contato
SELECT 
     p.Nome, 
     c.Numero
FROM 
     PESSOA p 
     FULL OUTER JOIN CONTATO c 
          ON (p.ID_PESSOA = c.ID_PESSOA)

  --Pessoa, PESSOA_X_PESSOA_ENDERECO e Endereco_Pessoa
SELECT 
     p.Nome, 
     pxpe.ID_ENDERECO, 
     ep.Logradouro
FROM 
     PESSOA p 
     FULL OUTER JOIN PESSOA_X_PESSOA_ENDERECO pxpe 
          ON(p.ID_PESSOA = pxpe.ID_PESSOA)
     FULL OUTER JOIN ENDERECO_PESSOA ep 
          ON (pxpe.ID_ENDERECO = ep.ID_ENDERECO)
          
  --Todas as tabelas (começando por pessoa)
SELECT 
     p.Nome,
     c.Numero,
     pxpe.ID_ENDERECO,
     ep.Logradouro
FROM 
     PESSOA p
     FULL OUTER JOIN CONTATO c 
         ON (p.ID_PESSOA = c.ID_PESSOA)
     FULL OUTER JOIN PESSOA_X_PESSOA_ENDERECO pxpe 
         ON (p.ID_PESSOA = pxpe.ID_PESSOA)
     FULL OUTER JOIN ENDERECO_PESSOA ep 
         ON (pxpe.ID_ENDERECO = ep.ID_ENDERECO)

--Utilizando o EXISTS, selecione as pessoas que tem endereço
SELECT 
*
FROM 
PESSOA p
WHERE 
EXISTS (
  SELECT 
  	  * 
  FROM 
      PESSOA_X_PESSOA_ENDERECO pxpe  
  WHERE 
      p.ID_PESSOA = pxpe.ID_PESSOA
)


--Selecione id, nome da tabela pessoa junto com id, logradouro da tabela endereço
SELECT 
p.ID_PESSOA, 
p.Nome || p.ID_PESSOA, 
ep.Logradouro
FROM 
PESSOA p,
ENDERECO_PESSOA ep 
WHERE 
EXISTS (
  SELECT 
      * 
  FROM 
      PESSOA_X_PESSOA_ENDERECO pxpe  
  WHERE 
      p.ID_PESSOA = pxpe.ID_PESSOA
)