package pageobject.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class HeaderPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public HeaderPO(WebDriver driver){
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

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenu;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutSidebar;

    /**
     * display Burger Menu
     */

    public boolean displayBurgerMenu() throws InterruptedException{
        selenium.displayBurgerMenuBtn(burgerMenu);

        return true;
    }

    /**
     * Click on login button
     * @throws InterruptedException
     */
    public void clickonReactBurger() throws InterruptedException{
        selenium.clickOn(burgerMenu);
    }

    /**
     * Click on login button
     * @throws InterruptedException
     */
    public void clickonLogoutSidebar() throws InterruptedException{
        selenium.clickOn(logoutSidebar);
    }
}
