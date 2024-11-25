
import java.io.*;
        import java.util.*;

public class EmailValidatorRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path of the file containing email addresses: ");
        String emailListFile = scanner.nextLine();

        System.out.print("Enter the path of the output file for valid emails: ");
        String outputFile = scanner.nextLine();

        EmailValidator emailValidator = new EmailValidator();

        try {
            File file = new File(emailListFile);
            if (!file.exists()) {
                System.out.println("The email list file does not exist.");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String email;
            int count = 0;

            while ((email = reader.readLine()) != null) {
                email = email.trim();
                if (emailValidator.isValidEmail(email)) {
                    writer.write(email);
                    writer.newLine();
                    count++;
                }
            }

            reader.close();
            writer.close();

            System.out.println("Validation completed. " + count + " valid email(s) saved to " + outputFile);

        } catch (IOException e) {
            System.err.println("Error reading or writing files: " + e.getMessage());
        }

        scanner.close();
    }
}
