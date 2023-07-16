package Develhope.JavaOOPAdvanced;

interface LearningPerson{
    abstract void studyAtHome();

}

interface TeachingPerson{
    abstract void teachToOtherPeople();
}

class CollegePerson{
    protected String name;
    protected String surname;
    protected int collegeId;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void goToCollege(){
        System.out.println("College Person by the name: "+ getName()+" "+getSurname()+" college ID is: "+getCollegeId());
    }
}


class Student extends CollegePerson implements LearningPerson{
    private int academicYear;

    public int getAcademicYear() {
        return academicYear;
    }

    public Student(String name, String surname, int id , int year) {
        this.name = name;
        this.surname = surname;
        this.collegeId = id;
        this.academicYear = year;
    }

    @Override
    public void studyAtHome() {

        System.out.println(getName()+" "+getSurname()+" is a student in "+getAcademicYear()+"th Year\n");

    }
}

class Professor extends CollegePerson implements TeachingPerson{
    private String teachingSubject;

    public Professor(String name,String surname, int id, String teachingSubject) {
        this.name = name;
        this.surname = surname;
        this.collegeId = id;
        this.teachingSubject = teachingSubject;
    }

    public String getTeachingSubject() {
        return teachingSubject;
    }

    @Override
    public void teachToOtherPeople() {

        System.out.println(getName()+" "+getSurname()+" is a professor lecturing: "+getTeachingSubject()+"\n");
    }
}


class Assistant extends CollegePerson implements LearningPerson,TeachingPerson{
    boolean isGoingToBeAPhD;

    public Assistant(String name,String surname, int id,boolean willBeAPhD) {
        this.isGoingToBeAPhD = willBeAPhD;
        this.name = name;
        this.surname = surname;
        this.collegeId = id;
    }

    public boolean isGoingToBeAPhD() {
        return isGoingToBeAPhD;
    }



    @Override
    public void studyAtHome() {
        System.out.println("Is "+getName()+" "+getSurname()+" going to be a PHD holder:"+(isGoingToBeAPhD()?" Yes":"No"));
    }

    @Override
    public void teachToOtherPeople() {
        System.out.println(getName()+" "+getSurname()+" is also an assistant in teaching");
    }
}

public class InterfaceTester {
    public static void main(String[] args){

        Student student = new Student("Fidelis","Maiba",1719,3);
                student.goToCollege();
                student.studyAtHome();

        Professor professor = new Professor("Jael","Gudu",102,"Multimedia Programming");
                  professor.goToCollege();
                  professor.teachToOtherPeople();

        Assistant assistant = new Assistant("Gieno","Shubaniu",4321,true);
                   assistant.goToCollege();
                   assistant.studyAtHome();
                   assistant.teachToOtherPeople();
    }
}
