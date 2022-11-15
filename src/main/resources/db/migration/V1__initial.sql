CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS customers (
    id uuid DEFAULT uuid_generate_v4() PRIMARY KEY,
    username VARCHAR NOT NULL,
    email VARCHAR,
    telegram_username VARCHAR
);

CREATE TABLE IF NOT EXISTS books (
    id uuid DEFAULT uuid_generate_v4() PRIMARY KEY,
    name VARCHAR NOT NULL,
    author_name VARCHAR NOT NULL default 'anonymous author',
    is_rented boolean default false
);

CREATE TABLE IF NOT EXISTS orders (
    id uuid DEFAULT uuid_generate_v4() PRIMARY KEY,
    customer_id uuid REFERENCES customers(id),
    book_id uuid REFERENCES books(id),
    date_of_creation timestamp with time zone NOT NULL default CURRENT_TIMESTAMP,
    date_of_expiration timestamp with time zone,
    is_active boolean default true
);

CREATE TABLE IF NOT EXISTS book_genres (
    book_id uuid REFERENCES books(id),
    genre VARCHAR NOT NULL
);