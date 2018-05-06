package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BookFlight;
import pages.FlightFinder;
import pages.HomePage;
import utils.BaseTest;
import utils.TestReporter;

import static org.testng.Assert.assertTrue;

@Listeners({TestReporter.class})
public class TestFindFlight extends BaseTest {

    private HomePage homePage;
    private String textToCheck = "\n" +
            "        Please print a copy of this screen for your records. Thank you for choosing \n" +
            "        Mercury Tours.";

    @Test
    public void testFindFirstFlight(){

        homePage = PageFactory.initElements(driver, HomePage.class);
        driver.get(BASE_URL);
        assertTrue(homePage.register("FirstName", "LastName",USERNAME, PASSWORD)
                .getText().contains("Thank you for registering"));

        FlightFinder flightFinder = homePage.openFlightsPage();
        flightFinder.findFlight("1", "London", "6", "10",
                "Paris", "7", "11", "Business", "Unified Airlines");

        BookFlight bookFlight = flightFinder.selectFlight();

        assertTrue(bookFlight.bookFlight("Test", "Test", "1111222233334444")
                .getText().contains(textToCheck));

    }

    @Test
    public void testFindNextFlight() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        driver.get(BASE_URL + "mercuryreservation.php");

        FlightFinder flightFinder = PageFactory.initElements(driver, FlightFinder.class);
        flightFinder.findFlight("2", "Frankfurt", "7", "21",
                "Seattle", "8", "18", "First","Blue Skies Airlines");

        BookFlight bookFlight = flightFinder.selectFlight();

        assertTrue(bookFlight.bookFlight("FirstName", "LastName", "2222333311114444")
                .getText().contains(textToCheck));

    }
}
