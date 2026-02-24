package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckOutPage {
    private Page page;

    public CheckOutPage(Page page) {
        this.page = page;
    }

    private Locator firstName() {
        return page.locator("#first-name");
    }

    private Locator lastName() {
        return page.locator("#last-name");
    }

    private Locator postalCode() {
        return page.locator("#postal-code");
    }

    private Locator continueBtn() {
        return page.locator("#continue");
    }

    private Locator finishBtn() {
        return page.locator("#finish");
    }

    private Locator successMessage() {
        return page.locator(".complete-header");
    }

    public void enterCheckoutDetails(String fName, String lName, String zip) {
        firstName().fill(fName);
        lastName().fill(lName);
        postalCode().fill(zip);
        continueBtn().click();
    }

    public void finishOrder() {
        finishBtn().click();
    }

    public void verifyOrderSuccess() {
        assertThat(successMessage()).hasText("Thank you for your order!");
    }
}
