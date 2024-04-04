package org.pwj;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class VideoRecording {
    public static void main(String[] args) {

        Playwright pl = Playwright.create();
        Browser br = pl.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext brc =br.newContext(new Browser.NewContextOptions()
                                .setRecordVideoDir(Paths.get("myVideo/"))
                                .setViewportSize(990,800));

        Page p = brc.newPage();

        p.navigate("https://www.orangehrm.com/en/30-day-free-trial");
        p.locator("div #Form_getForm_subdomain").fill("test12hrm");
        p.locator("#Form_getForm_Name").fill("test AutoUser");
        p.locator("#Form_getForm_Email").fill("test12hrm@gmail.com");
        p.locator("#Form_getForm_Contact").fill("1234567890");

        p.close();
        brc.close();
        pl.close();

    }


}
