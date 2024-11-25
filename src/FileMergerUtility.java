import java.io.*;

public class FileMergerUtility {

    public void mergeFiles(String inputFile1, String inputFile2, String outputFile) {
        BufferedReader reader1 = null;
        BufferedReader reader2 = null;
        BufferedWriter writer = null;

        try {
            reader1 = new BufferedReader(new FileReader(inputFile1));
            reader2 = new BufferedReader(new FileReader(inputFile2));

            writer = new BufferedWriter(new FileWriter(outputFile));

            String line;

            while ((line = reader1.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            while ((line = reader2.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Files merged successfully into: " + outputFile);

        } catch (IOException e) {
            System.err.println("Error during file reading or writing: " + e.getMessage());
        } finally {
            try {
                // Close the resources
                if (reader1 != null) reader1.close();
                if (reader2 != null) reader2.close();
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.err.println("Error closing the resources: " + e.getMessage());
            }
        }
    }
}
