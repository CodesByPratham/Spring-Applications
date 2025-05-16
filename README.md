# 💼 Spring Java Projects Collection

A collection of **five practical and educational Java Spring-based projects** that cover real-world applications and foundational Spring concepts. These projects demonstrate everything from full-stack web APIs with Oracle DB to core concepts like **IoC** and **Dependency Injection** using both **Spring Boot** and the **Spring Framework (XML)**.

---

## 📘 Table of Contents

1. 🔗 Dynamic Web API - Employee and Department Management
2. 🌀 Spring Boot IoC and Dependency Injection Demo
3. 🗃️ Spring Boot Oracle JDBC CRUD Console App
4. 📦 Spring Framework IoC & DI Demo (XML Config)
5. 🧾 Static Web API (In-Memory Product CRUD)

---

## 1. 🔗 Dynamic Web API - Employee and Department Management

A **Spring Boot 3+** REST API project to manage **Employees** and **Departments**, with full CRUD support for both. Built using `JdbcTemplate` and integrated with **Oracle Database**.

### 🔧 Features

- CRUD APIs for both Employees and Departments
- Many-to-One relationship: Employee → Department
- Single and batch operations
- Spring Boot + Spring JDBC
- Oracle DB Integration

### 📎 Quick Link: [View Full Project Details](/dynamicWebApi/)

---

## 2. 🌀 Spring Boot - IoC and Dependency Injection Demo

A concise Spring Boot app to understand **Inversion of Control** and **Dependency Injection** concepts. This project uses simple classes (`Traveler`, `Vehicle`, `Car`, `Bike`, `Engine`) to demonstrate:

- Constructor Injection ✅
- Field & Setter Injection
- `@Autowired`, `@Qualifier`, and `@Primary`

### 📎 Quick Link: [View Full Project Details](/springBoot/)

---

## 3. 🗃️ Spring Boot Database (Oracle JDBC CRUD Console App)

A **menu-driven console app** using Spring Boot and Spring JDBC for performing CRUD operations on a **Student** entity stored in an **Oracle Database**.

### 💡 Features

- Console menu to Add, Read, Update, Delete students
- Spring JDBC with `JdbcTemplate`
- Preloaded sample data with `data.sql`
- Graceful error handling

### 📎 Quick Link: [View Full Project Details](/springBootDatabase/)

---

## 4. 📦 Spring Framework - IoC and Dependency Injection Demo (XML Configuration)

A classic Spring Framework project (non-Boot) showcasing **IoC and DI** via **XML Configuration** (`spring.xml`).

### 🧠 Concepts

- Constructor and Setter Injection
- XML Bean Configuration
- Vehicle interface with `Car`, `Bike`, and `Engine` classes

### 📎 Quick Link: [View Full Project Details](/springFramework/)

---

## 5. 🧾 Static Web API (Spring Boot)

A **Spring Boot** application that exposes a lightweight **REST API** for performing **CRUD operations** on static in-memory product data. Ideal for testing and quick demos.

### 🔧 Features

- In-memory product CRUD operations
- Simple REST endpoints
- No database required
- Preloaded product list
- Java 17 and Spring Boot 3+

### 📎 Quick Link: [View Full Project Details](/staticWebApi/)

---

## 📂 Project Directory Overview

```
ROOT/
├── dynamic-web-api/            # REST API for Employees and Departments
├── spring-boot-di-demo/        # Spring Boot - IoC & DI Conceptual Demo
├── spring-boot-database/       # Oracle DB CRUD Console App
├── spring-framework-di-xml/    # Spring Framework (XML DI) Demo
└── static-web-api/             # In-memory Product CRUD API
```

---

## 🔧 How to Run Any Project

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/spring-java-projects.git
   ```

2. Navigate to the specific project folder.

3. Follow instructions in that project's section or its internal README.

---

## 💬 Final Note

These projects are designed for **learning**, **demonstration**, and **real-world application**. Together, they offer a solid foundation in Java Spring Development—from API building to DI mastery.

---
