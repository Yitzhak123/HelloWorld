package application_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import abstract_pages.AbstractPageObject;
import io.appium.java_client.android.AndroidDriver;

public class EditNoteContentPage extends AbstractPageObject{

	public EditNoteContentPage(AndroidDriver<WebElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void assertInPage() {
		// TODO Auto-generated method stub
		
	}

	public void typeTextToAddTagTextBox(String text) {
		typeToElement(By.className("android.widget.MultiAutoCompleteTextView"), text);	
	}
	
	public void typeFreeTextToNoteEditText(String text) {
		typeToElement(By.className("android.widget.EditText"), text);	
	}
	
	public NotesPage clickOnTheNavigateUpButton() {
		clickOnElement(By.className("android.widget.ImageButton"));
		return new NotesPage(driver);
	}
	
	public String getTextInTagTextBox() {
		return findElement(
				By.className("android.widget.MultiAutoCompleteTextView")).getAttribute("text");
	}
	
	public String getTextInNoteEditText() {
		return findElement(By.className("android.widget.EditText")).getAttribute("text");
	}
	
	public NotesPage deleteThisNote() {
		return null;
		
	}
}
