package application_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import abstract_pages.AbstractMobilePageObject;
import io.appium.java_client.android.AndroidDriver;

public class TeamWorkAppLoginPage extends AbstractMobilePageObject{

	public TeamWorkAppLoginPage(AndroidDriver<WebElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void assertInPage() {
		// TODO Auto-generated method stub
		
	}

	public HomePage submitAndSuccessToLogin(String userName, String password) {
		String xpathUserName = "//android.widget.TextView[@text='Email Address or API Key']";
		typeToElement(
			By.xpath(xpathUserName), userName);
		typeToElement(
			By.xpath("//android.widget.TextView[@text='Password']"), password);
		clickOnElement(By.className("android.widget.Button"));
			
		return new HomePage(driver);
	}
	
}
