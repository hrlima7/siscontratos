create table arquivo_contrato (
	contrato_id int not null,
	nome_arquivo varchar(150) not null,
	descricao varchar(150),
	content_type varchar(80) not null,
	tamanho int not null,
	

primary key (contrato_id),
constraint fk_arquivo_contrato foreign key (contrato_id) references contrato (id)
) engine=InnoDB default charset=utf8