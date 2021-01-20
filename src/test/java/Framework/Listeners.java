package Framework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WrapsDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import resources.ExtentReporterNG;
import resources.base;

public class Listeners extends base implements ITestListener{
	ExtentReports extentobj;
	
	public void onTestStart(ITestResult result) {    //before executing test control will come here
		
	     extentobj = ExtentReporterNG.getReportObject();
		 ExtentTest test = extentobj.createTest("idnitialDemo");
		
		
	}

	public void onTestSuccess(ITestResult result) {
		
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("inside listener methhod");
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			System.out.println("inside try");
		}  catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			getScreenShotPath(testMethodName,driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
	
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
	
		extentobj.flush();
		
	}
}
