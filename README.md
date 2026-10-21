# MedCore HMS – Cloud-Based Hospital Management System

MedCore HMS is a cloud-deployed hospital management backend developed using Java and Spring Boot. It provides REST APIs for managing patients, doctors, appointments, and medical records, with database integration and a web interface for accessing the available API endpoints.

## Live Demo

- **Application:** https://medcore-hms-v6rw.onrender.com
- **GitHub Repository:** https://github.com/adityasahay12/medcore-hms

## Technologies Used

- **Programming Language:** Java
- **Backend Framework:** Spring Boot
- **API Architecture:** RESTful APIs
- **Persistence:** Spring Data JPA and Hibernate
- **Database:** TiDB Cloud (MySQL-compatible)
- **Build Tool:** Maven
- **Containerization:** Docker
- **Cloud Deployment:** Render
- **Version Control:** Git and GitHub

## Features

- Patient record creation and retrieval
- Doctor management APIs
- Appointment management APIs
- Medical record management APIs
- Database integration using Spring Data JPA and Hibernate
- Cloud deployment using Docker and Render
- Environment-variable-based database configuration
- Web homepage with links to API endpoints

## API Endpoints

The following endpoints are available in the deployed application.

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/api/patients` | Retrieve patient records |
| POST | `/api/patients` | Create a patient record |
| GET | `/api/doctors` | Retrieve doctor records |
| GET | `/api/appointments` | Retrieve appointment records |
| GET | `/api/medical-records` | Retrieve medical records |

**Base URL:** `https://medcore-hms-v6rw.onrender.com`

For example, to retrieve patients, open:

`https://medcore-hms-v6rw.onrender.com/api/patients`

An empty JSON array (`[]`) indicates that no records are currently returned by that endpoint.

## Prerequisites

To run the project locally, install:

- Java Development Kit (JDK)
- Maven or the included Maven Wrapper
- MySQL-compatible database
- Git

## Run Locally

1. Clone the repository:

   ```bash
   git clone https://github.com/adityasahay12/medcore-hms.git
   ```

2. Navigate to the project directory:

   ```bash
   cd medcore-hms
   ```

3. Configure the database connection using environment variables.

   Example for PowerShell:

   ```powershell
   $env:DB_URL="jdbc:mysql://localhost:3306/medcore_hms"
   $env:DB_USERNAME="root"
   $env:DB_PASSWORD="your_database_password"
   ```

   Replace the example password with your own local database password. Never commit actual credentials to GitHub.

4. Start the application using the Maven Wrapper on Windows:

   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

   If Maven is installed separately, you can use:

   ```bash
   mvn spring-boot:run
   ```

5. Open the application:

   `http://localhost:8080`

## Database Configuration

The application uses environment variables for database credentials:

- `DB_URL` – Database JDBC connection URL
- `DB_USERNAME` – Database username
- `DB_PASSWORD` – Database password

For local development, the application can use a local MySQL database. For cloud deployment, configure these variables in the hosting platform with the appropriate cloud database connection details.

Hibernate is configured to update the database schema automatically during application startup.

## Deployment

The application is containerized using Docker and deployed on Render. The deployed backend connects to a cloud-hosted, MySQL-compatible database.

The live deployment can be accessed at:

https://medcore-hms-v6rw.onrender.com

## Project Structure

```text
medcore-hms/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/medcore/hms/
│   │   │       ├── controller/
│   │   │       ├── entity/
│   │   │       ├── repository/
│   │   │       ├── config/
│   │   │       └── MedcoreHmsApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   │           └── index.html
│   └── test/
├── Dockerfile
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

*Note: The structure above summarizes the main project components; exact package and file names may vary.*

## Testing

The deployed application has been checked through its REST endpoints. Patient record creation and retrieval have been tested, and the GET endpoints for doctors, appointments, and medical records have been checked for JSON responses.

## Security Considerations

- Store database credentials in environment variables.
- Do not commit passwords, tokens, or other secrets to the repository.
- Use fictional data when testing the application.
- Review authentication, authorization, and access controls before using real patient information.

## Future Enhancements

- Role-based access control for administrators, doctors, and other authorized users
- Input validation and centralized exception handling
- Appointment scheduling and status management
- Expanded automated testing
- Enhanced API documentation and monitoring

## Author

**MedCore HMS – Backend Internship Project**

Developed using Java, Spring Boot, REST APIs, Spring Data JPA/Hibernate, and a MySQL-compatible cloud database.

