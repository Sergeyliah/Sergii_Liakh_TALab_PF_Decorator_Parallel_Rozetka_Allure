package tests;

import org.testng.annotations.Test;
import utility.DataProviderClass;

import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

public class AddToCartTests extends SearchAndBuy{


    @Test(dataProvider = "Data", dataProviderClass = DataProviderClass.class)
    public void tc_001(String product, String brand) throws IOException, XPathExpressionException {
        searchAndBuy(product,brand);
        Verify.verify();

    }
}
