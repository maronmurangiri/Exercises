package onlineExercises.JavaBasicsOOP;

import java.util.ArrayList;
import java.util.List;

import static java.time.LocalTime.now;

public class ReviewExercise {
    public static void main(String[] args){
        Student student1 = new Student(1,"fidelis","Maiba", "2000-02-12");
        Student student2 = new Student(2,"Vincent","Kavishe","2001-10-01");
        Student student3 = new Student(3,"Angela","Deborah","1996-01-20");
        Student student4 = new Student(4,"christine","Ombui","1992-01-29");

        Professor professor1 = new Professor(1,"Jael","Gudu","Multimedia programming");
        Professor professor2 = new Professor(2,"Shadrack","Metto","computer audit");

        professor1.assignGrade(student1,20);
        professor2.assignGrade(student2,19);

        Student[] studentArray = {student1,student2,student3,student4};
        Professor[] professorsArray = {professor1,professor2};

        System.out.println("Excellent Student");
        for (Student student : studentArray){
            if (student.isExcellent()){
                System.out.println(student.firstName+" "+student.lastName);
            }
        }

        Student highestAverageStudent =  studentArray[0];
        for (Student student:studentArray){
            if (student.calculateGradeAverage()>highestAverageStudent.calculateGradeAverage()){
                highestAverageStudent =student;
            }
        }
        System.out.println("Student with highest grade count");
        System.out.println(highestAverageStudent.getFirstName()+" "+highestAverageStudent.getLastName());

    }
}

class Student{
    int studentId;
    String firstName;
    String lastName;
    String dateOfBirth;

    List<Integer> grade ;

    public Student(int studentId, String firstName, String lastName, String dateOfBirth) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;

    }

    public Student() {
        this.grade = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Integer> getGrade() {
        return grade;
    }

    public void setGrade(List<Integer> grade) {
        this.grade = grade;
    }

   public double calculateGradeAverage(){
        double average;
        int aggregatedGrade=0;
        if(!grade.isEmpty()){
            for (int grades : grade){
                aggregatedGrade+=grades;
            }
        }
        else {
            System.out.println("The grade list is empty");
        }
        average =aggregatedGrade/grade.size();
        return average;
    }

    public boolean isExcellent(){
        return calculateGradeAverage()>2;
    }
}


class Professor{
    int id;
    String firstName;
    String lastName;
    String courseName;

    public Professor(int id, String firstName, String lastName, String courseName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseName = courseName;
    }

    public Professor(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void assignGrade(Student s, int grade){
        if (grade>=18){
            s = new Student();


            s.grade.add(grade);
        }
        else {
            System.out.println("You have failed");
        }
    }
}
