package questions;

import com.microsoft.playwright.*;

import java.util.ArrayList;
import java.util.List;

public class Leetcode {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();

        page.navigate("https://leetcode.com/problemset/");
        page.url().contains("problemset");

        Locator question = page.locator("//div[@role='row']/div[@role='cell'][2]");
        List<String > items = new ArrayList<>();

        for(int i=0; i<question.count(); i++){
            if(question.locator("//a").nth(i).textContent().contains(i+"."))
                items.add(question.locator("//a").nth(i).textContent());
            // System.out.println(question.nth(i).textContent());

        }
        for(int j= 0 ; j < 5; j++)
            System.out.println(items.get(j));

        page.close();
        browser.close();
        playwright.close();

    }

}
