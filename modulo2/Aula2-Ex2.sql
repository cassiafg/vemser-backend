CREATE SEQUENCE VEMSER_CASSIA.SEQ_PAIS
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

INSERT INTO VEMSER_CASSIA.PAIS (ID_PAIS, NOME)
VALUES (SEQ_PAIS.NEXTVAL, 'BRASIL');

INSERT INTO VEMSER_CASSIA.PAIS (ID_PAIS, NOME)
VALUES (SEQ_PAIS.NEXTVAL, 'ARGENTINA');

CREATE SEQUENCE VEMSER_CASSIA.SEQ_ESTADO
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

INSERT INTO VEMSER_CASSIA.ESTADO (ID_ESTADO, ID_PAIS, NOME)
VALUES (SEQ_ESTADO.NEXTVAL, 1, 'RS');

INSERT INTO VEMSER_CASSIA.ESTADO (ID_ESTADO, ID_PAIS, NOME)
VALUES (SEQ_ESTADO.NEXTVAL, 1, 'SC');

INSERT INTO VEMSER_CASSIA.ESTADO (ID_ESTADO, ID_PAIS, NOME)
VALUES (SEQ_ESTADO.NEXTVAL, 2, 'MENDOZA')

INSERT INTO VEMSER_CASSIA.ESTADO (ID_ESTADO, ID_PAIS, NOME)
VALUES (SEQ_ESTADO.NEXTVAL, 2, 'CORDOBA')

CREATE SEQUENCE VEMSER_CASSIA.SEQ_CIDADE
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

INSERT INTO VEMSER_CASSIA.CIDADE (ID_CIDADE, ID_ESTADO, NOME)
VALUES (SEQ_CIDADE.NEXTVAL, 1, 'PORTO ALEGRE')

INSERT INTO VEMSER_CASSIA.CIDADE (ID_CIDADE, ID_ESTADO, NOME)
VALUES (SEQ_CIDADE.NEXTVAL, 1, 'BENTO GONCALVES')

INSERT INTO VEMSER_CASSIA.CIDADE (ID_CIDADE, ID_ESTADO, NOME)
VALUES (SEQ_CIDADE.NEXTVAL, 2, 'FLORIANOPOLIS')

INSERT INTO VEMSER_CASSIA.CIDADE (ID_CIDADE, ID_ESTADO, NOME)
VALUES (SEQ_CIDADE.NEXTVAL, 2, 'URUBICI')

INSERT INTO VEMSER_CASSIA.CIDADE (ID_CIDADE, ID_ESTADO, NOME)
VALUES (SEQ_CIDADE.NEXTVAL, 3, 'MENDOZA')

INSERT INTO VEMSER_CASSIA.CIDADE (ID_CIDADE, ID_ESTADO, NOME)
VALUES (SEQ_CIDADE.NEXTVAL, 3, 'RIVADAVIA')

INSERT INTO VEMSER_CASSIA.CIDADE (ID_CIDADE, ID_ESTADO, NOME)
VALUES (SEQ_CIDADE.NEXTVAL, 4, 'CORDOBA')

INSERT INTO VEMSER_CASSIA.CIDADE (ID_CIDADE, ID_ESTADO, NOME)
VALUES (SEQ_CIDADE.NEXTVAL, 4, 'OLIVA')

CREATE SEQUENCE VEMSER_CASSIA.SEQ_BAIRRO3
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

INSERT INTO VEMSER_CASSIA.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (SEQ_BAIRRO3.NEXTVAL, 1, 1, 'BONFIM')

INSERT INTO VEMSER_CASSIA.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (SEQ_BAIRRO3.NEXTVAL, 1, 1, 'PETROPOLIS')

INSERT INTO VEMSER_CASSIA.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (SEQ_BAIRRO3.NEXTVAL, 2, 1, 'PANAZZOLO')

INSERT INTO VEMSER_CASSIA.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (SEQ_BAIRRO3.NEXTVAL, 2, 1, 'VINOSUL')

INSERT INTO VEMSER_CASSIA.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (SEQ_BAIRRO3.NEXTVAL, 3, 2, 'AGRONOMICA')

INSERT INTO VEMSER_CASSIA.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (SEQ_BAIRRO3.NEXTVAL, 3, 2, 'COQUEIROS')

INSERT INTO VEMSER_CASSIA.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (SEQ_BAIRRO3.NEXTVAL, 4, 2, 'AVENCAL')

INSERT INTO VEMSER_CASSIA.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (SEQ_BAIRRO3.NEXTVAL, 4, 2, 'CAMPESTRE')

INSERT INTO VEMSER_CASSIA.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (SEQ_BAIRRO3.NEXTVAL, 5, 3, 'MAIPU')

INSERT INTO VEMSER_CASSIA.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (SEQ_BAIRRO3.NEXTVAL, 5, 3, 'CUYO')

INSERT INTO VEMSER_CASSIA.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (SEQ_BAIRRO3.NEXTVAL, 6, 3, 'CARRIZALES')

INSERT INTO VEMSER_CASSIA.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (SEQ_BAIRRO3.NEXTVAL, 6, 3, 'JUAN')

INSERT INTO VEMSER_CASSIA.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (SEQ_BAIRRO3.NEXTVAL, 7, 4, 'ARGUELO')

INSERT INTO VEMSER_CASSIA.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (SEQ_BAIRRO3.NEXTVAL, 7, 4, 'LIBERTADOR')

INSERT INTO VEMSER_CASSIA.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (SEQ_BAIRRO3.NEXTVAL, 8, 4, 'FIORI')

INSERT INTO VEMSER_CASSIA.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (SEQ_BAIRRO3.NEXTVAL, 8, 4, 'GOMEZ')

CREATE SEQUENCE VEMSER_CASSIA.SEQ_ENDERECO1
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 1, 1, 'RUA JOAO TELLES', 504, 'AP 401', '95380000')

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 1, 1, 'RUA FERNANDES VIEIRA', 1010, 'AP 702', '95450000')

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 2, 1, 'AV BAGE', 1610, 'AP 804', '98700410')

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 2, 1, 'RUA CARAZINHO', 1008, 'AP 302', '93285400')

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 3, 2, 'RUA ANTONIO LONGHI', 700, 'AP 100', '90500100')

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 3, 2, 'RUA LUIS MILAN', 800, 'AP 301', '90500500')

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 4, 2, 'RUA BUARQUE DE MACEDO', 700, 'AP 100', '90500100')

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 4, 2, 'RUA VINDIMA', 1000, NULL, NULL)

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 5, 3, 'RUA FREI CANECA', 700, NULL, NULL)

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 5, 3, 'SERVIDAO FRANZONI', 580, NULL, NULL)

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 6, 3, 'RUA DA FONTE', 1000, NULL, NULL)

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 6, 3, 'RUA MIGUEL DAUX', 300, NULL, NULL)

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 7, 4, 'RUA PEDRO CUSTODIO', 500, NULL, NULL)

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 7, 4, 'RUA NEREU RAMOS', 940, NULL, NULL)

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 8, 4, 'AV RODOLFO ANDERMAN', 1000, NULL, NULL)

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 8, 4, 'RUA RIO CANOAS', 144, NULL, NULL)

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 9, 5, 'AV PEDRO MOLINA', 2500, NULL, NULL)

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 9, 5, 'AV PERU', 5000, NULL, NULL)

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 10, 5, 'AV GODOY CRUZ', 310, NULL, NULL)

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 10, 5, 'AV GARIBALDI', 800, NULL, NULL)

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 11, 6, 'CALLE SAN JUAN', 144, NULL, NULL)

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 11, 6, 'CALLE SALTA', 800, NULL, NULL)

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 12, 6, 'AV LAVALLE', 900, NULL, NULL)

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 12, 6, 'CALLE BUENOS AIRES', 750, NULL, NULL)

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 13, 7, 'AV MONTEVIDEO', 4500, NULL, NULL)

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 13, 7, 'CALLE SAN LORENZO', 200, NULL, NULL)

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 14, 7, 'AV LA PAMPA', 310, NULL, NULL)

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 14, 7, 'CALLE MADRID', 750, NULL, NULL)

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 15, 8, 'AV DORREGO', 500, NULL, NULL)

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 15, 8, 'CALLE FORMOSA', 800, NULL, NULL)

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 16, 8, 'CALLE ZAPIOLA', 915, NULL, NULL)

INSERT INTO VEMSER_CASSIA.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (SEQ_ENDERECO1.NEXTVAL, 16, 8, 'AV TUCUMAN', 600, NULL, NULL)
