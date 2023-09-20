package onlineExercises.JavaOOPAdvanced;

import java.util.*;

public class MapSetTester {
    public static void main(String[] args){
        Map<String, Integer> months = new LinkedHashMap<>();
            months.put("January",1);
            months.put("February",2);
            months.put("March",3);
            months.put("April",4);
            months.put("May",5);
            months.put("June",6);
            months.put("July",7);
            months.put("August",8);
            months.put("September",9);
            months.put("October",10);
            months.put("November",11);
            months.put("December",12);
        System.out.println("Months and their respective cardinal numbers: "+months);

        Set<String> monthsSet = months.keySet();
        System.out.println("Set view of the keys: "+monthsSet);

        List<Integer> cardinalMonth =  new ArrayList<>(months.values());
        System.out.println("List of cardinal months: "+cardinalMonth);

        Integer[] cardinalMonthArray =  months.values().toArray(new Integer[0]);
        System.out.println("Array of cardinal months: "+Arrays.toString(cardinalMonthArray));


    }
}
