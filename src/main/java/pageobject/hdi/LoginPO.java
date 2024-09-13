package pageobject.hdi;

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

    @FindBy(name = "username")
    private WebElement usernameEditText;

    @FindBy(name = "password")
    private WebElement passwordEditText;

    @FindBy(xpath = "//button[@class='button button-primary px-20']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='login__error alert alert-danger text-sm text-center']")
    private WebElement loginMessageError;

    /**
     * Enter username
     * @param username
     */
    public void enterUsername(String username) {
        selenium.enterText(usernameEditText, username, true);
    }

    /**
     * Enter password
     * @param password
     */
    public void enterPassword(String password) {
        selenium.enterText(passwordEditText, password, true);
    }

    /**
     * Click on login button
     * @throws InterruptedException
     */
    public void clickOnLoginButton() throws InterruptedException {
        selenium.clickOn(loginButton);
    }

    /**
     * Get login message error
     */
    public String getLoginMessageError() {
        return selenium.getText(loginMessageError);
    }
}
