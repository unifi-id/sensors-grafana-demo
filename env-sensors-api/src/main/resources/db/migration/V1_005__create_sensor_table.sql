CREATE TABLE environmental.sensor
(
    id             INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    device_id      VARCHAR(64) NOT NULL,
    title          VARCHAR(64) NOT NULL,
    description    VARCHAR(64),
    zone_id        INT         NOT NULL,
    sensor_type_id INT         NOT NULL,
    created_at     TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE environmental.sensor
    ADD FOREIGN KEY (zone_id) REFERENCES core.zone (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE;

ALTER TABLE environmental.sensor
    ADD FOREIGN KEY (sensor_type_id) REFERENCES environmental.sensor_type (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE;

CREATE UNIQUE INDEX ON environmental.sensor (zone_id, device_id);
CREATE INDEX ON environmental.sensor (created_at);
