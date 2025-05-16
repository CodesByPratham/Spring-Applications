# Static Web API (Spring Boot)

A **Spring Boot** application that exposes a simple **REST API** to perform **CRUD operations** on **static product data**.  
The data is stored **in-memory** (no database required), making it lightweight for demos or testing.

---

## 🛠 Technologies Used

- Java 17+
- Spring Boot 3+
- Spring Web
- Maven
- Lombok

---

## 📂 Project Structure

```bash
STATICWEBAPI
│
├── src/main/java/com/pratham/staticWebApi
│   ├── controller/
│   │   ├── HomeController.java          # Welcome endpoint
│   │   └── ProductController.java       # Product CRUD API
│   ├── model/
│   │   └── Product.java                  # Product entity (id, name, price)
│   ├── service/
│   │   └── ProductService.java           # In-memory service layer
│   └── StaticWebApiApplication.java      # Application runner
│
├── src/main/resources/
├── test/
├── pom.xml
└── README.md
```

---

## ⚙️ How to Run

> **Pre-requisites:** Java 17+ and Maven installed.

### 1. Clone the Repository
```bash
git clone <repo_url>
cd STATICWEBAPI
```

### 2. Build and Run
```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

Application will start at:  
`http://localhost:8080/`

---

## 🚀 API Endpoints

| Method  | Endpoint                  | Description                  |
|:-------:|:---------------------------|:------------------------------|
| GET     | `/`                        | Greeting Message ("Hello World...") |
| GET     | `/products`                 | Get all products              |
| GET     | `/products/{id}`            | Get a product by ID           |
| POST    | `/products`                 | Add a new product             |
| PUT     | `/products/{id}`            | Update an existing product    |
| DELETE  | `/products/{id}`            | Delete a product              |

---

## 📦 Sample Static Data

On application start, the following products are pre-loaded:

| ID   | Name     | Price (INR) |
|------|----------|------------|
| 101  | Iphone   | 80000      |
| 102  | Samsung  | 90000      |
| 103  | Redmi    | 40000      |

---

## 📄 Example API Usage

### Get All Products
```bash
GET http://localhost:8080/products
```

### Add a New Product
```bash
POST http://localhost:8080/products
Content-Type: application/json

{
    "id": 104,
    "name": "OnePlus",
    "price": 50000
}
```

### Update a Product
```bash
PUT http://localhost:8080/products/104
Content-Type: application/json

{
    "id": 104,
    "name": "OnePlus 12R",
    "price": 52000
}
```

### Delete a Product
```bash
DELETE http://localhost:8080/products/104
```

---

## 📈 Features Summary

| Feature              | Available |
|----------------------|-----------|
| In-Memory CRUD        | ✅         |
| RESTful API           | ✅         |
| No Database Needed    | ✅         |
| Lightweight Setup     | ✅         |

---
