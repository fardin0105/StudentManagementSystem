/**
 * Abstract superclass representing a person in the university system.
 * Demonstrates Abstraction and Encapsulation.
 */
public abstract class Person {
    // Private attributes to enforce encapsulation
    private String id;
    private String name;
    private String email;

    // Constructor
    public Person(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getter and Setter methods
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Abstract method to be overridden by subclasses (Polymorphism & Abstraction)
    public abstract void displayDetails();
}
