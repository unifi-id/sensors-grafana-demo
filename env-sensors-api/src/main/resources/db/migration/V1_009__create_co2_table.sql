CREATE TABLE environmental.co2
(
    id         INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    value      FLOAT     NOT NULL,
    sensor_id  INT       NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE environmental.co2
    ADD FOREIGN KEY (sensor_id) REFERENCES environmental.sensor (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE;

CREATE UNIQUE INDEX ON environmental.co2 (sensor_id, created_at);
CREATE INDEX ON environmental.co2 (created_at);
