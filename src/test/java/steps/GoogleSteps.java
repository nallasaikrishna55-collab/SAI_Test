package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;


public class GoogleSteps extends TestBase {

    @Given("I open Google homepage")
    public void iOpenGoogleHomepage() {
       googleHomePage.open();
    }

    @Then("The page title should contain {string}")
    public void thePageTitleShouldContain(String expectedTitle) {
        String actualTitle = googleHomePage.getTitle();
        System.out.println("Page title: " + actualTitle);
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        driver.quit();
    }
}
