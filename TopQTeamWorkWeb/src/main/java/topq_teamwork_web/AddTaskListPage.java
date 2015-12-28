package topq_teamwork_web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddTaskListPage {

	@FindBy(id="newTaskListName")
    private WebElement element;

    public void addNewTaskList(String text) {
    	element.clear();
    	element.sendKeys(text);
    	element.submit();
    }

}
