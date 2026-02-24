package api;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;

import java.util.HashMap;
import java.util.Map;

public class BaseAPI {

    protected static final APIRequestContext requestContext;

    static {
       Playwright playwright = Playwright.create();
        Map<String,String> header = new HashMap<>();
        header.put("Content-type","application/json");
        requestContext = playwright.request().newContext(new APIRequest.NewContextOptions()
                        .setBaseURL("https://practice.expandtesting.com")
                .setExtraHTTPHeaders(header));
    }
}
