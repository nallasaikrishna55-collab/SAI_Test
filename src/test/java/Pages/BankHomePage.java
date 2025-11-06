package Pages;

import api.ParaBankApiHelper;
import appManager.HelperBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import utilities.LocatorType;
import utilities.MessageRepository;

public class BankHomePage extends HelperBase {

    @Value("${xpathUserName}")
    private String xpathUserName;

    @Value("${xpathPassWord}")
    private String xpathPassWord;

    @Value("${cssBtnSubmit}")
    private String submitBtn;

    @Value("${xpathLogout}")
    private String xpathlogOut;

    @Value("${userName}")
    private String userName;

    @Value("${passWord}")
    private String passWord;

    @Value("${xpathRegister}")
    private String xpathRegisterBtn;

    @Value("${xpathFrstName}")
    private String xpathFrstName;

    @Value("${xpathLastName}")
    private String xpathLastName;

    @Value("${xpathAddress}")
    private String xpathAddress;

    @Value("${xpathCity}")
    private String xpathCity;

    @Value("${xpathState}")
    private String xpathState;

    @Value("${xpathZipCode}")
    private String xpathZipCode;

    @Value("${xpathPhoneNumber}")
    private String xpathPhoneNumber;

    @Value("${xpathSSn}")
    private String xpathSSn;

    @Value("${xpathCusUserName}")
    private String xpathCusUserName;

    @Value("${xpathCusPassWord}")
    private String xpathCusPassWord;

    @Value("${cssRepeatPassWord}")
    private String cssRepeatPassWord;

    @Value("${cssRegister}")
    private String cssRegister;

    @Value("${cssWelcomeText}")
    private String cssWelcomeText;

    public String appUserName;
    public String appPassWord;

    @Autowired
    ParaBankApiHelper paraBankApiHelper;

    @Autowired
    MessageRepository messageRepository;

    public void logintoBankApp() {

        findByElement(LocatorType.XPATH, xpathUserName, 2);

        enterLoginCred();


        if (logoutBtnisDisplayed() != true) {
            if (getWelcomeText().contains(messageRepository.getInvalidLoginCred())) {
          String api=  paraBankApiHelper.registerUser(appUserName = addRandomChars(userName), appPassWord = addRandomChars(passWord));
            enterLoginCred();

            }
        }

    }

    public void enterLoginCred() {
        if (appUserName != null)
            userName = appUserName;

        enterText(LocatorType.XPATH, xpathUserName, userName);

        if (appPassWord != null)
            passWord = appPassWord;
        enterText(LocatorType.XPATH, xpathPassWord, passWord);
        clickOnBtn(LocatorType.CSS, submitBtn);
    }

    public boolean logoutBtnisDisplayed() {
        return elementIsPresent(LocatorType.XPATH, xpathlogOut, 2);
    }

    public void clickOnRegisterBtn() {
        clickOnBtn(LocatorType.XPATH, xpathRegisterBtn);

    }

    public void clickOnRegistrationBtn() {
        clickOnBtn(LocatorType.CSS, cssRegister);

    }

    public void enterRegistrationDetails(String firstName, String lastName, String address, String city, String state, String zipCode, String phoneNumber, String ssn, String userName, String passWord) {
        enterText(LocatorType.XPATH, xpathFrstName, firstName);
        enterText(LocatorType.XPATH, xpathLastName, lastName);
        enterText(LocatorType.XPATH, xpathAddress, address);
        enterText(LocatorType.XPATH, xpathCity, city);
        enterText(LocatorType.XPATH, xpathState, state);
        enterText(LocatorType.XPATH, xpathZipCode, zipCode);
        enterText(LocatorType.XPATH, xpathPhoneNumber, phoneNumber);
        enterText(LocatorType.XPATH, xpathSSn, ssn);
        appUserName = addRandomChars(userName);
        enterText(LocatorType.XPATH, xpathCusUserName, appUserName);
        appPassWord = addRandomChars(passWord);
        enterText(LocatorType.XPATH, xpathCusPassWord, appPassWord);
        enterText(LocatorType.CSS, cssRepeatPassWord, appPassWord);
    }

    public String getWelcomeText() {

        return getTextMessage(LocatorType.CSS, cssWelcomeText);
    }

}
