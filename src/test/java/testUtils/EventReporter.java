package testUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.qameta.allure.Allure.step;

import test.TestBase;

public class EventReporter implements WebDriverEventListener {
	private TestBase testBaseObject = new TestBase();

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		step(getBrowserName() + ": Accepting Alert");
	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		step(getBrowserName() + ": Alert is accepted");
	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		step(getBrowserName() + ": Dismissing Alert");
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		step(getBrowserName() + ": Alert is dismissed");
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		step(getBrowserName() + ": Navigating to: " + url);
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		step(getBrowserName() + ": You are now navigated to " + url);
	}

	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		step(getBrowserName() + ": Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		step(getBrowserName() + ": Navigated back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		step(getBrowserName() + ": Navigating forward to next page");
	}

	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		step(getBrowserName() + ": Navigated forward to next page");
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		step(getBrowserName() + ": Refreshing the page");
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		step(getBrowserName() + ": You did refresh the page");
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		step(getBrowserName() + ": Trying to find" + by);
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		step(getBrowserName() + ": " + by + " is found");
		wait(driver,element);
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		step(getBrowserName() + ": Clicking on [" + element.toString() + "]");
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		step(getBrowserName() + ": Clicking" + element.toString() + "is successful");
		wait(driver,element);
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		step(getBrowserName() + ": Value of the:" + element.toString() + " before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		step(getBrowserName() + ": Element value changed to: " + element.toString());
	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub
		step(getBrowserName() + ": Exception occured: " + throwable);
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub

	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub

	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		step(getBrowserName() + ": Getting text of [" + element.toString() + "]");
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub

	}

	private String getBrowserName() {
		return testBaseObject.getBrowserName();
	}

	private void wait(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try {
			wait.until(listenerDriver -> element);
		} catch (org.openqa.selenium.TimeoutException e) {
		}
	}

}
