# Event Management System

An enterprise-grade Event Management REST API built with **Spring Boot**. This system facilitates event scheduling, ticket reservation, user authentication, and payment processing.

## Technogies Used

- **Core Framework**: Spring Boot (v4.0.1)
- **Language**: Java 17
- **Database**: MySQL 8.0+
- **Security**: Spring Security + JWT (JSON Web Tokens)
- **ORM / Data Access**: Spring Data JPA, Hibernate
- **Utilities**:
  - **Lombok** (Boilerplate code reduction)
  - **MapStruct** (DTO <-> Entity mapping)
- **Build Tool**: Maven

## Project Structure

```bash
src/main/java/com/iuc/event_management
├── config/           # Security & App Configuration (JwtAuthFilter, SecurityConfig)
├── controller/       # REST Controllers (Auth, Event, Payment, Reservation)
├── dto/             # Data Transfer Objects (Request/Response)
├── entity/          # JPA Entities
├── exception/       # Global Exception Handling
├── mapper/          # MapStruct Interfaces
├── repository/      # Spring Data Repositories
├── service/         # Business Logic Layer
└── EventManagementApplication.java  # Entry Point
```

## Configuration

The application is configured via `src/main/resources/application.properties`.

### Database Configuration

Ensure you have a MySQL server running and create a database named `Event_Management_System`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/Event_Management_System?createDatabaseIfNotExist=true&useSSL=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

### JPA / Hibernate

- `spring.jpa.hibernate.ddl-auto=update`: Automatically updates the schema.
- `spring.jpa.show-sql=true`: Logs SQL queries for debugging.

## Installation & Execution

### Prerequisites

- JDK 17 or higher
- Maven 3.6+
- MySQL Server

### Steps to Run

1. **Clone the repository**

   ```bash
   git clone <repository-url>
   cd event_management
   ```

2. **Configure Database**
   Update `src/main/resources/application.properties` with your MySQL credentials.

3. **Build the project**

   ```bash
   mvn clean install
   ```

4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```
   Alternatively, you can run it using the Maven wrapper:
   ```bash
   ./mvnw spring-boot:run
   ```

The server will start on port `8085` (as defined in properties).

## API Endpoints Overview

### Authentication (`/auth`)

- `POST /auth/register`: Register a new user.
- `POST /auth/login`: Authenticate and receive a JWT.

### Events (`/events`)

- `GET /events`: List all events.
- `POST /events`: Create a new event (**Organizer Role Required**).

### Other Modules

- **Reservations**: Managed via `ReservationController`.
- **Payments**: Managed via `PaymentController`.

> **Note**: Most endpoints require a valid Bearer Token in the `Authorization` header.

##  Security

Authentication is stateful-less using **JWT**.

- **Filter**: `JwtAuthenticationFilter` intercepts requests to validate tokens.
- **Configuration**: `SecurityConfig` defines public vs protected routes.
