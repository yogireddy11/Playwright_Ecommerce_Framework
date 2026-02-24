package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    static {
        try {
            FileInputStream inputStream = new FileInputStream("src/test/resources/config.properties");
            prop = new Properties();
            prop.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getKey(String key){
        return prop.getProperty(key);
    }

}
