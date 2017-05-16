CREATE TABLE users_accounts (
  owner_id INTEGER,
  account INTEGER NOT NULL UNIQUE,
  balance INTEGER NOT NULL DEFAULT 0
);