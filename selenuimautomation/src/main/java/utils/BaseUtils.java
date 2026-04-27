package utils;

import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

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
	
	public static String getScreenShotPath(WebDriver driver, String pageName) throws IOException {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/target/screenshots/image_" + pageName + ".png";
        FileUtils.copyFile(source, new File(path));
        return path;
    }

}
