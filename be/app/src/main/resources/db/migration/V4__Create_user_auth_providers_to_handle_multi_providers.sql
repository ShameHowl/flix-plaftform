CREATE TABLE user_auth_providers
(
    user_id        BIGINT NOT NULL,
    auth_providers VARCHAR(255) NULL
);

ALTER TABLE users
    ADD is_verified BIT(1) NULL;

ALTER TABLE user_auth_providers
    ADD CONSTRAINT fk_user_auth_providers_on_user FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE users
DROP
COLUMN auth_provider;