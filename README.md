# playwright-with-java

# Selectors in playwright
    - text  page.locator(text=<your test>) or page.locator('yourtext')
    - CSS selector
    - frame  --> page.frame("name of frame") or page.frameLocator("selector ")
    - selecting element in shadow dom
    - selecting visible element  -->	 button:visible oe button >> visible=true
    - Selecting element that contains other element ---> <tag or class >:has('text or link')
    - Comma n Union (|)
        - xpath union
    - Selecting element based on layout/ or relative element--  left of , right of below, above near and near,200 ( near, pixel)
    - Nth element.  
        - "button >> nth=0" //gives 1st ele
        - "button >> nth=-1" //gives last ele
    - React Selector
        - page.locator("_react:componentName[followeed by selector]") using using react developer tool.
    - Xpath Selector
    - id, data-testid, data-test-id, data-test 

# One time login::
    - it has capability to store strore cred in .json file and can it be re-utilized for further login (browserContext is used here)

# JS Alert
    - with the help of playwrght listner, we can handle it,
      Page page = browser.newPage();
      // to handle alert with confirm and Cancel button
      page.onDialog(dialog -> {
      String text= dialog.message(); --> to get alert message
      System.out.println(text);
      dialog.accept(""); --> to accept/ with or without message
      //dialog.dismiss(); // to cancel alert/
    
           });

# Upload and Download file
    Attache and De attache file:;
    - page.setInputFiles("Locator", Paths.get("path of your file")) // upload
    - page.setInputFiles("Locator", new Paths[0]) // remove
    - page.setInputFiles("Locator", new Paths[]{Paths.get("fist file name"),Paths.get("2ns file name"),Paths.get("3rd file name")}) -- upload multiple files

# Download File via Playwright:
    - page.waitForDownload(() -> {
        page.locator("a:has-text('chromedriver_mac64.zip')").click();
        });

# Running codegen::
    - mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen https://amzaon.in"

# Test urls:
    - http://londonfreelance.ord/courses/frames.index.html
    - iframe/frame:: https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/
    - check box:  https://www.formsite.com/templates/registration-form-templates/information-request-form/
    - drop-down canvas, data picker, check box, radio button :  https://www.formsite.com/templates/registration-form-templates/records-request-form/. image title:: title="Records-Request-Forms-and-Examples"
    Shadow dom reference::
    - https://books-pwakit.appspot.com/
    - https://selectorshub.com/shadow-dom-in-iframe/

    all type of coponent:: https://selectorshub.com/xpath-practice-page/
