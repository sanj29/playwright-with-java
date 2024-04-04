package org.pwj;

import com.microsoft.playwright.*;

import java.util.List;

public class DropdownPlaywright {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        //BrowserContext brc =browser.newContext();
        Page page = browser.newPage();
        page.setViewportSize(1920, 1080);

        page.navigate("https://www.orangehrm.com/en/30-day-free-trial");
        Locator loc =page.locator("select#Form_getForm_Country:has(option[value='India'])");

        loc.allInnerTexts().forEach(System.out::println);
        //
        page.close();
    }
}
