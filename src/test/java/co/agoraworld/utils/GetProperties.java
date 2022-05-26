package co.agoraworld.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class GetProperties {
    private static Logger Log = LogManager.getLogger(GetProperties.class.getName());

    private GetProperties() {
        Log.info("Getting properties");
    }

    private static Properties properties = new Properties();

    public static String getProperty(String property) {
        return properties.getProperty(property);
    }

    public static String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

    public static String getAuthUrl() {
        return properties.getProperty("AWS_URL");
    }

    static {
        String env = System.getProperty("environment") == null ? "dev" : System.getProperty("environment");
        setProperties(env);
    }

    private static void setProperties(String environment) {
        try (
            InputStreamReader reader = new InputStreamReader(
                    GetProperties.class.getResourceAsStream("/" + environment + ".properties"), "UTF-8"))
            {
                properties.load(reader);
            } catch(IOException e){
                Log.error("Cannot read properties file", e);
            }
        }
}
