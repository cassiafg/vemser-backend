--Aula 3
--Exerc�cio #1

--Atualizar o logradouro e o complemento dos endere�os com id 2 e 3;
UPDATE VEMSER_CASSIA.ENDERECO
SET    LOGRADOURO = 'RUA DOM PEDRO II', COMPLEMENTO = 'APTO 202'
WHERE  ID_ENDERECO = 2 AND ID_ENDERECO = 3;

--Atualizar o n�mero do endere�o onde id � 4 para 999999;
UPDATE VEMSER_CASSIA.ENDERECO 
SET	   NUMERO = 999999
WHERE  ID_ENDERECO = 4;

--Remover o �ltimo registro da tabela endere�o (utilizando a fun��o max);
SELECT MAX(ID_ENDERECO) FROM VEMSER_CASSIA.ENDERECO

DELETE
FROM   VEMSER_CASSIA.ENDERECO
WHERE  ID_ENDERECO = (SELECT MAX(ID_ENDERECO) FROM VEMSER_CASSIA.ENDERECO)

--Remover o endere�o onde o n�mero = 999999;
SELECT *
FROM   VEMSER_CASSIA.ENDERECO e 
WHERE  NUMERO = 999999;

DELETE FROM   VEMSER_CASSIA.ENDERECO
WHERE         NUMERO = 999999;

--Remover 2 registros da tabela endere�o;
DELETE FROM   VEMSER_CASSIA.ENDERECO
WHERE         ID_ENDERECO = 18 AND ID_ENDERECO = 28;