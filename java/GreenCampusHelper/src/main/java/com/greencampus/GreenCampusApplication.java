package com.greencampus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Green Campus Helper Application
 * 
 * A web application to help students and staff track eco-friendly activities,
 * monitor participation, and encourage sustainable habits within a campus environment.
 * 
 * Aligned with SDG Goal 13: Climate Action
 * 
 * @author Green Campus Team
 * @version 1.0.0
 */
@SpringBootApplication
public class GreenCampusApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreenCampusApplication.class, args);
        System.out.println("\n🌱 Green Campus Helper is running!");
        System.out.println("🌍 Access the application at: http://localhost:8080");
        System.out.println("📊 H2 Console available at: http://localhost:8080/h2-console\n");
    }
}
