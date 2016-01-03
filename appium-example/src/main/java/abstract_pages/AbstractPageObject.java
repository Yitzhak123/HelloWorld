package abstract_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public abstract class AbstractPageObject {

	protected final AndroidDriver<WebElement> driver;
	protected static WebDriverWait wait;
	protected final TouchAction action; 

	public AbstractPageObject(AndroidDriver<WebElement> driver) {
		super();
		this.driver = driver;
		this.action = new TouchAction(driver);
		assertInPage();
	}
	
	public static void setWebDriverWait(WebDriverWait wait_) {
		wait = wait_;
	}
	
	protected abstract void assertInPage();

	public String getDriverUrl() {
    	return driver.getCurrentUrl();
    }
    
    public void closePage() {
    	driver.close();
    }
    
    public void clickOnElement(By locator) {
	    wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	public void submitElement(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator)).submit();
	}

	  
	public void typeToElement(By locator, String text) { 
	    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	    element.clear();
	    element.sendKeys(text);
	}
	
	public void typeToElementAndSubmit(By locator, String text) {
		 WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		 element.clear();
		 element.sendKeys(text);
		 element.submit();
	}
	
	public WebElement findElement(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public boolean isElementExist(By locator) {
		return !wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator)).isEmpty();
	}
}
