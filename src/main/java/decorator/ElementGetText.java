package decorator;

import org.openqa.selenium.WebElement;

public class ElementGetText extends ProElement{
    public ElementGetText(WebElement element) {
        super(element);
    }
    public String getText(){
        return super.getText();
    }

}
