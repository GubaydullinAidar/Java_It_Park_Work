CREATE DATABASE gubaydullin_project;

CREATE TABLE bank_users (
  id SERIAL PRIMARY KEY ,
  name VARCHAR(30) NOT NULL,
  mail VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE users_accounts (
  owner_id INTEGER REFERENCES bank_users(id),
  account INTEGER NOT NULL UNIQUE,
  balance INTEGER NOT NULL DEFAULT 0
);
