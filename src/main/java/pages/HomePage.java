package pages;

import decorator.InputData;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='search']")
    private InputData searchField;

    public void inputDataToSearchField(String product) {
        searchField.inputData(product);
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ENTER).perform();

    }
}
