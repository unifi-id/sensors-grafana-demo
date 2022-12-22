CREATE TABLE environmental.motion
(
    id         INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    is_present BOOLEAN   NOT NULL,
    sensor_id  INT       NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE environmental.motion
    ADD FOREIGN KEY (sensor_id) REFERENCES environmental.sensor (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE;

CREATE UNIQUE INDEX ON environmental.motion (sensor_id, created_at);
CREATE INDEX ON environmental.motion (created_at);
