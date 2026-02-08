package com.greencampus.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * Admin user subclass.
 * Demonstrates Inheritance (extends User) and Interface Implementation (implements Reportable).
 */
@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User implements Reportable {

    public Admin() {
        super();
        setRole("ADMIN");
    }

    public Admin(String name, String email, String password) {
        super(name, email, password, "ADMIN");
    }

    // Polymorphism: Overriding abstract method
    @Override
    public String displayRole() {
        return "Administrator - Campus Sustainability Monitor";
    }

    // Interface Implementation
    @Override
    public String generateReport() {
        return "Generating system-wide sustainability report...";
    }
    
    public void viewAllActivities() {
        // Implementation logic would go here
    }
}
