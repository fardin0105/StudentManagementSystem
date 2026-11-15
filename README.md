# Student Management System (Java OOP Assignment)

A console-based **Student Management System** developed in Java to demonstrate core Object-Oriented Programming (OOP) principles: **Abstraction, Encapsulation, Inheritance, and Polymorphism**.

## Project Structure
```
StudentManagementSystem/
├── src/
│   ├── Person.java      # Abstract superclass defining common person attributes & abstract methods
│   ├── Student.java     # Subclass extending Person with CGPA validation and course enrollment
│   ├── Lecturer.java    # Subclass extending Person representing academic staff
│   ├── Course.java      # Class representing university courses associated with students & lecturers
│   └── Main.java        # Console-based menu application using Scanner and runtime polymorphism
└── README.md
```

## How to Run
1. Open the repository in GitHub Codespaces or any Java IDE (VS Code, IntelliJ IDEA, Eclipse).
2. Navigate to the `src` folder:
   ```bash
   cd src
   ```
3. Compile all Java files:
   ```bash
   javac *.java
   ```
4. Run the main program:
   ```bash
   java Main
   ```
