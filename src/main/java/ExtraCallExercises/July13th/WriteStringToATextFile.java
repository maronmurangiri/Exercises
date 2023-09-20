package ExtraCallExercises.July13th;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
/* Write a Java program to write a string to a text file named "output.txt". */

public class WriteStringToATextFile {
        public static void main(String[] args)
        {
        try {
            FileWriter write = new FileWriter("Output.txt");
            write.write("This is a text file");
            write.write("\n");
            write.write("thank you,byee");

            write.close();
            System.out.println("File Written successfully");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
