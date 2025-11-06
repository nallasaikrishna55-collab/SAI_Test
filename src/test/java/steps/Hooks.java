package steps;

import appManager.HelperBase;
import appManager.WebDriverManager;
import io.cucumber.java.*;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;

public class Hooks {

    @Autowired
    private HelperBase helperBase;

    @Autowired
    private WebDriverManager webDriverManager;

    @Before
    public void setUp() {
        if (helperBase.getDriver() == null) {
            webDriverManager.createDriver();
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed() && helperBase.getDriver() != null) {
                byte[] screenshot = ((TakesScreenshot) helperBase.getDriver())
                        .getScreenshotAs(OutputType.BYTES);

                scenario.attach(screenshot, "image/png", "Failure Screenshot");

                Allure.step("Failure Screenshot", step -> {
                    Allure.addAttachment("Screenshot", "image/png",
                            new ByteArrayInputStream(screenshot), "png");
                });
            }
        } catch (Exception e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        } finally {
            webDriverManager.quitDriver();
        }
    }
}
