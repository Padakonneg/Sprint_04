package resource;

import java.util.HashMap;
import java.util.Map;

public class StartPageTestData {

    private Map<String, String> questionAnswerList2;

    private static final String QUESTION_1 = "Сколько это стоит? И как оплатить?";
    private static final String QUESTION_2 = "Хочу сразу несколько самокатов! Так можно?";
    private static final String QUESTION_3 = "Как рассчитывается время аренды?";
    private static final String QUESTION_4 = "Можно ли заказать самокат прямо на сегодня?";
    private static final String QUESTION_5 = "Можно ли продлить заказ или вернуть самокат раньше?";
    private static final String QUESTION_6 = "Вы привозите зарядку вместе с самокатом?";
    private static final String QUESTION_7 = "Можно ли отменить заказ?";
    private static final String QUESTION_8 = "Я жизу за МКАДом, привезёте?";
    //Ответы
    private static final String ANSWER_1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private static final String ANSWER_2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private static final String ANSWER_3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private static final String ANSWER_4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private static final String ANSWER_5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private static final String ANSWER_6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private static final String ANSWER_7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private static final String ANSWER_8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    public StartPageTestData() {
        initializeQuestionAnswer();
    }

    public void initializeQuestionAnswer() {
        questionAnswerList2 = new HashMap<>();
        questionAnswerList2.put(QUESTION_1, ANSWER_1);
        questionAnswerList2.put(QUESTION_2, ANSWER_2);
        questionAnswerList2.put(QUESTION_3, ANSWER_3);
        questionAnswerList2.put(QUESTION_4, ANSWER_4);
        questionAnswerList2.put(QUESTION_5, ANSWER_5);
        questionAnswerList2.put(QUESTION_6, ANSWER_6);
        questionAnswerList2.put(QUESTION_7, ANSWER_7);
        questionAnswerList2.put(QUESTION_8, ANSWER_8);
    }

    public Map<String, String> getQuestionAnswerList2() {
        return questionAnswerList2;
    }
}