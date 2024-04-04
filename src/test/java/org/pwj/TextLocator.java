package org.pwj;

import com.microsoft.playwright.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextLocator {

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
    public void testTextLocator(){
        page.locator("input[id='input-email']").fill("testautomation@gmail.com");
        page.locator("input[id='input-password']").fill("gmail.com");
        //page.locator("//*[@id=\"form-login\"]/button").click();
        page.locator("div.mb-3 button:has-text('Login')").click();
    }

    @Test
    public void testHasTextWay(){
    String txt =page.locator("h2:has-text('New Customer')").textContent();
        System.out.println(txt);
    }


    @Test
    public void testTextWithMultiElement(){

        brc.newPage().navigate("https://www.orangehrm.com/en/30-day-free-trial");

        Locator locator =page.locator("text=Privacy Policy");
        System.out.println(locator.count());
        for(int i =0; i <locator.count() ; i++){
           String str= locator.nth(i).textContent();
            if(str.equals("Service Privacy Policy")){
                locator.nth(i).click();
                break;
                }
        }

    }

}
