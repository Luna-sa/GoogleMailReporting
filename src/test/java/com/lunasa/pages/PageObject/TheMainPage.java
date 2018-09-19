package com.lunasa.pages.PageObject;

import org.openqa.selenium.By;

public class TheMainPage extends AbstractPage {
    private static final By COMPOSE_BUTTON_LOCATOR = By.xpath("//div[contains(text(),'COMPOSE')]");

        public void assertLogIn() {
            //      Assert, that the login is successful.
            open("https://mail.google.com/mail/");
            waitForTitleContains("msslunasa@gmail.com - Gmail");
            implicitlyWait();
        }

        public void composeButton() {
//      Create a new mail (fill addressee, subject and body fields).
            click(COMPOSE_BUTTON_LOCATOR);
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
