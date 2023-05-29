package yandex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderScooterPages {

    private final By inputName = By.xpath(".//input[@placeholder='* Имя']");
    private final By inputSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By inputAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By inputMetro = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By inputNumberPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By buttonNext = By.xpath(".//button[text()= 'Далее']");
    private final By statusOrder = By.xpath(".//button[text()= 'Статус заказа']");
    private final By inputFirstTextMetro = By.xpath(".//button/div[text() = 'Сокол']");
    //Кнопка возврата в стартовое меню
    private final By buttonStartPages = By.xpath(".//a[@class ='Header_LogoScooter__3lsAR']");
    private final WebDriver driver;


    public OrderScooterPages(WebDriver driver) {
        this.driver = driver;
    }

    public OrderScooterPages setInputName(String name) {
        WebElement element = driver.findElement(inputName);
        element.click();
        element.sendKeys(name);
        return this;
    }

    public OrderScooterPages setInputSurname(String surname) {
        WebElement element = driver.findElement(inputSurname);
        element.click();
        element.sendKeys(surname);
        return this;
    }

    public OrderScooterPages setInputAddress(String address) {
        WebElement element = driver.findElement(inputAddress);
        element.click();
        element.sendKeys(address);
        return this;
    }

    public OrderScooterPages setInputMetro(String metro) {
        WebElement element = driver.findElement(inputMetro);
        element.click();
        element.sendKeys(metro);
        driver.findElement(By.xpath(".//button/div[text() = '" + metro + "']")).click();
        return this;
    }

    public OrderScooterPages setNumberPhone(String phone) {
        WebElement element = driver.findElement(inputNumberPhone);
        element.click();
        element.sendKeys(phone);
        return this;
    }

    public OrderScooterPages clickButtonNext() {
        driver.findElement(buttonNext).click();
        return this;
    }

    public OrderScooterPages clickButtonStartPages() {
        driver.findElement(buttonStartPages).click();
        return this;
    }

    public OrderScooterPages forWhomOrder(String name, String surname, String address, String metro, String phone){
        setInputName(name);
        setInputSurname(surname);
        setInputAddress(address);
        setInputMetro(metro);
        setNumberPhone(phone);
        return this;
    }
}