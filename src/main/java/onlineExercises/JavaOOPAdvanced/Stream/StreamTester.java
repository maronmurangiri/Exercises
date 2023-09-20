package onlineExercises.JavaOOPAdvanced.Stream;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

class WriteAFile{
    public void writingAFile(){
        FileWriter writer = null;
        try {
            writer = new FileWriter("onlineExercises/JavaOOPAdvanced/Stream/file.txt");
            writer.write("hello\n");
            writer.write("how\n");
            writer.write("are you\n");
            writer.write("?");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
public class StreamTester {
    public static void main(String[] args) {
        WriteAFile writeAFile = new WriteAFile();
                writeAFile.writingAFile();


        Path filePath =Path.of("onlineExercises/JavaOOPAdvanced/Stream/file.txt");
        try {
            Stream<String> fileLines = Files.lines(filePath);
            fileLines.forEach(lines-> System.out.println(lines));
            System.out.println(Files.readString(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    }




