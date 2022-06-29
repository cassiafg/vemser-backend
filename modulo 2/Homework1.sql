CREATE TABLE VEMSER_CASSIA.ESTUDANTE(
	id NUMBER NOT NULL,
	nome VARCHAR2(200) NOT NULL,
	data_nascimento DATE NOT NULL,
	nr_matricula NUMBER(10) UNIQUE NOT NULL,
	ativo CHAR(1) NOT NULL,
	PRIMARY KEY (id)
);

CREATE SEQUENCE VEMSER_CASSIA.SEQ_ESTUDANTE
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

INSERT INTO VEMSER_CASSIA.ESTUDANTE(id, nome, data_nascimento, nr_matricula, ativo)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Pedro', TO_DATE('01-12-1980', 'dd-mm-yyyy'), 1352478410, 's');

INSERT INTO VEMSER_CASSIA.ESTUDANTE(id, nome, data_nascimento, nr_matricula, ativo)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Joana', TO_DATE('13-12-1995', 'dd-mm-yyyy'), 1985253640, 's');

INSERT INTO VEMSER_CASSIA.ESTUDANTE(id, nome, data_nascimento, nr_matricula, ativo)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Bruna', TO_DATE('01-11-1982', 'dd-mm-yyyy'), 1570520369, 'n');

INSERT INTO VEMSER_CASSIA.ESTUDANTE(id, nome, data_nascimento, nr_matricula, ativo)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Amanda', TO_DATE('12-09-1987', 'dd-mm-yyyy'), 1896320482, 'n');

INSERT INTO VEMSER_CASSIA.ESTUDANTE(id, nome, data_nascimento, nr_matricula, ativo)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Jorge', TO_DATE('05-04-1999', 'dd-mm-yyyy'), 1580752014, 's');

INSERT INTO VEMSER_CASSIA.ESTUDANTE(id, nome, data_nascimento, nr_matricula, ativo)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Marcos', TO_DATE('10-05-1992', 'dd-mm-yyyy'), 1520874108, 's');

INSERT INTO VEMSER_CASSIA.ESTUDANTE(id, nome, data_nascimento, nr_matricula, ativo)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Otávio', TO_DATE('01-12-1985', 'dd-mm-yyyy'), 1582042896, 'n');

INSERT INTO VEMSER_CASSIA.ESTUDANTE(id, nome, data_nascimento, nr_matricula, ativo)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Roberto', TO_DATE('03-07-1988', 'dd-mm-yyyy'), 1874052368, 's');

INSERT INTO VEMSER_CASSIA.ESTUDANTE(id, nome, data_nascimento, nr_matricula, ativo)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Jonas', TO_DATE('05-02-1997', 'dd-mm-yyyy'), 1475287413, 'n');

INSERT INTO VEMSER_CASSIA.ESTUDANTE(id, nome, data_nascimento, nr_matricula, ativo)
VALUES (SEQ_ESTUDANTE.NEXTVAL, 'Tatiane', TO_DATE('03-08-1991', 'dd-mm-yyyy'), 1452874632, 's');

SELECT * FROM VEMSER_CASSIA.ESTUDANTE;
