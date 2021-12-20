package decorator;

import org.openqa.selenium.WebElement;

public class InputData extends ProElement{
    public InputData(WebElement element) {
        super(element);
    }
    public void inputData(String product){
        super.sendKeys(product);
    }

}
