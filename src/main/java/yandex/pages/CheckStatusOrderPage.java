package yandex.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckStatusOrderPage {

    private final By surnameInOrder = By.xpath(".//div/div[text() = 'Фамилия']/following-sibling::*");
    private final By nameInOrder = By.xpath(".//div/div[text() = 'Имя']/following-sibling::*");
    private final By addressInOrder = By.xpath(".//div/div[text() = 'Адрес']/following-sibling::*");
    private final By metroInOrder = By.xpath(".//div/div[text() = 'Станция метро']/following-sibling::*");
    private final By phoneNumberInOrder = By.xpath(".//div/div[text() = 'Телефон']/following-sibling::*");
    private final By rentalPeriodInOrder = By.xpath(".//div/div[text() = 'Срок аренды']/following-sibling::*");
    private final By colorInOrder = By.xpath(".//div/div[text() = 'Цвет']/following-sibling::*");
    private final By commentInOrder = By.xpath(".//div/div[text() = 'Комментарий']/following-sibling::*");
    private final WebDriver driver;

    public CheckStatusOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public CheckStatusOrderPage checkSurnameInOrder(String surname) {
        Assert.assertEquals("Фамилия в заказе некорректное", surname, driver.findElement(surnameInOrder).getText());
        return this;
    }

    public CheckStatusOrderPage checkNameInOrder(String name) {
        Assert.assertEquals("Имя в заказе некорректное", name, driver.findElement(nameInOrder).getText());
        return this;
    }

    public CheckStatusOrderPage checkAddressInOrder(String address) {
        Assert.assertEquals("Адрес в заказе некорректен", address, driver.findElement(addressInOrder).getText());
        return this;
    }

    public CheckStatusOrderPage checkMetroInOrder(String metro) {
        Assert.assertEquals("Метро в заказе некорректно", metro, driver.findElement(metroInOrder).getText());
        return this;
    }

    public CheckStatusOrderPage checkPhoneInOrder(String phone) {
        Assert.assertEquals("Телефон в заказе некорректен", phone, driver.findElement(phoneNumberInOrder).getText());
        return this;
    }

    public CheckStatusOrderPage checkPeriodInOrder(String period) {
        Assert.assertEquals("Период в заказе некорректен", period, driver.findElement(rentalPeriodInOrder).getText());
        return this;
    }

    public CheckStatusOrderPage checkColorInOrder(String color) {
        Assert.assertEquals("Период в заказе некорректен", color, driver.findElement(colorInOrder).getText());
        return this;
    }

    public CheckStatusOrderPage checkCommentInOrder(String comment) {
        Assert.assertEquals("Комментарий в заказе некорректен", comment, driver.findElement(commentInOrder).getText());
        return this;
    }

    public CheckStatusOrderPage checkingEntireOrder(String name, String surname, String address, String metro, String phone, String period, String color, String comment) {
        checkNameInOrder(name);
        checkSurnameInOrder(surname);
        checkAddressInOrder(address);
        checkMetroInOrder(metro);
        checkPhoneInOrder(phone);
        checkPeriodInOrder(period);
        checkColorInOrder(color);
        checkCommentInOrder(comment);
        return this;
    }
}