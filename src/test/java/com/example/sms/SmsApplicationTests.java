package com.example.sms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SmsApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void studentProperties() {
        Student sample = new Student(99, "Test User", "test@domain.com", "Physics");
        assertEquals(99, sample.getId());
        assertEquals("Test User", sample.getName());
        assertEquals("test@domain.com", sample.getEmail());
        assertEquals("Physics", sample.getDepartment());
    }
}
