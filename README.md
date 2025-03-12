# Traini8 Training Center Registry

A Spring Boot application for managing government-funded training centers. Provides REST APIs to create and retrieve training center details with validations. Uses H2 in-memory database for persistence.

---

## Table of Contents
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Setup & Installation](#setup--installation)
- [API Documentation](#api-documentation)
- [Validation Rules](#validation-rules)
- [Testing the APIs](#testing-the-apis)
- [Database Access](#database-access)
- [Project Structure](#project-structure)
- [Technologies Used](#technologies-used)
- [Troubleshooting](#troubleshooting)

---

## Features
- ✅ **Create Training Centers**: Validate and save training center details.
- ✅ **List All Centers**: Fetch all saved training centers.
- ✅ **H2 Database**: In-memory storage with web console access.
- ✅ **Validations**: Mandatory fields, format checks, and error handling.

---

## Prerequisites
- Java 17
- Maven 3.8+
- Postman/cURL (for API testing)

---

## Setup & Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/nehal13-p/training-center-registry.git
   cd training-center-registry

Build the Project:
mvn clean install

Run the Application:
mvn spring-boot:run
The server starts at http://localhost:8080.

API Documentation
1. Create a Training Center (POST)

Endpoint: POST /api/training-centers

Headers:
Content-Type: application/json

Sample Request:
{
  "centerName": "Tech Training Hub",
  "centerCode": "Tech12345678",
  "address": {
    "detailedAddress": "456 Tech Park",
    "city": "Bangalore",
    "state": "Karnataka",
    "pincode": "560001"
  },
  "studentCapacity": 200,
  "coursesOffered": ["Java", "Spring Boot"],
  "contactEmail": "contact@techtraining.com",
  "contactPhone": "9876543210"
}
Success Response (201 Created):


{
  "id": 1,
  "centerName": "Tech Training Hub",
  "centerCode": "Tech12345678",
  "address": {
    "detailedAddress": "456 Tech Park",
    "city": "Bangalore",
    "state": "Karnataka",
    "pincode": "560001"
  },
  "studentCapacity": 200,
  "coursesOffered": ["Java", "Spring Boot"],
  "createdOn": 1698765432100,
  "contactEmail": "contact@techtraining.com",
  "contactPhone": "9876543210"
}


2. List All Training Centers (GET)

Endpoint: GET /api/training-centers

Sample Response (200 OK):

[
  {
    "id": 1,
    "centerName": "Tech Training Hub",
    "centerCode": "Tech12345678",
    "address": { ... },
    "studentCapacity": 200,
    "coursesOffered": ["Java", "Spring Boot"],
    "createdOn": 1698765432100,
    "contactEmail": "contact@techtraining.com",
    "contactPhone": "9876543210"
  }
]

Validation Rules
Field - Validation Criteria
centerName - Mandatory, ≤40 characters.
centerCode - Mandatory, exactly 12 alphanumeric characters (e.g., Abc12345678).
address - Nested object with mandatory detailedAddress, city, state, and pincode.
contactPhone - Mandatory, 10 digits (e.g., 9876543210).
contactEmail - Valid format if provided (e.g., user@example.com).
createdOn - Auto-populated by the server (user input ignored).

Testing the APIs

Using Postman:
Create a Training Center:

Method: POST

URL: http://localhost:8080/api/training-centers

Body: Raw JSON (use the sample request above).

Fetch All Centers:

Method: GET

URL: http://localhost:8080/api/training-centers.

Database Access
H2 Console URL: http://localhost:8080/h2-console

Credentials:
JDBC URL: jdbc:h2:mem:trainingdb
Username: sa
Password: (leave empty)

Sample Queries:

-- View all training centers
SELECT * FROM TRAINING_CENTER;

-- View courses offered
SELECT * FROM COURSES_OFFERED;


Project Structure

src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── traini8/
│   │           └── registry/
│   │               ├── controller/       # API endpoints (TrainingCenterController)
│   │               ├── model/            # JPA entities (TrainingCenter, Address)
│   │               ├── dto/              # Request DTO (TrainingCenterRequest)
│   │               ├── repository/       # Spring Data JPA (TrainingCenterRepository)
│   │               ├── service/          # Business logic (TrainingCenterService)
│   │               └── exception/        # Error handling (GlobalExceptionHandler)
│   └── resources/
│       └── application.properties        # H2 config, JPA settings


Technologies Used -

Spring Boot 3.1.5
H2 Database (in-memory)
Spring Data JPA
Hibernate Validator
Maven

Troubleshooting
Port Conflict: Change the port in application.properties:

properties
server.port=8081
Validation Errors: Check the HTTP 400 response for field-specific errors.
H2 Connection Issues: Ensure the JDBC URL is jdbc:h2:mem:trainingdb.
Data Not Persisting: Restart the app and recheck the H2 console.