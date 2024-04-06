package org.pwj.windowstab;

import com.microsoft.playwright.*;

public class OpenBlankTab {


    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext bcx = browser.newContext();
        Page page1 =bcx.newPage();

        page1.navigate("https://www.orangehrm.com/");

       Page popup= page1.waitForPopup( () -> {
           page1.evaluate("window.open('', '_blank')"); // opening blank url
        });

        popup.waitForLoadState();

        popup.navigate("http://www.gogole.com");
        System.out.println("popup.title() :" +popup.title());
        popup.close();
        System.out.println("page1.title() :" +page1.title());
        playwright.close();
    }

}
