package yandex;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import yandex.pages.AboutRentPage;
import yandex.pages.CheckStatusOrderPage;
import yandex.pages.OrderScooterPages;
import yandex.pages.StartPages;

@RunWith(Parameterized.class)
public class TestOrderPages extends BaseTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final String day;
    private final String comment;
    private final String color;

    public TestOrderPages(String name, String surname, String address, String metro, String phone, String date, String day, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.day = day;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters(name = "Проверка заказа. Тестовые данные: {0}, {1}, {2}, {3}, {4}")
    public static Object[][] getCredential() {
        return new Object[][]{
                {"Александр", "Плеханов", "Барнаульский тупик", "Сокол", "89172006008", "29.05.2023", "сутки", "серая безысходность", "Хочу самокат"}
//                {"Артем", "Угаркин", "Большая садовая", "Павелецкая", "89063131020", "23.05.2023", "двое суток", "чёрный жемчуг", ""}
        };
    }

    @Test
    public void objectPage() {
        new StartPages(driver)
                .clickOrderTop();
        new OrderScooterPages(driver)
                .forWhomOrder(name, surname, address, metro, phone)
                .clickButtonNext();
        new AboutRentPage(driver)
                .fillingOutRentalInformation(date, day, color, comment)
                .clickButtonOrder()
                .clickAgreeOrder()
                .checkOrderSuccess()
                .clickCheckStatusButton();
        new CheckStatusOrderPage(driver)
                .checkingEntireOrder(name, surname, address, metro, phone, day, color, comment);
    }
}