package org.pwj;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * Unit test for simple App.
 */
public class PlaywrightTestDemo
{
    public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
// Channel can be "chrome", "msedge", "chrome-beta", "msedge-beta" or "msedge-dev".
            BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
            lp.setChannel("firefox");
            lp.setHeadless(true);
            Browser browser = playwright.firefox().launch(lp);
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.setViewportSize(1920, 1080);
           // page.pause();
            page.navigate("https://test.cadent.tv/ulp/");
            // page.getByPlaceholder("Enter your email").click();
            page.getByPlaceholder("Enter your email").fill("testuse@gmail.com");
            // page.getByPlaceholder("Enter your email").press("Tab");
            page.getByPlaceholder("Enter your password").fill("test@123");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();
            System.out.println("page url:" + page.url());
            System.out.println("page title:" + page.title());
            System.out.println(page.getByText("Username or password is").textContent());
            assertThat(page.getByText("Username or password is")).hasText("Username or password is incorrect");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./screenshot/passwordError.png")));
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Forgot your password?")).click();
            // page.getByPlaceholder("Enter your email").click();
            System.out.println("forgot password url:" + page.url());
            page.getByPlaceholder("Enter your email").fill("s2singh@cadent.tv");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Back to Sign In")).click();
        }
    }

}
