package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;
    private Properties properties = new Properties();
    protected static String USERNAME;
    protected static String PASSWORD;
    protected static String BASE_URL;

    @BeforeSuite
    protected void initDriver() {
        loadProperties();
        WebDriverManager.chromedriver().setup();
        if (driver == null) {
            driver = new ChromeDriver();
        }

        driver.manage().timeouts()
                .setScriptTimeout(30, TimeUnit.SECONDS)
                .pageLoadTimeout(30, TimeUnit.SECONDS)
                .implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private void loadProperties() {
        String propPath = "tests.properties";
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream(propPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        USERNAME = properties.getProperty("username");
        PASSWORD = properties.getProperty("password");
        BASE_URL = properties.getProperty("baseUrl");
    }
}
