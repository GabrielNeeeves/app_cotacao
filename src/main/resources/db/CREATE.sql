-- Utilizando o mecanismo InnoDB para suporte a chave estrangeira

USE `app-cotacao`;

CREATE TABLE Usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE Empresa (
    id_empresa INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE Escola (
    id_escola INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    endereco VARCHAR(100) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE Cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT UNIQUE NOT NULL,
    CONSTRAINT fk_cliente_usuario FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
) ENGINE=InnoDB;

CREATE TABLE Dependente (
    id_dependente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    id_cliente INT NOT NULL,
    CONSTRAINT fk_dependente_cliente FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente)
) ENGINE=InnoDB;

CREATE TABLE Funcionario (
    id_funcionario INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_empresa INT NOT NULL,
    id_escola INT,
    CONSTRAINT fk_funcionario_usuario FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario),
    CONSTRAINT fk_funcionario_empresa FOREIGN KEY (id_empresa) REFERENCES Empresa(id_empresa),
    CONSTRAINT fk_funcionario_escola FOREIGN KEY (id_escola) REFERENCES Escola(id_escola)
) ENGINE=InnoDB;

CREATE TABLE Material (
    id_material INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE Material_Empresa (
    id_empresa INT NOT NULL,
    id_material INT NOT NULL,
    modelo VARCHAR(255),
    preco DECIMAL(10,2),
    desconto DECIMAL(5,2),
    observacoes VARCHAR(100),
    PRIMARY KEY (id_empresa, id_material),
    CONSTRAINT fk_material_empresa_empresa FOREIGN KEY (id_empresa) REFERENCES Empresa(id_empresa),
    CONSTRAINT fk_material_empresa_material FOREIGN KEY (id_material) REFERENCES Material(id_material)
) ENGINE=InnoDB;

CREATE TABLE ListaPadrao (
    id_lista INT AUTO_INCREMENT PRIMARY KEY,
    ano INT NOT NULL,
    serie VARCHAR(50) NOT NULL,
    professor VARCHAR(255),
    observacoes VARCHAR(100),
    descricao VARCHAR(100),
    id_escola INT NOT NULL,
    CONSTRAINT fk_listapadrao_escola FOREIGN KEY (id_escola) REFERENCES Escola(id_escola)
) ENGINE=InnoDB;

CREATE TABLE ListaPropria (
    id_lista_propria INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    id_cliente INT NOT NULL,
    CONSTRAINT fk_listapropria_cliente FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente)
) ENGINE=InnoDB;

CREATE TABLE ListaPropria_Material (
    id_lista_propria INT NOT NULL,
    id_material INT NOT NULL,
    PRIMARY KEY (id_lista_propria, id_material),
    CONSTRAINT fk_listapropria_material_lista FOREIGN KEY (id_lista_propria) REFERENCES ListaPropria(id_lista_propria),
    CONSTRAINT fk_listapropria_material_material FOREIGN KEY (id_material) REFERENCES Material(id_material)
) ENGINE=InnoDB;

CREATE TABLE ListaPadrao_Material (
    id_lista INT NOT NULL,
    id_material INT NOT NULL,
    PRIMARY KEY (id_lista, id_material),
    CONSTRAINT fk_listapadrao_material_lista FOREIGN KEY (id_lista) REFERENCES ListaPadrao(id_lista),
    CONSTRAINT fk_listapadrao_material_material FOREIGN KEY (id_material) REFERENCES Material(id_material)
) ENGINE=InnoDB;

CREATE TABLE MateriaisEscolhidos (
    id_cliente INT NOT NULL,
    id_material INT NOT NULL,
    PRIMARY KEY (id_cliente, id_material),
    CONSTRAINT fk_materiais_escolhidos_cliente FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
    CONSTRAINT fk_materiais_escolhidos_material FOREIGN KEY (id_material) REFERENCES Material(id_material)
) ENGINE=InnoDB;

