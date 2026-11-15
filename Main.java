import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main driver class for the Console-Based Student Management System.
 * Handles user interaction via Scanner, control structures, and runtime polymorphism.
 */
public class Main {
    // Using Person superclass reference list to demonstrate Runtime Polymorphism
    private static ArrayList<Person> peopleList = new ArrayList<>();
    private static ArrayList<Course> courseList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        seedInitialData();
        int choice = 0;

        System.out.println("==================================================");
        System.out.println("      UNIVERSITY STUDENT MANAGEMENT SYSTEM        ");
        System.out.println("==================================================");

        // Main menu loop
        do {
            printMenu();
            System.out.print("Enter your choice (1-7): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } else {
                System.out.println("Invalid input! Please enter a number between 1 and 7.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    registerStudent();
                    break;
                case 2:
                    addCourse();
                    break;
                case 3:
                    enrollStudentInCourse();
                    break;
                case 4:
                    updateStudentCgpa();
                    break;
                case 5:
                    displayAllPeople();
                    break;
                case 6:
                    displayAllCourses();
                    break;
                case 7:
                    System.out.println("Exiting Student Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 7.");
            }
        } while (choice != 7);

        scanner.close();
    }

    // Pre-populate sample records so the system can be tested immediately
    private static void seedInitialData() {
        Lecturer lec1 = new Lecturer("L100", "Dr. Ahmad Fauzi", "ahmad@uni.edu.my",
                "Faculty of Information Technology", "Object-Oriented Programming");
        Lecturer lec2 = new Lecturer("L101", "Madam Siti Aminah", "siti@uni.edu.my",
                "Faculty of Information Technology", "Database Systems");

        Student s1 = new Student("CU12345", "Ali Bin Abu", "ali@student.uni.edu.my", "BIT", 3.75);
        Student s2 = new Student("CU12346", "Nurul Izzah", "nurul@student.uni.edu.my", "BCS", 3.40);

        Course c1 = new Course("CSF2103", "Object-Oriented Programming", 3, lec1);
        Course c2 = new Course("CSF2204", "Database Management Systems", 3, lec2);

        s1.enrollCourse(c1);

        peopleList.add(lec1);
        peopleList.add(lec2);
        peopleList.add(s1);
        peopleList.add(s2);

        courseList.add(c1);
        courseList.add(c2);
    }

    private static void printMenu() {
        System.out.println("\n------------------- MAIN MENU --------------------");
        System.out.println("1. Register New Student");
        System.out.println("2. Add New Course");
        System.out.println("3. Enroll Student in a Course");
        System.out.println("4. Update Student CGPA");
        System.out.println("5. Display All Records (Polymorphic View)");
        System.out.println("6. View Available Courses");
        System.out.println("7. Exit");
        System.out.println("--------------------------------------------------");
    }

    private static void registerStudent() {
        System.out.println("\n--- Register New Student ---");
        System.out.print("Enter Student ID (e.g., CU12347): ");
        String id = scanner.nextLine().trim();

        if (findPersonById(id) != null) {
            System.out.println("Error: A record with ID " + id + " already exists.");
            return;
        }

        System.out.print("Enter Full Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Enter Programme (e.g., BIT, BCS): ");
        String programme = scanner.nextLine().trim();

        System.out.print("Enter Current CGPA (0.00 - 4.00): ");
        double cgpa = 0.0;
        if (scanner.hasNextDouble()) {
            cgpa = scanner.nextDouble();
            scanner.nextLine();
        } else {
            scanner.nextLine();
            System.out.println("Invalid CGPA format. Defaulting to 0.00.");
        }

        Student newStudent = new Student(id, name, email, programme, cgpa);
        peopleList.add(newStudent);
        System.out.println("Student " + name + " registered successfully!");
    }

    private static void addCourse() {
        System.out.println("\n--- Add New Course ---");
        System.out.print("Enter Course Code (e.g., CSF2305): ");
        String code = scanner.nextLine().trim();

        if (findCourseByCode(code) != null) {
            System.out.println("Error: Course code " + code + " already exists.");
            return;
        }

        System.out.print("Enter Course Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Credit Hours: ");
        int credits = 3;
        if (scanner.hasNextInt()) {
            credits = scanner.nextInt();
            scanner.nextLine();
        } else {
            scanner.nextLine();
            System.out.println("Invalid input. Defaulting to 3 credits.");
        }

        System.out.print("Enter Assigned Lecturer ID (e.g., L100): ");
        String lecId = scanner.nextLine().trim();
        Person p = findPersonById(lecId);
        Lecturer assignedLec = (p instanceof Lecturer) ? (Lecturer) p : null;

        if (assignedLec == null) {
            System.out.println("Lecturer ID not found. Course will be listed with Lecturer: TBA.");
        }

        Course newCourse = new Course(code, name, credits, assignedLec);
        courseList.add(newCourse);
        System.out.println("Course " + code + " added successfully!");
    }

    private static void enrollStudentInCourse() {
        System.out.println("\n--- Enroll Student in a Course ---");
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine().trim();
        Person p = findPersonById(studentId);

        if (!(p instanceof Student)) {
            System.out.println("Error: Student ID not found.");
            return;
        }

        Student student = (Student) p;
        displayAllCourses();
        System.out.print("Enter Course Code to enroll: ");
        String courseCode = scanner.nextLine().trim();
        Course course = findCourseByCode(courseCode);

        if (course == null) {
            System.out.println("Error: Course code not found.");
            return;
        }

        student.enrollCourse(course);
    }

    private static void updateStudentCgpa() {
        System.out.println("\n--- Update Student CGPA ---");
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine().trim();
        Person p = findPersonById(studentId);

        if (!(p instanceof Student)) {
            System.out.println("Error: Student ID not found.");
            return;
        }

        Student student = (Student) p;
        System.out.printf("Current CGPA for %s: %.2f%n", student.getName(), student.getCgpa());
        System.out.print("Enter New CGPA (0.00 - 4.00): ");
        if (scanner.hasNextDouble()) {
            double newCgpa = scanner.nextDouble();
            scanner.nextLine();
            student.setCgpa(newCgpa);
            System.out.printf("Updated CGPA for %s: %.2f (%s)%n",
                    student.getName(), student.getCgpa(), student.getAcademicStanding());
        } else {
            scanner.nextLine();
            System.out.println("Invalid CGPA input. Update cancelled.");
        }
    }

    // Demonstrates Runtime Polymorphism: calling displayDetails() on Person references
    private static void displayAllPeople() {
        System.out.println("\n=== ALL UNIVERSITY RECORDS (POLYMORPHIC OUTPUT) ===");
        if (peopleList.isEmpty()) {
            System.out.println("No records available.");
            return;
        }
        for (Person p : peopleList) {
            p.displayDetails(); // Resolves to Student.displayDetails() or Lecturer.displayDetails() at runtime
        }
    }

    private static void displayAllCourses() {
        System.out.println("\n================ AVAILABLE COURSES ================");
        if (courseList.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        for (Course c : courseList) {
            c.displayCourseInfo();
        }
        System.out.println("===================================================");
    }

    private static Person findPersonById(String id) {
        for (Person p : peopleList) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }

    private static Course findCourseByCode(String code) {
        for (Course c : courseList) {
            if (c.getCourseCode().equalsIgnoreCase(code)) {
                return c;
            }
        }
        return null;
    }
}
