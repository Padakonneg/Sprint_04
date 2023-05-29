package yandex;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest{
    WebDriver driver;

    //Запуск теста
    @Before
    public void startUp() {
        driver = WebDriverFactory.get();
    }

    //Окончание теста
    @After
    public void exitTest() {
        driver.quit();
    }
}