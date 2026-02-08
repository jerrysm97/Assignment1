
import java.util.ArrayList;
import java.util.Scanner;

// Requirement: Main class to drive the console application
public class Main {
    // Global data storage for the session
    private static ArrayList<User> users = new ArrayList<>();
    // Store all activities centrally so Admin can view them
    private static ArrayList<GreenActivity> allActivities = new ArrayList<>();
    private static User currentUser = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Pre-populate with some sample data
        initializeSystem();

        System.out.println("🌿 Welcome to Green Campus Helper 🌿");
        System.out.println("Aligning with SDG 13: Climate Action");

        while (true) {
            if (currentUser == null) {
                showAuthMenu();
            } else {
                showUserMenu();
            }
        }
    }

    private static void initializeSystem() {
        // Create one admin and one student by default
        users.add(new Admin("System Admin", "admin@green.com", "admin123"));
        users.add(new NormalUser("Alice Student", "alice@uni.edu", "pass123"));
        // No pre-logged activities
    }

    private static void showAuthMenu() {
        System.out.println("\n--- MAIN MENU ---");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");

        int choice = getIntInput();

        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                register();
                break;
            case 3:
                System.out.println("Exiting Green Campus Helper. Goodbye! 🌱");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void login() {
        System.out.print("\nEnter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.login(email, password)) {
                currentUser = user;
                System.out.println("\n✅ Login Successful! Welcome, " + user.getName());
                user.displayRole(); // Polymorphism in action
                return;
            }
        }
        System.out.println("❌ Invalid credentials.");
    }

    private static void register() {
        System.out.println("\n--- REGISTER ---");
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        
        System.out.println("Select Role:");
        System.out.println("1. Student/Staff (Normal User)");
        System.out.println("2. Administrator");
        int roleChoice = getIntInput();

        if (roleChoice == 1) {
            users.add(new NormalUser(name, email, password));
            System.out.println("✅ Registration successful! Please login.");
        } else if (roleChoice == 2) {
            users.add(new Admin(name, email, password));
            System.out.println("✅ Admin registered successfully! Please login.");
        } else {
            System.out.println("Invalid role selected. Registration failed.");
        }
    }

    private static void showUserMenu() {
        System.out.println("\n--- DASHBOARD (" + currentUser.getName() + ") ---");
        
        if (currentUser instanceof Admin) {
            adminMenu();
        } else {
            normalUserMenu();
        }
    }

    private static void adminMenu() {
        Admin admin = (Admin) currentUser;
        System.out.println("1. View All Campus Activities");
        System.out.println("2. Generate System Report");
        System.out.println("3. Logout");
        System.out.print("Choose option: ");

        int choice = getIntInput();
        switch (choice) {
            case 1:
                // Pass global list to admin
                admin.viewAllActivities(allActivities);
                break;
            case 2:
                admin.generateReport();
                break;
            case 3:
                logout();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void normalUserMenu() {
        NormalUser normalUser = (NormalUser) currentUser;
        System.out.println("1. Log Green Activity");
        System.out.println("2. View My Activities");
        System.out.println("3. Logout");
        System.out.print("Choose option: ");

        int choice = getIntInput();
        switch (choice) {
            case 1:
                logNewActivity(normalUser);
                break;
            case 2:
                normalUser.viewMyActivities();
                break;
            case 3:
                logout();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void logNewActivity(NormalUser user) {
        System.out.println("\nSelect Activity:");
        System.out.println("1. Walking/Cycling (10 pts)");
        System.out.println("2. Save Electricity (15 pts)");
        System.out.println("3. Plant Trees (25 pts)");
        
        int choice = getIntInput();
        String type = "";
        int points = 0;

        switch (choice) {
            case 1: type = "Walking/Cycling"; points = 10; break;
            case 2: type = "Save Electricity"; points = 15; break;
            case 3: type = "Plant Trees"; points = 25; break;
            default: System.out.println("Invalid activity."); return;
        }

        user.logActivity(type, points);
        
        // Also add to global list so Admin can see it
        allActivities.add(new GreenActivity(type, points, user.getEmail()));
    }

    private static void logout() {
        currentUser = null;
        System.out.println("Logged out.");
    }

    // Requirement: Basic Exception Handling (try-catch)
    private static int getIntInput() {
        try {
            String line = scanner.nextLine();
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.out.println("⚠️ Error: Please enter a valid number.");
            return -1;
        }
    }
}
