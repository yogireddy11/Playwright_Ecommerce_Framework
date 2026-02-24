package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage {
     Page page;
    private static final Logger log = LogManager.getLogger(LoginPage.class);


    public LoginPage(Page page){
        this.page=page;
    }

    private Locator user(){
        return page.locator("#user-name");
    }
    private Locator pass(){
        return page.locator("#password");
    }
    private Locator loginBtn() {
        return page.locator("#login-button");
    }

    private Locator errorMessage() {
        return page.locator("[data-test='error']");
    }

    public void login(String user, String pass) {
      user().fill(user);
        log.info("Entering username");
      pass().fill(pass);
        log.info("Entering password");
      loginBtn().click();
        log.info("Login to application");
    }

    public void verifyLoginErrorVisible() {
        assertThat(errorMessage()).isVisible();
    }
}
