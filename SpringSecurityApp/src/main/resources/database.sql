-- Table: users
CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
);

--Table roles
CREATE TABLE roles (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

--Table for mapping user and roles: user_roles
CREATE TABLE user_roles (
  user_id INTEGER NOT NULL UNIQUE REFERENCES users(id),
  roles_id INTEGER NOT NULL UNIQUE REFERENCES roles(id)
);

--Insert data
INSERT INTO users VALUES (1, 'proselyte', '$2a$04$nUcZLoRDCFzl6cwsgNVVpeiPGbellIEGldOTUu6jAS8zNev4L2h9.');

INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_roles VALUES (1, 2);