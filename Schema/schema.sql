CREATE TABLE customers (
                           id SERIAL PRIMARY KEY,
                           name VARCHAR(100),
                           email VARCHAR(100) UNIQUE
);

CREATE TABLE accounts (
                          id SERIAL PRIMARY KEY,
                          account_number VARCHAR(20) UNIQUE,
                          balance DECIMAL(10,2),
                          type VARCHAR(20),
                          customer_id INT REFERENCES customers(id)
);
