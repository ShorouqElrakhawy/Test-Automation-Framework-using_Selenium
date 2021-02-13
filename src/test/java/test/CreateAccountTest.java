package test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.RegisterMessagePage;
import utilities.ExcelReader;

/**
 * 
 * @author Shorouq Elrakhawy
 *
 */

@Epic("GUI Register -> CreateAccountTest")
public class CreateAccountTest extends TestBase {
	SoftAssert softAssert = new SoftAssert();
	Faker fakeData = new Faker();
	String gender, firstNameInput, lastNameInput, emailInput, passwordInput, passwordInput2, monthInput, yearInput,
			dayInput;

	@BeforeClass
	public void beforeClass() {
		driver.navigate().to("https://demo.nopcommerce.com/");
		new HomePage(driver).clickRegisterButton();
	}

	@Test(description = "TC1 - Verify registeration fails when entering invalid email format or leaving the field empty", dataProvider = "dataOfTC1", priority = 1)
	@Description("When I enter invalid email formats/ leaving the field empty, And click Register button, Then an error message is displayed")
	@Severity(SeverityLevel.NORMAL)
	public void verifyRegisteration_usingInvalidEmailFormat_fails(String email, String expectedError) {
		new CreateAccountPage(driver).EnterEmail(email);
		new CreateAccountPage(driver).clickForm();
		if (CreateAccountPage.checkElementIsPresent(new CreateAccountPage(driver).emailErrorMessage))
			assertEquals(new CreateAccountPage(driver).getEmailErrorMessage(), expectedError);
		else
			softAssert.assertTrue(false, "Error message is not displayed");
		softAssert.assertAll();
	}

	@Test(description = "TC2 - Verify enterning non matching password and confirm password", dataProvider = "dataOfTC2")
	@Description("When I enter a non matching password and confirm password, Then an error message is displayed")
	@Severity(SeverityLevel.CRITICAL)
	public void verifyRegisteration_usingNonMatchingPasswordAndConfirmPassword(String expectedError) {
		new CreateAccountPage(driver).register(invalidList());
		assertEquals(new CreateAccountPage(driver).getConfirmPassErrorMessage(), expectedError);
	}

	@Test(description = "TC3 - Verify Registeration is successful when using valid data", dataProvider = "dataOfTC3")
	@Description("When I enter valid data, Then I will register successfully")
	@Severity(SeverityLevel.CRITICAL)
	public void verifyRegisteration_isSuccessful(String expectedMessage) {
		new CreateAccountPage(driver).register(list());
		assertEquals(new RegisterMessagePage(driver).getSuccessMsg(), expectedMessage);
		new HomePage(driver).ClickLogoutButton();
		new HomePage(driver).clickRegisterButton();
	}

	@DataProvider(name = "dataOfTC1")
	public Object[][] dataOfTC1() throws IOException {
		ExcelReader read = new ExcelReader();
		return read.getExcelData("CreateAccountTest", "TC1");
	}

	@DataProvider(name = "dataOfTC2")
	public Object[][] dataOfTC2() throws IOException {
		ExcelReader read = new ExcelReader();
		return read.getExcelData("CreateAccountTest", "TC2");
	}

	@DataProvider(name = "dataOfTC3")
	public Object[][] dataOfTC3() throws IOException {
		ExcelReader read = new ExcelReader();
		return read.getExcelData("CreateAccountTest", "TC3");
	}

	private ArrayList<String> invalidList() {
		initializeDymmyData();
		ArrayList<String> list = new ArrayList<String>();
		list.add(gender);
		list.add(firstNameInput);
		list.add(lastNameInput);
		list.add(dayInput);
		list.add(monthInput);
		list.add(yearInput);
		list.add(emailInput);
		list.add(passwordInput);
		list.add(passwordInput2);
		return list;
	}

	private ArrayList<String> list() {
		initializeDymmyData();
		ArrayList<String> list = new ArrayList<String>();
		list.add(gender);
		list.add(firstNameInput);
		list.add(lastNameInput);
		list.add(dayInput);
		list.add(monthInput);
		list.add(yearInput);
		list.add(emailInput);
		list.add(passwordInput);
		list.add(passwordInput);
		return list;
	}

	private void initializeDymmyData() {
		gender = fakeData.demographic().sex();
		firstNameInput = fakeData.name().firstName();
		lastNameInput = fakeData.name().lastName();
		passwordInput = fakeData.internet().password(6, 10);
		passwordInput2 = fakeData.internet().password(6, 10);
		dayInput = Integer.toString(fakeData.number().numberBetween(1, 31));
		monthInput = Integer.toString(fakeData.number().numberBetween(1, 12));
		yearInput = Integer.toString(fakeData.number().numberBetween(1960, 2021));
		emailInput = fakeData.internet().emailAddress();
	}

}
