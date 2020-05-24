package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

    @FindBy(id = "SubmitCreate")
    WebElement createAccountBtn;

    @FindBy(id = "email_create")
    WebElement emailCreateField;

    @FindBy(xpath = "//*[@id=\"create_account_error\"]/descendant::ol/li")
    WebElement emailErrorMessage;

    public LoginPage(WebDriver driver) {
	super(driver);
    }

    public void enterEmailAndClickCreateAccountBtn(WebDriver driver,String email) {
	setText(emailCreateField, email);
	click(createAccountBtn);
    }

    public String getErrorMessage(WebDriver driver) {
	return getText(emailErrorMessage);
    }

    
}
