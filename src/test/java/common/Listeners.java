package common;
/* This is a class containing listeners,
 listeners “listen” to the event defined in the script and behave accordingly */
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends Utils implements ITestListener
{
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        //this statement is to take a screenshot anytime the test fails
        try {
            takeScreenshot();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        ITestListener.super.onTestSkipped(result);

    }

    @Override
    public void onFinish(ITestContext context)
    {
        ITestListener.super.onFinish(context);
    }
}

