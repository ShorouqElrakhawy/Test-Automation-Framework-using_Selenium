package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.Constants;
import utilities.EventReporter;
import utilities.Helper;

public class TestBase {
    public static EventFiringWebDriver driver;

    @BeforeTest
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName) {
	if (browserName.equalsIgnoreCase("chrome")) {
	    System.setProperty(Constants.chromePropertyName, Constants.ChromeDriverPath);
	    driver = new EventFiringWebDriver(new ChromeDriver());
	}
	if (browserName.equalsIgnoreCase("firefox")) {
	    System.setProperty(Constants.firefoxPropertyName, Constants.firefoxDriverPath);
	    driver = new EventFiringWebDriver(new FirefoxDriver());
	}
	if (browserName.equalsIgnoreCase("edge")) {
	    System.setProperty(Constants.microsoftedgePropertyName, Constants.microsoftedgeDriverPath);
	    driver = new EventFiringWebDriver(new EdgeDriver());
	}

	driver.register(new EventReporter());
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.navigate().to("http://automationpractice.com/");
	getBrowserName();
   }
    
    public String getBrowserName() {
	return driver.getCapabilities().getBrowserName().toUpperCase();
    }

    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
	if (result.getStatus() == ITestResult.FAILURE) {
	    Helper.screenshot(driver, result.getName());
	}
    }

    @AfterTest
    public void stopDriver() {
	driver.quit();
    }

}
