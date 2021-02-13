package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {

	private By registerBtn = By.className("ico-register");
	public By logoutBtn = By.className("ico-logout");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void clickRegisterButton() {
		click(registerBtn);
	}
	
	public void ClickLogoutButton() {
		click(logoutBtn);
	}

}
