INSERT INTO VEMSER_CASSIA.PESSOA (id_pessoa, nome, DATA_NASCIMENTO, telefone, idade, altura, cpf)
VALUES (01, 'Jo�o', TO_DATE('01-02-1986', 'dd-mm-yyyy'), '988563314', 36, 1.80,'34512348053');

INSERT INTO VEMSER_CASSIA.PESSOA (id_pessoa, nome, DATA_NASCIMENTO, telefone, idade, altura, cpf)
VALUES (02, 'Joaquim', TO_DATE('01-02-1990', 'dd-mm-yyyy'),'986730461', 32, 1.92, '30547895214');

INSERT INTO VEMSER_CASSIA.PESSOA (id_pessoa, nome, DATA_NASCIMENTO, telefone, idade, altura, cpf)
VALUES (03, 'Marina', TO_DATE('01-02-1995', 'dd-mm-yyyy'),'302113460', 27, 1.60, '98625796341');

INSERT INTO VEMSER_CASSIA.PESSOA (id_pessoa, nome, DATA_NASCIMENTO, telefone, idade, altura, cpf)
VALUES (04, 'Thais', TO_DATE('01-02-1994', 'dd-mm-yyyy'),'974155846', 28, 1.72, '60587099632');

SELECT * FROM VEMSER_CASSIA.PESSOA;

UPDATE VEMSER_CASSIA.PESSOA
SET idade = 37
WHERE id_pessoa = 01;

UPDATE VEMSER_CASSIA.PESSOA
SET idade = 33
WHERE id_pessoa = 02;

UPDATE VEMSER_CASSIA.PESSOA
SET idade = 28
WHERE id_pessoa = 03;

UPDATE VEMSER_CASSIA.PESSOA
SET idade = 29
WHERE id_pessoa = 04;

DELETE FROM VEMSER_CASSIA.PESSOA WHERE id_pessoa = 04;

SELECT * FROM VEMSER_CASSIA.PESSOA;

