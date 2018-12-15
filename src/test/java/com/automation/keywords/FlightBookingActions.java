package com.automation.keywords;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.automation.getpageobjects.GetPage;

public class FlightBookingActions extends GetPage{
	
	WebDriver driver;
	
	public FlightBookingActions(WebDriver driver) {
		super(driver, "Flight");
		this.driver = driver;
	}

	public void selectOneWayOption() {
		element("radioBtn_oneWay").click();
		logMessage("Step: Select One way option \n");
	}

	public void enterCityInFromInputFieldAndSelectValueFromOptionsAppear(String source) {
		element("txtBx_fromTag").clear();
		element("txtBx_fromTag").sendKeys(source);
		element("opt_origin").click();
		logMessage("Step: enter city from input field and select value from option \n");
	}

	public void enterCityInToInputFieldAndSelectValueFromOptionsAppear(String destination) {
		element("txtBx_toTag").clear();
		element("txtBx_toTag").sendKeys(destination);
		element("opt_destination").click();
		logMessage("Step: enter city to input field and select value from option \n");
	}

	public void selectDateFromDepartOn() {
		element("cal_departOn").click();
		element("cal_departOn").sendKeys(Keys.RETURN);
		logMessage("Step: select date from depart on \n");
	}

	public void clickOnSearchButton() {
		element("btn_search").click();
		logMessage("Step: click on search button \n");
	}

	public void verifyResultAppear() {
		Assert.assertTrue(element("lbl_summary").isDisplayed());
		logMessage("Step: verify result appear \n");
	}

}
