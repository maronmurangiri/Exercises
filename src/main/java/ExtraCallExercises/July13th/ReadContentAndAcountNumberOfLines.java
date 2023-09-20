package ExtraCallExercises.July13th;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* Write a Java program to read the contents of a text file named "input.txt" and count the number of lines in the file. */
public class ReadContentAndAcountNumberOfLines {
    public static void main(String[] args){
        try {
            FileReader reader = new FileReader("Output.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            int lineCount = 0;

            while (bufferedReader.readLine()!= null){
                lineCount++;
            }
            System.out.println("Lines in the file: "+ lineCount);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
