CREATE TABLE Tarefas (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    status VARCHAR(50)
);