import java.util.Scanner;

public class FileMergerUtilityRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the path of the first text file: ");
        String inputFile1 = scanner.nextLine();

        System.out.print("Enter the path of the second text file: ");
        String inputFile2 = scanner.nextLine();

        System.out.print("Enter the path for the output merged file: ");
        String outputFile = scanner.nextLine();

        FileMergerUtility fileMergerUtility = new FileMergerUtility();

        fileMergerUtility.mergeFiles(inputFile1, inputFile2, outputFile);

        scanner.close();
    }
}
