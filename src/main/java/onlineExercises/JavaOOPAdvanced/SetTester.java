package onlineExercises.JavaOOPAdvanced;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetTester {
    public static void main(String[] args){
        Set<String> daysOfTheWeek = new HashSet<>();
                daysOfTheWeek.add("Monday");
                daysOfTheWeek.add("Tuesday");
                daysOfTheWeek.add("Wednesday");
                daysOfTheWeek.add("Thursday");
                daysOfTheWeek.add("Friday");
                daysOfTheWeek.add("Saturday");
                daysOfTheWeek.add("Sunday");

        System.out.println(daysOfTheWeek);

        Set<String> orderedDaysOfTheWeek = new LinkedHashSet<>();
                 orderedDaysOfTheWeek.add("Monday");
                 orderedDaysOfTheWeek.add("Tuesday");
                 orderedDaysOfTheWeek.add("Wednesday");
                 orderedDaysOfTheWeek.add("Thursday");
                 orderedDaysOfTheWeek.add("Friday");
                 orderedDaysOfTheWeek.add("Saturday");
                 orderedDaysOfTheWeek.add("Sunday");

        System.out.println(orderedDaysOfTheWeek);

        System.out.println("Is the first Set equal to the second one? "+ (orderedDaysOfTheWeek.equals(daysOfTheWeek)?"Yes":"No"));

    }
}
