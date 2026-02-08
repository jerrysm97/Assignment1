
import java.util.ArrayList;

// Class: Admin
// Requirement: Inheritance (extends User), Interface Implementation (implements Reportable)
public class Admin extends User implements Reportable {

    public Admin(String name, String email, String password) {
        super(name, email, password, "Admin");
    }

    // Polymorphism: Overriding abstract method from User
    @Override
    public void displayRole() {
        System.out.println("Role: Campus Administrator - Monitoring Sustainability.");
    }

    // Interface Implementation
    @Override
    public void generateReport() {
        System.out.println("\n--- 📊 SYSTEM REPORT ---");
        System.out.println("Generating report for sustainability committee...");
        // In a real app, this would calculate stats. 
        // Logic handled in Main for simplicity in this console design, 
        // or we could pass the list here.
        System.out.println("Report generation complete.");
    }
    
    public void viewAllActivities(ArrayList<GreenActivity> allActivities) {
        System.out.println("\n--- 🌍 All Campus Activities ---");
        if (allActivities.isEmpty()) {
            System.out.println("No activities logged yet.");
        } else {
            for (GreenActivity activity : allActivities) {
                System.out.println(activity);
            }
        }
    }
}
