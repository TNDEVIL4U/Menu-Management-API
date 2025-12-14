# Menu Management API — Spring Boot

A lightweight REST API to manage restaurant menu items. Provides simple, validated CRUD endpoints, clear error handling, structured responses, and an importable Postman collection for quick testing.

---

## Owner - Disclaimer

Name : Bhuvaneshwar TS
Email id : bhuvaneshwarts1@gmail.com
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
│   │   └── ItemNotFoundException.java
│   │
│   ├── dto/
│   │   ├── ItemMapper.java
│   │   ├── ItemRequestDto.java
│   │   └── ItemResponseDto.java
│
├── src/main/resources/
│   └──application.properties
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
Base URL:

```
/api/items
```

---

# **1️⃣ Get All Items**

### **GET /api/items**

#### ✔ Sample Response (200 OK)

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

---

# **2️⃣ Create Item**

### **POST /api/items**

#### 📤 Request Body

```json
{
  "name": "Pizza",
  "price": 250,
  "category": "Italian",
  "availability": true
}
```

#### ✔ Response (201 Created)

```json
{
  "id": 2,
  "name": "Pizza",
  "price": 250,
  "category": "Italian",
  "availability": true
}
```

#### ❌ Validation Error (400 Bad Request)

```json
{
  "name": "Name cannot be blank",
  "price": "Price amount is invalid"
}
```

---

# **3️⃣ Update Item**

### **PUT /api/items/{id}**

#### 📤 Request

```
PUT /api/items/2
```

```json
{
  "id": 2,
  "name": "Veg Pizza",
  "price": 270,
  "category": "Italian",
  "availability": true
}
```

#### ✔ Response (200 OK)

```json
"Item updated successfully"
```

---

# **4️⃣ Delete Item**

### **DELETE /api/items/{id}**

#### ✔ Response (200 OK)

```json
"Item deleted successfully"
```

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
{
  "info": {
    "name": "Menu Management API",
    "_postman_id": "menu-management-1234",
    "description": "Postman collection for Menu Management App",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
  },
  "item": [
    {
      "name": "Get All Items",
      "request": {
        "method": "GET",
        "header": [],
        "url": {
          "raw": "http://localhost:8080/api/items",
          "protocol": "http",
          "host": ["localhost"],
          "port": "8080",
          "path": ["api", "items"]
        }
      }
    },
    {
      "name": "Create Item",
      "request": {
        "method": "POST",
        "header": [
          { "key": "Content-Type", "value": "application/json" }
        ],
        "body": {
          "mode": "raw",
          "raw": "{\n    \"name\": \"Pizza\",\n    \"price\": 250,\n    \"category\": \"Italian\",\n    \"availability\": true\n}"
        },
        "url": {
          "raw": "http://localhost:8080/api/items",
          "protocol": "http",
          "host": ["localhost"],
          "port": "8080",
          "path": ["api", "items"]
        }
      }
    },
    {
      "name": "Update Item",
      "request": {
        "method": "PUT",
        "header": [
          { "key": "Content-Type", "value": "application/json" }
        ],
        "body": {
          "mode": "raw",
          "raw": "{\n    \"id\": 1,\n    \"name\": \"Updated Pizza\",\n    \"price\": 300,\n    \"category\": \"Italian\",\n    \"availability\": false\n}"
        },
        "url": {
          "raw": "http://localhost:8080/api/items/1",
          "protocol": "http",
          "host": ["localhost"],
          "port": "8080",
          "path": ["api", "items", "1"]
        }
      }
    },
    {
      "name": "Delete Item",
      "request": {
        "method": "DELETE",
        "header": [],
        "url": {
          "raw": "http://localhost:8080/api/items/1",
          "protocol": "http",
          "host": ["localhost"],
          "port": "8080",
          "path": ["api", "items", "1"]
        }
      }
    }
  ]
}

---

Open to Suggest your Ideas, Mail here : [bhuvaneshwarts1@gmail.com](mailto:bhuvaneshwarts1@gmail.com)
