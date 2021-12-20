package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends BasePage{

    private List<WebElement> buyButtons;

    public ProductPage(WebDriver driver) {
        super(driver);
    }


    public List<WebElement> getBuyButtons() {
        buyButtons = driver.findElements(By.xpath("//button[@class='buy-button goods-tile__buy-button ng-star-inserted']"));
        return buyButtons;
    }


}

