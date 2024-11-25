import java.io.*;

public class FileManager {

    public void copyFile(String inputFilePath, String outputFilePath) {
        try (InputStream inputStream = new FileInputStream(inputFilePath);
             OutputStream outputStream = new FileOutputStream(outputFilePath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.err.println("Error during file copy: " + e.getMessage());
        }
    }

    public void appendToFile(String filePath, byte[] data) {
        try (OutputStream outputStream = new FileOutputStream(filePath, true)) {
            outputStream.write(data);
            System.out.println("Data appended successfully.");
        } catch (IOException e) {
            System.err.println("Error appending to file: " + e.getMessage());
        }
    }
}
