package com.qa.pageobject.tests;

import com.qa.pageobject.base.BaseTest;
import com.qa.pageobject.pages.HomePage;
import com.qa.pageobject.pages.LoginPage;
import com.qa.pageobject.pages.MyAccountPage;
import org.junit.Test;

public class OpenSite extends BaseTest {
    @Test
    public void openLoginPage() {
        HomePage homePage = openSite();
        LoginPage loginPage = homePage.clickSignin();
        loginPage.setMail();
        loginPage.setPassword();
        MyAccountPage accountPage = loginPage.clickSignInButton();
        accountPage.validateUserName();
        accountPage.openDresses();
        accountPage.checkBreadcrumpPresense();
        homePage = accountPage.logOut();

        closeSite();
    }
}
