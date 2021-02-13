package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterMessagePage extends PageBase {

	private By successfulMsg = By.className("result");

	public RegisterMessagePage(WebDriver driver) {
		super(driver);
	}

	public String getSuccessMsg() {
		return getText(successfulMsg);
	}

}
