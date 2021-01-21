package Framework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WrapsDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.base;

public class Listeners extends base implements ITestListener {
	
	ExtentReports extentobj = ExtentReporterNG.getReportObject();;
	ExtentTest test;
	
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); // using this because whenever parallal execution happening extent report stast 
																		//executing all tc at the same time if any test fail it will override tc2 and it will mark tc2 as fail instead tc1
																		//to avoid this issue making application thread safe
	
	public void onTestStart(ITestResult result) {//before executing test control will come here
	    
		 test = extentobj.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		
		extentTest.get().log(Status.PASS, "Test passed");	
	}

	public void onTestFailure(ITestResult result) {
		//screenshot
		
		extentTest.get().fail(result.getThrowable());		
		
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
			extentTest.get().addScreenCaptureFromPath( getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());
			
		} catch (IOException e) {
			
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
