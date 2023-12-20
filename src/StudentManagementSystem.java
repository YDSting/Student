import java.util.ArrayList;

class Student {
    private String firstName;
    private String lastName;
    private String studentNumber;
    private String group;
    private ArrayList<Course> enrolledCourses;

    public Student(String firstName, String lastName, String studentNumber, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.group = group;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getGroup() {
        return group;
    }

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
        course.addStudent(this);
        System.out.println(firstName + " enrolled in course: " + course.getName());
    }

    public void leaveCourse(Course course) {
        enrolledCourses.remove(course);
        course.removeStudent(this);
        System.out.println(firstName + " left course: " + course.getName());
    }
}

class Course {
    private String name;
    private ArrayList<Student> enrolledStudents;

    public Course(String name) {
        this.name = name;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void addStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Student student1 = new Student("John", "Doe", "12345", "GroupA");
        Student student2 = new Student("Jane", "Smith", "67890", "GroupB");

        Course course1 = new Course("Java Programming");
        Course course2 = new Course("Database Management");

        student1.enrollInCourse(course1);
        student2.enrollInCourse(course2);

        student1.leaveCourse(course2);

        System.out.println("Courses enrolled by " + student1.getFirstName() + ": " + student1.getEnrolledCourses().size());
        System.out.println("Courses enrolled by " + student2.getFirstName() + ": " + student2.getEnrolledCourses().size());
    }
}
