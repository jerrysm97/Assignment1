package com.greencampus.model;

import jakarta.persistence.*;

/**
 * GreenActivity represents an eco-friendly action logged by a user.
 * Demonstrates Encapsulation with private fields and public getters/setters.
 */
@Entity
public class GreenActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activityID;
    
    private String activityType;
    private String date; // Stored as String for simplicity, or LocalDate
    private int points;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public GreenActivity() {
    }

    public GreenActivity(String activityType, String date, int points, User user) {
        this.activityType = activityType;
        this.date = date;
        this.points = points;
        this.user = user;
    }

    // Encapsulation: Public getters and setters
    public Long getActivityID() {
        return activityID;
    }

    public void setActivityID(Long activityID) {
        this.activityID = activityID;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
