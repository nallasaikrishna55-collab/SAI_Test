package steps;

import io.cucumber.java.en.*;
import static org.junit.Assert.*;

public class BankLogin extends TestBase {


    @Given("Open ParaBank application")
    public void open_para_bank_application() {
        googleHomePage.open();
    }

    @When("Login to application")
    public void login_to_application() {
        bankHomePage.logintoBankApp();
    }

    @Then("Verify user successfully logged into application")
    public void verify_user_successfully_logged_into_application() {
       assertTrue("user successfully logged into application",bankHomePage.logoutBtnisDisplayed());
    }

}
