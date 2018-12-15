package com.automation.keywords;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.automation.getpageobjects.GetPage;

public class SignInActions extends GetPage{

	WebDriver driver;
	public SignInActions(WebDriver driver) {
		super(driver, "SignIn");
		this.driver = driver;
	}

	public void clickOnYourTrips() {
		element("lnk_yourTrip").click();
		logMessage("Step: click on your trip link \n");
	}

	public void clickOnSignIn() {
		element("btn_signin").click();
		logMessage("Step: click on sign in  \n");
	}

	public void clickOnSignInButtonOnWindow() {
		switchToFrame(element("frame"));
		element("btn_signIn").click();
		logMessage("Step: click on sign in button on modal window \n");
	}

	public void verifyErrorMessage(String error) {
		Assert.assertTrue(element("error").getText().contains(error));
		switchToDefaultContent();
		logMessage("Step: verified error message  \n");
	}
		

}
