package application_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import abstract_pages.AbstractMobilePageObject;
import io.appium.java_client.android.AndroidDriver;

public class ActiveTaskListsPage extends AbstractMobilePageObject{

	public ActiveTaskListsPage(AndroidDriver<WebElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void assertInPage() {
		// TODO Auto-generated method stub
		
	}

	public AddTaskListPage clickOnAddTaskListButton() {
		/*String xpathAddTaskList = "//android.widget.TextView[@text='Add Task List']";
		action.moveTo(findElement(
				By.xpath(xpathAddTaskList)));
		findElement(By.xpath(xpathAddTaskList)).click();*/
		
		driver.scrollTo("Add Task List");
		String xpathAddTaskList = "//android.widget.TextView[@text='Add Task List']";
		findElement(By.xpath(xpathAddTaskList)).click();
//		WebElement element= findElement(By.xpath(xpathAddTaskList));
//		action.moveTo(element);
//		action.press(element);
		
		return new AddTaskListPage(driver);
		
	}

	public boolean IsTaskListExist(String taskListTitle, String taskListDescription) {
		System.out.println("taskListTitle = "+taskListTitle);
		
		driver.scrollTo(taskListTitle);
		List<WebElement> textViewList = findElements(
			By.xpath("//android.widget.ListView[@text='"+taskListTitle+"']/../android.widget.TextView"));
		return textViewList.get(0).equals(taskListTitle) && 
				textViewList.get(1).equals(taskListDescription);
	}

	public TaskListPage clickOnTaskList(String taskListTitle) {
		String xpathTaskListTitle = "//android.widget.ListView[@text='"+taskListTitle+"']";
		
		driver.scrollTo(taskListTitle).click();
		
		return new TaskListPage(driver);
	}

}
