package pages;

import decorator.Button;
import decorator.ElementGetText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//rz-cart[@class='header-actions__component']")
    private Button cartButton;
    @FindBy(xpath = "//span[@class='counter counter--green ng-star-inserted']")
    private ElementGetText amountOfItems;
    @FindBy(css = ".cart-receipt__sum-price > span:nth-child(1)")
    private ElementGetText totalPrice;

    public void clickCartButton(){
        cartButton.clickButton();
    }

    public ElementGetText getAmountOfItems() {
        return amountOfItems;
    }

    public ElementGetText getTotalPrice() {
        return totalPrice;
    }
}
