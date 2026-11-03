# HireLens – Resume Analyzer

HireLens is a Java Spring Boot-based Resume Analyzer that helps candidates evaluate their resumes against job descriptions. It identifies matching and missing skills and calculates a resume match score.

## Features

- User registration and login
- BCrypt password encryption
- JWT-based authentication
- Resume upload using AWS S3
- Resume metadata storage using MySQL
- Resume and job description management
- Resume-to-job-description skill matching
- Match score and missing skill analysis

## Technology Stack

| Technology | Purpose |
|---|---|
| Java | Backend programming |
| Spring Boot | REST API development |
| Spring Data JPA | Database operations |
| Spring Security | Application security |
| JWT | Authentication |
| MySQL | Data storage |
| AWS S3 | Resume file storage |
| Maven | Dependency management |
| Postman | API testing |

## Architecture

```text
             Client / Postman
                    |
                    v
             Spring Boot API
                    |
          +---------+---------+
          |                   |
          v                   v
        MySQL               AWS S3
    Resume Metadata       Resume Files
```

## Getting Started

### Prerequisites

- Java 17 or later
- Maven
- MySQL
- AWS account with an S3 bucket

### Setup

1. Clone the repository:

   ```bash
   git clone YOUR_GITHUB_REPOSITORY_URL
   ```

2. Open the project in IntelliJ IDEA.

3. Create the MySQL database:

   ```sql
   CREATE DATABASE hirelens;
   ```

4. Configure the required environment variables:

   ```text
   DB_USERNAME
   DB_PASSWORD
   JWT_SECRET
   AWS_S3_BUCKET
   AWS_REGION
   ```

5. Run the application:

   ```bash
   mvn spring-boot:run
   ```

## API Endpoints

| Method | Endpoint | Purpose |
|---|---|---|
| POST | `/api/auth/register` | Register user |
| POST | `/api/auth/login` | Login user |
| GET | `/api/users/me` | Get current user |
| POST | `/api/resumes/upload` | Upload resume |

## Project Status

Currently implementing authentication and resume upload functionality. Resume processing, skill extraction, job matching, and analysis features are planned next.

## Future Enhancements

- Separate resume processing service
- PDF text extraction using Apache Tika
- Automated skill extraction
- Resume match score calculation
- Docker-based deployment
- Asynchronous processing using Kafka or AWS SQS

## Author

**Sunil Kumar**  
B.Tech – Information Technology  
Arya College of Engineering, Jaipur
