package com.contactlist.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SignUpPage {

    private final static String signupPageURL = "https://thinking-tester-contact-list.herokuapp.com/addUser";
    private final static String EXPECTED_PAGE_TITLE = "Add User";
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final static By SUBMIT_BTN = By.id("submit");
    private final static By EMAIL_FIELD = By.id("email");
    private final static By PASSWORD_FIELD = By.id("password");
    private final static By FIRST_NAME_FIELD = By.id("firstName");
    private final static By LAST_NAME_FIELD = By.id("lastName");


    public SignUpPage(final WebDriver webDriver) {
        this.driver = webDriver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void validateSignupPage () {

        wait.until(ExpectedConditions.presenceOfElementLocated(FIRST_NAME_FIELD));

        final String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,signupPageURL, "Validate the Sign Up page URL");

        final String actualSignupPageTitle = driver.getTitle();
        Assert.assertEquals(actualSignupPageTitle, EXPECTED_PAGE_TITLE, "Validate the page title");

        final boolean isFirstNameFieldDisplayed = driver.findElement(FIRST_NAME_FIELD).isDisplayed();
        Assert.assertTrue(isFirstNameFieldDisplayed);

        final boolean isLastNameFieldDisplayed = driver.findElement(LAST_NAME_FIELD).isDisplayed();
        Assert.assertTrue(isLastNameFieldDisplayed);

        final boolean isEmailFieldDisplayed = driver.findElement(EMAIL_FIELD).isDisplayed();
        Assert.assertTrue(isEmailFieldDisplayed);

        final boolean isPasswordFieldDisplayed = driver.findElement(PASSWORD_FIELD).isDisplayed();
        Assert.assertTrue(isPasswordFieldDisplayed);

        final boolean isPSubmitBtnDisplayed = driver.findElement(SUBMIT_BTN).isDisplayed();
        Assert.assertTrue(isPSubmitBtnDisplayed);

    }

    public void createUser (final String firstName, final String lastName, final String email, final String password) {

        driver.findElement(FIRST_NAME_FIELD).sendKeys(firstName);
        driver.findElement(LAST_NAME_FIELD).sendKeys(lastName);
        driver.findElement(EMAIL_FIELD).sendKeys(email);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);

        driver.findElement(SUBMIT_BTN).click();
    }
}
