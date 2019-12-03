package com.qa.pageobject.pages;

import com.qa.pageobject.base.BaseTest;

public class HomePage extends AbstractPage {
    /**
     * HomePage constructor
     *
     * @param basetest
     */
    public HomePage(BaseTest basetest) {
        super(basetest);
        basetest.waitElementVisibility(signinBtn);
    }
}
