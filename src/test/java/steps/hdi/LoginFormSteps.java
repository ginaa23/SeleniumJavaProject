package steps.hdi;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobject.hdi.LoginPO;
import utilities.ThreadManager;

public class LoginFormSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private LoginPO login = new LoginPO(driver);

    @When("users input hdi email {string}")
    public void users_input_hdi_email(String username) {
        login.enterUsername(username);
    }

    @When("users input  hdi password {string}")
    public void users_input_hdi_password(String password) {
        login.enterPassword(password);
    }

    @When("users click on hdi login button")
    public void users_click_on_hdi_login_button() throws InterruptedException {
        login.clickOnLoginButton();
    }

    @Then("system display hdi login alert box is {string}")
    public void system_display_hdi_login_alert_box_is(String message) {
        Assert.assertEquals(login.getLoginMessageError(), message, "Message error not match");
    }
}
