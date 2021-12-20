package pages;

import decorator.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class SearchResultsPage extends BasePage {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//option[@value='2: expensive']")
    private Button sortAscButton;

    public void selectBrand(String str){
        driver.findElement(By.xpath(str)).click();
    }
    public void sortAsc(){
        sortAscButton.clickButton();
    }
    public Button getSortAscButton() {
        return sortAscButton;
    }
}
