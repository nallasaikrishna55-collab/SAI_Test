package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;

public class UserRegistrationdef extends TestBase {


    @When("User click on register")
    public void user_click_on_register() {
        bankHomePage.clickOnRegisterBtn();
    }

    @When("Fill all the mandatory fields {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void fill_all_the_mandatory_fields(String firstName, String lastName, String address, String city, String state, String zipCode, String phone, String ssn, String userName, String passWord) {
        bankHomePage.enterRegistrationDetails(firstName, lastName, address, city, state, zipCode, phone, ssn, userName, passWord);
    }

    @When("User clicks on register")
    public void user_clicks_on_register() {
        bankHomePage.clickOnRegistrationBtn();
    }

    @Then("User is created or not created successfully")
    public void user_is_created_or_not_created_successfully() {
        String actualMsg = bankHomePage.getWelcomeText();
        Assert.assertEquals("User not Created ", messageRepository.getAccCreatedMsg(), "actualMsg");

    }

}
