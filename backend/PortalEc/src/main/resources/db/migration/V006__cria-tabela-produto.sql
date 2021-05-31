CREATE TABLE public.tb_produto (
	codprod int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	descricao varchar(60) NOT NULL,
	unidade varchar(4) NOT NULL,
	embalagem varchar(15) NOT NULL,
	peso numeric(4,3) NOT NULL,
	departamento_id int8 NOT NULL,
	secao_id int8 NOT NULL,
	marca_id int8 NOT NULL,
	linhaproduto_id int8 NOT NULL,
	dtcadastro date NOT NULL,
	dtultalt date NULL,
	dtexclusao date NULL,
	codfunccad bigint NOT NULL,
	codfuncultalt bigint NULL,
	codfuncexclusao bigint NULL,
	enderecofoto varchar NULL,
	CONSTRAINT tb_produto_pk PRIMARY KEY (codprod),
	CONSTRAINT secao_produto_fk FOREIGN KEY (secao_id) REFERENCES public.tb_secao(id),
	CONSTRAINT departamento_produto_fk FOREIGN KEY (departamento_id) REFERENCES public.tb_departamento(id),
	CONSTRAINT marca_produto_fk FOREIGN KEY (marca_id) REFERENCES public.tb_marca(id),
	CONSTRAINT linhaproduto_produto_fk FOREIGN KEY (linhaproduto_id) REFERENCES public.tb_linhaproduto(id)
);