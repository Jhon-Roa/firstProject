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
    CONSTRAINT fk_idPais_region FOREIGN KEY (idPais) 
    REFERENCES pais(idPais) ON DELETE CASCADE
);


CREATE TABLE ciudad (
    idCiudad INT AUTO_INCREMENT,
    nombre VARCHAR(50),
    idRegion INT,
    CONSTRAINT pk_idCiudad_ciudad PRIMARY KEY (idCiudad),
    CONSTRAINT fk_idRegion_ciudad FOREIGN KEY (idRegion) 
    REFERENCES region(idRegion) ON DELETE CASCADE
);


CREATE TABLE barrio (
    idBarrio INT AUTO_INCREMENT,
    nombre VARCHAR(50),
    idCiudad INT,
    CONSTRAINT pk_idBarrio_barrio PRIMARY KEY (idBarrio),
    CONSTRAINT fk_idCiudad_barrio FOREIGN KEY (idCiudad) 
    REFERENCES ciudad(idCiudad) ON DELETE CASCADE
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
    CONSTRAINT fk_idTipoDocumento_cliente FOREIGN KEY (idTipoDocumento) 
    REFERENCES tipoDocumento(idTipoDocumento),
    CONSTRAINT fk_idBarrio_cliente FOREIGN KEY (idBarrio) 
    REFERENCES barrio(idBarrio)
);

CREATE TABLE laboratorio (
    idLaboratorio INT AUTO_INCREMENT,
    nombre VARCHAR(100),
    idBarrio INT,
    CONSTRAINT pk_idLaboratorio PRIMARY KEY (idLaboratorio),
    CONSTRAINT fk_idBarrio_laboratorio FOREIGN KEY (idBarrio)
    REFERENCES barrio(idBarrio)
);

CREATE TABLE farmacia (
    idFarmacia INT AUTO_INCREMENT,
    nombre VARCHAR(100),
    idBarrio INT,
    direccion VARCHAR(100),
    logoFarmacia MEDIUMBLOB,
    CONSTRAINT pk_idFarmacia PRIMARY KEY (idFarmacia),
    CONSTRAINT fk_idBarrio_farmacia FOREIGN KEY (idBarrio)
    REFERENCES barrio(idBarrio)
);

CREATE TABLE principioActivo (
    idPrincipioActivo INT AUTO_INCREMENT,
    nombre VARCHAR(60),
    CONSTRAINT pk_idPrincipioActivo PRIMARY KEY (idPrincipioActivo)
);

CREATE TABLE viaAdministracion (
    idViaAdministracion INT AUTO_INCREMENT,
    nombre VARCHAR(60),
    CONSTRAINT pk_idViaAdministracion PRIMARY KEY (idViaAdministracion)
);

CREATE TABLE unidadMedida (
    idUnidadMedida INT AUTO_INCREMENT,
    nombre VARCHAR(60),
    CONSTRAINT pk_idUnidadMedida PRIMARY KEY (idUnidadMedida)
);

CREATE TABLE medicina (
    idMedicina INT AUTO_INCREMENT,
    actas VARCHAR(10),
    nombre VARCHAR(100),
    registroSalud VARCHAR(50),
    descripcion VARCHAR(255),
    idViaAdministracion INT,
    idPrincipioActivo INT,
    idUnidadMedida INT,
    idLaboratorio INT,
    CONSTRAINT pk_idMedicina PRIMARY KEY (idMedicina),
    CONSTRAINT fk_idViaAdministracion_medicina FOREIGN KEY (idViaAdministracion)
    REFERENCES viaAdministracion(idViaAdministracion) ON DELETE CASCADE,
    CONSTRAINT fk_idPrincipioActivo_medicina FOREIGN KEY (idPrincipioActivo)
    REFERENCES principioActivo(idPrincipioActivo) ON DELETE CASCADE,
    CONSTRAINT fk_idUnidadMedida_medicina FOREIGN KEY (idUnidadMedida)
    REFERENCES unidadMedida(idUnidadMedida) ON DELETE CASCADE,
    CONSTRAINT fk_idLaboratorio_medicina FOREIGN KEY (idLaboratorio)
    REFERENCES laboratorio(idLaboratorio)
);

CREATE TABLE farmaciaMedicina (
    idFarmacia INT,
    idMedicina INT,
    precio DECIMAL(10,2) UNSIGNED,
    CONSTRAINT pk_idFarmacia_idMedicina PRIMARY KEY (idFarmacia, idMedicina),
    CONSTRAINT fk_idFarmacia_farmaciaMedicina FOREIGN KEY (idFarmacia)
    REFERENCES farmacia(idFarmacia) ON DELETE CASCADE,
    CONSTRAINT fk_idMedicina_farmaciaMedicina FOREIGN KEY (idMedicina)
    REFERENCES medicina(idMedicina) ON DELETE CASCADE
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
CREATE TRIGGER before_delete_laboratorio
BEFORE DELETE ON laboratorio
FOR EACH ROW
BEGIN
    UPDATE medicina
    SET idLaboratorio = NULL
    WHERE idLaboratorio = OLD.idLaboratorio;
END //
DELIMITER;

DELIMITER //
CREATE FUNCTION calcular_edad(fecha_nacimiento DATE)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE edad INT;
    SET edad = TIMESTAMPDIFF(YEAR, fecha_nacimiento, CURDATE());
    RETURN edad;
END //
DELIMITER ;
