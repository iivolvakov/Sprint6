package FAQ;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FaqPage {
    private final WebDriverWait wait;
    public FaqPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public void clickQuestion(int index) {
        By question = By.id("accordion__heading-" + index);
        wait.until(ExpectedConditions.elementToBeClickable(question)).click();
    }
    public String getAnswerText(int index) {
        By answer = By.id("accordion__panel-" + index);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(answer)).getText();
    }
}