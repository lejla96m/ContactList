package com.contactlist.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final static String EXPECTED_PAGE_TITLE = "Contact List App";
    private final static By PASSWORD_FIELD = By.id("password");
    private final static String EXPECTED_ERROR_MESSAGE = "Incorrect username or password";
    private final static By LOGIN_BTN = By.id("submit");
    private final static By EMAIL_FIELD = By.id("email");
    private final static By SIGNUP_BTN = By.id("signup");
    private final static By ERROR_MSG = By.id("error");


    public LoginPage(final WebDriver webDriver) {
        this.driver = webDriver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    public void validateLoginPageContent() {
        final String actualPageTitle = driver.getTitle();

        Assert.assertEquals(actualPageTitle, EXPECTED_PAGE_TITLE, "Validate the page title");

        final boolean isEmailFieldDisplayed = driver.findElement(EMAIL_FIELD).isDisplayed();
        Assert.assertTrue(isEmailFieldDisplayed);

        final boolean isPasswordFieldDisplayed = driver.findElement(PASSWORD_FIELD).isDisplayed();
        Assert.assertTrue(isPasswordFieldDisplayed);
    }

    public void validateLoginPageErrorMessage () {
        wait.until(ExpectedConditions.presenceOfElementLocated(ERROR_MSG));

        final boolean isInvalidCredentialsMessageDisplayed = driver.findElement(ERROR_MSG).isDisplayed();
        Assert.assertTrue(isInvalidCredentialsMessageDisplayed);

        final String actualMessage = driver.findElement(ERROR_MSG).getText();
        Assert.assertEquals(actualMessage, EXPECTED_ERROR_MESSAGE, "Validate the error message when invalid credentials are provided");
    }

    public void validateAndClickLoginBtn() {

        final boolean isLoginBtnDisplayed = driver.findElement(LOGIN_BTN).isDisplayed();
        Assert.assertTrue(isLoginBtnDisplayed);

        driver.findElement(LOGIN_BTN).click();

    }

    public void enterCredentials(final String email, final String password) {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));

        driver.findElement(EMAIL_FIELD).sendKeys(email);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    public void validateAndClickSignUpBtn() {
        final boolean isSignupBtnDisplayed = driver.findElement(SIGNUP_BTN).isDisplayed();
        Assert.assertTrue(isSignupBtnDisplayed);

        driver.findElement(SIGNUP_BTN).click();
    }
}
