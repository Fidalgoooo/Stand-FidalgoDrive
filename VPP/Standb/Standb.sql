create database standb;

use standb;

-- Tabela 'carros'
CREATE TABLE carros (
    idCarro INT AUTO_INCREMENT PRIMARY KEY,
    modelo VARCHAR(100),
    ano INT,
    cor VARCHAR(50),
    preco DECIMAL(10,2),
    estado VARCHAR(50),
    numero_chassi VARCHAR(100),
    numero_serie VARCHAR(100)
);

-- Tabela 'vendas'
CREATE TABLE vendas (
    idVenda INT AUTO_INCREMENT PRIMARY KEY,
    dataVenda DATE,
    precoCarro DECIMAL(10,2),
	nome varchar(100),
    modelo varchar(100)
);

-- Tabela 'vendedores'
CREATE TABLE vendedores (
    idVendedor INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    contacto VARCHAR(20),
    email VARCHAR(100),
    nif VARCHAR(20),
    numeroVendas INT
);

CREATE TABLE Login (
    id INT AUTO_INCREMENT PRIMARY KEY ,
    username TEXT NOT NULL,
    password TEXT NOT NULL
);

-- Inserir exemplo de vendedores
INSERT INTO vendedores (nome, contacto, email, nif, numeroVendas)
VALUES 
    ('João Silva', '123456789', 'joao@example.com', '1234567890', 332),
    ('Maria Santos', '987654321', 'maria@example.com', '0987654321', 333),
    ('Pedro Almeida', '111222333', 'pedro@example.com', '1231231234', 400),
    ('Ana Oliveira', '222333444', 'ana@example.com', '2342342345', 290),
    ('Luis Costa', '333444555', 'luis@example.com', '3453453456', 310),
    ('Carla Pereira', '444555666', 'carla@example.com', '4564564567', 275),
    ('Ricardo Nunes', '555666777', 'ricardo@example.com', '5675675678', 350),
    ('Sofia Martins', '666777888', 'sofia@example.com', '6786786789', 315),
    ('Paulo Ribeiro', '777888999', 'paulo@example.com', '7897897890', 340),
    ('Beatriz Fernandes', '888999000', 'beatriz@example.com', '8908908901', 325);

-- Inserir exemplo de carros
INSERT INTO carros (modelo, ano, cor, preco, estado, numero_chassi, numero_serie)
VALUES 
    ('Modelo A', 2020, 'Vermelho', 20000, 'Novo', 'CH123456', 'NS123456'),
    ('Modelo B', 2021, 'Azul', 25000, 'Usado', 'CH654321', 'NS654321'),
    ('Modelo C', 2019, 'Preto', 18000, 'Usado', 'CH112233', 'NS112233'),
    ('Modelo D', 2022, 'Branco', 27000, 'Novo', 'CH223344', 'NS223344'),
    ('Modelo E', 2023, 'Cinza', 30000, 'Novo', 'CH334455', 'NS334455'),
    ('Modelo F', 2021, 'Verde', 22000, 'Usado', 'CH445566', 'NS445566'),
    ('Modelo G', 2020, 'Amarelo', 21000, 'Novo', 'CH556677', 'NS556677'),
    ('Modelo H', 2018, 'Azul', 19000, 'Usado', 'CH667788', 'NS667788'),
    ('Modelo I', 2022, 'Preto', 28000, 'Novo', 'CH778899', 'NS778899'),
    ('Modelo J', 2023, 'Branco', 31000, 'Novo', 'CH889900', 'NS889900');

-- Inserir exemplo de vendas
INSERT INTO vendas (dataVenda, precoCarro, nome, modelo)
VALUES 
    ('2023-05-17', 20000, 'João Silva', 'Modelo A'),
    ('2023-06-01', 25000, 'Maria Santos', 'Modelo B'),
    ('2023-04-15', 18000, 'Pedro Almeida', 'Modelo C'),
    ('2023-07-22', 27000, 'Ana Oliveira', 'Modelo D'),
    ('2023-08-30', 30000, 'Luis Costa', 'Modelo E'),
    ('2023-09-12', 22000, 'Carla Pereira', 'Modelo F'),
    ('2023-10-05', 21000, 'Ricardo Nunes', 'Modelo G'),
    ('2023-11-20', 19000, 'Sofia Martins', 'Modelo H'),
    ('2023-12-10', 28000, 'Paulo Ribeiro', 'Modelo I'),
    ('2024-01-18', 31000, 'Beatriz Fernandes', 'Modelo J');
    
    -- Inserir exemplo de login
INSERT INTO login (username, password)
VALUES 
    ('Afonso','1234');