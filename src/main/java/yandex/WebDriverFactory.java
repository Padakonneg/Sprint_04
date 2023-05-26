package yandex;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    public static WebDriver get(){

        WebDriver driver;
        String browserName = System.getProperty("browserName");

        switch (browserName){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--no-sandbox","--disable-dev-shm-usage");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
                System.setProperty("webdriver.gecko.driver", "E:\\WebDriver\\bin\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Browser is not detected");
        }
        return driver;
    }
}