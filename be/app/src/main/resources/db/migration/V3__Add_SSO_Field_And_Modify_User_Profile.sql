ALTER TABLE users
    ADD auth_provider VARCHAR(255) NULL;

ALTER TABLE user_profiles
    ADD phone_number VARCHAR(15) NULL;

ALTER TABLE user_profiles
    MODIFY full_name VARCHAR (100);

ALTER TABLE user_profiles
    MODIFY full_name VARCHAR (100) NOT NULL;

ALTER TABLE users
    MODIFY password VARCHAR (255) NULL;