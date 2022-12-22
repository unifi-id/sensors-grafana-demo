CREATE TABLE environmental.sensor_type
(
    id          INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title       VARCHAR(32) NOT NULL UNIQUE,
    description VARCHAR(64)
);
