package pageobject.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class LoginPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public LoginPO(WebDriver driver){
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

    @FindBy(name = "user-name")
    private WebElement usernameEditText;

    @FindBy(name = "password")
    private WebElement passwordEditText;

    @FindBy(name = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement loginErrorMessage;

    /**
     * Enter username
     * @param username
     */
    public void enterUsername(String username){
        selenium.enterText(usernameEditText, username, true);
    }

    /**
     * Enter password
     * @param password
     */
    public void enterPassword(String password){
        selenium.enterText(passwordEditText, password, true);
    }

    /**
     * Click on login button
     * @throws InterruptedException
     */
    public void clickonLoginButton() throws InterruptedException{
        selenium.clickOn(loginButton);
    }

    /**
     * Get Login Error Message
     */
    public String getloginErrorMessage(){
        return selenium.getText(loginErrorMessage);
    }
}
