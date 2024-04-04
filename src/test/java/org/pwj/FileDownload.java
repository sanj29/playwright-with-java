package org.pwj;

import com.microsoft.playwright.*;
import java.nio.file.Paths;

public class FileDownload {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();

        page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=114.0.5735.90/");

        Download download =page.waitForDownload(() -> {
                page.locator("a:has-text('chromedriver_mac64.zip')").click();
        });

        System.out.println(download.url());
        download.saveAs(Paths.get("chrome114_driver.zip"));

        playwright.close();
    }
}
