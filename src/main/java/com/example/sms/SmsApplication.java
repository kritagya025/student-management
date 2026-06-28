package com.example.sms;

import jakarta.validation.Valid;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/students")
public class SmsApplication {

    private List<Student> students = new ArrayList<>();
    private int nextId = 4;

    public SmsApplication() {
        students.add(new Student(1, "Kritagya Yadav", "ky@gmail.com", "Computer Science"));
        students.add(new Student(2, "Mukul Dubey",    "md@gmail.com", "Electronics"));
        students.add(new Student(3, "Krishna",        "kk@gmail.com", "Mechanical"));
    }

    @GetMapping
    public List<Student> getAll() {
        return students;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return ResponseEntity.ok(s);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found with id: " + id);
    }

    @PostMapping
    public Student add(@Valid @RequestBody Student student) {
        student.setId(nextId++);
        students.add(student);
        return student;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @Valid @RequestBody Student updatedStudent) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(updatedStudent.getName());
                s.setEmail(updatedStudent.getEmail());
                s.setDepartment(updatedStudent.getDepartment());
                return ResponseEntity.ok(s);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found with id: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        boolean removed = students.removeIf(s -> s.getId() == id);
        if (removed) {
            return ResponseEntity.ok("Student with id " + id + " deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found with id: " + id);
    }

    public static void main(String[] args) {
        SpringApplication.run(SmsApplication.class, args);
    }
}