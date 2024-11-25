import java.io.*;
import java.util.*;

public class LineProcessor {

    public void processFile(String inputFilePath, String evenFilePath, String oddFilePath) {
        BufferedReader reader = null;
        BufferedWriter evenWriter = null;
        BufferedWriter oddWriter = null;

        try {
            reader = new BufferedReader(new FileReader(inputFilePath));
            evenWriter = new BufferedWriter(new FileWriter(evenFilePath));
            oddWriter = new BufferedWriter(new FileWriter(oddFilePath));

            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                if (lineNumber % 2 == 0) {
                    evenWriter.write(line);
                    evenWriter.newLine();
                } else {
                    oddWriter.write(line);
                    oddWriter.newLine();
                }
                lineNumber++;
            }

            System.out.println("Processing complete. Even lines written to " + evenFilePath + " and Odd lines written to " + oddFilePath);
        } catch (IOException e) {
            System.err.println("An error occurred during file processing: " + e.getMessage());
        } finally {
            try {
                if (reader != null) reader.close();
                if (evenWriter != null) evenWriter.close();
                if (oddWriter != null) oddWriter.close();
            } catch (IOException e) {
                System.err.println("Error closing file streams: " + e.getMessage());
            }
        }
    }
}
