# Basic Spring Auth
A simple authentication application built with Spring Boot. This project demonstrates user registration, profile management, and basic admin functionalities with a clean and minimal design.

## Table of Contents
- [Features](#features)
- [Technologies](#technologies)
- [Setup](#setup)
- [API Documentation](#api-documentation)
  - [General Information](#general-information)
  - [User Operations (Auth APIs)](#user-operations-auth-apis)
  - [Admin Operations (Admin APIs)](#admin-operations-admin-apis)
- [Contributing](#contributing)
- [License](#license)

## Features
- User registration with optional email and bio fields
- Profile update and deletion
- Admin endpoint to list all users
- JSON-based REST API with proper error handling

## Technologies
- **Spring Boot**: Core framework
- **Java**: Programming language
- **Maven**: Dependency management
- **H2 Database**: In-memory database (configurable in `application.properties`)

## Setup
### Clone the repository:
```bash
git clone https://github.com/isikkerim/basic-spring-auth.git
```

### Navigate to the project directory:
```bash
cd basic-spring-auth
```

### Build and run the application:
```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8081/api` (configurable via `server.port` in `application.properties`).

## API Documentation
### General Information
- **Base URL**: `http://localhost:8081/api` (Port can be changed in `application.properties` via `server.port`)
- **Data Format**: JSON
- **Error Handling**: Errors are returned in JSON format (e.g., `{ "error": "User not found" }`)

### 1. User Operations (Auth APIs)
#### 1.1. Register User
- **Endpoint**: `POST /auth/register`
- **Description**: Registers a new user.
- **Request Body**:
```json
{
  "username": "string",  // Required: Username
  "password": "string",  // Required: Password
  "email": "string",     // Optional: Email
  "bio": "string"        // Optional: Profile description
}
```
- **Response (Success)**:
  - **Status**: `200 OK`
  - **Body**:
```json
{
  "id": 1,
  "username": "testuser",
  "password": "testpass",
  "email": "test@example.com",
  "bio": "Test bio"
}
```
- **Error Case**:
  - **Status**: `400 Bad Request` (Missing or invalid data)

#### 1.2. Update Profile
- **Endpoint**: `PUT /auth/profile/{id}`
- **Description**: Updates user profile information.
- **Path Variable**: `id` - User ID
- **Request Body**:
```json
{
  "email": "string",  // Optional: New email
  "bio": "string"     // Optional: New bio
}
```
- **Response (Success)**:
  - **Status**: `200 OK`
  - **Body**:
```json
{
  "id": 1,
  "username": "testuser",
  "password": "testpass",
  "email": "newemail@example.com",
  "bio": "Updated bio"
}
```
- **Error Case**:
  - **Status**: `404 Not Found` (If user is not found)

#### 1.3. Delete Profile
- **Endpoint**: `DELETE /auth/profile/{id}`
- **Description**: Deletes a user account.
- **Path Variable**: `id` - User ID
- **Response (Success)**:
  - **Status**: `200 OK`
  - **Body**: `"User deleted / Kullanıcı silindi"`
- **Error Case**:
  - **Status**: `404 Not Found` (If user is not found)

### 2. Admin Operations (Admin APIs)
#### 2.1. Get All Users
- **Endpoint**: `GET /admin/users`
- **Description**: Returns a list of all users.
- **Response (Success)**:
  - **Status**: `200 OK`
  - **Body**:
```json
[
  {
    "id": 1,
    "username": "testuser",
    "password": "testpass",
    "email": "test@example.com",
    "bio": "Test bio"
  },
  {
    "id": 2,
    "username": "admin",
    "password": "adminpass",
    "email": "admin@example.com",
    "bio": "Admin bio"
  }
]
```
- **Error Case**: None (Returns an empty list `[]` if no users exist)

## Contributing
Feel free to fork this repository and submit pull requests. For major changes, please open an issue first to discuss what you would like to change.

## License
This project is licensed under the MIT License - see the `LICENSE` file for details.