package api.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties prop = new Properties();

    static {
        try {
            String env = System.getProperty("env", "qa"); // default = qa
            FileInputStream fis =
                new FileInputStream("src/test/resources/config-" + env + ".properties");
            prop.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Config file not found");
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}
