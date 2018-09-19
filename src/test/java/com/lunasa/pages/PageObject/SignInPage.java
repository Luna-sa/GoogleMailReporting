package com.lunasa.pages.PageObject;

import org.openqa.selenium.By;

public class SignInPage extends AbstractPage {
    private static final By NEXT_BUTTON_LOCATOR = By.xpath("//*[@id=\"identifierNext\"]/content/span");

    public void enterLogin() {
        // Login to the mail box.
        open("https://accounts.google.com/ServiceLogin/signinchooser?");
        implicitlyWait();
        // Enter the name of your mail:
        type(By.id("identifierId"), "msslunasa@gmail.com");
        click(NEXT_BUTTON_LOCATOR);
    }
}
