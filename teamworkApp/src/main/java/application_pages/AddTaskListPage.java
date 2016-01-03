package application_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import abstract_pages.AbstractMobilePageObject;
import io.appium.java_client.android.AndroidDriver;

public class AddTaskListPage extends AbstractMobilePageObject {

	public AddTaskListPage(AndroidDriver<WebElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void assertInPage() {
		// TODO Auto-generated method stub
		
	}

	public AddTaskListPage typeTheTaskListTitle(String taskListTitle) {
		typeToElement(By.xpath("//android.widget.TextView[@text='Add Task List']"), taskListTitle);
		return new AddTaskListPage(driver);
	}
	
	public AddTaskListPage typeTheTaskListDescription(String taskListDescription) {
		typeToElement(By.xpath("//android.widget.EditText[@text='Description']"), taskListDescription);
		return new AddTaskListPage(driver);
	}
	
	public ActiveTaskListsPage clickOnSaveButtonAndGoBackToActiveTaskListsPage() {
		clickOnElement(By.xpath("//android.widget.TextView[@text='Save']"));
		return new ActiveTaskListsPage(driver);
	}

}
