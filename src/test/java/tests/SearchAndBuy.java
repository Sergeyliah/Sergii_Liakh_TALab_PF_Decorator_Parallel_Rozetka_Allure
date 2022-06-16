package tests;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class SearchAndBuy extends BaseTest{
    public SearchAndBuy() throws IOException {
    }

    public void searchAndBuy(String product, String brand){
        getHomePage().inputDataToSearchField(product);
        getSearchResultsPage().selectBrand("//a[@data-id='"+brand+"']");
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
