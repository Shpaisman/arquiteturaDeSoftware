-- exponegocios.comerciantes definition

-- Drop table

-- DROP TABLE exponegocios.comerciantes;

CREATE TABLE public.comerciantes (
	id bigserial NOT NULL,
	endereco_virtual varchar(255) NULL,
	data_abertura timestamp NULL,
	data_fechamento timestamp NULL,
	nome varchar(255) NOT NULL,
	CONSTRAINT comerciantes_pkey PRIMARY KEY (id),
	CONSTRAINT nome_unique_insert UNIQUE (nome)
);

-- public.comerciante_forma_pagamento definition

-- Drop table

-- DROP TABLE public.comerciante_forma_pagamento;

CREATE TABLE public.comerciante_forma_pagamento (
	comerciante_id int8 NOT NULL,
	formas_pagamento varchar(255) NULL
);


-- public.comerciante_forma_pagamento foreign keys

ALTER TABLE public.comerciante_forma_pagamento ADD CONSTRAINT fk_comerciante_formapagamento FOREIGN KEY (comerciante_id) REFERENCES public.comerciantes(id);