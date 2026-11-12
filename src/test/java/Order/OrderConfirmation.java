package Order;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderConfirmation {
    private  WebDriver driver;
    private  WebDriverWait wait;

    private  By confirmButton = By.xpath("//button[normalize-space()='Да']");


    private  By successMessage = By.cssSelector(".Order_ModalHeader__3FDaJ");

    public OrderConfirmation(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void confirmOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton)).click();
    }

    public String getSuccessMessage() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
    }
}