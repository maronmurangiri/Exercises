package onlineExercises.JavaOOPAdvanced;

public class Months {

    public enum Month {
        JANUARY,
        FEBRUARY,
        MARCH,
        APRIL,
        MAY,
        JUNE,
        JULY,
        AUGUST,
        SEPTEMBER,
        OCTOBER,
        NOVEMBER,
        DECEMBER;
    }

    public static void main(String[] args){
        for (Month month : Month.values()){
            if (month.toString().toLowerCase().endsWith("y")){
                System.out.println(month+" ends with Y");
            }
            else {
                System.out.println( month+" doesn't end with Y");
            }
        }
    }


}
