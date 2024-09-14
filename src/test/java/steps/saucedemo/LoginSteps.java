package steps.saucedemo;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pageobject.saucedemo.LoginPO;
import utilities.ThreadManager;

public class LoginSteps {
    private static final Logger log = LoggerFactory.getLogger(LoginSteps.class);
    private WebDriver driver = ThreadManager.getDriver();
    private LoginPO login = new LoginPO(driver);

    @When("user input username {string} and password {string}")
    public void user_input_username_and_password(String username, String password){
        login.enterUsername(username);
        login.enterPassword(password);
    }

    @When("user click on login button")
    public void user_click_on_login_button() throws InterruptedException{
        login.clickonLoginButton();
    }

    @Then("system display error message {string}")
    public void system_display_error_message(String message){
        Assert.assertEquals(login.getloginErrorMessage(), message, "Message error not match");
    }
}
