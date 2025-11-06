package steps;

import Pages.BankHomePage;
import appManager.HelperBase;
import appManager.webDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected HelperBase helperBase;

    @Autowired
    protected webDriverManager webDriver;

    @Before
    public void setUp() {
//        driver = webDriver.getDriver();
//        driver = webDriver.getDriver(); // creates if null
//        helperBase.setDriver(driver);
    }

    @After
    public void tearDown() {
//        webDriver.quitDriver();
    }
}