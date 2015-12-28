package test_topqteamworkweb;
import org.testng.annotations.Test;

import abstract_page.HomePage;
import topq_teamwork_web.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestTopQTeamWorkWeb {

	private WebDriver driver;
	
	@BeforeMethod
	public void SetUpBeforeMethod() {
		driver = new FirefoxDriver();
		driver.get("https://topq.teamwork.com/");
	}

	@AfterMethod
	public void closePageAfterMethod() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
	
	@Test
	public void CreateNewTask() {
		
		String nameTaskList = "FinishSeleniumEx34232";
		LoginTopQTeamWork loginPage = new LoginTopQTeamWork(driver);
		HomePage homePage = loginPage.SubmitAndSuccessToLogin("fake04@fake.com", "fake");
		Reporter.log("Success to login!");
		
		TasksPage taskPage = homePage.clickOnModuleTasks();
		AddTaskListPage addTaskList = taskPage.clickOnAddTaskList();
		// Open temporary window. we will write in it the name of the task list
		addTaskList.addNewTaskList(nameTaskList);
		Reporter.log("We have a new task list", true);
		
		//return to task page
		AddTaskToTaskListPage addTaskToTaskListPage = taskPage.clickOnAddTask(nameTaskList);
		// Open window to add new task below the task list
		taskPage = addTaskToTaskListPage.addNewTask("TaskNumber1", "fake04 fake04 (me)");
		addTaskToTaskListPage = taskPage.AddTaskAfterWeClickOnAddTask(nameTaskList);
		addTaskToTaskListPage.addNewTask("TaskNumber2", "fake04 fake04 (me)");
		Reporter.log("We have a new 2 tasks in the task list", true);
		
		MilestonesPage milestonePage = taskPage.clickOnModuleMilestone();
		taskPage = milestonePage.clickOnModuleTasks();
		
		Assert.assertTrue(taskPage.IsTaskExistInTaskList(nameTaskList, "TaskNumber1", "fake04"));
		Assert.assertTrue(taskPage.IsTaskExistInTaskList(nameTaskList, "TaskNumber2", "fake04"));
		Assert.assertFalse(taskPage.IsTaskExistInTaskList(nameTaskList, "notTaskNumber1", "fake04"));
		Reporter.log("We have succeded to find our task in the task list", true);
		
		TaskListOptionsPage taskListOptionsPage = taskPage.clickOnTaskListOptions(nameTaskList);
		taskPage = taskListOptionsPage.deleteTaskList(nameTaskList);
	}
	
	@Test
	public void testAddTaskListToMilestone() {
		
		String nameTaskList = "FinishSeleniumEx34232";
		LoginTopQTeamWork loginPage = new LoginTopQTeamWork(driver);
		loginPage.typeUserName("fake04@fake.com");
		loginPage.typePassword("fake");
		HomePage homePage = loginPage.clickOnLoginButtonAndSuccessToLogin();
		Reporter.log("Success to login!");
		
		TasksPage taskPage = homePage.clickOnModuleTasks();
		AddTaskListPage addTaskList = taskPage.clickOnAddTaskList();
		// Open temporary window. we will write in it the name of the task list
		addTaskList.addNewTaskList(nameTaskList);
		Reporter.log("We have a new task list", true);
		
		MilestonesPage milestonePage = taskPage.clickOnModuleMilestone();
	}
}
