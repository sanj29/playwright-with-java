package org.pwj;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.awt.*;

public class MaximizeBrowser {

    public static void main(String[] args) {

        Dimension dim =Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)dim.getWidth();
        int height = (int)dim.getHeight();

        Playwright pl = Playwright.create();
        Browser br = pl.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page p = br.newPage();
        p.setViewportSize(width,height);
        p.navigate("http://www.amazon.com");

        pl.close();

    }
}
