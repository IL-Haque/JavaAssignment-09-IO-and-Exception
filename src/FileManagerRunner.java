
import java.util.Scanner;
import java.io.*;

public class FileManagerRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the input binary file path to copy: ");
        String inputFilePath = scanner.nextLine();
        System.out.print("Enter the output binary file path: ");
        String outputFilePath = scanner.nextLine();

        FileManager fileManager = new FileManager();

        fileManager.copyFile(inputFilePath, outputFilePath);

        System.out.print("Do you want to append data to the output file? (yes/no): ");
        String appendChoice = scanner.nextLine();

        if (appendChoice.equalsIgnoreCase("yes")) {
            System.out.print("Enter the path of the file to append data to: ");
            String appendFilePath = scanner.nextLine();

            System.out.print("Enter the data to append (in bytes): ");
            String dataToAppend = scanner.nextLine();
            byte[] data = dataToAppend.getBytes();

            fileManager.appendToFile(appendFilePath, data);
        }

        scanner.close();
    }
}
