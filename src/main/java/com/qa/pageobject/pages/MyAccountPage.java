package com.qa.pageobject.pages;

import com.google.common.base.CharMatcher;
import com.qa.pageobject.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Set;

public class MyAccountPage extends AbstractPage {

    @FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//a[.='Dresses']/following::a[@title='Dresses']")
    WebElement navMenu_Dresses;

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li")
    WebElement navMenu_women;
    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li")
    WebElement navMenu_women_summerDresses;
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]//a[@title='Evening Dresses']")
    WebElement navMenu_women_EveningDresses;
    @FindBy(xpath = "//li[@class='last']/a[contains(.,'Summer Dresses')]")
    WebElement summer_Dresses;
    @FindBy(xpath = "//div[contains(@class,'breadcrumb')]")
    WebElement breadcrumb;
    @FindBy(xpath = "//div[contains(@class,'breadcrumb')]")
    List<WebElement> breadcrumb_elements;
    @FindBy(xpath = "//span[@class='heading-counter']")
    WebElement productQuant;
    @FindBy(xpath = "//div[@class='product-image-container']")
    List<WebElement> itemQuantity;
    @FindBy(xpath = "//div[@class='product-image-container']")
    List<WebElement> oneTshort;
    @FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[last()]/a")
    WebElement Tshirts;
    @FindBy(xpath = "//a[@class='button ajax_add_to_cart_button btn btn-default']/span")
    WebElement addToCart;
    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElement proceedToCheckoutButton;
    @FindBy(xpath = "//span[@id='total_price']")
    WebElement totalPrice;


    /**
     * MyAccountPage constructor
     *
     * @param basetest
     */
    public MyAccountPage(BaseTest basetest) {
        super(basetest);
    }

    public void openDresses() {
        basetest.waitElementVisibility(navMenu_Dresses);
        navMenu_Dresses.click();
    }

    public void openSummerdresses() {
        basetest.waitElementVisibility(summer_Dresses);
        summer_Dresses.click();
    }

    public void checkBreadcrumpPresense() {
        basetest.waitElementVisibility(breadcrumb);

//        if (breadcrumb_elements.size() == 0) {
//            System.out.println("Error! No elements in a Breadcrump ");
//        }
        Assert.assertTrue(breadcrumb_elements.size() > 0);
    }

    public void checkProductQuantity() {
        basetest.waitElementVisibility(productQuant);
        String productQuantString = productQuant.getText();
        String num = CharMatcher.DIGIT.retainFrom(productQuantString);
        Assert.assertEquals("Not equals", itemQuantity.size(), Integer.parseInt(num));
    }

    public void breadcrumpClickOnTshirt() {
        //Actions action= new Action();
        basetest.waitElementVisibility(Tshirts);
        Tshirts.click();
    }

    public void clickOnFirstItem() {
        basetest.waitElementVisibility(oneTshort.get(0));
        System.out.println("hello");
        //oneTshort.get(0).click();
        Actions actions = new Actions(basetest.getDriver());
        actions.moveToElement(oneTshort.get(0)).perform();
        //basetest.moveToElement(oneTshort.get(0));
        addToCart.click();
        basetest.waitElementVisibility(proceedToCheckoutButton);
        proceedToCheckoutButton.click();


    }

    public void clickOnSummerDresses() {
        basetest.waitElementVisibility(navMenu_women);
        basetest.moveToElement(navMenu_women);
        navMenu_women_summerDresses.click();
    }

    public void clickOnEveningDresses() {
        basetest.waitElementVisibility(navMenu_women);
        basetest.moveToElement(navMenu_women);
        navMenu_women_EveningDresses.click();
    }

    public void addItemToBusket() {
        basetest.waitElementVisibility(addToCart);
        addToCart.click();
    }

    public void proceedToCheckout() {
        basetest.waitElementVisibility(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
    }

    public void checkTotalPrice() {
        basetest.waitElementVisibility(totalPrice);
        String st = totalPrice.getText().substring(1);
        double price_before = Double.valueOf(st);
        System.out.println(price_before);


    }

    public void openLinkInNewWindow(WebElement element) {

        for (String windowHandle : basetest.getDriver().getWindowHandles()) {
            basetest.getDriver().switchTo().window(windowHandle);
            element.click();
        }
    }
    public void getAndPrintCookies(){
       Set<Cookie> cookies = basetest.getDriver().manage().getCookies();
        System.out.println(cookies);
    }

}
