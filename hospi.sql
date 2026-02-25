CREATE DATABASE  IF NOT EXISTS hospital;
USE hospital;

CREATE TABLE IF NOT EXISTS medico (
  idmedico int NOT NULL AUTO_INCREMENT,
  nombre varchar(80) NOT NULL,
  especialidad varchar(45) NOT NULL,
  tel varchar(10) NOT NULL,
  PRIMARY KEY (idmedico)
) ENGINE=InnoDB;



CREATE TABLE IF NOT EXISTS paciente (
  idpaciente int NOT NULL AUTO_INCREMENT,
  nombre varchar(80) NOT NULL,
  edad tinyint(4) NOT NULL,
  sex varchar(10) NOT NULL,
  direccion varchar(100) NOT NULL,
  tel varchar(10) NOT NULL,
  PRIMARY KEY (idpaciente)
) ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS consulta (
  idconsulta int NOT NULL AUTO_INCREMENT,
  hora timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  idpaciente int NOT NULL,
  idmedico int NOT NULL,
  consultorio varchar(45) NOT NULL,
  PRIMARY KEY (idconsulta),
  INDEX con_per (idpaciente ASC),
  INDEX con_med (idmedico ASC),
  CONSTRAINT consul_med 
    FOREIGN KEY (idmedico) 
    REFERENCES medico (idmedico) 
    ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT consul_pac 
    FOREIGN KEY (idpaciente) 
    REFERENCES paciente (idpaciente) 
    ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB;