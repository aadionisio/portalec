CREATE TABLE public.tb_marca (
	id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	descricao varchar(50) NOT NULL,
	CONSTRAINT tb_marca_pk PRIMARY KEY (id)
);
