package com.contactlist.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AddContactPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final static String EXPECTED_PAGE_TITLE = "Add Contact";
    private final static String addContactPageURL = "https://thinking-tester-contact-list.herokuapp.com/addContact";
    private final static By CONTACT_FIRST_NAME = By.id("firstName");
    private final static By CONTACT_LAST_NAME = By.id("lastName");
    private final static By ADD_CONTACT = By.id("add-contact");

    public AddContactPage (final WebDriver webDriver) {
        this.driver = webDriver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void addNewContact (String firstName, String lastName) {

        wait.until(ExpectedConditions.presenceOfElementLocated(ADD_CONTACT));

        driver.findElement(ADD_CONTACT).click();

        validateAddContactPage();

        driver.findElement(CONTACT_FIRST_NAME).sendKeys(firstName);
        driver.findElement(CONTACT_LAST_NAME).sendKeys(lastName);

        driver.findElement(By.id("submit")).click();

    }

    private void validateAddContactPage () {

        wait.until(ExpectedConditions.presenceOfElementLocated(CONTACT_FIRST_NAME));

        final String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,addContactPageURL, "Validate the Sign Up page URL");

        final String actualSignupPageTitle = driver.getTitle();
        Assert.assertEquals(actualSignupPageTitle, EXPECTED_PAGE_TITLE, "Validate the page title");

    }

}
