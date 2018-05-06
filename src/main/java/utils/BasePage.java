package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement myElement(By by) {
        return driver.findElement(by);
    }

    protected void clickOn(By by) {
        myElement(by).click();
    }

    protected void typeText(By by, String text) {
        myElement(by).clear();
        myElement(by).sendKeys(text);
    }

    protected void selectByValue(By by, String value) {
        Select select = new Select(myElement(by));
        select.selectByValue(value);
    }

    protected void selectByText(By by, String visibleText) {
        Select select = new Select(myElement(by));
        select.selectByVisibleText(visibleText);
    }

}
