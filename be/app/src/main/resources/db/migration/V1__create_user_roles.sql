CREATE TABLE user_roles
(
    user_id BIGINT       NOT NULL,
    roles   VARCHAR(255) NULL
);

CREATE TABLE users
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime              NOT NULL,
    updated_at datetime              NOT NULL,
    username   VARCHAR(50)           NOT NULL,
    email      VARCHAR(100)          NOT NULL,
    password   VARCHAR(255)          NOT NULL,
    is_enabled BIT(1)                NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE users
    ADD CONSTRAINT uc_users_username UNIQUE (username);

ALTER TABLE user_roles
    ADD CONSTRAINT fk_user_roles_on_user FOREIGN KEY (user_id) REFERENCES users (id);