CREATE TYPE users_role AS ENUM ('admin','user');

ALTER TABLE users
ALTER COLUMN role TYPE users_role