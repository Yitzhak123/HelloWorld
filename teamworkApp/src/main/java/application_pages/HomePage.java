package application_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import abstract_pages.AbstractMobilePageObject;
import io.appium.java_client.android.AndroidDriver;

public class HomePage extends AbstractMobilePageObject{

	public HomePage(AndroidDriver<WebElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void assertInPage() {
		// TODO Auto-generated method stub
		
	}

	public ModulesPage clickOnMudulesButton() {
		findElement(By.className("android.widget.ImageButton")).click();
		return new ModulesPage(driver);
	}

}
