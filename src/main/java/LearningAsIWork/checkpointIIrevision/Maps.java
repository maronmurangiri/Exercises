package LearningAsIWork.checkpointIIrevision;

import com.sun.jdi.Value;

import java.security.Key;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Maps {
    public Maps(String name){

    }
    public static void main(String[] args){
        Map<String,String> studentSchool = new HashMap<>();
            studentSchool.put("Maron", "Moi");
            studentSchool.put("Newton","CUEA");
            studentSchool.put("Karen","Chogoria");
            studentSchool.put("Angela","Loreto");
            studentSchool.put("Carson","Meru school");
        System.out.println(studentSchool.entrySet());
        System.out.println(studentSchool.size());
        System.out.println(studentSchool.get("Angela"));
        for(Map.Entry<String,String> entry : studentSchool.entrySet() ){
            System.out.println(entry.getKey()+ ", "+entry.getValue());
        }
        List<Integer> aa = new ArrayList<>(Arrays.asList(1,2,3,4,1,2,3,1,2,3,5));

        Map<Integer,Integer> result = new HashMap<>();
        //frequency
        for (int i = 0; i< aa.size();i++){
            result.putIfAbsent(aa.get(i),Collections.frequency(aa,aa.get(i)));
        }
        System.out.println(result);
    }


}
