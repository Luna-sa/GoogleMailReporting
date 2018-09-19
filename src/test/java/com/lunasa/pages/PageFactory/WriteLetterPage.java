package com.lunasa.pages.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WriteLetterPage extends TheMainPage {
    @FindBy(xpath =("//div/textarea[@name='to']"))
    WebElement to;

    @FindBy(xpath =("//div/input[@name='subjectbox']"))
    WebElement subjectbox;

    @FindBy(xpath =("//div[@role='textbox']"))
    WebElement textbox;

    @FindBy(xpath =("//img[@alt='Close']"))
    WebElement closeButton;

    @FindBy(xpath =("//div/span/a[@title='Drafts (1)']"))
    WebElement numberOfDrafts;

    @FindBy(xpath =("//div/span[@email='mslunasa@gmail.com']"))
    WebElement emailName;

    @FindBy(xpath =("//form/input[@value='Hello World']"))
    WebElement helloWorldSubject;

    @FindBy(xpath =("//*[contains(text(), 'Just want to say hi')]"))
    WebElement helloWorldTextbox;

    @FindBy(xpath =("//div[@role='button' and contains(text(), 'Send')]"))
    WebElement sendButton;

    public void enterNewMail() {
        waitToBeClickable(By.xpath("//div/textarea[@name='to']"));
        to.sendKeys("mslunasa@gmail.com");
        subjectbox.sendKeys("Hello World");
        textbox.sendKeys("Just want to say hi");
        implicitlyWait();
    }

    public void closeButton() {
        closeButton.click();
        implicitlyWait();
    }
    public void verifyDraft() {
        numberOfDrafts.isEnabled();
        emailName.isEnabled();
        helloWorldSubject.isEnabled();
        helloWorldTextbox.isEnabled();
    }

    public void sentEmail() {
        sendButton.click();
        implicitlyWait();
    }
}
