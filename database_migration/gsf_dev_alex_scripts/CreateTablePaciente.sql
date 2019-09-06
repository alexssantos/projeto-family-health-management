DROP TABLE IF EXISTS paciente;

CREATE TABLE paciente (
  id_paciente int(11) NOT NULL 
	PRIMARY KEY AUTO_INCREMENT, 
  nome varchar(45) NOT NULL,
  data_nascimento datetime DEFAULT NULL,
  data_gravidez date DEFAULT NULL      
);

LOCK TABLES paciente WRITE;

UNLOCK TABLES;