# Spring Boot Database (Oracle JDBC CRUD Console App)

A **Spring Boot** project demonstrating **basic CRUD operations** (`Create`, `Read`, `Update`, `Delete`) on an **Oracle Database** using **Spring JDBC**.  
It features a **console-based, menu-driven** interface for easy interaction.

---

## 🛠 Technologies Used

- Java 21
- Spring Boot 3+
- Spring JDBC
- Oracle Database
- Maven

---

## 📂 Project Structure

```bash
SPRINGBOOTDATABASE
│
├── src/main/java/com/pratham/springBootDatabase
│   ├── SpringBootDatabaseApplication.java    # Main application with menu
│   ├── StudentRepo.java                      # Repository (JDBC operations)
│   └── model/
│       └── Student.java                      # Student POJO
│
├── src/main/resources/
│   ├── application.properties                # Database connection config
│   ├── schema.sql                             # Table schema creation
│   └── data.sql                               # Sample data insertion
│
├── pom.xml                                    # Maven dependencies
├── .gitignore
└── README.md                                  # You are here!
```

---

## ⚙️ How to Run

> **Before you run:**  
> Make sure you have a working **Oracle Database** and **provide correct connection details** in `application.properties`.

### 1. Set up Oracle DB
- Run `schema.sql` manually if needed to create `students` table.
- (Optional) Insert initial data using `data.sql`.

### 2. Configure `application.properties`
```properties
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
spring.sql.init.mode=always
```

### 3. Build and Run the Project
```bash
# From project root directory
mvn clean install
mvn spring-boot:run
```

---

## 🖥️ Application Workflow

1. On startup, the app **automatically**:
   - Adds a student.
   - Shows existing records.
   - Updates a record.
   - Deletes a record.

2. After that, the **console menu** appears:

| Option | Action                        |
|:------:|:------------------------------|
|   1    | Read (Show all students)       |
|   2    | Add a new student              |
|   3    | Update an existing student     |
|   4    | Delete a student               |
|   0    | Exit the application           |

> 🧠 *Handles invalid inputs and exceptions gracefully.*

---

## 📄 SQL Scripts

### `schema.sql`
```sql
-- (Make sure DROP TABLE is commented if running first time)
CREATE TABLE students (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    age NUMBER
);
```

### `data.sql`
```sql
INSERT INTO students(id, name, age) VALUES(99, 'Pratham', 21);
INSERT INTO students(id, name, age) VALUES(100, 'Kritika', 22);
INSERT INTO students(id, name, age) VALUES(101, 'Dev', 20);
INSERT INTO students(id, name, age) VALUES(102, 'Kishan', 19);
```

---

## 📊 Features Summary

| Feature              | Available |
|----------------------|-----------|
| Add Student          | ✅         |
| Read Students        | ✅         |
| Update Student       | ✅         |
| Delete Student       | ✅         |
| Console Menu         | ✅         |
| Oracle DB Integration| ✅         |

---