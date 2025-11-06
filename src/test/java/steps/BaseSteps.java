package steps;

import Pages.BankHomePage;
import Pages.GoogleHomePage;
import io.cucumber.spring.CucumberContextConfiguration;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import utilities.MessageRepository;


@CucumberContextConfiguration
@ContextConfiguration(locations = "classpath:beans.xml")
public class BaseSteps {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected GoogleHomePage googleHomePage;

    @Autowired
    protected BankHomePage bankHomePage;

    @Autowired
    protected MessageRepository messageRepository;

}
