This is mvp for educational adviser simulation. This project is a RESTful API built for a blog and course platform. It is developed using Spring Boot, JPA, and PostgreSQL. The base's taken from Gelecegi Yazanlar blog as isnpiration

## Prerequisites
The following software must be installed on your system to run the project successfully:

- Java 17 or higher: For the development environment.
- Maven: To manage dependencies and build the project.
- PostgreSQL: For the database.
- Flyway (optional): To manage database migrations.
- Git: To clone the project code.

### Setup and Running
Follow these steps to set up and run the backend project on your local machine.

### 1. Clone the Project
Open your terminal and clone the project to your local disk using the following command:
```bash
git clone <project-repo-url>
cd <project-folder-name>
```
### 2. Database Configuration
Create a database for your project in PostgreSQL and update the src/main/resources/application.properties file with your database connection details.

Replace the settings in application.properties with your own database information:

#### Example database settings
```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/aeta
spring.datasource.username=postgres
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
```
> [Important]  : If you are using Flyway for database migrations, check the SQL files in the src/main/resources/db/migration/ folder. You will not need to manually enter data into the database.

### 3. Run the Project
From the project's root directory, you can build and run the project using the following Maven commands:
```bash
./mvnw clean package
./mvnw spring-boot:run
```

## API Endpoints
The backend provides the following basic API endpoints to serve data to the frontend:

```bash
http://localhost:8080/api/blogs
http://localhost:8080/api/courses
http://localhost:8080/api/users
http://localhost:8080/images/{image_name} (For images)
```
