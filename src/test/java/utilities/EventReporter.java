package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import test.TestBase;

public class EventReporter implements WebDriverEventListener {
    private TestBase testBaseObject = new TestBase();

    @Override
    public void beforeAlertAccept(WebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println(getBrowserName()+": Accepting Alert");
    }

    @Override
    public void afterAlertAccept(WebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println(getBrowserName()+": Alert is accepted");
    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println(getBrowserName()+": Dismissing Alert");
    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println(getBrowserName()+": Alert is dismissed");
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println(getBrowserName()+": Navigating to: " + url);
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println(getBrowserName()+": You are now navigated to " + url);
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println(getBrowserName()+": Navigating back to previous page");
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println(getBrowserName()+": Navigated back to previous page");
    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println(getBrowserName()+": Navigating forward to next page");
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println(getBrowserName()+": Navigated forward to next page");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println(getBrowserName()+": Refreshing the page");
    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println(getBrowserName()+": You did refresh the page");
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println(getBrowserName()+": Trying to find" + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println(getBrowserName()+": "+by + " is found");
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println(getBrowserName()+": Clicking on [" + element.toString() + "]");
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println(getBrowserName()+": Clicking" + element.toString() + "is successful");
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
	// TODO Auto-generated method stub
	System.out.println(getBrowserName()+": Value of the:" + element.toString() + " before any changes made");
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
	// TODO Auto-generated method stub
	System.out.println(getBrowserName()+": Element value changed to: " + element.toString());
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {
	// TODO Auto-generated method stub

    }

    @Override
    public void afterScript(String script, WebDriver driver) {
	// TODO Auto-generated method stub

    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
	// TODO Auto-generated method stub

    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {
	// TODO Auto-generated method stub

    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println(getBrowserName()+": Exception occured: " + throwable);
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
	// TODO Auto-generated method stub

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
	// TODO Auto-generated method stub

    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
	// TODO Auto-generated method stub
	System.out.println(getBrowserName()+": Getting text of [" + element.toString() + "]");
    }
    
    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
	// TODO Auto-generated method stub

    }

    public String getBrowserName() {
	return testBaseObject.getBrowserName();
    }
}
