CREATE TABLE categoria (
	id int NOT NULL PRIMARY KEY,
	nome varchar(40) NOT NULL
);

INSERT INTO categoria VALUES (1, 'Alimentos');
INSERT INTO categoria VALUES (2, 'Bebidas');

--SELECT * FROM CATEGORIA 

CREATE TABLE produto (
	id int NOT NULL PRIMARY KEY,
	nome varchar(100) NOT NULL,
	data_cadastro timestamp NOT NULL,
	data_alteracao timestamp,
	categoria int NOT NULL,
	CONSTRAINT fk_produto_categoria FOREIGN KEY (categoria) REFERENCES categoria (id) 
);

INSERT INTO produto VALUES (1, 'Xis Bacon', '2022-09-02', NULL, 1);
INSERT INTO produto VALUES (2, 'Coquinha', '2022-09-03', '2022-09-06', 2);

--SELECT * FROM produto