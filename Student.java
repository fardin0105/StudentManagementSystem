import java.util.ArrayList;

/**
 * Subclass representing a Student, inheriting from Person.
 * Demonstrates Inheritance, Encapsulation, and Polymorphism.
 */
public class Student extends Person {
    private String programme;
    private double cgpa;
    private ArrayList<Course> enrolledCourses;

    // Constructor calling superclass constructor using super()
    public Student(String id, String name, String email, String programme, double cgpa) {
        super(id, name, email);
        this.programme = programme;
        setCgpa(cgpa); // Use setter for validation
        this.enrolledCourses = new ArrayList<>();
    }

    // Getters and Setters
    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        if (cgpa >= 0.0 && cgpa <= 4.0) {
            this.cgpa = cgpa;
        } else {
            System.out.println("Invalid CGPA. Setting default to 0.0.");
            this.cgpa = 0.0;
        }
    }

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    // Method to enroll the student in a course
    public void enrollCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            System.out.println(getName() + " has been enrolled in " + course.getCourseName() + ".");
        } else {
            System.out.println(getName() + " is already enrolled in " + course.getCourseName() + ".");
        }
    }

    // Helper method to determine academic standing
    public String getAcademicStanding() {
        if (cgpa >= 3.50) {
            return "Dean's List";
        } else if (cgpa >= 2.00) {
            return "Good Standing";
        } else {
            return "Academic Probation";
        }
    }

    // Overriding abstract method from Person (Runtime Polymorphism)
    @Override
    public void displayDetails() {
        System.out.println("--------------------------------------------------");
        System.out.println("Role             : Student");
        System.out.println("Student ID       : " + getId());
        System.out.println("Full Name        : " + getName());
        System.out.println("Email            : " + getEmail());
        System.out.println("Programme        : " + programme);
        System.out.printf("CGPA             : %.2f (%s)%n", cgpa, getAcademicStanding());
        System.out.print("Enrolled Courses : ");
        if (enrolledCourses.isEmpty()) {
            System.out.println("None");
        } else {
            for (int i = 0; i < enrolledCourses.size(); i++) {
                System.out.print(enrolledCourses.get(i).getCourseCode());
                if (i < enrolledCourses.size() - 1) System.out.print(", ");
            }
            System.out.println();
        }
        System.out.println("--------------------------------------------------");
    }
}
