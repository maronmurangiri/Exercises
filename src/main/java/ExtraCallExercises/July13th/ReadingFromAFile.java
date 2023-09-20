package ExtraCallExercises.July13th;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

/* Write a Java program to read the contents of a text file named "input.txt" and display them on the console. */
public class ReadingFromAFile {
    public static void main(String[] args){
        try {
            //Path path =  Path.of("Output.txt");
            Path path = Path.of("Output.txt");
            FileReader fileReader = new FileReader(path.toFile());
            int character;

            while ((character = fileReader.read()) != -1) {
                System.out.print((char) character);
            }
            fileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
