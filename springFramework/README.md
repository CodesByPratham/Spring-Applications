# Spring Framework - IoC and Dependency Injection Demo (XML Configuration)

This project is a simple **Spring Framework** application (without using Spring Boot) that **demonstrates the concepts of Inversion of Control (IoC)** and **Dependency Injection (DI)** using XML-based configuration (`spring.xml`).

## 📚 Concepts Covered
- **Inversion of Control (IoC)**: Framework controls the creation and management of objects (beans).
- **Dependency Injection (DI)**:
  - **Constructor Injection** (active in project)
  - **Setter Injection** (available in commented code)
  - **Field Injection** (through constructor)
- **Spring XML Configuration**: Defines how beans are wired together.

## 📂 Project Structure

```
src/main/java/org/pratham/
├── App.java             // Main class to initialize Spring Context and retrieve beans
├── Bike.java            // Bike implementation of Vehicle
├── Car.java             // Car implementation of Vehicle
├── Engine.java          // Engine class
├── Traveler.java        // Traveler class depending on Vehicle
└── Vehicle.java         // Vehicle interface

src/main/resources/
└── spring.xml           // XML configuration for defining and wiring beans
```

## 🚀 How it Works
1. **App.java**:
   - Loads Spring's `ApplicationContext` from `spring.xml`.
   - Retrieves the `Traveler` bean and invokes the `travel()` method.
2. **Traveler.java**:
   - Depends on `Vehicle` interface.
   - Shows Constructor Injection (active) and Setter Injection (commented for reference).
3. **Vehicle.java**:
   - A simple interface with the method `drive()`.
4. **Bike.java** and **Car.java**:
   - Implement `Vehicle`.
   - Depend on an `Engine` object, injected via **Setter Injection**.
5. **Engine.java**:
   - A simple class with a `start()` method.

6. **spring.xml**:
   - Defines all beans and their dependencies.
   - Demonstrates both Constructor and Setter Injection methods (easy to switch).

## 🛠️ Technologies Used
- Java 17+
- Spring Framework 5+
- Maven

## 🔥 Running the Application

1. Clone the repository:
   ```bash
   git clone <your-repo-url>
   ```
2. Navigate to the project directory:
   ```bash
   cd SPRINGFRAMEWORK
   ```
3. Build and run the application:
   ```bash
   ./mvnw compile
   ./mvnw exec:java -Dexec.mainClass="org.pratham.App"
   ```

---