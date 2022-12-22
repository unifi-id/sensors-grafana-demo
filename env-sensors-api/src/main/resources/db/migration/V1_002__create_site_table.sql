CREATE TABLE core.site
(
    id          INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title       VARCHAR(64) NOT NULL,
    description VARCHAR(64),
    client_id   INT         NOT NULL,
    created_at  TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE core.site
    ADD FOREIGN KEY (client_id) REFERENCES core.client (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE;

CREATE UNIQUE INDEX ON core.site (client_id, title);
CREATE INDEX ON core.site (created_at);

INSERT INTO core.site(client_id, title)
VALUES (1, 'Default Site');
