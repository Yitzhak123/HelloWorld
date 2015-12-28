package abstract_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import topq_teamwork_web.*;

public abstract class AbstractHomePage extends AbstractPageObject{

	public AbstractHomePage(WebDriver driver) {
		super(driver);
	}

	String findFirstDigit(String str) {
		return str.substring(str.indexOf('1'));
//		for (int i = 0; i < str.length(); i++) {
//			if('0'<= str.charAt(i) && str.charAt(i) <='9') {
//				return str.substring(i);
//			}
//		}
//		return null;
	}
	
	public TasksPage clickOnModuleTasks() {
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//li[@id='tab_tasks']/a[contains(., 'Tasks')]"))).click();
		return new TasksPage(driver);
	}
	
	public MilestonesPage clickOnModuleMilestone() {
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//li[@id='tab_milestones']/a[contains(., 'Milestones')]"))).click();
		return new MilestonesPage(driver);
	}
}
