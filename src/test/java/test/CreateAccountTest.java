package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelReader;

/**
 * 
 * @author Shorouq Elrakhawy
 *
 */

@Epic("GUI Register -> CreateAccountTest")
public class CreateAccountTest extends TestBase {
    private HomePage homePage;
    private LoginPage loginPage;
    private CreateAccountPage regPage;
    Faker fakeData = new Faker();
    String titleInput, firstNameInput, lastNameInput, emailInput, passwordInput, monthInput, yearInput, firstName1Input,
	    lastName1Input, addressInput, cityInput, stateInput, aliasInput, dayInput, zipCode, mobileInput;

    @Test(description = "TC1 - Verify using invalid email format won't navigate to 'Create Account' page", dataProvider = "dataOfTC1", priority = 1)
    @Description("When I enter invalid email formats, Then I can't navigate to 'Create Account' page, And error message is displayed")
    @Severity(SeverityLevel.NORMAL)
    public void verifyRegisteration_usingInvalidEmailFormat_fails(String email, String expectedError) {
	homePage.clickLoginButton(driver);
	loginPage.enterEmailAndClickCreateAccountBtn(driver,email);
	assertEquals(loginPage.getErrorMessage(driver), expectedError);
    }

    @Test(description = "TC2 - Verify using valid email navigates to 'Create Account' page", dataProvider = "dataOfTC2", priority = 2)
    @Description("When I enter valid email, Then page navigates to 'Create Account' page")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyRegisteration_usingValidEmail_naviagtesToRegisterationPage(String expectedLink) {
	homePage.clickLoginButton(driver);
	loginPage.enterEmailAndClickCreateAccountBtn(driver,fakeData.internet().emailAddress());
	WebDriverWait wait = new WebDriverWait(driver, 100);
	ExpectedCondition<Boolean> urlIsCorrect = arg0 -> driver.getCurrentUrl().contains(expectedLink);
	assertTrue(wait.until(urlIsCorrect));
    }

    @Test(description = "TC3 - Verify Registeration is successful when using valid data", dependsOnMethods = {
	    "verifyRegisteration_usingValidEmail_naviagtesToRegisterationPage" }, dataProvider = "dataOfTC3")
    @Description("When I enter valid data, Then I will register successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyRegisteration_isSuccessful(String expectedMessage) {
	regPage.register(list());
	//I will make this method fail
	assertEquals(regPage.getSuccessMsg(),expectedMessage);
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

    private ArrayList<String> list() {
	initializeDymmyData();
	ArrayList<String> list = new ArrayList<String>();
	list.add(titleInput);
	list.add(firstNameInput);
	list.add(lastNameInput);
	list.add(passwordInput);
	list.add(dayInput);
	list.add(monthInput);
	list.add(yearInput);
	list.add(firstName1Input);
	list.add(lastName1Input);
	list.add(addressInput);
	list.add(cityInput);
	list.add(stateInput);
	list.add(zipCode);
	list.add(mobileInput);
	list.add(aliasInput);
	return list;

    }

    private void initializeDymmyData() {
	titleInput = "Mrs";
	firstNameInput = fakeData.name().firstName();
	lastNameInput = fakeData.name().lastName();
	passwordInput = fakeData.internet().password(5, 10);
	dayInput = Integer.toString(fakeData.number().numberBetween(1, 31));
	monthInput = Integer.toString(fakeData.number().numberBetween(1, 12));
	yearInput = Integer.toString(fakeData.number().numberBetween(1900, 2020));
	firstName1Input = fakeData.name().firstName();
	lastName1Input = fakeData.name().lastName();
	addressInput = fakeData.address().streetAddress();
	cityInput = fakeData.address().city();
	stateInput = Integer.toString(fakeData.number().numberBetween(1, 50));
	zipCode = fakeData.number().digits(5);
	mobileInput = fakeData.phoneNumber().cellPhone();
	aliasInput = fakeData.internet().emailAddress();
    }

    @BeforeClass
    public void beforeClass() {
	homePage = new HomePage(driver);
	loginPage = new LoginPage(driver);
	regPage = new CreateAccountPage(driver);
    }

}
