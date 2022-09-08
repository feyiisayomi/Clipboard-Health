package common;
/* This is a class containing listeners,
 listeners “listen” to the event defined in the script and behave accordingly */
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener
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
        ITestListener.super.onTestFailure(result);
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

