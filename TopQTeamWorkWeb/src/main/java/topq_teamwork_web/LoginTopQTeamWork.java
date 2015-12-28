package topq_teamwork_web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import abstract_page.AbstractPageObject;
import abstract_page.HomePage;

public class LoginTopQTeamWork extends AbstractPageObject{

	public LoginTopQTeamWork(WebDriver driver) {
		super(driver);
	}

	public HomePage SubmitAndSuccessToLogin(String userName, String password) {
		
		driver.findElement(By.id("userLogin")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("ordLoginSubmitBtn")).click();
		
		return new HomePage(driver);
	}
	
	public LoginTopQTeamWork typeUserName(String userName) {
		driver.findElement(By.id("userLogin")).sendKeys(userName);
		return new LoginTopQTeamWork(driver);
	}
	
	public LoginTopQTeamWork typePassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
		return new LoginTopQTeamWork(driver);
	}
	
	
	public HomePage clickOnLoginButtonAndSuccessToLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ordLoginSubmitBtn"))).click();
		return new HomePage(driver);
	}
	
	public LoginTopQTeamWork SubmitAndFailToLogin(String userName, String password) {
		
		driver.findElement(By.id("userLogin")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("ordLoginSubmitBtn")).click();
		
		return new LoginTopQTeamWork(driver);
	}
	
	@Override
	protected void assertInPage() {
		Assert.assertFalse(driver.findElements(By.xpath
			("//button[@id='ordLoginSubmitBtn']")).isEmpty(), "This is not the login page");
	}

	
}
