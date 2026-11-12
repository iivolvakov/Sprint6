package CookieBanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CookieBanner {
    private final WebDriver driver;
    private final By confirmButton = By.id("rcc-confirm-button");

    public CookieBanner(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookies() {
        driver.findElement(confirmButton).click();
    }
}