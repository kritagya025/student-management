package com.example.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/students")
public class SmsApplication {

    private List<Student> students = new ArrayList<>();

    public SmsApplication() {
        students.add(new Student(1, "Kritagya Yadav",  "ky@gmail.com",  "Computer Science"));
        students.add(new Student(2, "Mukul Dubey",   "md@gmail.com",  "Electronics"));
        students.add(new Student(3, "Krishna",    "kk@gmail.com",   "Mechanical"));
    }

    @GetMapping
    public List<Student> getAll() {
        return students;
    }

    @GetMapping("/{id}")
    public Student getOne(@PathVariable int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public static void main(String[] args) {
        SpringApplication.run(SmsApplication.class, args);
    }
}
