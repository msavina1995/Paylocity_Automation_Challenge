package Utilities;

import Base.TestBase;

public class TestConfig extends TestBase {

	public static String server = "smtp.office365.com";
	public static String from = "donotreply";
	public static String password = "Sal82441";
	public static String[] to = { "buildalert" };

	public static String subject = "Test";

	public static String messageBody = "Test";
	public static String attachmentPath = "http://192.168.110.5:8080/job/aqa/job/PmeFeatures/ws/target/surefire-reports/html/extent.html";
	public static String attachmentName = "Extent Report";

}
