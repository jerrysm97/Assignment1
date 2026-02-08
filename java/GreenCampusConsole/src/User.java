
// Abstract Class: User
// Requirement: Encapsulation (private fields), Inheritance (Superclass), Abstraction
public abstract class User {
    // Encapsulation: Private fields
    private String name;
    private String email;
    private String password;
    private String role;

    public User(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Encapsulation: Public Getters and Setters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public boolean login(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    // Abstract Method (Polymorphism)
    public abstract void displayRole();
}
