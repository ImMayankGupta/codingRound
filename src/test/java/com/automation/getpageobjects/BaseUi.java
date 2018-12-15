package com.automation.getpageobjects;

import static com.automation.utils.ConfigPropertyReader.getProperty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.automation.utils.SeleniumWait;

public class BaseUi {
	protected SeleniumWait wait;
	WebDriver driver;
	protected BaseUi(WebDriver driver, String pageName) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = new SeleniumWait(driver, Integer.parseInt(getProperty("Config.properties", "timeout")));

	}

	protected void logMessage(String message) {
		Reporter.log(message, true);
	}
	
	protected void selectProvidedTextFromDropDown(WebElement el, String text) {
		Select sel = new Select(el);
		sel.selectByVisibleText(text);
		logMessage("STEP : Selected option is " + text);
	}
	
	protected void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
}
