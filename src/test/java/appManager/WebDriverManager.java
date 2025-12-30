package appManager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;

public class WebDriverManager {

    private static WebDriver driver;

    // This method creates the browser instance once
    public WebDriver createDriver() {
        if (driver == null) {
            io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-infobars");
            options.addArguments("--start-fullscreen"); // macOS prefers this
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
            } else if (os.contains("mac")) {
                options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
            }
            driver = new ChromeDriver(options);

            try {
                // extra safety delay — macOS takes time to focus window
                Thread.sleep(1000);

                // JavaScript resize to ensure it fully covers usable screen
                ((JavascriptExecutor) driver).executeScript(
                        "window.moveTo(0,0); window.resizeTo(screen.availWidth, screen.availHeight);"
                );

            } catch (Exception e) {
                System.out.println("Window maximize issue: " + e.getMessage());
            }
        }
        return driver;
    }


    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
