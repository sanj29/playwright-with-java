package org.pwj;

import com.microsoft.playwright.*;

public class WebTableWorking {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://datatables.net/extensions/select/examples/checkbox/checkbox.html");
        Locator rows = page.locator("table#example tr");
        rows.locator(":scope", new Locator.LocatorOptions()
                .setHasText("Bradley Greer")).locator(".dt-select-checkbox").click();
        rows.locator(":scope").allInnerTexts().forEach(System.out::println);

    }
}
