package LearningAsIWork.checkpointIIrevision;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class ReadingAFile {
    public static void main(String[] args){
        try {
            Path path = Path.of("greeting.txt");
            FileReader fileReader = new FileReader(path.toFile());

            int character = 0;
            int characterCount=0;
            int lineCount = 0;

            //character read and count
            while ((character = fileReader.read()) != -1){
                System.out.print((char)character);
                characterCount++;
            }

            //line read and count
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while(bufferedReader.readLine()!=null ){
                lineCount++;
            }
            System.out.println("Linecount "+lineCount);


            System.out.println("characterCount "+characterCount);
            fileReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
