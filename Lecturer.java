/**
 * Subclass representing a Lecturer, inheriting from Person.
 * Demonstrates Inheritance and Runtime Polymorphism alongside Student.
 */
public class Lecturer extends Person {
    private String department;
    private String specialization;

    public Lecturer(String id, String name, String email, String department, String specialization) {
        super(id, name, email);
        this.department = department;
        this.specialization = specialization;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public void displayDetails() {
        System.out.println("--------------------------------------------------");
        System.out.println("Role           : Lecturer");
        System.out.println("Staff ID       : " + getId());
        System.out.println("Full Name      : " + getName());
        System.out.println("Email          : " + getEmail());
        System.out.println("Department     : " + department);
        System.out.println("Specialization : " + specialization);
        System.out.println("--------------------------------------------------");
    }
}
