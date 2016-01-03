package application_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import abstract_pages.AbstractMobilePageObject;
import io.appium.java_client.android.AndroidDriver;

public class ModulesPage extends AbstractMobilePageObject{

	public ModulesPage(AndroidDriver<WebElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void assertInPage() {
		// TODO Auto-generated method stub
		
	}

	public ProjectsPage clickOnProjectsButton() {
		findElement(By.xpath("//android.widget.TextView[@text='Projects']")).click();
		return new ProjectsPage(driver);
	}

}
