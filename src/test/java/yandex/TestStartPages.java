package yandex;

import org.junit.Test;
import yandex.pages.OrderScooterPages;
import yandex.pages.StartPages;
import resource.StartPageTestData;

public class TestStartPages extends BaseTest {

    @Test
    public void objectPage() {
        StartPageTestData testData = new StartPageTestData();
        new StartPages(driver)
                .scrollToQuestion()
                .clickQuestion(testData.getQuestionAnswerList2());
    }

    @Test
    public void mainPageSamokat() {
        new StartPages(driver)
                .clickOrderTop();
        new OrderScooterPages(driver)
                .clickButtonStartPages();
    }

    @Test
    public void yandexGoToPage() {
        new StartPages(driver)
                .clickYandexLogo()
                .chekingYandexPages();
    }
}