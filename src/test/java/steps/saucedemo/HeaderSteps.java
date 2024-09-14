package steps.saucedemo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobject.saucedemo.HeaderPO;
import utilities.ThreadManager;

public class HeaderSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private HeaderPO header = new HeaderPO(driver);

    @Then("system display burger menu")
    public void system_display_burger_menu() throws InterruptedException{
        Assert.assertTrue(header.displayBurgerMenu(), "The system does not display the burger button");
    }

    @And("user click burger menu")
    public void user_click_burger_menu() throws InterruptedException{
        header.clickonReactBurger();
    }
    @Then("user click logout sidebar")
    public void user_click_logout_sidebar() throws InterruptedException{
        header.clickonLogoutSidebar();
    }

}
