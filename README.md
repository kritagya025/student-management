# Student Management System

My first Spring Boot project.

I started learning Java and Spring Boot a few weeks ago.
I built this project step by step to practice what I learned.

---

## What it does

- GET `/students` — returns all students
- GET `/students/{id}` — returns one student by ID (404 if not found)
- POST `/students` — add a new student (with validation)
- PUT `/students/{id}` — update a student (404 if not found, with validation)
- DELETE `/students/{id}` — delete a student (404 if not found)

---

## Validation

- Name is required
- Email is required and must be a valid email format
- Department is required

If any field is invalid, the API returns a `400 Bad Request` with a clear message for each field:

```json
{
  "name": "Name is required",
  "email": "Email should be valid"
}
```

---

## Error Handling

If a student ID does not exist, the API returns a proper `404 Not Found` instead of `null`:

```json
"Student not found with id: 99"
```

---

## Tech Used

- Java 17
- Spring Boot 3.2
- Spring Boot Validation
- Maven

---

## How to Run

```bash
mvn spring-boot:run
```

Then open browser and go to:

```
http://localhost:8080/students
```

---

## Sample Output

```json
[
  { "id": 1, "name": "Kritagya Yadav", "email": "ky@gmail.com", "department": "Computer Science" },
  { "id": 2, "name": "Mukul Dubey",    "email": "md@gmail.com", "department": "Electronics" },
  { "id": 3, "name": "Krishna",        "email": "kk@gmail.com", "department": "Mechanical" }
]
```

---

## What I want to add next

- Connect to a real database (PostgreSQL)
- Search students by department or name
- Pagination for the GET all students endpoint
