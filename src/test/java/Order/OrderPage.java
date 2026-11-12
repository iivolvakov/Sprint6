package Order;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriver driver;

    private By fieldName=By.cssSelector("input[placeholder='* Имя']");
    private By surName=By.cssSelector("input[placeholder='* Фамилия']");
    private By adressFiled=By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    private  By stationOfMetro=By.cssSelector("input[placeholder='* Станция метро']");
    private By numberField=By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    private By buttonToNextPage=By.xpath("//button[normalize-space()='Далее']");
    private By dataDeliveryField=By.cssSelector("input[placeholder='* Когда привезти самокат']");
    private By calendarData=By.cssSelector(".react-datepicker__month-container");
    private By countOfDay=By.cssSelector("div.Dropdown-placeholder");
    private By buttonToChangeData=By.cssSelector("button[aria-label='Previous Month']");
    private By checkBoxOfColorBlack=By.id("black");
    private By checkBoxOfColorGrey=By.id("grey");
    private By commentToDelivery = By.cssSelector("input[placeholder='Комментарий для курьера']");
    private By buttonToOrder = By.xpath("//div[contains(@class,'Order_Buttons')]/button[normalize-space()='Заказать']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setNameField(String name){
        driver.findElement(fieldName).sendKeys(name);
    }

    public void setSurNameField(String surname){
        driver.findElement(surName).sendKeys(surname);
    }

    public void setCityToDelivery(String city){
        driver.findElement(adressFiled).sendKeys(city);
    }

    public void selectMetroStation(String stationName) {
        driver.findElement(stationOfMetro).sendKeys(stationName);

        By stationOption = By.xpath(
                "//button[normalize-space()='" + stationName + "']"
        );

        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(stationOption))
                .click();
    }

    public void setNumberPhone(String number){
        driver.findElement(numberField).sendKeys(number);
    }

    public void clikToButtonNext(){
        driver.findElement(buttonToNextPage).click();
    }

    public void selectDateForDelivery(String ariaLabel) {
        driver.findElement(dataDeliveryField).click();

        By date = By.cssSelector("div.react-datepicker__day[aria-label='" + ariaLabel + "']");
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(date)).click();
    }

    public void selectCountDayOfArenda(String days) {
        driver.findElement(countOfDay).click();

        By durationOption = By.xpath("//div[contains(@class,'Dropdown-option') and normalize-space()='" + days + "']");

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(durationOption)).click();
    }

    public void selectBlackColor() {
        WebElement checkbox = driver.findElement(checkBoxOfColorBlack);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public boolean isBlackColorSelected() {
        return driver.findElement(checkBoxOfColorBlack).isSelected();
    }

    public void selectGreyColor() {
        WebElement checkbox = driver.findElement(checkBoxOfColorGrey);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public boolean isGreyColorSelected() {
        return driver.findElement(checkBoxOfColorGrey).isSelected();
    }

    public void sendComment(String comment){
        driver.findElement(commentToDelivery).sendKeys(comment);
    }

    public void clickButtonToOrder(){
        driver.findElement(buttonToOrder).click();
    }
    public boolean isDeliveryDateFieldDisplayed() {
        return driver.findElement(dataDeliveryField).isDisplayed();
    }
}
