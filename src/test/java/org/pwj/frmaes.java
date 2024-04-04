package org.pwj;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class frmaes {


    //https://www.londonfreelance.org/courses/frames/index.html
    //frame[@name='main']
    public static void main(String[] args) {

        Playwright pl = Playwright.create();
        Browser br  = pl.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page pg = br.newPage();

        pg.navigate("https://www.londonfreelance.org/courses/frames/index.html");
        String txt=pg.frameLocator("frame[name=main]").locator("h2").textContent();
        System.out.println(txt);
        // here main is frame name
        String h2=pg.frame("main").locator("h2").textContent();
        System.out.println(h2);

        // here content is frame name
        System.out.println(pg.frame("content").locator("'Mike Holderness'").textContent());;
        System.out.println(pg.frame("content").locator("text=Mike Holderness").textContent());;
    }

}
