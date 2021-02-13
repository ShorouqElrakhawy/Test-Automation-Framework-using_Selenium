package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	protected static WebDriver driver;

	public PageBase(WebDriver driver) {
		PageBase.driver = driver;
	}

	public static String getAttributeValue(By by, String attrName) {
		return locateElement(by).getAttribute(attrName);
	}

	public void navigate(String url) {
		driver.navigate().to(url);
	}

	public void keyboard_clickEnterKey(By by) {
		locateElement(by).sendKeys(Keys.ENTER);
	}

	public static void click(By by) {
		locateElement(by).click();
	}

	public static void submit(By by) {
		locateElement(by).submit();
	}

	public String getText(By by) {
		return locateElement(by).getText();
	}

	public void setText(By by, String value) {
		WebElement element = locateElement(by);
		element.clear();
		element.sendKeys(value);
	}

	public void selectByValue(By by, String value) {
		Select selem = new Select(locateElement(by));
		selem.selectByValue(value);
	}

	public static WebElement locateElement(By by) {
//		waitUntilElementIsDisplayed(by);
		WebElement element = driver.findElement(by);
//		scrollToElement(element, driver, by);
		return element;
	}

	public static void timeOut(int sec, WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	public static boolean checkElementIsPresent(By by) {
		return driver.findElements(by).size() > 0;
	}

	public static boolean checkElementIsDisplayed(By by) {
		boolean flag = false;
		if (locateElement(by).isDisplayed()) {
			flag = true;
			System.out.println("Element" + by + " is displayed");
		} else
			System.out.println("Element" + by + " is not displayed");

		return flag;
	}

	public static void waitUntilElementIsDisplayed(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static void scrollToElement(WebElement element, WebDriver driver, By by) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
