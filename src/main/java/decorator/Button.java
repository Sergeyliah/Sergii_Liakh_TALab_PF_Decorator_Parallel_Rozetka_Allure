package decorator;

import org.openqa.selenium.WebElement;

public class Button extends ProElement{

    public Button(WebElement webElement) {
        super(webElement);
    }
    public void clickButton(){
        System.out.println("CLICK");
        super.click();
    }


}