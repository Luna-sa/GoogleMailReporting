package com.lunasa.pages.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraftsPage extends TheMainPage {
    @FindBy(xpath =("//*[contains(text(), 'Hello World')]/ancestor::tr/td/div[@role='link']"))
    WebElement draftMail;

    public void verifyMailInDrafts() {
        open("https://mail.google.com/mail/u/0/#drafts");
        implicitlyWait();
        draftMail.isEnabled();
        isElementDisplayed(By.xpath("//*[contains(text(), 'Hello World')]/ancestor::tr/td/div[@role='link']"));
        draftMail.click();
        implicitlyWait();
    }


    public void verifyEmptyDrafts() {
        //                  Verify, that the mail disappeared from ‘Drafts’ folder.
        open("https://mail.google.com/mail/u/0/#inbox");
        implicitlyWait();
    }
}
