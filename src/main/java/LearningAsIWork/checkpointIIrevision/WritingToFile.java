package LearningAsIWork.checkpointIIrevision;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class WritingToFile {
    public static void main(String[] args){
        try {
            Path path = Path.of("writeString.txt");
            Files.writeString(path,"maron is writting");
            Files.writeString(path,"Maron is appending",StandardOpenOption.APPEND);
            FileWriter writer = new FileWriter("greeting.txt");
            String writing = "Hey\nbonjour\nNi hao\nsasa\nGuten morgen";
                writer.write(writing);
                writer.write("I hope all is fine with you people\n");
                writer.write("thanks,byeeeeeeeeeeeeeeeeeeee,a bientot, salut\n");
                writer.write(",,,,,,,,,,,,,,,,,,");
                writer.append("Maron has appended all this again, isnt a joke\n");
                writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
