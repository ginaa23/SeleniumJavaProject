package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

public class CommonSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @Given("user access page {string}")
    public void user_access_page(String url) {
        selenium.navigateToPage(url);
    }

    @Given("user access page hdi")
    public void user_access_page_hdi() {
        selenium.navigateToPage("https://www.hdistore.com");
    }

    @Given("Given user access page saucedemo")
    public void given_user_access_page_saucedemo() {
        selenium.navigateToPage("https://www.saucedemo.com");
    }

    @Then("compare current url with {string}")
    public void compare_url(String url){
        Assert.assertEquals(url, selenium.getURL());
   }
}