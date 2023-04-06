package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class UpgradedDriverHelper {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private UpgradedDriverHelper() {}

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            String browser = getBrowser();
            try {
                switch (browser) {
                    case "chrome":
                        WebDriverManager.getInstance(ChromeDriver.class).setup();
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--remote-allow-origins=*");
                        driver.set(new ChromeDriver(options));
                        break;
                    case "firefox":
                        WebDriverManager.getInstance(FirefoxDriver.class).setup();
                        driver.set(new FirefoxDriver());
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid browser specified: " + browser);
                }
                driver.get().manage().window().maximize();
                driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } catch (Exception e) {
                throw new RuntimeException("Failed to initialize " + browser + " driver", e);
            }
        }
        return driver.get();
    }

    private static String getBrowser() {
        // This method can be used to retrieve the browser to use from a configuration file, system property, etc.
        return "chrome";
    }

}
