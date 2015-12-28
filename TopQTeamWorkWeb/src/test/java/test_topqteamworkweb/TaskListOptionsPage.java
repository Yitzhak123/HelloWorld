package test_topqteamworkweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import abstract_page.AbstractHomePage;
import topq_teamwork_web.TasksPage;

public class TaskListOptionsPage extends AbstractHomePage{

	String idOfTaskList;
	
	public TaskListOptionsPage(WebDriver driver, String idOfTaskList) {
		super(driver);
		this.idOfTaskList = idOfTaskList;
	}

	@Override
	protected void assertInPage() {
		// TODO Auto-generated method stub
		
	}

	public TasksPage deleteTaskList(String nameTaskList) {
		driver.findElement(
			By.xpath("//a[@href='javascript:tw.DeleteTaskList( "+idOfTaskList+" , false )']")).click();
		return new TasksPage(driver);
	}

}
