package utility;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;
import java.util.stream.Stream;

public class Utility {
    public static Object fetchPropertyValue(String key) throws IOException {
        FileInputStream file = new FileInputStream("./src/main/properties/properties");
        Properties property = new Properties();
        property.load(file);
        return property.get(key);
    }
    public static Object fetchPropertyValueXML(String key) throws IOException {
        FileInputStream file = new FileInputStream("./src/main/properties/user.xml");
        Properties property = new Properties();
        property.loadFromXML(file);
        return property.get(key);
    }
    public static double XMLParser(String file) throws FileNotFoundException, XPathExpressionException {
        InputSource doc = new InputSource(new InputStreamReader(new FileInputStream(new File(file))));
        String  xpathExpression = "//exchangerate[@buy]";
        NodeList list = (NodeList) XPathFactory.newInstance().newXPath().evaluate(xpathExpression,doc, XPathConstants.NODESET);
        return Double.parseDouble(list.item(0).getAttributes().item(1).getNodeValue());

    }
    public static void downloadUsingStream(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }
    @DataProvider(name = "Data", parallel = true)
    public static Object[][] testDataGenerator() throws Exception {
        FileInputStream file = new FileInputStream("./src/main/properties/Data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet list1 = workbook.getSheet("Sheet1");
        int numberOfData = list1.getPhysicalNumberOfRows();
        Object[][] testData = new Object[numberOfData][2];
        for (int i = 0; i < numberOfData; i++) {
            XSSFRow row = list1.getRow(i);
            XSSFCell product = row.getCell(0);
            XSSFCell brand = row.getCell(1);
            testData[i][0] = product.getStringCellValue();
            testData[i][1] = brand.getStringCellValue();
        }
        return testData;
    }
    @DataProvider(name = "Data2", parallel = true)
    public static Iterator<Object[]> testDataGenerator2(){
        return Stream.of(
                new Object[]{"ноутбуки", "ASUS"},
                new Object[]{"телевизоры", "Samsung"},
                new Object[]{"холодильники", "Samsung"},
                new Object[]{"смартфоны", "Samsung"},
                new Object[]{"фотоаппараты", "Olympus"}).iterator();
    }

}
