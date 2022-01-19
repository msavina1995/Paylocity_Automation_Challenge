package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import Base.TestBase;

public class EditEmployeeTest extends TestBase {

	@Test(priority = 1, description = "Edit Employee")

	public void editemployee() throws InterruptedException {
		Thread.sleep(500);
	//click("edit");

	WebElement select = driver.findElement(By.xpath(OR.getProperty("edit")));
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", select);
	
	clear("fname");
	type("fname", "Georg1");
	
	clear("lname");
	type("lname", "FamilyName1");
	
	clear("dependants");
	type("dependants", "2");
	Thread.sleep(500);
	click("updateemployee");
	Thread.sleep(300);
	/*
	WebElement neweployeefname = driver.findElement(By.name("Georg1"));
	WebElement neweployeelname = driver.findElement(By.name("FamilyName1"));
	
	if (neweployeefname.isDisplayed() && neweployeelname.isDisplayed()) {
		log.debug("Employee is updated: ");
	}
	else {
		log.error("Employee was not updated ");}
		*/
	Thread.sleep(300);
}
}