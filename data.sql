CREATE TABLE IF NOT EXISTS  Personne
(
    id            INTEGER PRIMARY KEY,
    nom           VARCHAR(64)       NOT NULL,
    prenom        VARCHAR(64)       NOT NULL,
    dateNaissance VARCHAR(64)       NOT NULL,
);


CREATE TABLE IF NOT EXISTS  Compte
(
    id            INTEGER PRIMARY KEY,
    depotInitial           DECIMAL (64) ,
    personne_id        INTEGER (64)       ,
    dateNaissance VARCHAR(64)       ,
);