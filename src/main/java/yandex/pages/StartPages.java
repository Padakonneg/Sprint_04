package yandex.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static yandex.config.AppConfig.APP_URL;
import static yandex.config.AppConfig.YANDEX_URL;

public class StartPages {
    //Прокручивание до заказа.
    private final By questionAboutImportant = By.xpath(".//div[@class='Home_FourPart__1uthg']");
    //Заказать наверху страницы.
    private final By orderScooterTopPage = By.xpath(".//button[@class='Button_Button__ra12g']");
    //Заказать внизу страницы
    private final By orderScooterMiddlePage = By.xpath(".//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");
    //Главная страница яндекса.
    private final By yandexPage = By.xpath(".//a[@class ='Header_LogoYandex__3TSOI']");
    //Страница Яндекса
    private final By yandexHref = By.xpath(".//a[@href='https://dzen.ru/']");
    //Навигация по вопросам о важном на странице, ей богу пытался сделать через реализацию где я
    //помещаю все элементы в массив элементов, но увы. С этим получается ещё больше проблем, т.к нельзя проверить
    //кликабельна ли область. Т.к она может не открываться.
    private final By oneStringQuestion = By.xpath(".//div[@id='accordion__heading-0']");
    private final By twoStringQuestion = By.xpath(".//div[@id='accordion__heading-1']");
    private final By threeStringQuestion = By.xpath(".//div[@id='accordion__heading-2']");
    private final By fourStringQuestion = By.xpath(".//div[@id='accordion__heading-3']");
    private final By fiveStringQuestion = By.xpath(".//div[@id='accordion__heading-4']");
    private final By sixStringQuestion = By.xpath(".//div[@id='accordion__heading-5']");
    private final By sevenStringQuestion = By.xpath(".//div[@id='accordion__heading-6']");
    private final By eightStringQuestion = By.xpath(".//div[@id='accordion__heading-7']");
    //Навигация по ответам
    private final By oneStringAnswer = By.xpath(".//div[@class='accordion__item'][1]/div[@class = 'accordion__panel']/p");
    private final By twoStringAnswer = By.xpath(".//div[@class='accordion__item'][2]/div[@class = 'accordion__panel']/p");
    private final By threeStringAnswer = By.xpath(".//div[@class='accordion__item'][3]/div[@class = 'accordion__panel']/p");
    private final By fourStringAnswer = By.xpath(".//div[@class='accordion__item'][4]/div[@class = 'accordion__panel']/p");
    private final By fiveStringAnswer = By.xpath(".//div[@class='accordion__item'][5]/div[@class = 'accordion__panel']/p");
    private final By sixStringAnswer = By.xpath(".//div[@class='accordion__item'][6]/div[@class = 'accordion__panel']/p");
    private final By sevenStringAnswer = By.xpath(".//div[@class='accordion__item'][7]/div[@class = 'accordion__panel']/p");
    private final By eightStringAnswer = By.xpath(".//div[@class='accordion__item'][8]/div[@class = 'accordion__panel']/p");

    private final WebDriver driver;
    private Map<By, By> xpathQuestionAnswerList;

    // Конструктор страницы
    public StartPages(WebDriver driver) {
        initializeXpath();
        this.driver = driver;
        driver.get(APP_URL);
    }

    public StartPages scrollToQuestion() {
        WebElement scroll = driver.findElement(questionAboutImportant);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", scroll);
        return this;
    }

    public StartPages questionAreaClick(By by) {
        driver.findElement(by).click();
        return this;
    }

    //Клик по области с вопросом.
    public StartPages clickQuestion(Map map) {
        for (Map.Entry<By, By> entry : xpathQuestionAnswerList.entrySet()) {
            questionAreaClick(entry.getKey());
            String textQuestionInSite = driver.findElement(entry.getKey()).getText();
            String textAnswerInSite = driver.findElement(entry.getValue()).getText();
            checkTextQuestionAndAnswer(textQuestionInSite, textAnswerInSite, map);
        }
        return this;
    }

    //Проверка вопрос - ответ на соответствие
    private StartPages checkTextQuestionAndAnswer(String question, String answer, Map map) {
        if (map.containsKey(question)) {
            Assert.assertEquals(answer, map.get(question));
        }
        return this;
    }

    //Метод нажатия наверху страницы
    public StartPages clickOrderTop() {
        driver.findElement(orderScooterTopPage).click();
        return this;
    }

    //Метод нажатия в середине страницы
    public StartPages clickOrderMiddle() {
        driver.findElement(orderScooterMiddlePage).click();
        return this;
    }

    public StartPages clickYandexLogo() {
        driver.findElement(yandexPage).click();
        return this;
    }

    public StartPages chekingYandexPages() {
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(yandexHref));
        String strUrl = driver.getCurrentUrl();
        Assert.assertEquals("Страница редиректа на яндекс некорректная", YANDEX_URL, strUrl);
        return this;
    }

    //Инициализация мап c xpath
    public StartPages initializeXpath() {
        xpathQuestionAnswerList = new HashMap<>();
        xpathQuestionAnswerList.put(oneStringQuestion, oneStringAnswer);
        xpathQuestionAnswerList.put(twoStringQuestion, twoStringAnswer);
        xpathQuestionAnswerList.put(threeStringQuestion, threeStringAnswer);
        xpathQuestionAnswerList.put(fourStringQuestion, fourStringAnswer);
        xpathQuestionAnswerList.put(fiveStringQuestion, fiveStringAnswer);
        xpathQuestionAnswerList.put(sixStringQuestion, sixStringAnswer);
        xpathQuestionAnswerList.put(sevenStringQuestion, sevenStringAnswer);
        xpathQuestionAnswerList.put(eightStringQuestion, eightStringAnswer);
        return this;
    }
}