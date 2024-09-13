package steps.hdi;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobject.hdi.HomePO;
import utilities.ThreadManager;

public class HomeSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private HomePO home = new HomePO(driver);

    @When("users click on hdi login button on header menu")
    public void users_click_on_hdi_login_button_on_header_menu() throws InterruptedException {
        home.clickOnLoginButton();
    }
}
