package tests;

import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchAndBuy extends BaseTest{
    public void searchAndBuy(String product, String brand){
        getHomePage().inputDataToSearchField(product);
        getSearchResultsPage().selectBrand("//label[@for='"+brand+"']");
        getSearchResultsPage().sortAsc();
        try {
            List<WebElement> list = getProductPage().getBuyButtons();
            list.get(0).click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            List <WebElement> list = getProductPage().getBuyButtons();
            list.get(0).click();
        }
        getShoppingCartPage().clickCartButton();

    }
}
