package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class InventoryPage {

    Page page;
    public InventoryPage(Page page){
        this.page=page;
    }

    private Locator products() {
        return page.locator(".inventory_item");
    }

    private Locator cartBadge() {
        return page.locator(".shopping_cart_badge");
    }

    public void verifyProductsCount(int expected) {
        assertThat(products()).hasCount(expected);
    }

    public void addProductToCart(String productName) {
        page.getByText(productName)
                .locator("xpath=ancestor::div[@class='inventory_item']")
                .getByRole(com.microsoft.playwright.options.AriaRole.BUTTON)
                .click();
    }

    public void verifyCartCount(String count) {
        assertThat(cartBadge()).hasText(count);
    }
}
