package dmi.ju.runner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class ProjectUtils {

    private static final String PROP_USERNAME = "user.username";
    private static final String PROP_PASSWORD = "user.password";
    private static final String PROP_BASE_URL = "baseUrl";
    private static final String PROP_CHROME_OPTIONS = "chrome_options";


    private static Properties properties;


    private static void initProperties() {
        if (properties == null) {
            properties = new Properties();

            try {
                InputStream inputStream = BaseTest.class.getClassLoader().getResourceAsStream("local.properties");
                if (inputStream == null) {
                    System.out.println("ERROR: The \u001B[31mlocal.properties\u001B[0m file not found in src/test/resources/ directory.");
                    System.out.println("You need to create it from local.properties.TEMPLATE file.");
                    System.exit(1);
                }
                properties.load(inputStream);
            } catch (IOException ignore) {
            }
        }
    }

    static final ChromeOptions chromeOptions;

    static {
        initProperties();

        chromeOptions = new ChromeOptions();
        String options = properties.getProperty(PROP_CHROME_OPTIONS);
        if (options != null) {
            for (String argument : options.split(";")) {
                chromeOptions.addArguments(argument);
            }
        }

        WebDriverManager.chromedriver().setup();
    }

    public static void log(String str) {
        System.out.println(str);
    }

    public static void logf(String str, Object... arr) {
        System.out.printf(str, arr);
        System.out.println();
    }

    static String getUrl() {
        return properties.getProperty(PROP_BASE_URL);
    }


    static void get(WebDriver driver) {
        driver.get(getUrl());
    }

    static WebDriver createDriver() {
        WebDriver driver = new ChromeDriver(ProjectUtils.chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }
}
