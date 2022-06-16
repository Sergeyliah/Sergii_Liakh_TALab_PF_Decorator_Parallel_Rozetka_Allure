package tests;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.CaptureScreenshot;
import utility.Utility;

import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

public class Verify extends BaseTest{
    private static final String CURRENCY_RATE_URL = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5";
    private static final String CURRENCY_RATE_XML_PATH = "./src/main/properties/currency_rate.xml";
    private static final String AMOUNT_OF_ITEMS = "amountOfItems";
    private static final String TOTAL_PRICE = "totalPrice";

    public Verify() throws IOException {
    }

    public static void verify() throws IOException, XPathExpressionException {
        Assert.assertEquals(Integer.parseInt((String) Utility.fetchPropertyValueXML(AMOUNT_OF_ITEMS)), Integer.parseInt(getShoppingCartPage().getAmountOfItems().getText()));
        Utility.downloadUsingStream(CURRENCY_RATE_URL, CURRENCY_RATE_XML_PATH);
        double currencyRate = Utility.XMLParser(CURRENCY_RATE_XML_PATH);
        Assert.assertTrue(Integer.parseInt(getShoppingCartPage().getTotalPrice().getText())<Integer.parseInt((String) Utility.fetchPropertyValueXML(TOTAL_PRICE))*currencyRate);

    }

}
