package Order;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    private By topOrderButton = By.cssSelector("button.Button_Button__ra12g");
    private By middleOrderButton = By.cssSelector("button.Button_Button__ra12g.Button_Middle__1CSJM");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }

    public void clickMiddleOrderButton() {
        driver.findElement(middleOrderButton).click();
    }

}
