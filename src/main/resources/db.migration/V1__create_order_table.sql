CREATE TABLE IF NOT EXISTS evaluations (
  id bigint GENERATED ALWAYS AS identity
  	CONSTRAINT pk_evaluation
  		primary key,
  status varchar(255) NOT NULL,
  order_id NOT NULL,
  points decimal(1,2) NOT NULL,
  description varchar(256)
);