import java.io.*;
import java.util.*;

public class UrlDownloaderRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the path of the file containing URLs: ");
        String urlListFile = scanner.nextLine();

        UrlDownloader downloader = new UrlDownloader();

        try {
            File file = new File(urlListFile);
            if (!file.exists()) {
                System.out.println("The URL list file does not exist.");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String url;
            int count = 1;

            while ((url = reader.readLine()) != null) {
                String outputFile = "output" + count + ".txt";
                downloader.downloadContent(url, outputFile);
                count++;
            }

            reader.close();

        } catch (IOException e) {
            System.err.println("Error reading the URL list file: " + e.getMessage());
        }

        scanner.close();
    }
}
