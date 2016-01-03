package application_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;

import abstract_pages.AbstractPageObject;
import io.appium.java_client.android.AndroidDriver;

public class NotesPage extends AbstractPageObject{

	public NotesPage(AndroidDriver<WebElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void assertInPage() {
		// TODO Auto-generated method stub
		
	}

	public EditNoteContentPage clickOnCreateNewNote() {
		clickOnElement(By.className("android.widget.ImageView"));
		return new EditNoteContentPage(driver);
	}

	public EditNoteContentPage clickOnTheNoteWithText(String text) {
		clickOnElement(By.xpath("//android.widget.TextView[@text='"+text+"']"));
		return new EditNoteContentPage(driver);
	}

	public NotesPage deleteNoteWithText(String freeText) {
		action.longPress(findElement
				(By.xpath("//android.widget.TextView[@text='"+freeText+"']"))).perform().release();
		clickOnElement(
				By.xpath("//android.support.v7.widget.LinearLayoutCompat/android.widget.TextView"));
		return new NotesPage(driver);		
	}

}
