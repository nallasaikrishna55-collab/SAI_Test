package appManager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.LocatorType;

import java.time.Duration;
import java.util.Random;

public class HelperBase {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    // Default constructor (for Spring)
    public HelperBase() {
    }


    // Setter for Spring injection
    public void setDriver(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    /**
     * finds the element based on the type of element
     *
     * @param type
     * @param locatorValue
     * @param timeoutSeconds
     * @return
     */
    public WebElement findByElement(LocatorType type, String locatorValue, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        By locator;

        switch (type) {
            case ID -> locator = By.id(locatorValue);
            case NAME -> locator = By.name(locatorValue);
            case XPATH -> locator = By.xpath(locatorValue);
            case CSS -> locator = By.cssSelector(locatorValue);
            case CLASS_NAME -> locator = By.className(locatorValue);
            case LINK_TEXT -> locator = By.linkText(locatorValue);
            case PARTIAL_LINK_TEXT -> locator = By.partialLinkText(locatorValue);
            case TAG_NAME -> locator = By.tagName(locatorValue);
            default -> throw new IllegalArgumentException("Invalid locator type: " + type);
        }

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement findByElement(LocatorType type, String locatorValue) {
        By locator;

        switch (type) {
            case ID -> locator = By.id(locatorValue);
            case NAME -> locator = By.name(locatorValue);
            case XPATH -> locator = By.xpath(locatorValue);
            case CSS -> locator = By.cssSelector(locatorValue);
            case CLASS_NAME -> locator = By.className(locatorValue);
            case LINK_TEXT -> locator = By.linkText(locatorValue);
            case PARTIAL_LINK_TEXT -> locator = By.partialLinkText(locatorValue);
            case TAG_NAME -> locator = By.tagName(locatorValue);
            default -> throw new IllegalArgumentException("Invalid locator type: " + type);
        }

        return driver.findElement(locator);
    }


    public void enterText(LocatorType type, String element, String text) {
        WebElement ele = findByElement(type, element);
        ele.sendKeys(text);
    }

    public void clickOnBtn(LocatorType type, String element) {
        WebElement ele = findByElement(type, element);
        ele.click();
    }

    public boolean elementIsPresent(LocatorType type, String locatorValue, int timeoutSeconds) {
        try {
            // Reuse the existing findByElement method that includes timeout
            findByElement(type, locatorValue, timeoutSeconds);
            return true;
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }


    public String addRandomChars(String text) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder randomChars = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(characters.length());
            randomChars.append(characters.charAt(index));
        }

        return text + randomChars.toString();
    }

    public String getTextMessage(LocatorType type, String element) {
        WebElement ele = null;
        try {

            ele = findByElement(type, element, 2);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ele.getText();
    }

}