/**
 * Class representing a University Course.
 * Demonstrates Encapsulation and Association with Student and Lecturer.
 */
public class Course {
    private String courseCode;
    private String courseName;
    private int creditHours;
    private Lecturer lecturer;

    public Course(String courseCode, String courseName, int creditHours, Lecturer lecturer) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.lecturer = lecturer;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public void displayCourseInfo() {
        String lecturerName = (lecturer != null) ? lecturer.getName() : "TBA";
        System.out.printf("%-10s | %-30s | %d Credits | Lecturer: %s%n",
                courseCode, courseName, creditHours, lecturerName);
    }
}
