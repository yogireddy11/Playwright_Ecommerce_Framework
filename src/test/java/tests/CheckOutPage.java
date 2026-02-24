package tests;

import base.BaseTest;
import base.PlaywrightFactory;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.RetryAnalyzer;

public class CheckOutPage extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(
                PlaywrightFactory.getPage());

        InventoryPage inventoryPage = new InventoryPage(
                PlaywrightFactory.getPage());

        CartPage cartPage = new CartPage(
                PlaywrightFactory.getPage());

        pages.CheckOutPage checkoutPage = new pages.CheckOutPage(
                PlaywrightFactory.getPage());

        loginPage.login("standard_user", "secret_sauce");

        inventoryPage.verifyProductsCount(6);

        inventoryPage.addProductToCart("Sauce Labs Backpack");

        inventoryPage.verifyCartCount("1");

        PlaywrightFactory.getPage().locator(".shopping_cart_link").click();

        cartPage.verifyCartItemCount(1);

        cartPage.clickCheckout();

        checkoutPage.enterCheckoutDetails("Yogi", "Reddy", "500001");

        checkoutPage.finishOrder();

        checkoutPage.verifyOrderSuccess();
    }
}
