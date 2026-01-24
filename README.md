# Bank System API (Assignment 3)

## Project Overview
This project is a console-based Bank System API developed in Java using Object-Oriented Programming principles and JDBC.  
The system works with a real PostgreSQL database and follows a multi-layer architecture.

Architecture:
Controller → Service → Repository → Database

---

## Features
- Create bank accounts (Savings, Checking)
- Deposit and withdraw money
- Store data in PostgreSQL using JDBC
- Input validation and business rules
- Polymorphism and abstraction
- CLI-based demonstration

---

## OOP Design

### Abstract Class
AccountBase  
Fields:
- id
- accountNumber
- balance
- customer

Abstract methods:
- getAccountType()
- calculateMonthlyFee()

Concrete methods:
- deposit()
- withdraw()

---

### Subclasses
- SavingsAccount
- CheckingAccount

Polymorphism is demonstrated by using AccountBase references for different account types.

---

### Composition
Account has a Customer object.

---

### Encapsulation
Fields are protected or private and accessed through getters.

---

## Database Design

### Tables

customers
- id (Primary Key)
- name
- email (UNIQUE)

accounts
- id (Primary Key)
- account_number (UNIQUE)
- balance
- type
- customer_id (Foreign Key → customers.id)

---

### schema.sql

CREATE TABLE customers (
id SERIAL PRIMARY KEY,
name VARCHAR(100) NOT NULL,
email VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE accounts (
id SERIAL PRIMARY KEY,
account_number VARCHAR(20) UNIQUE NOT NULL,
balance DECIMAL(10,2) CHECK (balance >= 0),
type VARCHAR(20),
customer_id INT REFERENCES customers(id)
);

---

## Project Structure
```
bank-system-api
└── src
├── controller
│   └── BankController.java
├── service
│   └── AccountService.java
├── repository
│   └── AccountRepository.java
├── model
│   ├── AccountBase.java
│   ├── SavingsAccount.java
│   ├── CheckingAccount.java
│   └── Customer.java
├── utils
│   └── DatabaseConnection.java
└── Main.java
```
---

## Controller / API Demonstration

The Main class demonstrates:
- Creating customers and accounts
- Depositing and withdrawing money
- Displaying all accounts
- Deleting an account
- Polymorphism in action

Example output:
SA-001 1200.0  
CA-001 400.0

---

## How to Run

1. Start PostgreSQL
2. Create database named bank_db
3. Execute schema.sql
4. Update database credentials in DatabaseConnection.java
5. Run Main.java from IntelliJ IDEA

---

## Reflection

What I learned:
- How abstract classes and inheritance work together
- How JDBC connects Java to a real database
- Why layered architecture is important

Challenges:
- Database connection configuration
- Proper encapsulation of fields

Benefits:
- Clean and scalable code structure
- Easy to maintain and extend
- Real-world backend development experience

---

