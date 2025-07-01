# Restaurant Management System

This project is a RESTful API for managing users in a restaurant system, built with Spring Boot.

## Features
- User registration and management
- In-memory H2 database for development
- Validation and error handling
- Ready for extension with more features

## Technologies Used
- Java 21
- Spring Boot 3.2.5
- Spring Data JPA
- H2 Database
- Maven

## Getting Started

### Prerequisites
- Java 21+
- Maven 3.8+

### Running the Application

```
mvn spring-boot:run
```

Or build the jar and run:

```
mvn clean package
java -jar target/restaurante-system-0.0.1-SNAPSHOT.jar
```

### API Endpoints

- `GET /users` - List all users
- `POST /users` - Create a new user
- `GET /users/{id}` - Get user by ID
- `PUT /users/{id}` - Update user
- `DELETE /users/{id}` - Delete user

### Database

The application uses an in-memory H2 database by default. Access the H2 console at:
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`

### Testing

Run tests with:
```
mvn test
```

## Docker

To build and run with Docker:
```
docker build -t restaurante-system .
docker run -p 8080:8080 restaurante-system
```

Or use docker-compose:
```
docker-compose up --build
```

## Postman Collection

A Postman collection is available in `postman_collection.json` for testing the API endpoints.

## License

This project is for educational purposes.
