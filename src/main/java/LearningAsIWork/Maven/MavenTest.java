package LearningAsIWork.Maven;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class MavenTest {
    public static void main(String[] args){
        try {
            System.out.println(Unirest.get("https://5027.000webhostapp.com/").asString().getBody());
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }
}
