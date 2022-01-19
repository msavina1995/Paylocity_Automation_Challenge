package Listeners;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;

import Base.TestBase;
import Utilities.MonitoringMail;
import Utilities.TestConfig;
import Utilities.TestUtil;

public class CustomListeners extends TestBase implements ITestListener, ISuiteListener {

	public String messagetext;

	public String messageBody;

	// Test

	public void onFinish(ITestContext context) {

	}

	public void onStart(ITestContext context) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailure(ITestResult arg0) {

		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {

			e.printStackTrace();
		}

		test.log(LogStatus.FAIL, arg0.getName().toUpperCase() + " Failed with exception : " + arg0.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
		rep.endTest(test);
		rep.flush();
		Reporter.log("Click to see screenshot");
		Reporter.log("<a target=\"_blank\"href=" + TestUtil.screenshotName + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\"href=" + TestUtil.screenshotName + ")img src=" + TestUtil.screenshotName
				+ " height=200 width=200></img></a>");
		rep.endTest(test);
		rep.flush();
		Reporter.log("Login Successfully not executed");

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestStart(ITestResult arg0) {

		// test = rep.startTest(arg0.getName().toUpperCase());
		test = rep.startTest(arg0.getMethod().getDescription().toUpperCase());
		/*
		 * if(!TestUtil.isTestRunnable(arg0.getName(), excel)) {
		 * 
		 * throw new SkipException("Skipping the test  "+arg0.getName().toUpperCase()
		 * +" as the run mode is No"); } rep.endTest(test); rep.flush();
		 */
	}

	public void onTestSuccess(ITestResult arg0) {

		test.log(LogStatus.PASS, arg0.getName().toUpperCase() + " Pass");
		rep.endTest(test);
		rep.flush();

		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {

			e.printStackTrace();
		}
		Reporter.log("Click to see screenshot");
		Reporter.log("<a target=\"_blank\"href=" + TestUtil.screenshotName + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\"href=" + TestUtil.screenshotName + ")img src=" + TestUtil.screenshotName
				+ " height=200 width=200></img></a>");

		Reporter.log("Login Successfully not executed");

	}

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ISuite suite) {
		MonitoringMail mail = new MonitoringMail();
		messagetext = "Please follow this link to see Automation Testing Results\n";

		messageBody = "http://192.168.110.5:8080/job/aqa/job/PmeFeatures/ws/target/surefire-reports/html/extent.html";

		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, null, TestConfig.subject, messageBody,
					TestConfig.attachmentPath, TestConfig.attachmentName, messageBody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
