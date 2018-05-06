package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class BookFlight extends BasePage {

    public BookFlight(WebDriver driver) {
        super(driver);
    }

    private By firstName = By.name("passFirst0");
    private By lastName = By.name("passLast0");
    private By cardNumber = By.name("creditnumber");
    private By buyFlight = By.name("buyFlights");

    public BookFlight bookFlight(String firstName, String lastName, String cardNumber) {
        typeText(this.firstName, firstName);
        typeText(this.lastName, lastName);
        typeText(this.cardNumber, cardNumber);
        clickOn(this.buyFlight);
        return this;
    }

    public String getText() {
        return driver.getPageSource();
    }
}
