package utils;

import java.io.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadPropertiesFile {

    private static final Logger logger = Logger.getLogger(ReadPropertiesFile.class.getName());
    private static final Properties prop = new Properties();
    private static String env = "prod";

    static {
        String environment = System.getProperty("env", env);
        loadProperties(environment);
    }

    private ReadPropertiesFile() {
    }

    /**
     * Loads properties from the specified environment file.
     *
     * @param environment The environment (e.g., "dev", "prod", "test").
     */
    private static void loadProperties(String environment) {
        String fileName = "/" + environment + ".properties";

        try (InputStream inputStream = ReadPropertiesFile.class.getResourceAsStream(fileName)) {
            if (inputStream == null) {
                logger.log(Level.SEVERE, "Property file '{0}' not found in the classpath", fileName);
                throw new FileNotFoundException("Property file not found: " + fileName);
            }
            prop.load(inputStream);
            logger.info("Properties file loaded successfully for environment: " + environment);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error loading properties file: " + fileName, e);
            throw new RuntimeException("Failed to load properties file", e);
        }
    }

    /**
     * Gets the value associated with the given key from the properties file.
     *
     * @param key The key for which the value is to be fetched.
     * @return The value associated with the key, or null if the key doesn't exist.
     */
    public static String getPropertyValue(String key) {
        return prop.getProperty(key);
    }

    /**
     * Sets the environment for the properties file. This allows for switching environments at runtime.
     *
     * @param environment The environment (e.g., "dev", "prod", "test").
     */
    public static void setEnv(String environment) {
        env = environment;
        loadProperties(env);
    }
}
