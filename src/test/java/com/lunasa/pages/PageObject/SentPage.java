package com.lunasa.pages.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SentPage extends AbstractPage {
    private static final By DRAFTS_LOCATOR = By.xpath("//div/span/a[@title='Drafts']");
    private static final By HELLOWORLD_LOCATOR = By.xpath("//*[contains(text(), 'Hello World')]/ancestor::tr/td/div[@role='link']");
//    private static final By INBOX_LOCATOR = By.xpath("//a[@href ='https://mail.google.com/mail/u/0/#inbox']");
//    private static final By OK_BUTTON_LOCATOR = By.xpath("//div/button[contains(text(),'OK')]");
//    private static final By MORE_BUTTON_LOCATOR = By.xpath("//span/span[text() = 'More']");
//    private static final By LESS_BUTTON_LOCATOR = By.xpath("//div/span[contains(text(),'Less')]");
//    private static final By TRASH_LOCATOR = By.xpath("//a[@href ='https://mail.google.com/mail/u/0/#trash']");
//    private static final By SENT_MAIL_LOCATOR = By.xpath("//div/span[text() = 'mslunasa']");
//    private static final By CHECKBOX_FALSE_LOCATOR = By.xpath("//td/div[@role = 'checkbox'][@aria-checked = 'false']");
//    private static final By CHECKBOX_TRUE_LOCATOR = By.xpath("//td/div[@role = 'checkbox'][@aria-checked = 'true']");
//    private static final By DELETE_BUTTON_LOCATOR = By.xpath("//div[@data-tooltip = 'Delete'][@aria-label = 'Delete']");
//    private static final By SENT_MAIL_FIELD_LOCATOR = By.xpath("//*[@id=':2e']");

    public void verifySentFolderContainsMail() {
//      Verify, that the mail is in ‘Sent’ folder.
        isElementDisplayed(DRAFTS_LOCATOR);
        findElement(DRAFTS_LOCATOR);
        open("https://mail.google.com/mail/u/0/#sent");
        implicitlyWait();
        isElementDisplayed(HELLOWORLD_LOCATOR);
        findElement(HELLOWORLD_LOCATOR);
        implicitlyWait();
    }

//    public void moveMailIntoInbox() {
//    }
}
