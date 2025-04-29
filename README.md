# Spring Boot MongoDB Workshop

A REST API project built with Spring Boot and MongoDB, demonstrating document-oriented database concepts and operations.

## 📋 Overview

This project showcases the implementation of a document-oriented database system using MongoDB and Spring Boot. It demonstrates CRUD operations, association between objects (nested objects and references), and queries using Spring Data and MongoRepository.

## 🛠️ Technologies

- Java
- Spring Boot
- MongoDB
- Spring Data MongoDB
- Maven

## 🔍 Key Features

- CRUD operations for users and posts
- Proper error handling with custom exceptions
- Data transfer objects (DTOs) for optimized data traffic
- Document references and nested documents
- Custom queries using query methods and @Query annotation
- Parameter handling for search operations

## 🏗️ Project Structure

The application follows a layered architecture:

- **domain**: Entity classes (User, Post)
- **dto**: Data Transfer Objects (UserDTO, AuthorDTO, CommentDTO)
- **repositories**: MongoDB repositories
- **resources**: REST controllers and exception handlers
- **services**: Business logic and operations
- **config**: Configuration classes including database initialization

## 📊 Data Model

### User
```json
{
  "id": "string",
  "name": "string",
  "email": "string",
  "posts": ["Post references"]
}
```

### Post
```json
{
  "id": "string",
  "date": "date",
  "title": "string",
  "body": "string",
  "author": {
    "id": "string",
    "name": "string"
  },
  "comments": [
    {
      "text": "string",
      "date": "date",
      "author": {
        "id": "string",
        "name": "string"
      }
    }
  ]
}
```

## 🚀 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | /users   | Get all users |
| GET    | /users/{id} | Get user by ID |
| POST   | /users   | Create new user |
| DELETE | /users/{id} | Delete user |
| PUT    | /users/{id} | Update user |
| GET    | /users/{id}/posts | Get posts by user |
| GET    | /posts/{id} | Get post by ID |
| GET    | /posts/titlesearch | Search posts by title |
| GET    | /posts/fullsearch | Search posts by text and date range |

## 🔧 Setup and Configuration

### Prerequisites
- Java JDK 8 or higher
- MongoDB installed and running
- Maven

### Installation Steps

1. Clone the repository:
   ```
   git clone https://github.com/yourusername/workshop-spring-boot-mongodb.git
   ```

2. Navigate to the project directory:
   ```
   cd workshop-spring-boot-mongodb
   ```

3. Make sure MongoDB is running:
   ```
   mongod
   ```

4. Build the project:
   ```
   mvn clean install
   ```

5. Run the application:
   ```
   mvn spring-boot:run
   ```

The application should be available at `http://localhost:8080`

### MongoDB Configuration

In `application.properties`:
```
spring.data.mongodb.uri=mongodb://localhost:27017/workshop_mongo
```

## 📝 Usage Examples

### Get all users
```
GET /users
```

### Create a new user
```
POST /users
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john@example.com"
}
```

### Search posts by title
```
GET /posts/titlesearch?text=good%20morning
```

### Full search posts by text and date range
```
GET /posts/fullsearch?text=travel&minDate=2018-01-01&maxDate=2018-12-31
```

## 🌱 Database Initialization

The project includes a data initialization class that creates sample users and posts when the application starts.

## 📚 Concepts Covered

- Document-oriented vs. relational paradigm differences
- CRUD operations implementation
- Design decisions for document-oriented databases
- Object associations (nested objects and references)
- MongoDB queries with Spring Data

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🙏 Acknowledgements

This project was developed as part of an Object-Oriented Programming with Java course by Professor Dr. Nelio Alves.
