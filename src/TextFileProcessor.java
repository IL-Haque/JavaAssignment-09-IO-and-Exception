import java.io.*;
import java.nio.file.*;

public class TextFileProcessor {


    public void replaceWordInFile(String filePath, String targetWord, String replacementWord) {
        try {

            String content = new String(Files.readAllBytes(Paths.get(filePath)));


            content = content.replaceAll("\\b" + targetWord + "\\b", replacementWord);


            Files.write(Paths.get(filePath), content.getBytes());
            System.out.println("The word has been replaced and the file has been updated.");

        } catch (IOException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
    }
}
