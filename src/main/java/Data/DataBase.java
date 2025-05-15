package Data;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;

public class DataBase {

 WebDriver driver;

 WebDriverWait wait;

 public DataBase(WebDriver driver) {
  this.driver = driver;
  wait = new WebDriverWait(driver, Duration.ofSeconds(10));

  PageFactory.initElements(driver, this);
 }

 @FindBy(xpath = "//img[@alt='Website for automation practice']")
 public WebElement homeLogo;

 @FindBy(xpath = "//a[@href='/login']")
 public WebElement signupLoginLink;
//     //a[@href='/login' and contains(., 'Signup / Login')]
 @FindBy(xpath = "//h2[text()='New User Signup!']")
 public WebElement newUserSignupHeader;

 @FindBy(xpath = "//h2[text()='Login to your account']")
 public WebElement UserLoginupHeader;

 @FindBy(xpath = "//input[@data-qa='signup-name']")
 public WebElement signupNameInput;

 @FindBy(css = "input[data-qa='signup-email']")
 public WebElement signupEmailInput;

 @FindBy(css = "input[data-qa='login-email']")
 public WebElement LoginEmailInput;

 @FindBy(css = "button[data-qa='signup-button']")
 public WebElement signupButton;

 @FindBy(css = "button[data-qa='login-button']")
 public WebElement loginButton;
 @FindBy(xpath = "//b[text()='Enter Account Information']")
 public WebElement enterAccountInfoText;

 @FindBy(id = "id_gender1")
 WebElement radioMr;
 @FindBy(id = "name")
 WebElement nameInput;

 @FindBy(css = "input[data-qa='email']")
 WebElement emailInput;

 @FindBy( css = "input[type='Password']")
 WebElement LoginPassword;

 @FindBy(name = "password")
 WebElement passwordInput;

 @FindBy(css = "select[data-qa='days']")
 public WebElement daysDropdown;

 @FindBy(css = "select[data-qa='months']")
 public WebElement monthsDropdown;
 @FindBy(id = "years")
 public WebElement yearDropdown;

 @FindBy(id = "newsletter")
 WebElement newsletterCheckbox;

 @FindBy(id = "optin")
 WebElement optInCheckbox;

 @FindBy(css = "input[data-qa='first_name']")
 WebElement firstNameInput;

 @FindBy(id = "last_name")
 WebElement lastNameInput;

 @FindBy(id = "company")
 WebElement companyInput;


 @FindBy(css = "input[data-qa='address'][name='address1'][id='address1']")
 WebElement addressInput;

 @FindBy(css = "input[data-qa='address2']")
 WebElement address2Input;

 @FindBy(id = "country")
 WebElement countryDropDown;

 @FindBy(css = "input[data-qa='state'][name='state']")
 WebElement stateInput;

 @FindBy(id = "city")
 WebElement cityInput;

 @FindBy(xpath = "//input[@data-qa='zipcode']")
 WebElement zipcodeInputField;

 @FindBy(xpath = "//input[@data-qa='mobile_number']")
 WebElement mobileNumberInput;

 @FindBy(xpath = "//button[@type='submit' and @data-qa='create-account']")
 WebElement createAccountButton;

 @FindBy(xpath = "//b[normalize-space()='Account Created!']")
 WebElement accountCreatedMessage;

 @FindBy(css = "a.btn.btn-primary[data-qa='continue-button']")
 public WebElement continueButton;

 @FindBy(xpath = "//a[contains(., 'Logged in as')]")
 public WebElement loggedInUser;

 @FindBy(xpath = "//a[@href='/delete_account']")
 public WebElement deleteAccountLink;

 @FindBy(xpath = "//b[text()='Account Deleted!']")
 public WebElement accountDeletedMessage;

 @FindBy(css = "a[data-qa='continue-button']")
 public WebElement deletecontinueButton;

 @FindBy(xpath = "//a[contains(., 'Logged')]")
 public WebElement loggedUserVisible;
 @Given("Open Main page")
 public void openWebsite() {
  driver.get("https://www.automationexercise.com/");
 }

 public void clickSignupLogin() {
  signupLoginLink.click();
 }

 public boolean isSignupHeaderVisible() {
  return newUserSignupHeader.isDisplayed();
 }

 public boolean isLoginHeaderVisible() {
  return UserLoginupHeader.isDisplayed();
 }

 public void UserisloggedVisible(){ loggedUserVisible.isDisplayed(); }

 @Step
 @Description("sing up process for new user ")
 public void fillSignupForm(String name, String email) {
  signupNameInput.sendKeys(name);
  signupEmailInput.sendKeys(email);
  signupButton.click();
 }


 @Step
 @Description("login process for user ")
 public void fillLoginForm(String Login_email, String Login_password){
  LoginEmailInput.sendKeys(Login_email);
  LoginPassword.sendKeys(Login_password);
  loginButton.click();

 }
 public void scrollByPixels(int x, int y) {
  JavascriptExecutor js = (JavascriptExecutor) driver;
  js.executeScript("window.scrollBy(" + x + "," + y + ");");  // Scrolls by pixels (x, y)
 }

 public void mainpageVisible(){
  enterAccountInfoText.isDisplayed();
 }
 @When("here new user make registration ")
@Step("here new user make registration")
 public void enterAccountInfoRegistration(String name, String Password,String firstName,
  String lastName,String company,String address,String address2,String state,
  String city,String zipcode,String mobileNumber) throws InterruptedException {
  wait.until(ExpectedConditions.visibilityOf(enterAccountInfoText));
  enterAccountInfoText.isDisplayed();
  radioMr.click();
  nameInput.clear();
  nameInput.sendKeys(name);
  //Thread.sleep(3000);
  //emailInput.clear();
  //emailInput.sendKeys(EMAIL);
 //Thread.sleep(3000);
  passwordInput.sendKeys(Password);
 scrollByPixels(500,500);
 //Thread.sleep(3000);

 Select daySelect = new Select(daysDropdown);
 daySelect.selectByValue("25");

 Select monthSelect = new Select(monthsDropdown);
 monthSelect.selectByVisibleText("June");

 Select yearSelect = new Select(yearDropdown);
 yearSelect.selectByVisibleText("1995");
 //Thread.sleep(3000);

 newsletterCheckbox.click();
 newsletterCheckbox.isSelected();
 optInCheckbox.click();
 optInCheckbox.isSelected();
 // Thread.sleep(3000);

 firstNameInput.sendKeys(firstName);
 lastNameInput.sendKeys(lastName);
 companyInput.sendKeys(company);
 addressInput.sendKeys(address);
 address2Input.sendKeys(address2);
 //Thread.sleep(3000);
 Select CountrySelect = new Select(countryDropDown);
 CountrySelect.selectByVisibleText("Canada");

 stateInput.sendKeys(state);
 cityInput.sendKeys(city);
 zipcodeInputField.sendKeys(zipcode);
 mobileNumberInput.sendKeys(mobileNumber);
 createAccountButton.click();

 accountCreatedMessage.isDisplayed();
 continueButton.click();
 loggedInUser.isDisplayed();
 }


 @Then("than we need to delete account")
 @Step("than we need to delete account")
 public void DeleteAccount(){
  deleteAccountLink.click();
  accountDeletedMessage.isDisplayed();
  deletecontinueButton.click();


 }
}
