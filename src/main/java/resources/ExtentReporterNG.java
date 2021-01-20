package resources;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public WebDriver driver;
	public static ExtentReports extentobj;

	
	public  static ExtentReports getReportObject() {
		
		String path = System.getProperty("user.dir") + "/reports/index.html";

		ExtentSparkReporter reptobj = new ExtentSparkReporter(path);
		reptobj.config().setReportName("Aparna test Autonmation Result");
		reptobj.config().setDocumentTitle("Test result");

		extentobj = new ExtentReports();
		extentobj.attachReporter(reptobj);
		extentobj.setSystemInfo("Tester", "Aparna Choudhary");
 
		return extentobj;
	}
}
