package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.Calendar;

public class CaptureScreenshot {
    static String filename = null;
    public static void takeScreenshot(WebDriver driver, String name) {
        try {
            Calendar c = Calendar.getInstance();
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            filename = "./Screenshots/"+name+c.getTime().toString().replace(":", "").replace(" ", "")+".png";
            File f = screenshot.getScreenshotAs(OutputType.FILE);
            File fd = new File(filename);
            FileUtils.copyFile(f, fd);
        }
        catch (Exception e){
            System.out.println("Not able to take screenshot");
        }
        //attachScreenshotToReport();
    }

//    public static void attachScreenshotToReport() {
//        try {
//            System.setProperty("org.uncommons.reportng.escape-output", "false");
//            File f = new File(filename);
//            Reporter.log("<a title= \"Snapshot\"href=\"" + f.getAbsolutePath() + "\">" +
//                    "<img width=\"418\"height=\"240\"alt=\"alternativeName\"title=\"title\"src=\"../surefire-reports/html/screenShots/"+filename+"\"</a>");
//        }
//        catch (Exception e){
//            System.out.println("Not able to take screenshot");
//        }
//
//    }
}
