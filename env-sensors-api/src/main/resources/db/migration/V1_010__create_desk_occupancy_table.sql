CREATE TABLE environmental.desk_occupancy
(
    id         INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    is_present BOOLEAN   NOT NULL,
    sensor_id  INT       NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE environmental.desk_occupancy
    ADD FOREIGN KEY (sensor_id) REFERENCES environmental.sensor (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE;

CREATE UNIQUE INDEX ON environmental.desk_occupancy (sensor_id, created_at);
CREATE INDEX ON environmental.desk_occupancy (created_at);
