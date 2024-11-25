
import java.util.Scanner;

public class ConfigManagerRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the configuration file path: ");
        String configFilePath = scanner.nextLine();

        ConfigManager configManager = new ConfigManager(configFilePath);

        while (true) {
            System.out.println("\nConfiguration Management");
            System.out.println("1. Display All Properties");
            System.out.println("2. Get Property Value");
            System.out.println("3. Update Property Value");
            System.out.println("4. Save Changes and Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                    configManager.displayProperties();
                    break;

                case 2:
                    System.out.print("Enter the property key to retrieve: ");
                    String key = scanner.nextLine();
                    String value = configManager.getProperty(key);
                    if (value != null) {
                        System.out.println("Value for " + key + " = " + value);
                    } else {
                        System.out.println("Property not found.");
                    }
                    break;

                case 3:

                    System.out.print("Enter the property key to update: ");
                    key = scanner.nextLine();
                    System.out.print("Enter the new value: ");
                    String newValue = scanner.nextLine();
                    configManager.setProperty(key, newValue);
                    System.out.println("Property updated.");
                    break;

                case 4:

                    configManager.saveProperties();
                    System.out.println("Changes saved. Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
