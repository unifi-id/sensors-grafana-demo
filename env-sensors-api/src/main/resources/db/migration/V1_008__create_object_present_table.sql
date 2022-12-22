CREATE TABLE environmental.object_present
(
    id         INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    is_present BOOLEAN   NOT NULL,
    sensor_id  INT       NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE environmental.object_present
    ADD FOREIGN KEY (sensor_id) REFERENCES environmental.sensor (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE;

CREATE UNIQUE INDEX ON environmental.object_present (sensor_id, created_at);
CREATE INDEX ON environmental.object_present (created_at);
