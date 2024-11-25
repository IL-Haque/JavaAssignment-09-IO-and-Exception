import java.io.*;
import java.net.*;

public class UrlDownloader {

    public void downloadContent(String urlString, String outputFile) {
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            URL url = new URL(urlString);

            URLConnection connection = url.openConnection();

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            writer = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Content from " + urlString + " saved to " + outputFile);

        } catch (IOException e) {
            System.err.println("Error downloading content from URL: " + urlString + " - " + e.getMessage());
        } finally {
            try {

                if (reader != null) reader.close();
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.err.println("Error closing the resources: " + e.getMessage());
            }
        }
    }
}
