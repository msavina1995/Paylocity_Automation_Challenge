package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import Base.TestBase;

public class AddEmployeeTest extends TestBase{

	@Test(priority = 1, description = "Add New Employee")
	public void AddEmployee() throws InterruptedException {

		Thread.sleep(500);
		click("addemployee");
		
		Thread.sleep(200);
		
		type("fname", "Georg");
		
		type("lname", "FamilyName");
		
		type("dependants", "3");
		Thread.sleep(500);
		click("addbutton");
		
		Thread.sleep(500);
/*
		WebElement neweployeefname = driver.findElement(By.name("Georg"));
		WebElement neweployeelname = driver.findElement(By.name("FamilyName"));
		
		if (neweployeefname.isDisplayed() && neweployeelname.isDisplayed()) {
			log.debug("Employee is created: ");
		}
		else {
			log.error("Employee wasn't create: ");}
		Thread.sleep(500);
		*/
	}

}
