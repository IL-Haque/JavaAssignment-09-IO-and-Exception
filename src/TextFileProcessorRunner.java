
import java.util.Scanner;

public class TextFileProcessorRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        System.out.print("Enter the word to be replaced: ");
        String targetWord = scanner.nextLine();

        System.out.print("Enter the replacement word: ");
        String replacementWord = scanner.nextLine();


        TextFileProcessor fileProcessor = new TextFileProcessor();

        fileProcessor.replaceWordInFile(filePath, targetWord, replacementWord);

        scanner.close();
    }
}
