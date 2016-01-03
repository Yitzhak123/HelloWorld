package com;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import abstract_pages.AbstractMobilePageObject;
import application_pages.ActiveTaskListsPage;
import application_pages.AddTaskListPage;
import application_pages.HomePage;
import application_pages.ModulesPage;
import application_pages.ProjectsPage;
import application_pages.TaskListPage;
import application_pages.TeamWorkAppLoginPage;
import application_pages.WebDriverTrainingProjectPage;
import io.appium.java_client.android.AndroidDriver;

public class TestTeamWorkApp {

	private AndroidDriver<WebElement> driver;

	@BeforeMethod
	public void setUp() throws Exception {
		File app = new File("teamwork.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "google Galaxy Nexus - 4.2.2 - API 17 - 720x1280");
		capabilities.setCapability("platformVersion", "4.2.2");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "net.teamworkpm.phone");
		capabilities.setCapability("appActivity", ".ProjectsActivity");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	
	@Test
	public void testAddNewNote() throws InterruptedException{
		String userName = "fake04@fake.com";
		String password = "fake";
		String taskListTitle = "taslList234343";
		String taskListDescription = "description1";
		AbstractMobilePageObject.setWebDriverWait(new WebDriverWait(driver, 20));
		TeamWorkAppLoginPage teamWorkAppLoginPage = new TeamWorkAppLoginPage(driver);
		HomePage homePage = teamWorkAppLoginPage.submitAndSuccessToLogin(userName, password);
		ModulesPage modulesPage = homePage.clickOnMudulesButton();
		ProjectsPage projectsPage = modulesPage.clickOnProjectsButton();
		WebDriverTrainingProjectPage webDriverTrainingProjectPage = projectsPage.clickOnWebDriverTrainingProject();
		ActiveTaskListsPage activeTaskListsPage = webDriverTrainingProjectPage.clickOnTasksButton();
		AddTaskListPage addTaskList = activeTaskListsPage.clickOnAddTaskListButton();
		Reporter.log("success to clickOnAddTaskListButton", true);
		
		addTaskList = addTaskList.typeTheTaskListTitle(taskListTitle); 
		addTaskList = addTaskList.typeTheTaskListDescription(taskListDescription);
		activeTaskListsPage = addTaskList.clickOnSaveButtonAndGoBackToActiveTaskListsPage();
		Reporter.log("success to add list task and new 2 tasks", true);
		
		Assert.assertTrue(activeTaskListsPage.IsTaskListExist(taskListTitle, taskListDescription),"aaa");
		TaskListPage taskListPage = activeTaskListsPage.clickOnTaskList(taskListDescription);
		Reporter.log("Test success!", true);
		
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(4000);
		driver.quit();
	}
}
