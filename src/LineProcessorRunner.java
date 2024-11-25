
import java.util.Scanner;

public class LineProcessorRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the input file path: ");
        String inputFilePath = scanner.nextLine();

        System.out.print("Enter the output file path for even lines: ");
        String evenFilePath = scanner.nextLine();

        System.out.print("Enter the output file path for odd lines: ");
        String oddFilePath = scanner.nextLine();

        LineProcessor processor = new LineProcessor();

        processor.processFile(inputFilePath, evenFilePath, oddFilePath);

        scanner.close();
    }
}
