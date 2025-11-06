package appManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class webDriverManager {


    // This method creates the browser instance once
    public WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");

        return new ChromeDriver(options);
    }

    // Gracefully close browser at the end
   /* public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }*/
    }
