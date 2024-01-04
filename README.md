# Contact Management System

This project implements a simple Contact Management System with REST API endpoints using Java, Spring Boot, and Maven.

## Prerequisites
- Java 8 or 11
- Maven
- Database (e.g., MySQL, PostgreSQL, H2, etc.)

## Technology Stack
- Java 8 or 11
- JUnit
- Spring Boot
- Maven
- Database of your choice

## Setting up the Database
1. Create a database for the application.
2. Update the `application.properties` file with the database connection details.

## Building the Application
1. Open a terminal and navigate to the project directory.
2. Run the following command to build the application:
   ```bash
   mvn clean install
   ```

## API Endpoints

### Create contact 

**Method** = POST,

**Endpoint** = "/createContact"

**Body**
    
    {
    "phoneNumber":"9621332946",
    "name":"Vinay",
    "address":"Delhi",
    "email":"vinay@gmail.com"
    }

### View All Contact

**Method** = GET,

**Endpoint** = "/viewAllContact"


### Delete contact

**Method** = DELETE,

**Endpoint** = "/deleteContact/${phoneNumber}"


| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `phoneNumber`      | `string` | **Required**. phoneNumber of item to fetch |

**This project is done By => Deependra Yadav**

**In 2 hours** 
















