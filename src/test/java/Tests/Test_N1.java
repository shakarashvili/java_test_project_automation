package Tests;

import Data.DataBase;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.qameta.allure.Description;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "RegistrationStep",
        plugin = {"pretty","html:target/cucumber-report.html"},
        monochrome = true
)

public class Test_N1 {

    WebDriver driver;
    WebDriverWait wait;
    DataBase database;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();  // or use WebDriverManager if available
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        database = new DataBase(driver);  // Pass driver to Page Object
    }

    @Test(priority = 1 )
    @Description("Test Case 1: Register User")
    public void registerUser() throws InterruptedException {
        database.openWebsite();

        Assert.assertTrue(database.homeLogo.isDisplayed(), "Home logo is not visible");

        database.clickSignupLogin();

        Assert.assertTrue(database.isSignupHeaderVisible(), "Signup header not visible");

        database.fillSignupForm("Geroge95", "Shakara25@gmail.com");
        database.enterAccountInfoRegistration("George","123123","George",
                "Shakarasvili", "Liberty","Chavchavadze N37","stage 6",
                "baltimor","Tbilisi","0193","+995571090909");
        //database.DeleteAccount();
    }

    @Test(priority =  2 )
    @Description("Login User with correct email and password")
    public void LoginUserwithcorrectemailandpassword() throws InterruptedException {

        database.openWebsite();
        Assert.assertTrue(database.homeLogo.isDisplayed(), "Home logo is not visible");
        Thread.sleep(2000);
        database.clickSignupLogin();
        Assert.assertTrue(database.isLoginHeaderVisible(), "Login header is not visible");
        database.fillLoginForm("Shakara25@gmail.com", "123123");
        database.UserisloggedVisible();
        database.DeleteAccount();

    }
    @Test(priority =  3 )
    @Description("Login User with incorrect email and password")
    public void LoginUserwithINcorrectemailandpassword() throws InterruptedException {
        database.openWebsite();
        Assert.assertTrue(database.homeLogo.isDisplayed(), "Home logo is not visible");
        database.clickSignupLogin();
        Assert.assertTrue(database.isLoginHeaderVisible(), "Login header is not visible");
        database.fillLoginForm("devidson28@gmail.com","1234512345");
        database.LogingerrorMessageisvisible();
    }

    @Test(priority =  4 )
    @Description("Logout User")
    public void LogoutUser() throws InterruptedException {

        database.openWebsite();
        Assert.assertTrue(database.homeLogo.isDisplayed(), "Home logo is not visible");
        Thread.sleep(2000);
        database.clickSignupLogin();
        Assert.assertTrue(database.isLoginHeaderVisible(), "Login header is not visible");
        database.fillLoginForm("david20@gmail.com", "123123");
        database.UserisloggedVisible();
        database.logout();
        database.signupLoginLink_Visible();
        database.handleAlert();
        Thread.sleep(2000);




    }
    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
