package Develhope.JavaOOPAdvanced;

import java.util.HashMap;
import java.util.Map;

public class MapTester {
    public static void main(String[] args){
        Map<Integer,String> numbersFrom1To5 = new HashMap<>();
                numbersFrom1To5.put(1,"One");
                numbersFrom1To5.put(2,"Two");
                numbersFrom1To5.put(3,"Three");
                numbersFrom1To5.put(4,"Four");
                numbersFrom1To5.put(5,"Five");


        Map<Integer,String> oddNumbersForm1to9 = new HashMap<>();
                oddNumbersForm1to9.put(1,"Uno");
                oddNumbersForm1to9.put(3,"Tre");
                oddNumbersForm1to9.put(5,"cinque");
                oddNumbersForm1to9.put(7,"Sette");
                oddNumbersForm1to9.put(9,"Nove");


        numbersFrom1To5.putAll(oddNumbersForm1to9);
        System.out.println(numbersFrom1To5);

        for (int i =5;i<=9;i++){
            if (numbersFrom1To5.containsKey(i)){
                System.out.println(i+" = "+numbersFrom1To5.get(i));
            }
            else {
                System.out.println(i+": No associated value");
            }
        }
    }
}
