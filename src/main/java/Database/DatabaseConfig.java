package Database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The type Database config.
 */
public class DatabaseConfig {
    private static final String DATABASE_PATH = "/database.properties";

    private final Properties properties;

    /**
     * Instantiates a new Database config.
     *
     */
    public DatabaseConfig()  {
        properties = new Properties();
        try {
            InputStream input = getClass().getResourceAsStream(DATABASE_PATH);
            properties.load(input);
        }catch (IOException ex){
            System.err.println("Не могу открыть файл для подключения к базе данных");

        }

    }

    /**
     * Gets database url.
     *
     * @return the database url
     */
    public String getDatabaseUrl() {
        return properties.getProperty("database.url");
    }

    /**
     * Gets database username.
     *
     * @return the database username
     */
    public String getDatabaseUsername() {
        return properties.getProperty("database.username");
    }

    /**
     * Gets database password.
     *
     * @return the database password
     */
    public String getDatabasePassword() {
        return properties.getProperty("database.password");
    }
}
