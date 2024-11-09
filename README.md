# Student Data Management API

This project provides a simple RESTful API to manage student profiles, marks, and fees using Spring Boot. The API includes various endpoints for CRUD operations and additional features like filtering, sorting, and ranking students based on their marks. The API is documented using Swagger UI for easy interaction and testing.

## Features
- **Student Management**: 
  - Create, Read, Update, and Delete student profiles.
- **Advanced Filtering and Sorting**: 
  - Filter students by course, feesPaid status, and age.
  - Sort students by name, age, or marks.
- **Additional Endpoints**:
  - Retrieve top N students by marks.
  - Filter students by marks range.
  - Retrieve students by specific course or feesPaid status.
- **Swagger UI**: 
  - Interactive API documentation and testing interface.

## Prerequisites

- Java 17 
- Gradle
- Spring Boot 2.7.5
- Internet connection (for dependencies and API documentation)

## Installation

### Clone the repository
```bash
git clone https://github.com/logicerror2/student-data-api.git
```
Navigate to student-data-api
```bash
cd student-data-api
```

Run the Gradle
```bash
./gradlew bootRun
```

The API will be available at http://localhost:8080

Access the Swagger UI for interactive API testing at: http://localhost:8080/swagger-ui.html

Endpoints
Here are the available API endpoints:

1. GET /students: Retrieve a list of all students.
Query Parameters:
course (optional): Filter by course.
feesPaid (optional): Filter by feesPaid status.
2. GET /students/{id}: Retrieve student details by ID.
3. POST /students: Add a new student profile.
Request Body: JSON object with student details (name, age, course, marks, feesPaid).
4. PUT /students/{id}: Update student profile, marks, or fees status by ID.
Request Body: JSON object with updated student details.
5. DELETE /students/{id}: Delete a student profile by ID.
6. GET /students/top: Retrieve the top N students by marks.
Query Parameter:
n: The number of top students to retrieve.
7. GET /students/marks-range: Retrieve students with marks within a specified range.
Query Parameters:
minMarks: Minimum marks.
maxMarks: Maximum marks.
8. GET /students/filter-by-course: Retrieve students by course.
Query Parameter:
course: The course name to filter by.
9. GET /students/filter-by-fees: Retrieve students by feesPaid status.
Query Parameter:
feesPaid: Boolean value to filter by feesPaid status.
10. GET /students/sorted: Retrieve students sorted by a specified field.
Query Parameter:
sortBy: Field to sort by (name, age, marks).
11. GET /students/filtered: Retrieve students with advanced filters.
Query Parameters:
course (optional): Filter by course.
feesPaid (optional): Filter by feesPaid status.
minAge (optional): Filter by minimum age.
maxAge (optional): Filter by maximum age.

