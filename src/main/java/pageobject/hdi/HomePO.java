package pageobject.hdi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class HomePO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public HomePO(WebDriver driver){
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    /*
     * All WebElements are identified by @FindBy annotation
     *
     * @FindBy can accept tagName, partialLinkText, name, linkText, id, css,
     * className, xpath as attributes.
     */

    @FindBy(xpath = "//button[@class='button button-secondary']")
    private WebElement loginButton;

    /**
     * Click on login button
     * @throws InterruptedException
     */
    public void clickOnLoginButton() throws InterruptedException {
        selenium.clickOn(loginButton);
    }
}
