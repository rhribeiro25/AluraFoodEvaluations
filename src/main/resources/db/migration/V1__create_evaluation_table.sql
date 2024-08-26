CREATE TABLE IF NOT EXISTS evaluations (
  id bigint GENERATED ALWAYS AS identity
  	CONSTRAINT pk_evaluation
  		primary key,
  status varchar(255) NOT NULL,
  product_id bigint NOT NULL,
  points decimal(19,2) NOT NULL,
  comment varchar(256)
);