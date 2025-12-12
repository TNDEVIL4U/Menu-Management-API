# Menu Management API — Spring Boot

A lightweight REST API to manage restaurant menu items. Provides simple, validated CRUD endpoints, clear error handling, structured responses, and an importable Postman collection for quick testing.

---

## Owner - Disclaimer

Repository owner (GitHub ID): TNDEVIL4U  
This repository and its contents are maintained by the owner above. Use, modify, and contribute following the project's license and contribution guidelines.

---

## Project Structure

```
Menu-Management/
│
├── src/main/java/com/example/Menu/Management/
│   ├── MenuManagementApplication.java
│   │
│   ├── controller/
│   │   └── MenuController.java
│   │
│   ├── service/
│   │   └── MenuService.java
│   │
│   ├── repository/
│   │   └── MenuRepository.java
│   │
│   ├── model/
│   │   └── Item.java
│   │
│   ├── exceptions/
│   │   ├── ItemNotFoundException.java
│   │   └── GlobalExceptionHandler.java (optional improvement)
│   │
│   ├── dto/
│   │   ├── ItemMapper.java
│   │   ├── ItemRequestDto.java
│   │   └── ItemResponseDto.java
│   ├── config/ (optional for CORS)
│
├── src/main/resources/
│   ├── application.properties
│   └── data.sql (optional)
│
├── pom.xml
├── README.md
└── .gitignore
```

---

## Quick Setup

Requirements:
- Java 17+
- Maven 3.8+
- Spring Boot 3.x
- Any IDE (IntelliJ recommended)

Clone and run:
```bash
git clone https://github.com/TNDEVIL4U/Menu-Management-API.git
cd Menu-Management-API
mvn clean install
mvn spring-boot:run
```

Application URL:
```
http://localhost:8080
```

Base API path:
```
/api/items
```

---

## API Endpoints

1) Get All Items
- GET /api/items
- 200 OK sample:
```json
[
  {
    "id": 1,
    "name": "Burger",
    "price": 120,
    "category": "Fast Food",
    "availability": true
  }
]
```

2) Create Item
- POST /api/items
- Request:
```json
{
  "name": "Pizza",
  "price": 250,
  "category": "Italian",
  "availability": true
}
```
- 201 Created sample response returns the created item.

Validation error (400):
```json
{
  "name": "Name cannot be blank",
  "price": "Price amount is invalid"
}
```

3) Update Item
- PUT /api/items/{id}
- Request:
```json
{
  "id": 2,
  "name": "Veg Pizza",
  "price": 270,
  "category": "Italian",
  "availability": true
}
```
- 200 OK: "Item updated successfully"

4) Delete Item
- DELETE /api/items/{id}
- 200 OK: "Item deleted successfully"

---

## Validation Rules

| Field        | Rule                |
| ------------ | ------------------- |
| name         | @NotNull, @NotBlank |
| price        | @Min(1)             |
| category     | optional            |
| availability | optional            |

---

## Exception Handling

- Validation errors (400) handled via:
```java
@ExceptionHandler(MethodArgumentNotValidException.class)
```
- Not found (404):
```java
throw new ItemNotFoundException("Item not found");
```

---

## Technologies used throughout the repository

- Java 17
- Spring Boot 3.x (Spring Web / REST)
- Spring Data JPA
- Hibernate
- Jakarta Bean Validation (javax / jakarta validation annotations)
- Lombok (for boilerplate reduction)
- Maven (project build & dependency management)
- H2 / any JDBC-compatible DB (configurable via application.properties)
- Postman (collection provided for easy testing)
- (Optional) PlantUML for diagrams

These technologies are used across controllers, services, repositories, model validation, and build configuration.

---

## Postman Collection (importable)
Import → Raw Text in Postman (contains endpoints for Get, Create, Update, Delete).

Open to Suggest your Ideas, Mail here : [bhuvaneshwarts1@gmail.com](mailto:bhuvaneshwarts1@gmail.com)
