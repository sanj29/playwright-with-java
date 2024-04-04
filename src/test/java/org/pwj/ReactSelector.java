package org.pwj;

import com.microsoft.playwright.*;

public class ReactSelector {
    public static void main(String[] args) throws InterruptedException {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();

        page.navigate("https://www.netflix.com/in/");
        Locator email =page.locator("_react=Anonymous[name='email'] >> input").first();
        email.click();
        email.fill("9953960781@gmail.com");
       Locator btn= page.locator("button:has-text('Get Started')").first();
       btn.click();

        Thread.sleep(10000);

        playwright.close();


    }


}
