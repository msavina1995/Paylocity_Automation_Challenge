package Utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

import Base.TestBase;

public class ExtentManager extends TestBase {

	public static ExtentReports extent;

	public static ExtentReports getInstance() {

		if (extent == null) {

			extent = new ExtentReports(System.getProperty("user.dir") + "/target/surefire-reports/html/extent.html",
					true, DisplayOrder.OLDEST_FIRST);

			extent.loadConfig(
					new File(System.getProperty("user.dir") + "/src/test/resources/Extentconfig/ReportsConfig.xml"));

		}

		return extent;

	}

}