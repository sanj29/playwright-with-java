package org.pwj.windowstab;

import com.microsoft.playwright.*;

public class WindowTab_example {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext bcx = browser.newContext();

        Page page1 =bcx.newPage();
// Opening new url in same window

        page1.navigate("https://www.orangehrm.com/");
        Page tab = page1.waitForPopup( () ->{
            page1.click("img[alt='facebook logo']");
        });
        tab.waitForLoadState();
        System.out.println(" tab title ::" +tab.title());
        tab.close();
        System.out.println(page1.locator("div.copyright-text > p").textContent());

        System.out.println(" Main window title ::" +page1.title());

        playwright.close();

    }
}
