# Bookstore

This is a training project for the Server Programming course at Haaga-Helia University of Applied Sciences.

The project will be developed further during the course.

## Technologies

- Java
- Spring Boot
- Spring Web
- Thymeleaf
- Maven

## Current functionality

At this stage, the project includes:

- A Spring Boot application
- `BookController`
- `Book` model class
- `/index` GET request
- A simple Thymeleaf index page

## Project structure

```text
src
└── main
    ├── java
    │   └── fi.haagahelia.bookstore
    │       ├── domain
    │       │   └── Book.java
    │       └── web
    │           └── BookController.java
    │
    └── resources
        └── templates
            └── index.html
