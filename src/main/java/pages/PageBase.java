package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
    protected static WebDriver driver;

    public PageBase(WebDriver driver) {
	PageFactory.initElements(driver, this);
    }

    public static String getAttributeValue(WebElement elem, String attrName) {
	return elem.getAttribute(attrName);
    }

    public void navigate(String url) {
	driver.navigate().to(url);
    }

    public void keyboard_clickEnterKey(WebElement elem) {
	elem.sendKeys(Keys.ENTER);
    }

    public static void click(WebElement elem) {
	elem.click();

    }

    public static void submit(WebElement elem) {
	elem.submit();
    }

    public String getText(WebElement elem) {
	return elem.getText();
    }

    public void setText(WebElement elem, String value) {
	elem.clear();
	elem.sendKeys(value);
    }

    public void selectByValue(WebElement elem, String value) {
	Select selem = new Select(elem);
	selem.selectByValue(value);
    }

}
