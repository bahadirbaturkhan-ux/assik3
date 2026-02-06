CREATE TABLE customers (
                           id INT PRIMARY KEY,
                           name VARCHAR(100) NOT NULL
);

CREATE TABLE addresses (
                           id INT PRIMARY KEY,
                           city VARCHAR(100),
                           street VARCHAR(100),
                           customer_id INT,
                           FOREIGN KEY (customer_id) REFERENCES customers(id)
);

CREATE TABLE accounts (
                          id INT PRIMARY KEY,
                          account_number VARCHAR(50),
                          balance DOUBLE,
                          type VARCHAR(20),
                          customer_id INT,
                          FOREIGN KEY (customer_id) REFERENCES customers(id)
);


INSERT INTO customers VALUES (1, 'Batyrkhan');
INSERT INTO addresses VALUES (1, 'Almaty', 'Abay street', 1);
INSERT INTO accounts VALUES (1, 'SA-001', 1000, 'SAVINGS', 1);
INSERT INTO accounts VALUES (2, 'CA-002', 500, 'CHECKING', 1);
