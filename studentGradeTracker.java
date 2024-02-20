import java.util.ArrayList;
import java.util.Scanner;
class Student {
private String name;
private int id;
private ArrayList<Integer> grades;
public Student(String name, int id) {
this.name = name;
this.id = id;
this.grades = new ArrayList<>();
}
public String getName() {
return name;
}
public int getId() {
return id;
}
public void addGrade(int grade) {
grades.add(grade);
}
public ArrayList<Integer> getGrades() {
return grades;
}
public double calculateAverage() {
if (grades.isEmpty()) {
return 0.0;
}
int sum = 0;
for (int grade : grades) {
sum += grade;
}
return (double) sum / grades.size();
}
}
class GradeTracker {
private ArrayList<Student> students;
public GradeTracker() {
this.students = new ArrayList<>();
}
public void addStudent(Student student) {
students.add(student);
}
public void addStudentGrade(int id, int grade) {
for (Student student : students) {
if (student.getId() == id) {
student.addGrade(grade);
}
}
}
public void displayGrades() {
System.out.println("Student Grades:");
for (Student student : students) {
System.out.println("Name: " +student.getName());
System.out.println("ID: " +student.getId());
System.out.println("Grades: " +student.getGrades());
System.out.println("Average: " +student.calculateAverage());
System.out.println();
}
}
}
class StudentGradeTracker {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
GradeTracker gradeTracker = new GradeTracker();
gradeTracker.addStudent(new Student("JohnDoe", 1001));
gradeTracker.addStudent(new Student("JaneSmith", 1002));
gradeTracker.addStudentGrade(1001, 85);
gradeTracker.addStudentGrade(1001, 90);
gradeTracker.addStudentGrade(1002, 78);
gradeTracker.addStudentGrade(1002, 92);
gradeTracker.displayGrades();
scanner.close();
}
}
