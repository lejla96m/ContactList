package com.contactlist.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final static String homePageURL = "https://thinking-tester-contact-list.herokuapp.com/contactList";
    private final static String EXPECTED_PAGE_TITLE = "Contact List";
    private final static By ADD_CONTACT_BTN = By.id("add-contact");
    private final static By LOGOUT_BTN = By.id("logout");
    private final static By CONTACT_TABLE = By.id("myTable");



    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void validateHomePage () {

        wait.until(ExpectedConditions.presenceOfElementLocated(CONTACT_TABLE));

        final String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, homePageURL, "Validate the Sign Up page URL");

      //  final String actualHomePageTitle = driver.getTitle();
     //   Assert.assertEquals(actualHomePageTitle, EXPECTED_PAGE_TITLE, "Validate the page title");

        final boolean isAddContactBtnDisplayed = driver.findElement(ADD_CONTACT_BTN).isDisplayed();
        Assert.assertTrue(isAddContactBtnDisplayed);

        final boolean isContactTableDisplayed = driver.findElement(CONTACT_TABLE).isDisplayed();
        Assert.assertTrue(isContactTableDisplayed);
    }

    public void logout () {

        driver.get(homePageURL);

        wait.until(ExpectedConditions.presenceOfElementLocated(LOGOUT_BTN));

        final boolean isLogoutBtnDisplayed = driver.findElement(LOGOUT_BTN).isDisplayed();
        Assert.assertTrue(isLogoutBtnDisplayed);

        driver.findElement(LOGOUT_BTN).click();

    }
}
