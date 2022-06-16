package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utility.CaptureScreenshot;

import static tests.BaseTest.getDriver;

public class ModifyListener implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("***********Test Case Start Here**************");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        CaptureScreenshot.takeScreenshot(getDriver(), "Screenshot");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        CaptureScreenshot.takeScreenshot(getDriver(), "Screenshot");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }
}
