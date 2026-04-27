package utils;

import java.io.InputStream;
import java.util.Properties;

public class BaseUtils {
	
	private static Properties properties;

    static {
        try {
            properties = new Properties();
            InputStream is = BaseUtils.class.getClassLoader()
                                            .getResourceAsStream("config.properties");
            properties.load(is);
        } catch (Exception e) {
            System.err.println("Failed to load config properties.");
            e.printStackTrace();
        }
    }
	
	public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}
