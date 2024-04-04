package org.pwj;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class JavaScriptAlert {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            // to handle alert with confirm and Cancel button
            page.onDialog(dialog -> {
               String text= dialog.message();
                System.out.println(text);
                dialog.accept("hi welcome to my alert");
                //dialog.dismiss();
            });

        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");

        page.click("//*[@id=\"content\"]/div/ul/li[1]/button");
        System.out.println(page.locator("#result").textContent());
        page.click("//*[@id=\"content\"]/div/ul/li[2]/button");
        System.out.println(page.locator("#result").textContent());

        page.click("//*[@id=\"content\"]/div/ul/li[3]/button");
        System.out.println(page.locator("#result").textContent());

        page.close();
        browser.close();
        playwright.close();
    }
}
