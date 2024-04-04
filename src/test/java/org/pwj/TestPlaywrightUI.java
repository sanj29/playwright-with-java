package org.pwj;

import com.microsoft.playwright.*;

public class TestPlaywrightUI {

    public static void main(String[] args) {

        try{
            Playwright playwright = Playwright.create();
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            //BrowserContext brc =browser.newContext();
            Page page = browser.newPage();
            page.setViewportSize(1920, 1080);

            page.navigate("https://selectorshub.com/xpath-practice-page/");
            //fill form:

            page.locator("//*[@id=\"shub45\"]").fill("test user ");
            page.getByPlaceholder("Enter Password").fill("test@123");
            page.locator("input[name='company']").fill("selectorHub ord");
            page.locator("input[name='mobile number']").fill("selectorHub ord");
            page.getByText("Submit").click();
            page.frameLocator("selector ");
        }catch (Exception e){
            e.printStackTrace();

        }

    }
}
