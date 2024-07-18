DROP DATABASE IF EXISTS farmacia;
CREATE DATABASE farmacia;
USE farmacia;

CREATE TABLE pais (
    idPais INT AUTO_INCREMENT,
    nombre VARCHAR(50),
    CONSTRAINT pk_idPais_pais PRIMARY KEY (idPais)
);

CREATE TABLE region (
    idRegion INT AUTO_INCREMENT,
    nombre VARCHAR(50),
    idPais INT,
    CONSTRAINT pk_idRegion_region PRIMARY KEY (idRegion),
    CONSTRAINT fk_idPais_region FOREIGN KEY (idPais) REFERENCES pais(idPais) ON DELETE CASCADE
);


CREATE TABLE ciudad (
    idCiudad INT AUTO_INCREMENT,
    nombre VARCHAR(50),
    idRegion INT,
    CONSTRAINT pk_idCiudad_ciudad PRIMARY KEY (idCiudad),
    CONSTRAINT fk_idRegion_ciudad FOREIGN KEY (idRegion) REFERENCES region(idRegion) ON DELETE CASCADE
);


CREATE TABLE barrio (
    idBarrio INT AUTO_INCREMENT,
    nombre VARCHAR(50),
    idCiudad INT,
    CONSTRAINT pk_idBarrio_barrio PRIMARY KEY (idBarrio),
    CONSTRAINT fk_idCiudad_barrio FOREIGN KEY (idCiudad) REFERENCES ciudad(idCiudad) ON DELETE CASCADE
);


CREATE TABLE tipoDocumento (
    idTipoDocumento INT AUTO_INCREMENT,
    nombre VARCHAR(50),
    CONSTRAINT pk_idTipoDocumento_tipoDocumento PRIMARY KEY (idTipoDocumento)
);

CREATE TABLE cliente (
    idCliente VARCHAR(30) NOT NULL,
    primerNombre VARCHAR(20) NOT NULL,
    segundoNombre VARCHAR(20),
    primerApellido VARCHAR(20) NOT NULL,
    segundoApellido VARCHAR(20),
    edad INT UNSIGNED NOT NULL,
    fechaNacimiento DATE NOT NULL,
    fechaRegistro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    idBarrio INT,
    idTipoDocumento INT NOT NULL,
    CONSTRAINT pk_idCliente_cliente PRIMARY KEY (idCliente),
    CONSTRAINT fk_idTipoDocumento_cliente FOREIGN KEY (idTipoDocumento) REFERENCES tipoDocumento(idTipoDocumento),
    CONSTRAINT fk_idBarrio_cliente FOREIGN KEY (idBarrio) REFERENCES barrio(idBarrio)
);

DELIMITER //
CREATE TRIGGER after_delete_barrio
AFTER DELETE ON barrio
FOR EACH ROW
BEGIN
    UPDATE cliente
    SET idBarrio = NULL
    WHERE idBarrio = OLD.idBarrio;
END //
DELIMITER ;

DELIMITER //
CREATE FUNCTION calcular_edad(fecha_nacimiento DATE)
RETURNS INT
BEGIN
    DECLARE edad INT;
    SET edad = TIMESTAMPDIFF(YEAR, fecha_nacimiento, CURDATE());
    RETURN edad;
END //
DELIMITER ;