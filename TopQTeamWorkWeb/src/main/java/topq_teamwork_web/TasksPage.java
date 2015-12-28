package topq_teamwork_web;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import abstract_page.AbstractHomePage;
import test_topqteamworkweb.TaskListOptionsPage;

public class TasksPage extends AbstractHomePage{

	
	public TasksPage(WebDriver driver) {
		super(driver);
	}

	private String searchTaskListId(String nameTaskList) {
		WebElement taskListElement = driver.findElement(By.xpath(
				"//div[@id='TaskListsContent']//a[contains(., '"+ nameTaskList +"')]"));
			
		String tempId = taskListElement.getAttribute("href");
		return tempId.substring(tempId.indexOf('4'));
	}
	
	@Override
	protected void assertInPage() {
		String message = "This is not the Tasks Page";
		Assert.assertFalse(driver.findElements(
				By.xpath("//*[@id='pageTitle'][contains(., 'Tasks')]")).isEmpty(), message);
	}

	public AddTaskListPage clickOnAddTaskList() {
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//li[@id='liBFOATL']/button/span[@class='btn-addIcon']"))).click();
		return PageFactory.initElements(driver, AddTaskListPage.class);
	}

	public AddTaskToTaskListPage AddTaskAfterWeClickOnAddTask(String nameTaskList) {
		
		String id = searchTaskListId(nameTaskList);
		return new AddTaskToTaskListPage(driver, id);
	}
	
	public AddTaskToTaskListPage clickOnAddTask(String nameTaskList) {
		
			String id = searchTaskListId(nameTaskList);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='options"+id+"']/button"))).click();
			return new AddTaskToTaskListPage(driver, id);
	}

	public boolean IsTaskExistInTaskList(String nameTaskList, 
			String WhatsNeedToBeDone, String whoShouldDoThis) {
		String id = searchTaskListId(nameTaskList);
		int i = 1;
		String xpathCurrentTask = "//div[@tl-id='"+id+"']["+i+"]//a/span";
		//while there are still elements in the task list
		while( !driver.findElements(By.xpath(xpathCurrentTask)).isEmpty() ) {
			// Check if the WhatsNeedToBeDone and whoShouldDoThis in the current task are
			// equal to what the user gave us
			if( (!driver.findElements(By.xpath(
				""+xpathCurrentTask+"[contains(., '"+WhatsNeedToBeDone+"')]")).isEmpty())
			&& (!driver.findElements(By.xpath(
						""+xpathCurrentTask+"[contains(., '"+whoShouldDoThis+"')]")).isEmpty()) )
			{
				return true;
			}
			++i;
			System.out.println("i = "+i);
			xpathCurrentTask = "//div[@tl-id='"+id+"']["+i+"]//a/span";
		}
		
		return false;
			
	}

	public TaskListOptionsPage clickOnTaskListOptions(String nameTaskList) {
		String id = searchTaskListId(nameTaskList);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@id='tlo_"+id+"']"))).click();
		//driver.findElement(By.xpath("//div[@id='tlo_"+id+"']")).click();
		return new TaskListOptionsPage(driver, id);
	}

	public void deleteNumOfTasks(int numOfTasks) {
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@id='TaskLists']//a[@class='ql']"));
		String nameTaskList;
		String str;
		String id;
		for (int i = 0; i < numOfTasks; i++) {
			str = elements.get(i).getAttribute("href");
			id = str.substring(str.lastIndexOf('4'));
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//div[@id='tlo_"+id+"']"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//a[@href='javascript:tw.DeleteTaskList( "+id+" , false )']"))).click();
		}
	}
	
}
