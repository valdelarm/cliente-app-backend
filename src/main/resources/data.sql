DROP TABLE IF EXISTS cliente;

CREATE TABLE cliente (
  cliente_id INT AUTO_INCREMENT  PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  id_endereco VARCHAR(250) DEFAULT NULL,
  FOREIGN KEY (id_endereco) REFERENCES endereco(endereco_id)
);


DROP TABLE IF EXISTS endereco;

CREATE TABLE endereco (
  endereco_id INT AUTO_INCREMENT  PRIMARY KEY,
  cep VARCHAR(8) NOT NULL,
  logradouro VARCHAR(100) NOT NULL,
  bairro VARCHAR(100) NOT NULL,
  cidade VARCHAR(50) NOT NULL,
  uf CHAR(2) NOT NULL,
  complemento VARCHAR(100)
);
INSERT INTO billionaires (first_name, last_name, career) VALUES
  ('Aliko', 'Dangote', 'Billionaire Industrialist'),
  ('Bill', 'Gates', 'Billionaire Tech Entrepreneur'),
  ('Folrunsho', 'Alakija', 'Billionaire Oil Magnate');