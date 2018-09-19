package com.lunasa.pages.PageObject;

import org.openqa.selenium.By;

public class DraftsPage extends TheMainPage {
    private static final By DRAFT_LOCATOR = By.xpath("//*[contains(text(), 'Hello World')]/ancestor::tr/td/div[@role='link']");

//      Verify, that the mail presents in ‘Drafts’ folder.
        public void verifyMailInDrafts() {
            open("https://mail.google.com/mail/u/0/#drafts");
            implicitlyWait();
            click(DRAFT_LOCATOR);
            implicitlyWait();
        }
        public void verifyEmptyDrafts() {
            open("https://mail.google.com/mail/u/0/#inbox");
            implicitlyWait();
//                  Verify, that the mail disappeared from ‘Drafts’ folder.
        }
}
