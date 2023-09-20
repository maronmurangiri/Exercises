package LearningAsIWork.Stream;

import com.sun.source.doctree.SeeTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise1 {
    private static List<Integer> ourNumbers = IntStream.range(1,10).boxed().toList();


    public static void main(String[] args){
        //even numbers stream
        ourNumbers.stream()
                .filter(evenNumbers->evenNumbers%2==0)
                .forEach(evenNumbers-> System.out.println(evenNumbers));

        //odd numbers stream
        Set<Integer> oddNumber = ourNumbers.stream()
                .filter(oddNumbers->oddNumbers%2!=0)
                .map(oddNumbers->oddNumbers)
                .collect(Collectors.toSet());

        System.out.println(oddNumber);

        List<String> stringList = List.of("Mark","Oscar","Dennis","Angela","Maron");
        stringList.stream()
                .map(list->list.toUpperCase())
                .collect(Collectors.toSet())
                .forEach(list-> System.out.println(list));
                ;

        //even numeber stream multiplied by two
       Set<Integer> eveNumberMultipliedByTwo = ourNumbers.stream()
                .filter(evenNumber->evenNumber%2==0)
                .map(evenNumber->evenNumber*2)
                .collect(Collectors.toSet());
        System.out.println(eveNumberMultipliedByTwo);

    }


}
