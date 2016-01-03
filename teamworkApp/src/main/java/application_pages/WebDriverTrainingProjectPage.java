package application_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import abstract_pages.AbstractMobilePageObject;
import io.appium.java_client.android.AndroidDriver;

public class WebDriverTrainingProjectPage extends AbstractMobilePageObject{

	public WebDriverTrainingProjectPage(AndroidDriver<WebElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void assertInPage() {
		// TODO Auto-generated method stub
		
	}

	public ActiveTaskListsPage clickOnTasksButton() {
		
		findElement(By.xpath("//android.widget.TextView[@text='Tasks']/..//android.widget.Button")).click();
		return new ActiveTaskListsPage(driver);
	}

}
