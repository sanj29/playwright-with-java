package org.pwj;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowIframe {

    public static void main(String[] args) {

        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setChannel("chrome");
        lp.setHeadless(false);
        try {
            Playwright playwright = Playwright.create();
            //Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Browser browser = playwright.chromium().launch(lp);
            Page page = browser.newPage();
            page.navigate("https://books-pwakit.appspot.com/");

            String txt =page.locator("book-app[apptitle='BOOKS'] .books-desc" ).textContent();
            System.out.println(txt);

            page.locator("book-app[apptitle='BOOKS'] #input").fill("automation");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
