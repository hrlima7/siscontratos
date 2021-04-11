create table contrato(
	id INT NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(50),
    contratante VARCHAR(100) NOT NULL,
    prazo_inicial INT,
    data_Inicio DATE,
    data_Final DATE,
    vl_global DOUBLE,
    PRIMARY KEY (id)
)

