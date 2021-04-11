ALTER TABLE contrato add column idgestao INT;

alter table contrato ADD
CONSTRAINT FK_CONTRATO_GESTAO
FOREIGN KEY (idgestao)
REFERENCES gestao(id);