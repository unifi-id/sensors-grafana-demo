CREATE TABLE environmental.temperature
(
    id         INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    value      FLOAT     NOT NULL,
    sensor_id  INT       NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE environmental.temperature
    ADD FOREIGN KEY (sensor_id) REFERENCES environmental.sensor (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE;

CREATE UNIQUE INDEX ON environmental.temperature (sensor_id, created_at);
CREATE INDEX ON environmental.temperature (created_at);
