# Book Store

A Spring Boot bookstore application with REST API support, built for the Haaga-Helia Back End Programming course.

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Data REST
- Thymeleaf
- H2 (in-memory database)

## Features

- Web pages (Thymeleaf) to list, add, edit, and delete books
- REST API (JSON) for books:
  - `GET /books` — list all books
  - `GET /books/{id}` — get one book by id
  - `POST /books` — create a new book
  - `PUT /books/{id}` — update a book
  - `DELETE /books/{id}` — delete a book
- Spring Data REST auto-generated API at `/api/books`, `/api/categories`

## Running the app

```bash
./mvnw spring-boot:run
```

App runs at `http://localhost:8080`

H2 console: `http://localhost:8080/h2-console`

## Author

Samir B K