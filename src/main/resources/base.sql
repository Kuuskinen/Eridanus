DROP TABLE IF EXISTS Observations;

CREATE TABLE Observations
(
    id               INT  NOT NULL PRIMARY KEY,
    planet           TEXT NOT NULL,
    observation_time TIME
);
