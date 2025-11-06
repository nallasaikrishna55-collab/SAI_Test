package Pages;

import appManager.HelperBase;

import org.springframework.beans.factory.annotation.Value;

public class GoogleHomePage  extends HelperBase {

    @Value("${app.Url}")
    private String appUrl;



    public void open() {
        driver.get(appUrl);
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
