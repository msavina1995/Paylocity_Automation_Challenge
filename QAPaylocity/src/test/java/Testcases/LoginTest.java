package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import Base.TestBase;

public class LoginTest extends TestBase{
	@Test(priority = 1, description = "Login")
	public void loginasPMEAdmin() throws InterruptedException {

		WebElement username = waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("username"))));
		username.sendKeys("TestUser123");

		type("password", "aRV(#E_Es)a$");

		Thread.sleep(300);
		//click("loginbtn");
		
		WebElement select = waitExplicit
				.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("loginbtn"))));
		Actions act = new Actions(driver);

		act.moveToElement(select);
		act.click().sendKeys(Keys.ENTER);
		act.build().perform();
		
		Thread.sleep(500);

	}
}
