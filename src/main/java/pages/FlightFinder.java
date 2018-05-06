package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.BasePage;

public class FlightFinder extends BasePage {

    public FlightFinder(WebDriver driver) {
        super(driver);
    }

    private By type = By.name("tripType");
    private By oneWay = By.xpath("//input[@value='oneway']");
    private By passangersCount = By.name("passCount");
    private By flightFrom = By.name("fromPort");
    private By depMonth = By.name("fromMonth");
    private By depDay = By.name("fromDay");
    private By flightTo = By.name("toPort");
    private By arrMonth = By.name("toMonth");
    private By arrDay = By.name("toDay");
    private By airline = By.name("airline");
    private By contBtn = By.name("findFlights");
    private By reserveFlight = By.name("reserveFlights");

    public FlightFinder findFlight(String passangersCount, String flightFrom, String depMonth,
                                   String depDay, String flightTo, String arrMonth, String arrDay,
                                   String clas, String airline) {
        clickOn(oneWay);
        selectByValue(this.passangersCount, passangersCount);
        selectByValue(this.flightFrom, flightFrom);
        selectByValue(this.depMonth, depMonth);
        selectByValue(this.depDay, depDay);
        selectByValue(this.flightTo, flightTo);
        selectByValue(this.arrMonth, arrMonth);
        selectByValue(this.arrDay, arrDay);
        clickOn(By.xpath("//input[@value='" + clas + "']"));
        selectByText(this.airline, airline);
        clickOn(contBtn);
        return this;
    }

    public BookFlight selectFlight() {
        clickOn(reserveFlight);
        return PageFactory.initElements(driver, BookFlight.class);
    }
}
