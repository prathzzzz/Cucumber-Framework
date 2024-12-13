package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import driverfactory.DriverFactory;

import java.time.Duration;

public class CommonUtils {
    private static final WebDriver driver = DriverFactory.getDriver();
    private static final int DEFAULT_TIMEOUT = 10;

    // Wait Methods
    public static void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Element Interactions
    public static void clickElement(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }

    public static void sendKeys(WebElement element, String text) {
        waitForElementToBeVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    // Element State Checks
    public static boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    // Text Retrieval
    public static String getElementText(WebElement element) {
        waitForElementToBeVisible(element);
        return element.getText();
    }

}