-- Connect to your database 'app-cotacao' before running this script.
-- For example, using psql: \c app-cotacao

CREATE TABLE Usuario (
    id_usuario SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE Empresa (
    id_empresa SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE Escola (
    id_escola SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    endereco VARCHAR(100) NOT NULL
);

CREATE TABLE Cliente (
    id_cliente SERIAL PRIMARY KEY,
    id_usuario INTEGER UNIQUE NOT NULL,
    CONSTRAINT fk_cliente_usuario FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);

CREATE TABLE Dependente (
    id_dependente SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    id_cliente INTEGER NOT NULL,
    CONSTRAINT fk_dependente_cliente FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente)
);

CREATE TABLE Funcionario (
    id_funcionario SERIAL PRIMARY KEY,
    id_usuario INTEGER NOT NULL,
    id_empresa INTEGER NOT NULL,
    id_escola INTEGER,
    CONSTRAINT fk_funcionario_usuario FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario),
    CONSTRAINT fk_funcionario_empresa FOREIGN KEY (id_empresa) REFERENCES Empresa(id_empresa),
    CONSTRAINT fk_funcionario_escola FOREIGN KEY (id_escola) REFERENCES Escola(id_escola)
);

CREATE TABLE Material (
    id_material SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE Material_Empresa (
    id_empresa INTEGER NOT NULL,
    id_material INTEGER NOT NULL,
    modelo VARCHAR(255),
    preco DECIMAL(10,2),
    desconto DECIMAL(5,2),
    observacoes VARCHAR(100),
    PRIMARY KEY (id_empresa, id_material),
    CONSTRAINT fk_material_empresa_empresa FOREIGN KEY (id_empresa) REFERENCES Empresa(id_empresa),
    CONSTRAINT fk_material_empresa_material FOREIGN KEY (id_material) REFERENCES Material(id_material)
);

CREATE TABLE ListaPadrao (
    id_lista SERIAL PRIMARY KEY,
    ano INTEGER NOT NULL,
    serie VARCHAR(50) NOT NULL,
    professor VARCHAR(255),
    observacoes VARCHAR(100),
    descricao VARCHAR(100),
    id_escola INTEGER NOT NULL,
    CONSTRAINT fk_listapadrao_escola FOREIGN KEY (id_escola) REFERENCES Escola(id_escola)
);

CREATE TABLE ListaPropria (
    id_lista_propria SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    id_cliente INTEGER NOT NULL,
    CONSTRAINT fk_listapropria_cliente FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente)
);

CREATE TABLE ListaPropria_Material (
    id_lista_propria INTEGER NOT NULL,
    id_material INTEGER NOT NULL,
    PRIMARY KEY (id_lista_propria, id_material),
    CONSTRAINT fk_listapropria_material_lista FOREIGN KEY (id_lista_propria) REFERENCES ListaPropria(id_lista_propria),
    CONSTRAINT fk_listapropria_material_material FOREIGN KEY (id_material) REFERENCES Material(id_material)
);

CREATE TABLE ListaPadrao_Material (
    id_lista INTEGER NOT NULL,
    id_material INTEGER NOT NULL,
    PRIMARY KEY (id_lista, id_material),
    CONSTRAINT fk_listapadrao_material_lista FOREIGN KEY (id_lista) REFERENCES ListaPadrao(id_lista),
    CONSTRAINT fk_listapadrao_material_material FOREIGN KEY (id_material) REFERENCES Material(id_material)
);

CREATE TABLE MateriaisEscolhidos (
    id_cliente INTEGER NOT NULL,
    id_material INTEGER NOT NULL,
    PRIMARY KEY (id_cliente, id_material),
    CONSTRAINT fk_materiais_escolhidos_cliente FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
    CONSTRAINT fk_materiais_escolhidos_material FOREIGN KEY (id_material) REFERENCES Material(id_material)
);