<h1 align="center">
  Crud Library
</h1>

This repository contains a simple CRUD project built using Java Spring. This repository is designed to be used in a library.
This repository aims to learn how to build APIs using Java Spring.

## Technologies
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://docs.spring.io/spring-framework/reference/data-access/orm/jpa.html)
- [Spring Security](https://spring.io/projects/spring-security)
- [JWT](https://jwt.io)
- [Flyway](https://documentation.red-gate.com/fd/migrations-184127470.html)
- [PostgreSQL](https://www.postgresql.org/docs/current/index.html)

## Table of Contents

- [Installation](#installation)
- [Execution](#execution)
- [API Endpoints](#api-endpoints)

## Installation
1. Clone the repository:

```bash
git clone https://github.com/patrickmarinho/Crud-Library.git
```

2. Install dependencies with Maven

3. Install [PostgresSQL](https://www.postgresql.org/download/)
   
## Execution

1. Start the application with Maven
2. The API will be accessible at http://localhost:8080

## API Endpoints

The API provides the following endpoints:

```markdown
POST/auth/register - Register a new user
```
Receives these parameters in the following JSON format:
```json
{
  "login": "John Doe",
  "password": "12345",
  "role": "ADMIN"
}
```
or
```json
{
  "login": "John Doe",
  "password": "12345",
  "role": "BASIC"
}
```
| Params     | Type        | Description                                                 |
|------------|-------------|-------------------------------------------------------------|
| `login`    | `String`    | **Required**. Your username.                                |
| `password` | `String`    | **Required**. Your password.                                |
| `role`     | `UserRole ` | **Required**. Your user type. It can be `ADMIN` or `BASIC`. |

```markdown
POST/auth/login - Log in a registered user
```

Receives these parameters in the following JSON format:
```json
{
  "login": "John Doe",
  "password": "12345"
}
```

| Params     | Type        | Description                                                 |
|------------|-------------|-------------------------------------------------------------|
| `login`    | `String`    | **Required**. Your username.                                |
| `password` | `String`    | **Required**. Your password.                                |


```markdown
POST/auth/login - Log in a registered user

GET/book - Retrieve a list of all books.

POST/book - Register a new book.

PUT/book/{id} - Alter book.

DELETE/book/{id} - Delete book.
```
