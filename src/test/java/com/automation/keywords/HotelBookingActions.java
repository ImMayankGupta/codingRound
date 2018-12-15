package com.automation.keywords;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.automation.getpageobjects.GetPage;

public class HotelBookingActions extends GetPage{
	
WebDriver driver;
	
	public HotelBookingActions(WebDriver driver) {
		super(driver, "Hotel");
		this.driver = driver;
	}

	public void selectHotelOption() {
		element("lnk_hotel").click();
		logMessage("Step: Select hotel option \n");
	}

	public void enterLocality(String locality) {
		element("txtBx_locality").clear();
		element("txtBx_locality").sendKeys(locality);
		element("opt_localation").click();
		logMessage("Step: enter locality \n");
	}

	public void clickOnSearchButton() {
		element("btn_search").click();
		logMessage("Step: Select hotel option \n");
	}

	public void selectCheckInDate() {
		element("inp_checkin").click();
		element("inp_checkin").sendKeys(Keys.RETURN);
		logMessage("Step: select check in date \n");
	}

	public void selectCheckOutDate() {
		element("inp_checkout").click();
		element("inp_checkout").sendKeys(Keys.RETURN);
		logMessage("Step: select check out date \n");
	}

	public void selectTravellerInfo(String value) {
		selectProvidedTextFromDropDown(element("select_traveller"), value);
	}

}
