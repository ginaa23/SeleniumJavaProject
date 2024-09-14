package steps.saucedemo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobject.saucedemo.ProductPO;
import utilities.ThreadManager;

import java.util.List;

public class ProductSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private ProductPO product = new ProductPO(driver);

    @When("user click on Add to cart")
    public void user_click_on_Add_to_cart() throws InterruptedException{
        product.clickonCartButton(0);
    }

    @And("button changed to Remove")
    public void button_changed_to_Remove() throws InterruptedException{
        Assert.assertEquals(product.getButtonRemove(0),"Remove", "Remove is not displayed");
    }

    @When("user add {int} product")
    public void user_add_product(int productCount) throws InterruptedException{
        for (int i = 0; i < productCount; i++){
            product.clickonCartButton(i);
        }
    }

    @Then("the cart item display {int}")
    public void the_cart_item_display(int expectedCount){
        int actualCount = product.getCartCount();
        Assert.assertEquals(actualCount, expectedCount, "Cart item count is incorrect!");
    }

    @When("user remove {int} product from cart")
    public void user_remove_product_from_cart(int productCount) throws InterruptedException{
        for (int i = 0; i < productCount; i++){
            product.clickOnRemoveButton(i);
        }
    }

    @When("user sort product {string} to {string}")
    public void user_sort_product(String start, String end) throws InterruptedException{
        if (start.equalsIgnoreCase("A") && end.equalsIgnoreCase("Z")){
            product.sortAscending();
        } else if (start.equalsIgnoreCase("Z") && end.equalsIgnoreCase("A")) {
            product.sortDescending();
        } else {
            throw new IllegalArgumentException("Invalid to sort: " + start + "to" + end);
        }
    }

    @Then("system display product")
    public void system_display_product(){
        List<String> displayedProductNames = product.displayedProductName();
        if (product.isSortedAscending()){
            List<String> sortedProductNames = product.sortProductNameAscending();
            Assert.assertEquals(displayedProductNames, sortedProductNames, "Product display by ascending");
        } else {
            List<String> sortedProductNames = product.sortProductNameDescending();
            Assert.assertEquals(displayedProductNames, sortedProductNames, "Product display bby descending");
        }
    }
}
