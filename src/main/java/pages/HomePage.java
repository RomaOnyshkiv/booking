package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.BasePage;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By register = By.xpath("//a[contains(.,'REGISTER')]");
    private By firstName = By.name("firstName");
    private By lastName = By.name("lastName");
    private By username = By.name("email");
    private By password = By.name("password");
    private By confirmPassword = By.name("confirmPassword");
    private By loginBtn = By.name("register");
    private By flights = By.linkText("Flights");

    public HomePage register(String firstName, String lastName, String username, String password) {
        clickOn(register);
        typeText(this.firstName, firstName);
        typeText(this.lastName, lastName);
        typeText(this.username, username);
        typeText(this.password, password);
        typeText(this.confirmPassword, password);
        clickOn(loginBtn);
        return this;
    }

    public String getText() {
        return driver.getPageSource();
    }

    public FlightFinder openFlightsPage() {
        clickOn(flights);
        return PageFactory.initElements(driver, FlightFinder.class);
    }




}
