package com.qa.pageobject.pages;

import com.qa.pageobject.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    private final String enterEmail = "koris69399@mailt.top";
    private final String enterPassword = "qwerty";

    @FindBy(xpath = "//form[@id='login_form']//input[@data-validate='isEmail']")
    WebElement mail;

    @FindBy(xpath = "//form[@id='login_form']//input[@id='passwd']")
    WebElement password;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    WebElement signIn_button;

    /**
     * LoginPage Constructor
     *
     * @param basetest
     */
    public LoginPage(BaseTest basetest) {
        super(basetest);
        basetest.waitElementVisibility(mail);
        basetest.waitElementVisibility(password);
    }

    /** set Email */
    public void setMail() {
        mail.sendKeys(enterEmail);
    }

    /** Set password */
    public void setPassword() {
        password.sendKeys(enterPassword);
    }

    /**
     * Sign in to MyAccountPage
     *
     * @return MyAccountPage
     */
    public MyAccountPage clickSignInButton() {
        basetest.waitElementVisibility(signIn_button);
        signIn_button.click();
        return new MyAccountPage(basetest);
    }
}
