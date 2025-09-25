# Derin's Blog Post Application

A simple, full-stack blog application built with Spring Boot that allows users to create, read, update, and delete blog posts. This application demonstrates modern Java web development practices using Spring Boot, JPA, Thymeleaf, and Bootstrap.

## 🚀 Features

- **CRUD Operations**: Create, Read, Update, and Delete blog posts
- **Responsive Design**: Bootstrap-powered UI that works on all devices
- **Database Integration**: H2 in-memory database with JPA/Hibernate
- **Web Interface**: Clean, intuitive web interface for managing blog posts
- **Real-time Updates**: Immediate reflection of changes in the web interface

## 🛠️ Technology Stack

- **Backend**: Spring Boot 2.1.6
- **Database**: H2 Database (in-memory)
- **ORM**: Spring Data JPA with Hibernate
- **Frontend**: Thymeleaf templates with Bootstrap 3.3.7
- **Build Tool**: Maven
- **Java Version**: Java 8

## 📋 Prerequisites

Before running this application, make sure you have the following installed:

- **Java 8** or higher
- **Maven 3.6+** (or use the included Maven wrapper)
- **Git** (for cloning the repository)

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone <repository-url>
cd JavaBlogPost
```

### 2. Run the Application

You can run the application using Maven wrapper (recommended) or Maven directly:

**Using Maven Wrapper:**

```bash
# On Windows
./mvnw.cmd spring-boot:run

# On Unix/Linux/Mac
./mvnw spring-boot:run
```

**Using Maven:**

```bash
mvn spring-boot:run
```

### 3. Access the Application

Once the application starts successfully, you can access it at:

- **Main Application**: http://localhost:8080
- **H2 Database Console**: http://localhost:8080/console
  - JDBC URL: `jdbc:h2:mem:testdb`
  - Username: `sa`
  - Password: (leave empty)

## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── derinsblog/
│   │           ├── DerinsBlogApplication.java          # Main Spring Boot application class
│   │           └── blogpost/
│   │               ├── BlogPost.java                  # JPA Entity for blog posts
│   │               ├── BlogPostController.java        # REST Controller handling web requests
│   │               └── BlogPostRepository.java        # Spring Data JPA Repository
│   └── resources/
│       ├── application.properties                     # Application configuration
│       ├── static/
│       │   └── css/
│       │       └── standard.css                       # Custom CSS styles
│       └── templates/
│           ├── fragments/
│           │   └── navbar.html                       # Reusable navigation bar fragment
│           └── blogpost/
│               ├── index.html                        # Blog posts listing page
│               ├── new.html                          # Create new blog post form
│               ├── edit.html                         # Edit existing blog post form
│               ├── show.html                         # Display individual blog post
│               └── result.html                       # Confirmation page after operations
└── test/
    └── java/
        └── com/
            └── derinsblog/
                └── DerinsBlogApplicationTests.java    # Unit tests
```

## 🎯 API Endpoints

| Method | Endpoint              | Description                       |
| ------ | --------------------- | --------------------------------- |
| GET    | `/`                   | Display all blog posts (homepage) |
| POST   | `/`                   | Create a new blog post            |
| GET    | `/blogpost/new`       | Show form to create new blog post |
| POST   | `/blogpost/new`       | Create new blog post from form    |
| GET    | `/blogpost/{id}`      | Display specific blog post        |
| GET    | `/blogpost/edit/{id}` | Show form to edit blog post       |
| PUT    | `/blogpost/{id}`      | Update existing blog post         |
| DELETE | `/blogpost/{id}`      | Delete blog post                  |

## 🗄️ Database Schema

The application uses a simple `BlogPost` entity with the following fields:

| Field       | Type   | Description                  |
| ----------- | ------ | ---------------------------- |
| `id`        | Long   | Primary key (auto-generated) |
| `title`     | String | Blog post title              |
| `author`    | String | Author name                  |
| `blogEntry` | String | Blog post content            |

## 🎨 User Interface

The application features a clean, responsive interface built with:

- **Bootstrap 3.3.7**: For responsive design and UI components
- **Thymeleaf**: Server-side template engine for dynamic content
- **Custom CSS**: Additional styling in `standard.css`
- **Navigation Bar**: Reusable fragment for consistent navigation

### Key Pages:

1. **Homepage (`/`)**: Lists all blog posts with options to view, edit, or delete
2. **New Post (`/blogpost/new`)**: Form to create new blog posts
3. **View Post (`/blogpost/{id}`)**: Display individual blog post details
4. **Edit Post (`/blogpost/edit/{id}`)**: Form to modify existing blog posts
5. **Result Page**: Confirmation page after successful operations

## 🔧 Configuration

The application is configured through `src/main/resources/application.properties`:

```properties
# H2 Database Console Configuration
spring.h2.console.enabled=true
spring.h2.console.path=/console

# Database Platform
spring.datasource.platform=h2
```

## 🧪 Testing

Run the test suite using Maven:

```bash
# Using Maven wrapper
./mvnw test

# Using Maven
mvn test
```

## 🚀 Building for Production

To build a production-ready JAR file:

```bash
# Using Maven wrapper
./mvnw clean package

# Using Maven
mvn clean package
```

The JAR file will be created in the `target/` directory and can be run with:

```bash
java -jar target/DerinsBlog-0.0.1-SNAPSHOT.jar
```

## 🔍 Development Features

- **Spring Boot DevTools**: Automatic restart and live reload during development
- **H2 Console**: Web-based database management interface
- **Actuator**: Production-ready features for monitoring and managing the application

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

## 👨‍💻 Author

**Derin Joseph**

- Portfolio: [derinjoseph.com](http://www.derinjoseph.com)

## 🆘 Troubleshooting

### Common Issues:

1. **Port 8080 already in use**: Change the port in `application.properties`:

   ```properties
   server.port=8081
   ```

2. **Java version issues**: Ensure you're using Java 8 or higher:

   ```bash
   java -version
   ```

3. **Maven wrapper permissions**: On Unix systems, make the wrapper executable:
   ```bash
   chmod +x mvnw
   ```

## 📚 Additional Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA Documentation](https://spring.io/projects/spring-data-jpa)
- [Thymeleaf Documentation](https://www.thymeleaf.org/documentation.html)
- [Bootstrap Documentation](https://getbootstrap.com/docs/3.3/)

---

**Happy Blogging! 🎉**
