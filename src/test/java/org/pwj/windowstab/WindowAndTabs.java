package org.pwj.windowstab;

import com.microsoft.playwright.*;

public class WindowAndTabs {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext bcx = browser.newContext();
        BrowserContext bcx1 = browser.newContext();

        Page page = bcx.newPage();
        Page page1 = bcx1.newPage();

        page.navigate("http://Google.com");
        page1.navigate("https://www.orangehrm.com/");
        System.out.println("First page url" +page.url());
        System.out.println("Second page url" +page1.url());

        page.close();
        page1.close();
        bcx.close();
        bcx1.close();
        playwright.close();
    }


}
