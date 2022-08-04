package com.seleniumJava.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport extends TestListenerAdapter {
	
	ExtentReports extentReport;
	ExtentTest extentTest;
	ExtentSparkReporter sparkReporter;
	
	public void onStart(ITestContext testcontext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportname = "./reports/test-Report-"+timeStamp+".html";
		sparkReporter = new ExtentSparkReporter(reportname);
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(sparkReporter);
		extentReport.setSystemInfo("Host Name", "localhost");
		extentReport.setSystemInfo("Environamnet", "Test");
		extentReport.setSystemInfo("User", "Donald Duck");
		
		sparkReporter.config().setDocumentTitle("selenium Java Extent Report");
		sparkReporter.config().setReportName("E2E tests");
		sparkReporter.config().setTheme(Theme.DARK);
	}

	public void onTestSuccess(ITestResult testResult) {
		extentReport.createTest(testResult.getName())
		.pass("");
	}
	
	public void onTestFailure(ITestResult testResult) {
		extentReport.createTest(testResult.getName()).fail(""); 
	}
	
	public void onFinish(ITestContext testContext) {
		extentReport.flush();	
	}
}
