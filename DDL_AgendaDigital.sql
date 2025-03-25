CREATE DATABASE comercioSA;

USE comercioSA;

CREATE TABLE cliente (
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    dt_nascimento DATE NOT NULL
);

CREATE TABLE endereco (
    id_endereco INT PRIMARY KEY AUTO_INCREMENT,
    cep VARCHAR(8) NOT NULL,
    logadouro VARCHAR(200) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cidade VARCHAR(150) NOT NULL,
    estado VARCHAR(100) NOT NULL,
    pais VARCHAR(100) NOT NULL
);

CREATE TABLE contato (
    id_contato INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    valor VARCHAR(100) NOT NULL,
    observacao VARCHAR(255),
    CONSTRAINT fk_contato_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

CREATE TABLE cliente_endereco (
    id_cliete_endereco INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT NOT NULL,
    id_endereco INT NOT NULL,
    numero INT NOT NULL, 
    CONSTRAINT fk_cliente_endereco_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
    CONSTRAINT fk_cliente_endereco_endereco FOREIGN KEY (id_endereco) REFERENCES endereco(id_endereco)
);
