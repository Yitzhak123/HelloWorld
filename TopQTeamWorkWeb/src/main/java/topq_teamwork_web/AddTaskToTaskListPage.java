package topq_teamwork_web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import abstract_page.AbstractHomePage;

public class AddTaskToTaskListPage extends AbstractHomePage{

	String idOfTaskList;
	
	public AddTaskToTaskListPage(WebDriver driver, String idOfTaskList) {
		super(driver);
		this.idOfTaskList = idOfTaskList;
	}

	@Override
	protected void assertInPage() {
		Assert.assertFalse( driver.findElements(By.xpath("//input[@placeholder='What needs to be done?']")).isEmpty() );	
	}

	//TODO: Separate to multiple methods
	public TasksPage addNewTask(String WhatsNeedToBeDone, String whoShouldDoThis) {
		String xpath = "//input[@value='"+idOfTaskList+"']/..//"
				+ "input[@placeholder='What needs to be done?'][@class='tt-query']";
		// Write What's need to be done
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).sendKeys(WhatsNeedToBeDone);
		driver.findElement(By.xpath(xpath)).sendKeys(WhatsNeedToBeDone);
		// Choose who need to do this
		Select select = new Select(driver.findElement(By.xpath("//*[@tasklistid='"+idOfTaskList+"']")));
		select.selectByVisibleText(whoShouldDoThis);
		
		driver.findElement(By.xpath("//input[@value='']/..//input[@value='Save my changes']")).click();
		return new TasksPage(driver);
	}
	
	
	

}
