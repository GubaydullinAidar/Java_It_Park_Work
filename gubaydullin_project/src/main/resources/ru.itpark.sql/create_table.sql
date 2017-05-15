CREATE TABLE bank_users (
  id SERIAL PRIMARY KEY ,
  name VARCHAR(30),
  mail VARCHAR(30)
);

CREATE TABLE users_card (
  owner_id INTEGER REFERENCES bank_users(id),
  cards INTEGER
);