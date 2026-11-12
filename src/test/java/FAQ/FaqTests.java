package FAQ;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import CookieBanner.CookieBanner;

import java.util.stream.Stream;

public class FaqTests {
    private WebDriver driver;
    private FaqPage faqPage;

    @BeforeEach
    public void setUp(){
        driver =new ChromeDriver();
        driver.get("https://qa-scooter.education-services.ru");

        CookieBanner cookieBanner=new CookieBanner(driver);
        cookieBanner.acceptCookies();
        faqPage=new FaqPage(driver);
    }

    @ParameterizedTest
    @MethodSource("faqQuestions")
    public void answerOpenForQuestion(int index, String expectedAnswer){
        faqPage.clickQuestion(index);

        String actualAnswer= faqPage.getAnswerText(index);
        assertEquals(expectedAnswer, actualAnswer);
    }

    static Stream<Arguments> faqQuestions() {
        return Stream.of(
                arguments(0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."),
                arguments(1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."),
                arguments(2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."),
                arguments(3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."),
                arguments(4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."),
                arguments(5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."),
                arguments(6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."),
                arguments(7, "Да, обязательно. Всем самокатов! И Москве, и Московской области.")
        );
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
