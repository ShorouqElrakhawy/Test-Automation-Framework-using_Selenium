package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

    @FindBy(className = "login")
    WebElement loginBtn;

    public HomePage(WebDriver driver) {
	super(driver);
    }

    public void clickLoginButton(WebDriver driver) {
	click(loginBtn);
    }

}
