package listeners;

import base.PlaywrightFactory;
import com.microsoft.playwright.Page;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.nio.file.Paths;

public class TestListeners implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        Page page = PlaywrightFactory.getPage();

        if (page != null) {
            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get("screenshots/"
                            + result.getName() + ".png")));
        }
    }
}
