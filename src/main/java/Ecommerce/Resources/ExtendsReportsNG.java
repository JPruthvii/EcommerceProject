package Ecommerce.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendsReportsNG {

	public static ExtentReports getReportObject()

	{
		String pathOfReport= System.getProperty("user.dir")+"\\Report\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(pathOfReport);
		reporter.config().setReportName("Web Automation Test");
		reporter.config().setDocumentTitle("Test Result");

		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Manoj JP" );
		return extent;

	}
}
