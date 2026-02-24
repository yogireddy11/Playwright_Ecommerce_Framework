package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CartPage {
    private Page page;

    public CartPage(Page page) {
        this.page = page;
    }

    private Locator cartItems() {
        return page.locator(".cart_item");
    }

    private Locator checkoutBtn() {
        return page.locator("#checkout");
    }

    public void verifyCartItemCount(int expected) {
        assertThat(cartItems()).hasCount(expected);
    }

    public void clickCheckout() {
        checkoutBtn().click();
    }
}
