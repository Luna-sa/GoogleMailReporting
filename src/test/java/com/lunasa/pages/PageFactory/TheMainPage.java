package com.lunasa.pages.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TheMainPage extends AbstractPage {
        @FindBy(xpath =("//div[contains(text(),'COMPOSE')]"))
        WebElement compose;

        public void composeButton() {
//          Create a new mail (fill addressee, subject and body fields).
            compose.click();
            implicitlyWait();
    }

        public void assertLogIn() {
            //      Assert, that the login is successful.
            open("https://mail.google.com/mail/");
            waitForTitleContains("msslunasa@gmail.com - Gmail");
            implicitlyWait();
        }

//      Log off.
        public void logOff() {
            open("https://accounts.google.com/SignOutOptions?hl=en-GB&continue=https://mail.google.com/mail&service=mail");
            implicitlyWait();
            open("https://accounts.google.com/Logout?hl=en-GB&continue=https://mail.google.com/mail&service=mail&timeStmp=1533070972&secTok=.AG5fkS9JgVx6uFohW2W2F3tkHZMZiOF11g");
            implicitlyWait();
        }
}
