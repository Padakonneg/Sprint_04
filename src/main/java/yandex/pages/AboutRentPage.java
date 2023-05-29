package yandex.pages;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AboutRentPage {
    private final By inputWhenBring = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    private final By inputDay = By.xpath(".//div[@class='Dropdown-control']");
    private final By selectOneDayPeriod = By.xpath(".//div[@role='option' and text() = 'сутки']");
    private final By selectTwoDayPeriod = By.xpath(".//div[@role='option' and text() = 'двое суток']");
    private final By selectThreeDayPeriod = By.xpath(".//div[@role='option' and text() = 'трое суток']");
    private final By selectFourDayPeriod = By.xpath(".//div[@role='option' and text() = 'четверо суток']");
    private final By selectFiveDayPeriod = By.xpath(".//div[@role='option' and text() = 'пятеро суток']");
    private final By selectSixDayPeriod = By.xpath(".//div[@role='option' and text() = 'шестеро суток']");
    private final By selectSevenDayPeriod = By.xpath(".//div[@role='option' and text() = 'семеро суток']");
    private final By selectBlackColor = By.xpath(".//label[@for='black']");
    private final By selectGreyColor = By.xpath(".//label[@for='grey']");
    private final By inputComments = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By buttonOrder = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text()='Заказать']");
    private final By agreeOrder = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() ='Да']");
    private final By refuseOrder = By.xpath(".//button[text() ='Нет']");
    private final By orderSuccess = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");
    private final By buttonCheckStatus = By.xpath(".//button[text() = 'Посмотреть статус']");
    private final WebDriver driver;


    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    public AboutRentPage setInputWhenBring(String date) {
        driver.findElement(inputWhenBring).click();
        driver.findElement(inputWhenBring).sendKeys(date);
        driver.findElement(inputWhenBring).sendKeys(Keys.ENTER);
        return this;
    }

    public AboutRentPage setInputOneDay(String day) {
        driver.findElement(inputDay).click();

        switch (day) {
            case "сутки":
                driver.findElement(selectOneDayPeriod).click();
                break;
            case "двое суток":
                driver.findElement(selectTwoDayPeriod).click();
                break;
            case "трое суток":
                driver.findElement(selectThreeDayPeriod).click();
                break;
            case "четверо суток":
                driver.findElement(selectFourDayPeriod).click();
                break;
            case "пятеро суток":
                driver.findElement(selectFiveDayPeriod).click();
                break;
            case "шестеро суток":
                driver.findElement(selectSixDayPeriod).click();
                break;
            case "семеро суток":
                driver.findElement(selectSevenDayPeriod).click();
                break;
        }
        return this;
    }

    public AboutRentPage setSelectColor(String color) {
        if (color.contains("серая безысходность")) {
            driver.findElement(selectGreyColor).click();
        }
        if (color.contains("чёрный жемчуг")) {
            driver.findElement(selectBlackColor).click();
        }
        return this;
    }

    public AboutRentPage addComment(String text) {
        driver.findElement(inputComments).sendKeys(text);
        return this;
    }

    public AboutRentPage clickAgreeOrder() {
        driver.findElement(agreeOrder).click();
        return this;
    }

    public AboutRentPage clickRefuseOrder() {
        driver.findElement(refuseOrder);
        return this;
    }

    public AboutRentPage checkOrderSuccess() {
        String expectedText = driver.findElement(orderSuccess).getText();
        Assert.assertThat("Заказ не оформлен", expectedText, CoreMatchers.anyOf(CoreMatchers.startsWith("Заказ оформлен"), CoreMatchers.endsWith("Запишите его: пригодится, чтобы отслеживать статус")));
        return this;
    }

    //Нажать кнопку проверить статус после оформления заказа.
    public AboutRentPage clickCheckStatusButton() {
        driver.findElement(buttonCheckStatus).click();
        return this;
    }

    public AboutRentPage clickButtonOrder() {
        driver.findElement(buttonOrder).click();
        return this;
    }

    public AboutRentPage fillingOutRentalInformation(String date, String day, String color, String comment) {
        setInputWhenBring(date);
        setInputOneDay(day);
        setSelectColor(color);
        addComment(comment);
        return this;
    }
}