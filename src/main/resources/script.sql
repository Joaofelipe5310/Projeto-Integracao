CREATE TABLE Linha (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(100) NOT NULL
);

CREATE TABLE Categoria (
                           id SERIAL PRIMARY KEY,
                           name VARCHAR(100) NOT NULL,
                           Linha_id INTEGER NOT NULL REFERENCES Linha(id) ON DELETE CASCADE
);

CREATE TABLE Modelo (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        Categoria_id INTEGER NOT NULL REFERENCES Categoria(id) ON DELETE CASCADE
);

INSERT INTO father (name)
VALUES ('Cronos')
    RETURNING id;

INSERT INTO Linha (name, id)
VALUES ('Ares', 2);

INSERT INTO Categoria (name, Linha_id) VALUES ('Cronos Old', 1);
INSERT INTO Categoria (name, Linha_id) VALUES ('Cronos L', 1);
INSERT INTO Categoria (name, Linha_id) VALUES ('Cronos-NG', 1);

INSERT INTO Categoria (name, Linha_id) VALUES ('Ares TB', 2);
INSERT INTO Categoria (name, Linha_id) VALUES ('Ares THS', 2);

INSERT INTO Modelo (name, Categoria_id) VALUES ('Cronos 6001-A', 1);
INSERT INTO Modelo (name, Categoria_id) VALUES ('Cronos 6003', 1);
INSERT INTO Modelo (name, Categoria_id) VALUES ('Cronos 7023', 1);

INSERT INTO Modelo (name, Categoria_id) VALUES ('Cronos 6021L', 2);
INSERT INTO Modelo (name, Categoria_id) VALUES ('Cronos 7023L', 2);

INSERT INTO Modelo (name, Categoria_id) VALUES ('Cronos 6001-NG', 3);
INSERT INTO Modelo (name, Categoria_id) VALUES ('Cronos 6003-NG', 3);
INSERT INTO Modelo (name, Categoria_id) VALUES ('Cronos 6021-NG', 3);
INSERT INTO Modelo (name, Categoria_id) VALUES ('Cronos 6031-NG', 3);
INSERT INTO Modelo (name, Categoria_id) VALUES ('Cronos 7021-NG', 3);
INSERT INTO Modelo (name, Categoria_id) VALUES ('Cronos 7023-NG', 3);

INSERT INTO Modelo (name, Categoria_id) VALUES ('Ares 7021', 4);
INSERT INTO Modelo (name, Categoria_id) VALUES ('Ares 7031', 4);
INSERT INTO Modelo (name, Categoria_id) VALUES ('Ares 7023', 4);

INSERT INTO Modelo (name, Categoria_id) VALUES ('Ares 8023 15', 5);
INSERT INTO Modelo (name, Categoria_id) VALUES ('Ares 8023 200', 5);
INSERT INTO Modelo (name, Categoria_id) VALUES ('Ares 8023 2,5', 5);

SELECT
    Linha.id   AS Linha_id,
    Linha.name AS Linha_name,

    Categoria.id    AS Categoria_id,
    Categoria.name  AS Categoria_name,

    Modelo.id   AS Modelo_id,
    Modelo.name AS Modelo_name

FROM Linha

         INNER JOIN Categoria
                    ON Categoria.Linha_id = Linha.id

         INNER JOIN Modelo
                    ON Modelo.Categoria_id = Categoria.id;
