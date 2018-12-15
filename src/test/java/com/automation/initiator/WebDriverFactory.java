package com.automation.initiator;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {

    private static String browser;
    String seleniumServer;
    public WebDriver getDriver(Map<String, String> seleniumconfig) {
    	seleniumServer = seleniumconfig.get("seleniumserver");

		browser = seleniumconfig.get("browser");

			if (browser.equalsIgnoreCase("firefox")) {
				if (System.getProperty("os.name").equals("Linux")) {
					return getChromeDriver(seleniumconfig.get("driverpath") + "geckodriver");
				} else if (System.getProperty("os.name").contains("Windows")) {
					return getFirefoxDriver(seleniumconfig.get("driverpath") + "geckodriver.exe");
				}
				
			} else if (browser.equalsIgnoreCase("chrome")) {

				if (System.getProperty("os.name").equals("Linux")) {
					return getChromeDriver(seleniumconfig.get("driverpath") + "chromedriver");
				} else if (System.getProperty("os.name").contains("Windows")) {
					return getChromeDriver(seleniumconfig.get("driverpath") + "chromedriver.exe");
				}

			} else if (browser.equalsIgnoreCase("Safari")) {
				return getSafariDriver();
			} else if ((browser.equalsIgnoreCase("ie")) || (browser.equalsIgnoreCase("internetexplorer"))
					|| (browser.equalsIgnoreCase("internet explorer"))) {
				return getInternetExplorerDriver(seleniumconfig.get("driverpath") + "IEDriverServer.exe");
			}
		return new FirefoxDriver();
    }

    @SuppressWarnings("deprecation")
	private static WebDriver getChromeDriver(String driverpath) {
    	System.setProperty("webdriver.chrome.driver", driverpath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-notifications");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		return new ChromeDriver(cap);
    }

    private static WebDriver getInternetExplorerDriver(String driverpath) {
        System.setProperty("webdriver.ie.driver", driverpath);
        return new InternetExplorerDriver();
    }

    private static WebDriver getSafariDriver() {
        return new SafariDriver();
    }

    private static WebDriver getFirefoxDriver(String path) {
		System.setProperty("webdriver.gecko.driver", path);
		return new FirefoxDriver();
	}
}
