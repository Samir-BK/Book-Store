
# Book-Store

A web-based Book-Store application built with **Java, Spring Boot, Spring Security, Thymeleaf, and PostgreSQL**.

The application allows authenticated users to manage books and provides administrator-only functionality for category creation and book deletion.

## Live Application

**Deployed application:** https://book-store-a00u.onrender.com

**GitHub repository:** https://github.com/Samir-BK/Book-Store

The application is hosted on **Render** using Docker and connected to a Render PostgreSQL database.

> **Note:** The application requires login. Render's free web service may take approximately one minute or longer to respond after inactivity.

## Features

- User authentication with Spring Security
- Password encryption using BCrypt hashing
- Role-based authorization (`USER` and `ADMIN`)
- View a list of books
- Add new books
- Edit existing books
- Delete books (administrator only)
- Create categories (administrator only)
- Assign categories to books
- Store data in a relational database
- Separate development and production configurations

## Technologies Used

| Technology | Purpose |
|------------|---------|
| Java 17 | Programming language |
| Spring Boot 4.1.1 | Backend application framework |
| Spring MVC | Web controllers and routing |
| Spring Data JPA / Hibernate | Database persistence |
| Spring Security | Authentication and authorization |
| Thymeleaf | Server-side HTML templates |
| PostgreSQL | Production database |
| H2 Database | Development database |
| Maven | Dependency management and build |
| Docker | Containerized deployment |
| Render | Application and database hosting |

## Project Structure

```text
src/
└── main/
    ├── java/fi/haagahelia/bookstore/
    │   ├── BookstoreApplication.java
    │   ├── WebSecurityConfig.java
    │   ├── UserDetailServiceImpl.java
    │   ├── domain/
    │   │   ├── Book.java
    │   │   ├── BookRepository.java
    │   │   ├── Category.java
    │   │   ├── CategoryRepository.java
    │   │   ├── User.java
    │   │   └── UserRepository.java
    │   └── web/
    │       ├── BookController.java
    │       └── CategoryController.java
    └── resources/
        ├── templates/
        ├── application.properties
        ├── application-dev.properties
        └── application-prod.properties
```

## Database

The application uses three main entities.

### Book

Stores information about each book:

- Title
- Author
- ISBN
- Publication year
- Price
- Category

### Category

Stores category names and maintains a one-to-many relationship with books.

### User

Stores authentication information:

- Username
- BCrypt-hashed password
- Email address
- Role (`USER` or `ADMIN`)

### Database Environments

- **Development:** H2 in-memory database
- **Production:** PostgreSQL hosted on Render

## Running Locally

### Prerequisites

- Java 17
- Git
- Internet connection to download Maven dependencies

### 1. Clone the Repository

```bash
git clone https://github.com/Samir-BK/Book-Store.git
cd Book-Store
```

### 2. Run the Application

On macOS or Linux:

```bash
./mvnw spring-boot:run
```

On Windows:

```cmd
mvnw.cmd spring-boot:run
```

The application uses the `dev` profile by default.

### 3. Open the Application

Visit:

http://localhost:8080

### Development Login Credentials

The development initializer creates the following demonstration accounts when the development database is empty:

| Username | Password | Role |
|----------|----------|------|
| `user` | `user` | USER |
| `admin` | `admin` | ADMIN |

**Important:** These accounts are for local development only. They are not automatically created in production.

## Security

The application uses **Spring Security** for form-based authentication and authorization.

Passwords are stored as BCrypt hashes rather than plaintext.

The application supports two roles:

- **USER:** Authenticated application user
- **ADMIN:** Administrator with additional permissions, including book deletion and category creation

Production administrator credentials are configured separately using environment variables and are not committed to GitHub.

## Deployment on Render

The application is deployed as a **Docker-based Web Service** on Render.

### Docker Deployment

The Dockerfile uses a multi-stage build:

1. Build the Spring Boot application using Java 17 and Maven.
2. Copy the generated JAR file into a Java 17 runtime image.
3. Start the application using `java -jar app.jar`.

### Production Environment Variables

The following environment variables are configured in Render:

| Variable | Description |
|----------|-------------|
| `SPRING_PROFILES_ACTIVE` | Set to `prod` |
| `SPRING_DATASOURCE_URL` | PostgreSQL JDBC connection URL |
| `SPRING_DATASOURCE_USERNAME` | PostgreSQL database username |
| `SPRING_DATASOURCE_PASSWORD` | PostgreSQL database password |

The production configuration reads database credentials from environment variables rather than hardcoding them.

The application uses the port provided by Render.

### Production Database

The production database is hosted separately using **Render PostgreSQL**.

Hibernate manages database schema updates through the production JPA configuration.

Development demonstration data is not automatically inserted into the production database.

## Using the Application

1. Open the deployed application.
2. Log in using a valid account.
3. Navigate to the **Book List** page.
4. Click **Add Book** to create a new book.
5. Enter the book details.
6. Select a category from the dropdown menu.
7. If necessary, create a category using **Add New Category**.
8. Save the book.
9. Return to the Book List to view the saved record.

Administrators can also edit books, delete books, and create categories.

## Deployment Notes

- Render's free web service may spin down after inactivity, causing slower initial loading.
- The free PostgreSQL database has a limited lifetime.
- Database backups or migration are necessary before the free database expires.
- Production passwords and database credentials must never be committed to GitHub.
- The application uses separate development and production profiles.

## Author

Developed as a Java Spring Boot Book-Store project.

**GitHub:** https://github.com/Samir-BK
