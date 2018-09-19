package com.lunasa.pages.PageObject;

import org.openqa.selenium.By;

public class WriteLetterPage extends TheMainPage {
    private static final By TO_FIELD_LOCATOR = By.xpath("//div/textarea[@name='to']");
    private static final By SUBJECT_FIELD_LOCATOR = By.xpath("//div/input[@name='subjectbox']");
    private static final By TEXTBOX_FIELD_LOCATOR = By.xpath("//div[@role='textbox']");
    private static final By CLOSE_BUTTON_LOCATOR = By.xpath("//img[@alt='Close']");
    private static final By SEND_BUTTON_LOCATOR = By.xpath("//div[@role='button' and contains(text(), 'Send')]");

    public void enterNewMail() {
        waitToBeClickable(By.xpath("//div/textarea[@name='to']"));
        type(TO_FIELD_LOCATOR,"mslunasa@gmail.com");
        type(SUBJECT_FIELD_LOCATOR,"Hello World");
        type(TEXTBOX_FIELD_LOCATOR,"Just want to say hi");
        implicitlyWait();
        }

    public void closeButton() {
        click(CLOSE_BUTTON_LOCATOR);
        implicitlyWait();
    }
    public void verifyDraft() {
        findElement(By.xpath("//div/span/a[@title='Drafts (1)']"));
        findElement(By.xpath("//div/span[@email='mslunasa@gmail.com']"));
        findElement(By.xpath("//form/input[@value='Hello World']"));
        findElement(By.xpath("//*[contains(text(), 'Just want to say hi')]"));
//      Verify the draft content (addressee, subject and body – should be the same as in 3).
    }

    public void sentEmail() {
        click(SEND_BUTTON_LOCATOR);
        implicitlyWait();
    }
}
