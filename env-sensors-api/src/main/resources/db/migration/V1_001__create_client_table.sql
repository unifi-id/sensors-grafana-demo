CREATE TABLE core.client
(
    id         INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    code       VARCHAR(64) NOT NULL,
    title      VARCHAR(64) NOT NULL,
    created_at TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX ON core.client (created_at);

INSERT INTO core.client(code, title)
VALUES ('test-club', 'Test Club');
