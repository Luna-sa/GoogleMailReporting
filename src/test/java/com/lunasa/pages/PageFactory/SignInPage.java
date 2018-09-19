package com.lunasa.pages.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends AbstractPage {
    @FindBy(xpath =("//*[@id=\"identifierNext\"]/content/span"))
    WebElement nextButtonPassword;

    @FindBy(id =("identifierId"))
    WebElement mailName;

    public void enterLogin() {
        // Login to the mail box.
        open("https://accounts.google.com/ServiceLogin/signinchooser?");
        implicitlyWait();
        // Enter the name of your mail:
        mailName.sendKeys("msslunasa@gmail.com");
        nextButtonPassword.click();
    }
}
