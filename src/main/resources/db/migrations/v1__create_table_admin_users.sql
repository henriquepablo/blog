CREATE TABLE AdminUsers (
    INT id PRIMARY KEY UNIQUE NOT NULL,
    VARCHAR(255) email UNIQUE NOT NULL,
    VARCHAR(255) password NOT NULL,
    VARCHAR(30) role NOT NULL
);