package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public abstract class AbstractComponent<T extends WebDriver> {
	protected T driver;

	public AbstractComponent(T driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	// Add common methods that can be used across components

	protected void clickElement(WebElement element) {
		element.click();
	}

	protected void typeText(WebElement element, String text) {
		element.sendKeys(text);
	}

	public void clearText(WebElement element) {
		element.clear();
	}

	public String getText(WebElement element) {
		return element.getText();
	}

	public void selectDropdownOption(WebElement dropdown, String option) {
		Select select = new Select(dropdown);
		select.selectByVisibleText(option);
	}

	public void checkCheckbox(WebElement checkbox) {
		if (!checkbox.isSelected()) {
			checkbox.click();
		}
	}

	public void uncheckCheckbox(WebElement checkbox) {
		if (checkbox.isSelected()) {
			checkbox.click();
		}
	}

	public void hoverOverElement(Actions actions, WebElement element) {
		actions.moveToElement(element).perform();
	}

	public void rightClick(Actions actions, WebElement element) {
		actions.contextClick(element).perform();
	}

	public void doubleClick(Actions actions, WebElement element) {
		actions.doubleClick(element).perform();
	}

	public void dragAndDrop(Actions actions, WebElement source, WebElement target) {
		actions.dragAndDrop(source, target).perform();
	}


}
