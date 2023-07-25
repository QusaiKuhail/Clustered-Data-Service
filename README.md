# Clustered Data Service

Clustered Data Service is a Spring Boot application that provides a RESTful API for managing foreign exchange (FX) deals.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Tests](#tests)
- [Docker](#docker)

## Features

- Save new FX deals.
- Validate and handle errors for duplicate FX deal entries.
- Perform basic CRUD operations on FX deals.

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Docker

## Getting Started

### Prerequisites

- Java 17 should be installed.
- Docker should be installed (optional).

### Installation

1. Clone the repository:
   ```
   git clone https://github.com/QusaiKuhail/Clustered-Data-Service.git
   ```

2. Navigate to the project directory:
   ```
   cd clustered-data-service
   ```

3. Build the project:
   ```
   mvn clean install
   ```

## Usage

To run the application locally, execute the following command:
```
java -jar target/clustered-data-service-0.0.1-SNAPSHOT.jar
```

The application will start, and you can access it at `http://localhost:8080`.

## API Endpoints

The application exposes the following API endpoints:

- `POST /fxdeals`: Create a new FX deal.

## Tests

To run the tests, execute the following command:
```
mvn test
```

## Docker

The application can be containerized using Docker. To build a Docker image, run:
```
docker build -t clustered-data-service .
```

To run the application in a Docker container, execute the following command:
```
docker run -p 8080:8080 clustered-data-service
```
