CREATE TABLE core.zone
(
    id          INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title       VARCHAR(64) NOT NULL,
    description VARCHAR(64),
    site_id     INT         NOT NULL,
    created_at  TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE core.zone
    ADD FOREIGN KEY (site_id) REFERENCES core.site (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE;

CREATE UNIQUE INDEX ON core.zone (site_id, title);
CREATE INDEX ON core.zone (created_at);

INSERT INTO core.zone(site_id, title)
VALUES (1, 'Default Zone');
