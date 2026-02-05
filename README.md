# Bank System (Assignment 4)

## 📌 Project Overview

This project is a **Bank System** implemented in **Java** using **SOLID principles**, **Advanced OOP**, **JDBC**, **Generics**, **Lambdas**, and **Reflection**.
The system allows managing bank accounts and customers with a clean layered architecture.

The project fully satisfies **Assignment 4 requirements**.

---

## 🏗 Architecture

The project follows a **layered architecture**:

* **Model** – domain entities (Account, Customer)
* **Repository** – data access layer (JDBC)
* **Service** – business logic and validation
* **Controller** – delegation layer
* **Utils** – helpers (DB, reflection, sorting)
* **Exception** – custom runtime exceptions

Dependency flow:

```
Controller → Service → Repository → Database
```

---

## 📁 Project Structure

```
bank-system-solid
└── src
    ├── controller
    │   └── BankController.java
    ├── service
    │   ├── AccountService.java
    │   └── interfaces
    │       └── Validatable.java
    ├── repository
    │   ├── AccountRepository.java
    │   └── interfaces
    │       └── CrudRepository.java
    ├── model
    │   ├── AccountBase.java
    │   ├── SavingsAccount.java
    │   ├── CheckingAccount.java
    │   └── Customer.java
    ├── exception
    │   ├── InvalidInputException.java
    │   ├── DuplicateResourceException.java
    │   ├── ResourceNotFoundException.java
    │   └── DatabaseOperationException.java
    ├── utils
    │   ├── DatabaseConnection.java
    │   ├── ReflectionUtils.java
    │   └── SortingUtils.java
    └── Main.java
```

---

## 🧠 SOLID Principles Applied

### SRP – Single Responsibility Principle

* Each class has one responsibility (Controller, Service, Repository).

### OCP – Open/Closed Principle

* New account types can be added without modifying existing logic.

### LSP – Liskov Substitution Principle

* `SavingsAccount` and `CheckingAccount` correctly extend `AccountBase`.

### ISP – Interface Segregation Principle

* `Validatable` and `CrudRepository` are small and focused.

### DIP – Dependency Inversion Principle

* Service layer depends on repository interfaces, not implementations.

---

## ⚙ Technologies Used

* Java 17+
* PostgreSQL
* JDBC
* IntelliJ IDEA
* Git & GitHub

---

## 🗄 Database Schema

```sql
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
```

---

## ▶ How to Run

1. Create PostgreSQL database `bank_db`
2. Run SQL schema
3. Update credentials in `DatabaseConnection.java`
4. Add PostgreSQL JDBC driver to classpath
5. Run `Main.java`

---

## 🔍 Reflection Example

The project uses **RTTI (Reflection)** to inspect objects at runtime:

* Prints class name
* Prints declared methods

Implemented in `ReflectionUtils.inspect()`.

---

## 🧪 Example Output

```
model.SavingsAccount
getAccountType
calculateMonthlyFee
deposit
getId
getAccountNumber
getBalance
getCustomer
```

---

## ✅ Assignment 4 Checklist

* SOLID principles ✔
* Abstract classes ✔
* Interfaces (default + static) ✔
* Generics ✔
* Lambdas & Streams ✔
* Reflection ✔
* JDBC ✔
* Clean architecture ✔

---

## 📊 UML Class Diagram (Text)

```
@startuml
skinparam classAttributeIconSize 0

package model {
    abstract class AccountBase {
        - id : int
        - accountNumber : String
        - balance : double
        - customer : Customer
        + deposit(amount : double) : void
        + getBalance() : double
        + getAccountType() : String
        + calculateMonthlyFee() : double
    }

    class SavingsAccount {
        + getAccountType() : String
        + calculateMonthlyFee() : double
    }

    class CheckingAccount {
        + getAccountType() : String
        + calculateMonthlyFee() : double
    }

    class Customer {
        - id : int
        - name : String
        - email : String
    }

    AccountBase <|-- SavingsAccount
    AccountBase <|-- CheckingAccount
    AccountBase --> Customer
}

package repository {
    interface CrudRepository<T, ID> {
        + create(entity : T)
        + findById(id : ID)
        + findAll()
        + update(id : ID, entity : T)
        + delete(id : ID)
    }

    class AccountRepository {
        + create(AccountBase)
        + findById(Integer)
        + findAll()
        + update(Integer, AccountBase)
        + delete(Integer)
    }

    CrudRepository <|.. AccountRepository
}

package service {
    interface Validatable<T> {
        + validate(obj : T)
    }

    class AccountService {
        - repository : CrudRepository
        + create(AccountBase)
        + sortByBalance()
        + delete(id : int)
    }

    Validatable <|.. AccountService
    AccountService --> CrudRepository
}

package controller {
    class BankController {
        - service : AccountService
        + create(AccountBase)
        + delete(id : int)
    }

    BankController --> AccountService
}

package utils {
    class DatabaseConnection {
        + getConnection() : Connection
    }

    class ReflectionUtils {
        + inspect(obj : Object)
    }

    class SortingUtils {
        + byBalance(list : List<AccountBase>)
    }
}

@enduml

```

---

## 👨‍🎓 Author

Batyrkhan

---

## 🏁 Conclusion

This project demonstrates a clean, extensible, and maintainable Java application that fully complies with **Assignment 4** requirements and showcases advanced object-oriented programming concepts.
