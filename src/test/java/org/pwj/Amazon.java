package org.pwj;

import com.microsoft.playwright.*;

import java.util.List;

public class Amazon {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        //BrowserContext brc =browser.newContext();
        Page page = browser.newPage();
        page.setViewportSize(1920, 1080);

        page.navigate("https://www.amazon.in/");
      /*  {
            Locator links = page.locator("a:has-text('Amazon')");
            List<String> linksText = links.allInnerTexts();
            linksText.forEach(System.out::println);
        }*/

        {
            Locator footerList=   page.locator("div.navFooterLinkCol:has(a[href='https://amazon.jobs'])");
            footerList.allInnerTexts().forEach(System.out::println);
        }


        System.out.println(page.locator(":has-text('Amazon')").count());

        playwright.close();
    }
    //
}
