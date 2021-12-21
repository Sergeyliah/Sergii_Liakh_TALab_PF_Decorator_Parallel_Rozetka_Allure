package utility;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.stream.Stream;

public class DataProviderClass {
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
