package com.contactlist.ui.tests;


import com.contactlist.ui.pages.AddContactPage;
import com.contactlist.ui.pages.HomePage;
import com.contactlist.ui.pages.LoginPage;
import com.contactlist.ui.pages.SignUpPage;
import com.contactlist.utilities.WebDriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ContactListTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private SignUpPage signUpPage;
    private HomePage homePage;
    private AddContactPage addContactPage;

    @Parameters({"browser"})
    @BeforeTest

    public void setup(final String browser) {

        driver = WebDriverSetup.getWebDriver("edge");
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        driver.manage().window().maximize();

    }

    @Parameters({"firstName", "lastName","email", "password"})
    @Test (priority = 1)

    public void validateSignUp (final String firstName, final String lastName, final String email, final String password) {

        this.loginPage = new LoginPage(driver);
        this.signUpPage = new SignUpPage(driver);
        this.homePage = new HomePage(driver);

        loginPage.validateLoginPageContent();
        loginPage.validateAndClickSignUpBtn();
        signUpPage.validateSignupPage();
        signUpPage.createUser(firstName, lastName, email, password);

        homePage.logout();

    }

    @Test (priority = 2)

    public void tryToLoginWithInvalidCredentials () {

        String email = " ";
        String password = " ";

        loginPage.enterCredentials(email, password);
        loginPage.validateAndClickLoginBtn();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Still not appeared.");
        }

        loginPage.validateLoginPageErrorMessage();

    }

    @Parameters({"email", "password"})
    @Test (priority = 3, dependsOnMethods = "validateSignUp")

    public void validateLogin(final String email, final String password) {

        driver.navigate().refresh();

        loginPage.validateLoginPageContent();
        loginPage.enterCredentials(email, password);
        loginPage.validateAndClickLoginBtn();

       }

    @Parameters({"firstName", "lastName"})
    @Test (priority = 4, dependsOnMethods = "validateLogin")

    public void validateAddNewContact (final String firstName, final String lastName) {

        this.homePage = new HomePage(driver);
        this.addContactPage = new AddContactPage(driver);

        addContactPage.addNewContact(firstName, lastName);

        homePage.validateHomePage();

    }

    @AfterTest

        public void teardown() {

            this.homePage = new HomePage(driver);

            homePage.logout();
            driver.close();
        }

}

