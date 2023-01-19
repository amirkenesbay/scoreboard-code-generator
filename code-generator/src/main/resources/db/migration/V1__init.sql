CREATE TABLE IF NOT EXISTS scoreboard_schema.scoreboard (
    code_id BIGSERIAL PRIMARY KEY,
    code_name VARCHAR(128) NOT NULL UNIQUE
);

INSERT INTO scoreboard_schema.scoreboard (code_id, code_name) VALUES (1, 'a0a0');

CREATE SEQUENCE scoreboard_schema.scoreboard_seq NO MINVALUE NO MAXVALUE START WITH 2;

ALTER TABLE scoreboard_schema.scoreboard
    ALTER COLUMN code_id SET DEFAULT nextval('scoreboard_schema.scoreboard_seq');

ALTER SEQUENCE scoreboard_schema.scoreboard_seq OWNED BY scoreboard_schema.scoreboard.code_id;