package com.qa.pageobject.tests;

import com.qa.pageobject.base.BaseTest;
import org.junit.Test;
import com.qa.pageobject.pages.HomePage;
import com.qa.pageobject.pages.LoginPage;
import com.qa.pageobject.pages.MyAccountPage;

public class Tests extends BaseTest {
    @Test
    public void openLoginPage() {
        HomePage homePage = openSite();
        LoginPage loginPage = homePage.clickSignin();
        loginPage.setMail();
        loginPage.setPassword();
        MyAccountPage accountPage = loginPage.clickSignInButton();
        accountPage.validateUserName();
        homePage = accountPage.logOut();


        closeSite();
    }
}
