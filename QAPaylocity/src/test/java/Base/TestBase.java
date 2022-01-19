package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utilities.ExtentManager;
import Utilities.TestUtil;

public class TestBase {

	public static WebDriver driver;

	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");

	public static WebDriverWait wait;
	public static WebDriverWait waitExplicit;
	public static WebDriverWait waitExplicitlong;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	
	String path = System.getProperty("user.dir");
	String driverpath = path + "/src/test/resources/Executables/chromedriver.exe";

	@BeforeSuite
	public void setUp() {
		
		if (driver == null) {

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "/src/test/resources/Properties/Config.properties");
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}

			try {
				config.load(fis);
				log.debug("Config file is loaded!!!");
			} catch (IOException e1) {

				e1.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "/src/test/resources/Properties/OR.properties");
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}

			try {
				OR.load(fis);
				log.debug("OR file is loaded!!!");
			} catch (IOException e) {

				e.printStackTrace();
			}

			if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\msavina\\eclipse-workspace\\QAPaylocity\\src\\test\\resources\\Executables\\geckodriver.exe");

				driver = new FirefoxDriver();

			} else if (config.getProperty("browser").equals("chrome")) {

				System.setProperty("webdriver.chrome.driver", driverpath);

				driver = new ChromeDriver();

				log.debug("Chrome launched!!!");
/**
				String downloadFilepath = "http://192.168.110.5:8080/job/aqa/job/EndToEndAutomationPHP7/ws/target/surefire-reports/html/";
				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
				chromePrefs.put("download.default_directory", downloadFilepath);
				ChromeOptions ChromeOptions = new ChromeOptions();
				ChromeOptions.setExperimentalOption("prefs", chromePrefs);

				ChromeOptions.addArguments("--headless", "window-size=1920,1080", "--no-sandbox", "--disable-gpu",
						"--allow-insecure-localhost", "--allow-running-insecure-content", "--ignore-certificate-errors",
						"--ignore-ssl-errors=true");
				ChromeOptions.setAcceptInsecureCerts(true);
				ChromeOptions.setHeadless(true);
				ChromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				ChromeOptions.setCapability(org.openqa.selenium.chrome.ChromeOptions.CAPABILITY, ChromeOptions);

				driver = new ChromeDriver(ChromeOptions);

				File chromeDriver = new File("/usr/bin/chromedriver");

				System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());

				log.debug("Chrome launched!!!");
**/
			} else if (config.getProperty("browser").equals("ie")) {
				System.setProperty("webdriver.ie.driver",
						"C:\\Users\\msavina\\eclipse-workspace\\QAPaylocity\\src\\test\\resources\\Executables\\IEDriverServer.exe");

				driver = new InternetExplorerDriver();

			}

			driver.get(config.getProperty("testingurl"));
			log.debug("Navigated to : " + config.getProperty("testingurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 20);

			waitExplicit = new WebDriverWait(driver, 10);
			waitExplicitlong = new WebDriverWait(driver, 100);
		}

	}

	public void click(String locator) {

		driver.findElement(By.xpath(OR.getProperty(locator))).click();

		test.log(LogStatus.INFO, "Clicking on : " + locator);

	}

	public void clear(String locator) {

		driver.findElement(By.xpath(OR.getProperty(locator))).clear();

		test.log(LogStatus.INFO, "Clearing on : " + locator);

	}

	public void type(String locator, String value) {

		driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);

		test.log(LogStatus.INFO, "Typing in : " + locator + "Entered Value as " + value);
	}
	
	public boolean isElementPresent(By by) {
		try {

			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {

			return false;

		}

	}
	

	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.quit();

		}

		log.debug("Test execution completed!!!");

	}
}
