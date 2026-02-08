
// Class: GreenActivity
// Requirement: Encapsulation (private fields, public getters/setters)
public class GreenActivity {
    private String activityType;
    private int points;
    private String userEmail; // To link activity to a user

    public GreenActivity(String activityType, int points, String userEmail) {
        this.activityType = activityType;
        this.points = points;
        this.userEmail = userEmail;
    }

    // Encapsulation: Getters
    public String getActivityType() {
        return activityType;
    }

    public int getPoints() {
        return points;
    }

    public String getUserEmail() {
        return userEmail;
    }

    @Override
    public String toString() {
        return "[User: " + userEmail + "] Activity: " + activityType + " | Points: " + points;
    }
}
