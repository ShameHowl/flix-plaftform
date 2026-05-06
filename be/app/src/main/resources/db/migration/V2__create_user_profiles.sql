CREATE TABLE user_profiles
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    avatar_url VARCHAR(255) NULL,
    full_name  VARCHAR(255) NULL,
    user_id    BIGINT NULL,
    CONSTRAINT pk_user_profiles PRIMARY KEY (id)
);

ALTER TABLE user_profiles
    ADD CONSTRAINT uc_user_profiles_user UNIQUE (user_id);

ALTER TABLE user_profiles
    ADD CONSTRAINT FK_USER_PROFILES_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);