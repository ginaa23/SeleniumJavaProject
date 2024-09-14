package pageobject.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public ProductPO(WebDriver driver){
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
    @FindBy(xpath = "//button[text()='Add to cart']")
    private List<WebElement> cartButton;

    @FindBy(xpath = "//button[text()='Remove']")
    private List<WebElement> removeButton;

    @FindBy(xpath = "//*[@data-test='shopping-cart-badge']")
    private WebElement cartBadge;

    @FindBy(className = "product_sort_container")
    private WebElement sortProducts;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> nameOfProduct;

    /**
     * click Add to cart
     * @param index
     */
    public void clickonCartButton(int index) throws InterruptedException{
        selenium.clickOn(cartButton.get(index));
    }

    /**
     * get Remove Button
     * @param index
     */
    public String getButtonRemove(int index){
        return selenium.getText(removeButton.get(index));
    }

    public int getCartCount(){
        if (cartBadge.isEnabled()){
            return Integer.parseInt(cartBadge.getText().trim());
        } else {
            return 0;
        }
    }

    public void clickOnRemoveButton(int index) throws InterruptedException{
        selenium.clickOn(removeButton.get(index));
    }

    /**
     * get display product on page
     */
    public List<String> displayedProductName(){
        List<String> productPage = new ArrayList<>();
            for (WebElement product : nameOfProduct){
                productPage.add(product.getText().trim());
            }
            return productPage;
    }

    /**
     * sort product A to Z
     */
    public void sortAscending() throws InterruptedException{
        selenium.selectDropdownOption(sortProducts, "Name (A to Z)");
        sortedAscending = true;
        Thread.sleep(2000);
    }

    /**
     * sort product Z to A
     */
    public void sortDescending() throws InterruptedException{
        selenium.selectDropdownOption(sortProducts, "Name (Z to A)");
        sortedAscending = false;
        Thread.sleep(2000);
    }

    /**
     * display product name by ascending
     */
    public List<String> sortProductNameAscending(){
        List<String> productSort = displayedProductName();
        Collections.sort(productSort, String::compareToIgnoreCase);
        return productSort;
    }

    /**
     * display product name by descending
     */
    public List<String> sortProductNameDescending(){
        List<String> productSort = displayedProductName();
        productSort.sort(Collections.reverseOrder(String::compareToIgnoreCase));
        return productSort;
    }

    /**
     *
     */
    public boolean isSortedAscending(){
        return sortedAscending;
    }

    private boolean sortedAscending;

}
