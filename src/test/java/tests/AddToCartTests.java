package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import listener.ModifyListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utility.DataProviderClass;

import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Listeners(ModifyListener.class)
public class AddToCartTests extends SearchAndBuy{
    public AddToCartTests() throws IOException {
    }

    @Description("***This is description***")

    @Test(dataProvider = "Data", dataProviderClass = DataProviderClass.class)
    public void tc_001(String product, String brand) throws IOException, XPathExpressionException {
        searchAndBuy(product,brand);
        Verify.verify();
    //saveScreenshotPNG(getDriver());
    }
    //attachments for Allure
    //@Attachment(value = "Page screenshot", type = "image/png")
    //private byte[] saveScreenshotPNG(WebDriver driver){
    //    return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    //}
}
