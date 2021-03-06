CREATE TABLE PAIS (
	ID_PAIS NUMBER(38) NOT NULL,
	NOME VARCHAR2(50) NOT NULL,
	PRIMARY KEY (ID_PAIS)
);


CREATE TABLE ESTADO (
	ID_ESTADO NUMBER(38) NOT NULL,
	ID_PAIS NUMBER(38) NOT NULL,
	NOME VARCHAR2(50) NOT NULL,
	PRIMARY KEY (ID_ESTADO),
	CONSTRAINT FK_PAIS_ID_PAIS FOREIGN KEY (ID_PAIS) REFERENCES PAIS (ID_PAIS)
);


CREATE TABLE CIDADE (
	ID_CIDADE NUMBER(38) NOT NULL,
	ID_ESTADO NUMBER(38) NOT NULL,
	NOME VARCHAR2(50) NOT NULL,
	CONSTRAINT PK_CIDADE PRIMARY KEY (ID_CIDADE, ID_ESTADO)
);


CREATE TABLE BAIRRO (
	ID_BAIRRO NUMBER(38) NOT NULL,
	ID_CIDADE NUMBER(38) NOT NULL,
	ID_ESTADO NUMBER(38) NOT NULL,
	NOME VARCHAR2(50) NOT NULL,
	CONSTRAINT PK_BAIRRO PRIMARY KEY (ID_BAIRRO, ID_CIDADE),
	CONSTRAINT FK_ESTADO_ID_ESTADO FOREIGN KEY (ID_ESTADO) REFERENCES ESTADO (ID_ESTADO)
);


CREATE TABLE ENDERECO (
	ID_ENDERECO NUMBER(38) NOT NULL,
	ID_BAIRRO NUMBER(38) NOT NULL,
	ID_CIDADE NUMBER(38) NOT NULL,
	LOGRADOURO VARCHAR2(255) NOT NULL,
	NUMERO NUMBER(38) NOT NULL,
	COMPLEMENTO VARCHAR2(100),
	CEP CHAR(9),
	PRIMARY KEY (ID_ENDERECO),
	CONSTRAINT FK_BAIRRO_ID_BAIRRO_ID_CIDADE FOREIGN KEY (ID_BAIRRO, ID_CIDADE) REFERENCES BAIRRO (ID_BAIRRO, ID_CIDADE)
);
