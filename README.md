# Student Management System

My first Spring Boot project.

I just started learning Java and Spring Boot a few days ago.
I built this small project to practice what I learned.

---

## What it does

- GET `/students` — returns all students
- GET `/students/{id}` — returns one student by ID

---

## Tech Used

- Java 17
- Spring Boot 3.2
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
  { "id": 1, "name": "Kritagya Yadav",  "email": "ky@gmail.com", "department": "Computer Science" },
  { "id": 2, "name": "Mukul Dubey",   "email": "md@gmail.com", "department": "Electronics" },
  { "id": 3, "name": "Krishna",    "email": "kk@gmail.com",  "department": "Mechanical" }
]
```

---

## What I want to add next

- POST — add a new student
- PUT — update a student
- DELETE — delete a student
- Connect to a real database
