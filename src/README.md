```roomsql
-- Crear la tabla Cliente
CREATE TABLE Cliente (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    edad INT NOT NULL
);

-- Crear la tabla Producto (tabla base para los tipos de productos)
CREATE TABLE Producto (
    id SERIAL PRIMARY KEY,
    descripcion VARCHAR(255) NOT NULL
);

-- Crear la tabla ProductoAlimenticio, que hereda de Producto
CREATE TABLE ProductoAlimenticio (
    id SERIAL PRIMARY KEY,
    aporte_calorico FLOAT NOT NULL,
    CONSTRAINT fk_producto FOREIGN KEY (id) REFERENCES Producto(id) ON DELETE CASCADE
);

-- Crear la tabla ProductoElectronico, que hereda de Producto
CREATE TABLE ProductoElectronico (
    id SERIAL PRIMARY KEY,
    volt_input FLOAT NOT NULL,
    CONSTRAINT fk_producto FOREIGN KEY (id) REFERENCES Producto(id) ON DELETE CASCADE
);

-- Crear la tabla Pedido
CREATE TABLE Pedido (
    id SERIAL PRIMARY KEY,
    calle VARCHAR(255) NOT NULL,
    fecha DATE NOT NULL,
    ciudad VARCHAR(255) NOT NULL,
    cliente_id INT NOT NULL,
    CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES Cliente(id) ON DELETE CASCADE
);

-- Crear la tabla intermedia para la relación muchos a muchos entre Pedido y Producto
CREATE TABLE Pedido_Producto (
    pedido_id INT NOT NULL,
    producto_id INT NOT NULL,
    PRIMARY KEY (pedido_id, producto_id),
    CONSTRAINT fk_pedido FOREIGN KEY (pedido_id) REFERENCES Pedido(id) ON DELETE CASCADE,
    CONSTRAINT fk_producto FOREIGN KEY (producto_id) REFERENCES Producto(id) ON DELETE CASCADE
);

```