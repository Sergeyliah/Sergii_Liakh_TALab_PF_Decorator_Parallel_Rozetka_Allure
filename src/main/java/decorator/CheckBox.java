package decorator;

import org.openqa.selenium.WebElement;

public class CheckBox extends ProElement {

    public CheckBox(WebElement webElement) {
        super(webElement);
    }

    public void setChecked(boolean value) {
        if (value != isChecked()) {
            super.click();
        }
    }

    public boolean isChecked() {
        return super.isSelected();
    }
}