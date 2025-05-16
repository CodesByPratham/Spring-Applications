# Dynamic Web API - Employee and Department Management

**Dynamic Web API** is a Java Spring Boot project that provides a RESTful API to manage Employees and Departments.  
It supports full CRUD operations — Create, Read, Update, and Delete — on both entities and interacts with an Oracle database using `JdbcTemplate`.

## 🚀 Features

- Manage **Employees** and **Departments**
- Single and batch operations for:
  - Adding
  - Updating
  - Deleting
- Full database interaction via **Spring JdbcTemplate**
- REST APIs built with **Spring Boot**
- Entity relationships: Employee → Department (Many-to-One)

## 🛠️ Tech Stack

- Java 17+
- Spring Boot 3+
- Spring Web
- Spring JDBC
- Oracle Database
- Lombok

## 📂 Project Structure

```
com.pratham.dynamicWebApi
├── controller
│   ├── DepartmentController.java
│   └── EmployeeController.java
├── model
│   ├── Department.java
│   └── Employee.java
├── repository
│   ├── DepartmentRepo.java
│   └── EmployeeRepo.java
├── service
│   ├── DepartmentService.java
│   └── EmployeeService.java
└── DynamicWebApiApplication.java
```

## 🛣️ API Endpoints

### Department Endpoints

|  Method  |        Endpoint        | Description                 |
| :------: | :--------------------: | :-------------------------- |
|  `GET`   |     `/department`      | Fetch all departments       |
|  `GET`   | `/department/{deptId}` | Fetch a department by ID    |
|  `POST`  |     `/department`      | Add a new department        |
|  `POST`  |  `/department/batch`   | Add multiple departments    |
|  `PUT`   | `/department/{deptId}` | Update a department         |
|  `PUT`   |  `/department/batch`   | Update multiple departments |
| `DELETE` | `/department/{deptId}` | Delete a department         |
| `DELETE` |  `/department/batch`   | Delete multiple departments |

### Employee Endpoints

|  Method  |     Endpoint      | Description               |
| :------: | :---------------: | :------------------------ |
|  `GET`   |    `/employee`    | Fetch all employees       |
|  `GET`   | `/employee/{id}`  | Fetch an employee by ID   |
|  `POST`  |    `/employee`    | Add a new employee        |
|  `POST`  | `/employee/batch` | Add multiple employees    |
|  `PUT`   | `/employee/{id}`  | Update an employee        |
|  `PUT`   | `/employee/batch` | Update multiple employees |
| `DELETE` | `/employee/{id}`  | Delete an employee        |
| `DELETE` | `/employee/batch` | Delete multiple employees |

## 🧩 Database Setup

- **Make sure to comment the lines for droping tables and sequence in schema.sql**

## ▶️ How to Run

1. **Clone the project**

```bash
git clone https://github.com/your-username/dynamic-web-api.git
```

2. **Set up the Oracle database** with the provided SQL scripts.

3. **Configure your `application.properties`**

```properties
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
spring.sql.init.mode=always
```

4. **Run the application**

```bash
mvn spring-boot:run
```

The app will be available at:  
🔗 `http://localhost:8080/`

## 📝 Notes

- Make sure Oracle Database is running before starting the app.
- Lombok is required — install the Lombok plugin if you're using IntelliJ IDEA, Eclipse, VsCode, etc.
- Use tools like **Postman** or **Insomnia** to test the APIs.

---
