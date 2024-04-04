package org.pwj;

import com.microsoft.playwright.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class AllVisibleLinksOnPage {

    Page page;
    BrowserContext brc; // used to launch new site.


    @BeforeClass
    public void launchBrowser(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        brc = browser.newContext();
        page = browser.newPage();
        page.navigate("https://demo.opencart.com/index.php?route=account/login");
    }


    @Test
    public void getAllVisibleLinksOnPage(){
        Locator links=page.locator("a:visible");
        System.out.println(links.count());
        List<String> pageLst =page.locator("a:visible").allInnerTexts();
        pageLst.forEach(System.out::println);
        // or can be written as
        pageLst.stream().forEach(e-> System.out.println(e));
        /*for(String str : pageLst){
            System.out.println(str);
        }*/

        for(int i=0; i<links.count(); i++){
            System.out.println(page.locator("a:visible").nth(i));
            System.out.println(page.locator("a:visible").nth(i).textContent());
        }
    }

    @Test
    public void testVisibleImagesOnPage(){
        Locator links=page.locator("xpath=//img >> visible=true");
        System.out.println(links.count());
    }
}
