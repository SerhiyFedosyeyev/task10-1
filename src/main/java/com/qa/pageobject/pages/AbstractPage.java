package com.qa.pageobject.pages;

import com.qa.pageobject.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    protected BaseTest basetest;
    private final String USERNAME = "bob bob";

    @FindBy(xpath = "//a[@class='login']")
    WebElement signinBtn;

    @FindBy(xpath = "//a[@class='logout']")
    WebElement logOut;

    @FindBy(xpath = "//div[@class='header_user_info']//span")
    WebElement userName;

    /**
     * Abstract Page constructor Initialisation of elements
     *
     * @param basetest
     */
    public AbstractPage(BaseTest basetest) {
        this.basetest = basetest;
        PageFactory.initElements(basetest.getDriver(), this);
    }

    /**
     * Click on Sign In button
     *
     * @return LoginPage
     */
    public LoginPage clickSignin() {
        basetest.waitElementVisibility(signinBtn);
        signinBtn.click();
        return new LoginPage(basetest);
    }

    /**
     * Log Out from account
     *
     * @return HomePage
     */
    public HomePage logOut() {
        basetest.waitElementVisibility(logOut);
        logOut.click();
        basetest.waitElementVisibility(signinBtn);
        return new HomePage(basetest);
    }

    /** User name validation */
    public void validateUserName() {
        Assert.assertEquals("Different User names ", USERNAME, userName.getText());
    }
}
