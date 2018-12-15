package com.automation.test;

import static com.automation.utils.YamlReader.getYamlValue;

import java.lang.reflect.Method;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.initiator.*;

public class FlightBookingTest {
	TestSessionInitiator test;
	    
    @BeforeClass
	public void Start_Test_Session() {
		test = new TestSessionInitiator(this.getClass().getSimpleName());
		test.launchApplication(getYamlValue("url"));
	}

	@BeforeMethod
	public void handleTestMethodName(Method method) {
		test.stepStartMessage(method.getName());
	}
   
	@Test()
	public void testThatResultsAppearForAOneWayJourney(){
		test.flightActions.selectOneWayOption();
		test.flightActions.enterCityInFromInputFieldAndSelectValueFromOptionsAppear(getYamlValue("source"));
		test.flightActions.enterCityInToInputFieldAndSelectValueFromOptionsAppear(getYamlValue("destination"));
		test.flightActions.selectDateFromDepartOn();
		test.flightActions.clickOnSearchButton();
		test.flightActions.verifyResultAppear();
	}
	
	
	@AfterMethod
	public void take_screenshot_on_failure(ITestResult result) {
		test.takescreenshot.takeScreenShotOnException(result);
	}
	
	@AfterMethod
	public void handleTestMethod(Method method) {
		test.stepFinishMessage(method.getName());
	}

	@AfterClass
	public void close_Test_Session() {
		test.closeBrowserSession();
	}
}
