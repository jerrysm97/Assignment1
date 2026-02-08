
import java.util.ArrayList;

// Class: NormalUser
// Requirement: Inheritance (extends User)
public class NormalUser extends User {

    private ArrayList<GreenActivity> myActivities;

    public NormalUser(String name, String email, String password) {
        super(name, email, password, "Student");
        this.myActivities = new ArrayList<>();
    }

    // Polymorphism: Overriding abstract method
    @Override
    public void displayRole() {
        System.out.println("Role: Student/Staff - Participant in Green Initiatives.");
    }

    public void logActivity(String type, int points) {
        GreenActivity activity = new GreenActivity(type, points, this.getEmail());
        myActivities.add(activity);
        System.out.println("✅ Activity logged: " + type + " (" + points + " pts)");
    }

    public void viewMyActivities() {
        System.out.println("\n--- 📜 My Activity History ---");
        if (myActivities.isEmpty()) {
            System.out.println("No activites logged yet.");
        } else {
            for (GreenActivity activity : myActivities) {
                System.out.println(activity); // Uses GreenActivity.toString()
            }
        }
    }
}
