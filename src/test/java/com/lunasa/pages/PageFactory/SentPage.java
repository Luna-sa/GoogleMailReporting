package com.lunasa.pages.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SentPage extends AbstractPage {

//    private static final String TEST = "test";

    @FindBy(xpath =("//div/span/a[@title='Drafts']"))
    WebElement zeroMailsInDraft;

    @FindBy(xpath =("//*[contains(text(), 'Hello World')]/ancestor::tr/td/div[@role='link']"))
    WebElement helloWorldMail;

//    @FindBy(xpath = ("//a[@href ='https://mail.google.com/mail/u/0/#trash']"))
//    WebElement bin;
//
//    @FindBy(xpath =("//div/button[contains(text(),'OK')]"))
//    WebElement okButton;

    public void verifySentFolderContainsMail() {
        isElementDisplayed(By.xpath("//div/span/a[@title='Drafts']"));
        zeroMailsInDraft.isEnabled();
        open("https://mail.google.com/mail/u/0/#sent");
        implicitlyWait();
        isElementDisplayed(By.xpath("//*[contains(text(), 'Hello World')]/ancestor::tr/td/div[@role='link']"));
        helloWorldMail.isEnabled();
    }

//    public void moveMailIntoTrash() {
//        isElementDisplayed(By.xpath("//a[@href ='https://mail.google.com/mail/u/0/#trash']"));
//        dragAndDrop((By.xpath("//*[contains(text(), 'Hello World')]/ancestor::tr/td/div[@role='link']")),(By.xpath("//a[@href ='https://mail.google.com/mail/u/0/#trash']")));
//        implicitlyWait();
//        isElementDisplayed(By.xpath("//div/button[contains(text(),'OK')]"));
//        click(By.xpath("//div/button[contains(text(),'OK')]"));
//        implicitlyWait();
//    }
}
