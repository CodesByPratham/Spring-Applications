# Spring Boot - IoC and Dependency Injection Demo

This project is a **Spring Boot** application designed to **demonstrate and clear the concepts of Inversion of Control (IoC)** and **Dependency Injection (DI)** using simple classes like `Traveler`, `Vehicle`, `Car`, `Bike`, and `Engine`.

## 📚 Concepts Covered

- **Inversion of Control (IoC)**: Framework controls object creation and dependency management.
- **Dependency Injection (DI)**: External objects are injected into classes instead of creating them manually.
- **Constructor Injection** (Recommended approach)
- **Field and Setter Injection** (Also demonstrated but not recommended for best practices)
- **Resolving Bean Ambiguities** using:
  - `@Primary`
  - `@Qualifier`

## 📂 Project Structure

```
src/main/java/com/pratham/springBoot/
├── Application.java     // Main class to bootstrap the Spring Boot app
├── Bike.java             // Bike implementation of Vehicle
├── Car.java              // Car implementation of Vehicle
├── Engine.java           // Simple Engine class with start method
├── Traveler.java         // Traveler class depending on a Vehicle
└── Vehicle.java          // Vehicle interface
```

## 🚀 How it Works

1. **Application.java**:
   - Bootstraps the Spring Boot application.
   - Uses Spring’s `ApplicationContext` to get the `Traveler` bean and calls its `travel()` method.
2. **Traveler.java**:
   - Depends on the `Vehicle` interface.
   - Uses `@Autowired` and `@Qualifier("car")` to inject a specific implementation (`Car`).
3. **Vehicle.java**:
   - A simple interface with the method `drive()`.
4. **Bike.java** and **Car.java**:
   - Implement `Vehicle`.
   - Depend on `Engine`, injected via **Constructor Injection**.
   - Demonstrate how to handle multiple beans (`@Primary`, `@Qualifier`).
5. **Engine.java**:
   - A simple component class with a `start()` method.

## 🛠️ Technologies Used

- Java 21
- Spring Boot 3+
- Maven

## 🔥 Running the Application

1. Clone the repository:
   ```bash
   git clone <your-repo-url>
   ```
2. Navigate to the project directory:
   ```bash
   cd SPRINGBOOT
   ```
3. Build and run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Output:
   ```
   Engine Started...
   Car is driving...
   ```

---
