package endtoend.learning;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.base;
import resources.extentreportng;

public class listeners extends base implements ITestListener{

	ExtentTest test;
	ExtentReports extent=extentreportng.getReportObject();
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		
		
		ExtentTest test=extent.createTest("initialdemo");
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.log(Status.PASS, "test passed");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.fail(result.getThrowable());
		WebDriver driver=null;
		String testmethodname=result.getMethod().getMethodName();
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		getscreenshotpath(testmethodname, driver);
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
