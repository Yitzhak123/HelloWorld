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

import abstract_pages.AbstractPageObject;
import application_pages.EditNoteContentPage;
import application_pages.NotesPage;
import io.appium.java_client.android.AndroidDriver;

public class TestSimpleNotes {

	private AndroidDriver<WebElement> driver;

	@BeforeMethod
	public void setUp() throws Exception {
		File app = new File("Simplenote.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "google Galaxy Nexus - 4.2.2 - API 17 - 720x1280");
		capabilities.setCapability("platformVersion", "4.2.2");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.automattic.simplenote");
		capabilities.setCapability("appActivity", ".NotesActivity");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	
	@Test
	public void testAddNewNote() throws InterruptedException{
		Reporter.log("Given the application Simplenote is opened");
		Reporter.log("When the user creates a new note");
		String tagText = "abcd";
		String freeText = "free text";
		// Your code comes here	
		NotesPage notesPage = new NotesPage(driver);
		AbstractPageObject.setWebDriverWait(new WebDriverWait(driver, 12));
		EditNoteContentPage editNoteContentPage = notesPage.clickOnCreateNewNote();
		
		Reporter.log("And the user add some content to the note");
		editNoteContentPage.typeTextToAddTagTextBox(tagText);
		editNoteContentPage.typeFreeTextToNoteEditText(freeText);
		notesPage = editNoteContentPage.clickOnTheNavigateUpButton();
		Reporter.log("And the note is saved");
		// Your code comes here
		editNoteContentPage = notesPage.clickOnTheNoteWithText("free text");
		Reporter.log("When the same note is selected");
		// Your code comes here
		Assert.assertEquals(
				editNoteContentPage.getTextInNoteEditText(), freeText);
		Assert.assertEquals(editNoteContentPage.getTextInTagTextBox().substring(0, 4), tagText);
		Reporter.log("Then it holds the same content");
		
		notesPage = editNoteContentPage.clickOnTheNavigateUpButton();
		notesPage = notesPage.deleteNoteWithText(freeText);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
}
