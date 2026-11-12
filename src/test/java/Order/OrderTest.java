package Order;

import CookieBanner.CookieBanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.education-services.ru");

        CookieBanner cookieBanner = new CookieBanner(driver);
        cookieBanner.acceptCookies();

        mainPage = new MainPage(driver);
    }

    @Test
    public void orderWithTopButtonAndBlackScooter() {
        mainPage.clickTopOrderButton();

        OrderPage orderPage = new OrderPage(driver);

        orderPage.setNameField("ААААААА");
        orderPage.setSurNameField("ААААА");
        orderPage.setCityToDelivery("Москва");
        orderPage.selectMetroStation("Сокольники");
        orderPage.setNumberPhone("21111111111");
        orderPage.clikToButtonNext();


        assertTrue(orderPage.isDeliveryDateFieldDisplayed());


        orderPage.selectDateForDelivery("Choose суббота, 28-е ноября 2026 г.");
        orderPage.selectCountDayOfArenda("двое суток");
        orderPage.selectBlackColor();
        assertTrue(orderPage.isBlackColorSelected());
        orderPage.sendComment("Позвонить перед доставкой");
        orderPage.clickButtonToOrder();


        OrderConfirmation confirmation = new OrderConfirmation(driver);
        confirmation.confirmOrder();

        assertTrue(confirmation.getSuccessMessage().contains("Заказ оформлен"));
    }

    @Test
    public void orderWithMiddleButtonAndGreyScooter() {

        mainPage.clickMiddleOrderButton();

        OrderPage orderPage = new OrderPage(driver);


        orderPage.setNameField("Пётр");
        orderPage.setSurNameField("Петров");
        orderPage.setCityToDelivery("Воронеж");
        orderPage.selectMetroStation("Черкизовская");
        orderPage.setNumberPhone("88005553535");
        orderPage.clikToButtonNext();


        assertTrue(orderPage.isDeliveryDateFieldDisplayed());


        orderPage.selectDateForDelivery("Choose воскресенье, 29-е ноября 2026 г.");


        orderPage.selectCountDayOfArenda("трое суток");
        orderPage.selectGreyColor();
        assertTrue(orderPage.isGreyColorSelected());
        orderPage.sendComment("ААААААААААААААААА");
        orderPage.clickButtonToOrder();


        OrderConfirmation confirmation = new OrderConfirmation(driver);
        confirmation.confirmOrder();

        assertTrue(confirmation.getSuccessMessage().contains("Заказ оформлен"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}