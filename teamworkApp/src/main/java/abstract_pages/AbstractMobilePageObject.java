package abstract_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public abstract class AbstractMobilePageObject {

	protected final AndroidDriver<WebElement> driver;
	protected static WebDriverWait wait;
	protected final TouchAction action; 
	private Dimension size;
	private int startx;
	private int endx;
	private int endy;
	private int starty;

	public AbstractMobilePageObject(AndroidDriver<WebElement> driver) {
		super();
		this.driver = driver;
		this.action = new TouchAction(driver);
		size = driver.manage().window().getSize();
		startx = size.width / 2;
		endx = startx;
		starty = (int) (size.height * 0.99);
		endy = (int) (size.height * 0.01);
		assertInPage();
	}
	
	public WebElement scrollFromBottomToTopUntilUntilExpectedElement(By locator){
		while( driver.findElements(locator).isEmpty() ) {
			driver.swipe(startx, endy, endx, starty, 1500);
		}
		
		return driver.findElement(locator);
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

	public void clearElementText(By locator) {
		 WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		 element.clear();
	}
	
	public void typeToElement(By locator, String text) { 
	    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	    element.sendKeys(text);
	}
	
	public void typeToElementAndSubmit(By locator, String text) {
		 WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		 element.sendKeys(text);
		 element.submit();
	}
	
	public WebElement findElement(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public List<WebElement> findElements(By locator) {
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	public boolean isElementExist(By locator, int secondsToWaitUntilSearching) {
		try {
			Thread.sleep(secondsToWaitUntilSearching);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return !driver.findElements(locator).isEmpty();
	}
}
