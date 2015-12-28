package abstract_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends AbstractHomePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	protected void assertInPage() {
		String message = "This is not The Home Page";
		Assert.assertFalse(driver.findElements
			(By.xpath("//div[@id='mlogo']/a/img[@alt='WebDriver Training']")).isEmpty(), message);
	}

	
	
}
