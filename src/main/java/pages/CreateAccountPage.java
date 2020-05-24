package pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends PageBase {

    @FindBy(id = "id_gender1")
    WebElement mrTitle;

    @FindBy(id = "id_gender2")
    WebElement mrsTitle;

    @FindBy(id = "customer_firstname")
    WebElement firstName;

    @FindBy(id = "customer_lastname")
    WebElement lastName;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "days")
    WebElement days;

    @FindBy(id = "months")
    WebElement months;

    @FindBy(id = "years")
    WebElement years;

    @FindBy(id = "firstname")
    WebElement firstName1;

    @FindBy(id = "lastname")
    WebElement lastName1;

    @FindBy(id = "address1")
    WebElement address;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "id_state")
    WebElement state;

    @FindBy(id = "postcode")
    WebElement postcode;

    @FindBy(id = "phone_mobile")
    WebElement mobile;

    @FindBy(id = "alias")
    WebElement alias;

    @FindBy(id = "submitAccount")
    WebElement registerBtn;
    
    @FindBy(className = "info-account")
    WebElement successfulMsg;

    public CreateAccountPage(WebDriver driver) {
	super(driver);
    }

    private void selectTitle(String title) {
	switch (title) {
	case "Mr":
	    click(mrTitle);
	    break;

	case "Mrs":
	    click(mrsTitle);
	    break;
	}
    }

    public String getSuccessMsg() {
	return getText(successfulMsg);
    }
    
    public void register(ArrayList<String> list) {
	selectTitle(list.get(0));
	setText(firstName, list.get(1));
	setText(lastName, list.get(2));
	setText(password, list.get(3));
	selectByValue(days, list.get(4));
	selectByValue(months, list.get(5));
	selectByValue(years, list.get(6));
	setText(firstName1, list.get(7));
	setText(lastName1, list.get(8));
	setText(address, list.get(9));
	setText(city, list.get(10));
	selectByValue(state, list.get(11));
	setText(postcode, list.get(12));
	setText(mobile, list.get(13));
	setText(alias, list.get(14));
	click(registerBtn);
    }

}
