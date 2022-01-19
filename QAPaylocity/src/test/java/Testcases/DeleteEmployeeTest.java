package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import Base.TestBase;

public class DeleteEmployeeTest extends TestBase {
	
	
	@Test(priority = 1, description = "Delete Employee")

	public void editemployee() throws InterruptedException {
		Thread.sleep(500);
		click("delete");
		
		Thread.sleep(200);
		
		click("deleteemployee");
		
		Thread.sleep(200);
	/*	
		WebElement noemployeesfound = driver.findElement(By.name("No employees found."));
		
		if (noemployeesfound.isDisplayed()) {
			log.debug("Employee is deleted: ");
		}
		else {
			log.error("Employee was not deleted ");}
*/
		click("logout");
		Thread.sleep(300);
}
}