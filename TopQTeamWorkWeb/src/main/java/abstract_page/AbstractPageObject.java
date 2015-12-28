package abstract_page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPageObject {

	protected final WebDriver driver;
	protected final WebDriverWait wait;

	public AbstractPageObject(WebDriver driver) {
		super();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 15);
		this.driver = driver;
		assertInPage();
	}
	
	protected abstract void assertInPage();

	public String getDriverUrl() {
    	return driver.getCurrentUrl();
    }
    
    public void closePage() {
    	driver.close();
    }
}
