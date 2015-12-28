package topq_teamwork_web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import abstract_page.AbstractHomePage;

public class MilestonesPage extends AbstractHomePage{

	public MilestonesPage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected void assertInPage() {
		String message = "This is not the Milestones Page";
		Assert.assertFalse(driver.findElements(
				By.xpath("//*[@id='pageTitle'][contains(., 'Milestones')]")).isEmpty(), message);
	}

}
