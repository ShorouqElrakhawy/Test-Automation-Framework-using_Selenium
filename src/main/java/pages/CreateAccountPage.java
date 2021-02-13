package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage extends PageBase {
	private By male = By.id("gender-male");
	private By female = By.id("gender-female");
	private By firstName = By.id("FirstName");
	private By lastName = By.id("LastName");
	private By day = By.xpath("//*[@name='DateOfBirthDay']");
	private By month = By.xpath("//*[@name='DateOfBirthMonth']");
	private By year = By.xpath("//*[@name='DateOfBirthYear']");
	private By email = By.id("Email");
	private By form = By.className("form-fields");
	private By password = By.id("Password");
	private By confirmPassword = By.id("ConfirmPassword");
	private By registerBtn = By.id("register-button");
	public By emailErrorMessage = By.id("Email-error");
	private By confirmPassErrorMessage = By.id("ConfirmPassword-error");

	public CreateAccountPage(WebDriver driver) {
		super(driver);
	}

	private void selectGender(String gender) {
		switch (gender) {
		case "Male":
			click(male);
			break;

		case "Female":
			click(female);
			break;
		}
	}

	public String getConfirmPassErrorMessage() {
		return getText(confirmPassErrorMessage);
	}

	public String getEmailErrorMessage() {
		return getText(emailErrorMessage);
	}

	public String getPasswordInputValue() {
		return getText(password);
	}

	public void EnterEmail(String email) {
		setText(this.email, email);
	}

	public void clickRegisterBtn() {
		submit(registerBtn);
	}

	public void clickForm() {
		click(form);
	}

	public void register(ArrayList<String> list) {
		selectGender(list.get(0));
		setText(firstName, list.get(1));
		setText(lastName, list.get(2));
		selectByValue(day, list.get(3));
		selectByValue(month, list.get(4));
		selectByValue(year, list.get(5));
		setText(email, list.get(6));
		setText(password, list.get(7));
		setText(confirmPassword, list.get(8));
		clickRegisterBtn();
	}

}
