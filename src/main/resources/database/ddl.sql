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

CREATE TABLE laboratio (
    idLaboratorio INT AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    idBarrio INT NOT NULL,
    CONSTRAINT pk_idLaboratio_laboratorio PRIMARY KEY (idLaboratorio),
    CONSTRAINT fk_idBarrio_laboratio FOREIGN KEY (idBarrio)
    REFERENCES barrio(idBarrio) ON DELETE CASCADE
);

CREATE TABLE proveedor (
    idProveedor INT AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    idBarrio INT NOT NULL,
    CONSTRAINT pk_idProveedor_proveedor PRIMARY KEY (idProveedor),
    CONSTRAINT fk_idBarrio_proveedor FOREIGN KEY (idBarrio)
    REFERENCES barrio(idBarrio) ON DELETE CASCADE
);

CREATE TABLE categoriaPrincipioActivo (
    idCategoriaPrincipioActivo INT AUTO_INCREMENT,
    nombre VARCHAR(20),
    CONSTRAINT pk_idCategoriaPrincipioActivo_categoriaPrincipioActivo PRIMARY KEY (idCategoriaPrincipioActivo)    
);

CREATE TABLE principioActivo (
    idPrincipioActivo INT AUTO_INCREMENT,
    nombre VARCHAR(20),
    idCategoriaPrincipioActivo INT,
    CONSTRAINT pk_idPrincipioActivo_principioActivo PRIMARY KEY (idPrincipioActivo),
    CONSTRAINT fk_idCategoriaPrincipioActivo_principioActivo FOREIGN KEY (idCategoriaPrincipioActivo)
    REFERENCES categoriaPrincipioActivo(idCategoriaPrincipioActivo) ON DELETE CASCADE
);

CREATE TABLE viaAdministracion (
    idViaAdministracion INT AUTO_INCREMENT,
    nombre VARCHAR(30),
    CONSTRAINT pk_idViaAdministracion_viaAdministracion PRIMARY KEY (idViaAdministracion)
);

CREATE TABLE unidadMedida (
    idUnidadDeMedida INT AUTO_INCREMENT,
    nombre VARCHAR(5),
    CONSTRAINT pk_idUnidadDeMedida_unidadMedida PRIMARY KEY (idUnidadDeMedida)
);

CREATE TABLE presentacion (
    idPresentacion INT AUTO_INCREMENT,
    nombre VARCHAR(50),
    CONSTRAINT pk_idPresentacion_presentacion PRIMARY KEY (idPresentacion)
);

CREATE TABLE producto (
    codigoProducto VARCHAR(30),
    nombre VARCHAR(50) NOT NULL,
    registroInvima VARCHAR(30),
    idViaAdministracion INT NOT NULL,
    idPrincipioActivo INT NOT NULL,
    idUnidadDeMedida INT NOT NULL,
    idPresentacion INT NOT NULL,
    fechaCaducidad DATE NOT NULL,
    stock INT NOT NULL,
    stockMin INT NOT NULL,
    stockMax INT NOT NULL,
    valorVenta DECIMAL(20,2) DEFAULT 0.00,
    CONSTRAINT pk_codigoProducto_producto PRIMARY KEY (codigoProducto),
    CONSTRAINT fk_idViaAdministracion_producto FOREIGN KEY (idViaAdministracion)
    REFERENCES viaAdministracion(idViaAdministracion) ON DELETE CASCADE,
    CONSTRAINT fk_idPrincipioActivo_producto FOREIGN KEY (idPrincipioActivo)
    REFERENCES principioActivo(idPrincipioActivo) ON DELETE CASCADE,
    CONSTRAINT fk_idUnidadDeMedida_producto FOREIGN KEY (idUnidadDeMedida)
    REFERENCES unidadMedida(idUnidadDeMedida) ON DELETE CASCADE,
    CONSTRAINT fk_idPresentacion_producto FOREIGN KEY (idPresentacion)
    REFERENCES presentacion(idPresentacion) ON DELETE CASCADE
);

CREATE TABLE productoProveedor (
    codigoProducto VARCHAR(30),
    idProveedor INT,
    CONSTRAINT pk_productoProveedor PRIMARY KEY (codigoProducto, idProveedor),
    CONSTRAINT fk_codigoProducto_productoProveedor FOREIGN KEY (codigoProducto)
    REFERENCES producto(codigoProducto) ON DELETE CASCADE,
    CONSTRAINT fk_idProveedor_productoProveedor FOREIGN KEY (idProveedor)
    REFERENCES proveedor(idProveedor) ON DELETE CASCADE
);

CREATE TABLE productoLaboratio (
    codigoProducto VARCHAR(30),
    idLaboratorio INT,
    CONSTRAINT productoLaboratio PRIMARY KEY (codigoProducto, idLaboratorio),
    CONSTRAINT fk_codigoProducto_productoLaboratio FOREIGN KEY (codigoProducto)
    REFERENCES producto(codigoProducto) ON DELETE CASCADE,
    CONSTRAINT fk_idLaboratorio_productoLaboratio FOREIGN KEY (idLaboratorio)
    REFERENCES laboratio(idLaboratorio) ON DELETE CASCADE
);

CREATE TABLE historialCompra (
    idCompra INT AUTO_INCREMENT,
    codigoProducto VARCHAR(30) NOT NULL,
    fecha DATE NOT NULL,
    cantidad INT,
    precioCompra DECIMAL(20,2),
    CONSTRAINT pk_idCompra_historialCompra PRIMARY KEY (idCompra),
    CONSTRAINT fk_codigoProducto_historialCompra FOREIGN KEY (codigoProducto)
    REFERENCES producto(codigoProducto) ON DELETE CASCADE 
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
DETERMINISTIC
BEGIN
    DECLARE edad INT;
    SET edad = TIMESTAMPDIFF(YEAR, fecha_nacimiento, CURDATE());
    RETURN edad;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER actualizar_valor_venta
AFTER INSERT ON historialCompra
FOR EACH ROW
BEGIN
    DECLARE nuevo_valor_venta DECIMAL(20, 2);

    SELECT 
        (SUM(cantidad * precioCompra) / SUM(cantidad)) * (1.2)
    INTO 
        nuevo_valor_venta
    FROM 
        historialCompra
    WHERE 
        codigoProducto = NEW.codigoProducto;

    UPDATE Producto
    SET valorVenta = nuevo_valor_venta
    WHERE codigoProducto = NEW.codigoProducto;
END//
DELIMITER ;