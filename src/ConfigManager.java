import java.io.*;
import java.util.Properties;

public class ConfigManager {
    private Properties properties;
    private String configFilePath;

    public ConfigManager(String configFilePath) {
        this.configFilePath = configFilePath;
        this.properties = new Properties();
        loadProperties();
    }

    private void loadProperties() {
        try (InputStream inputStream = new FileInputStream(configFilePath)) {
            properties.load(inputStream);
        } catch (IOException e) {
            System.err.println("Error loading properties file: " + e.getMessage());
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }

    public void saveProperties() {
        try (OutputStream outputStream = new FileOutputStream(configFilePath)) {
            properties.store(outputStream, null);
        } catch (IOException e) {
            System.err.println("Error saving properties file: " + e.getMessage());
        }
    }

    public void displayProperties() {
        if (properties.isEmpty()) {
            System.out.println("No properties available.");
        } else {
            properties.forEach((key, value) -> System.out.println(key + "=" + value));
        }
    }
}
