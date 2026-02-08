package com.greencampus.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * NormalUser subclass representing students/staff.
 * Demonstrates Inheritance.
 */
@Entity
@DiscriminatorValue("STUDENT")
public class NormalUser extends User {

    public NormalUser() {
        super();
        setRole("STUDENT");
    }

    public NormalUser(String name, String email, String password) {
        super(name, email, password, "STUDENT");
    }

    // Polymorphism: Overriding abstract method
    @Override
    public String displayRole() {
        return "Campus Member - Green Activity Participant";
    }
    
    public void logActivity() {
        // Implementation logic
    }
}
