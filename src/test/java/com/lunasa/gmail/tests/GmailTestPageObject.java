package com.lunasa.gmail.tests;

import com.lunasa.pages.PageObject.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GmailTestPageObject {

	@BeforeClass
	public void setUp() {
	}

	@Test
	public void GmailTest() {
	    try {
            new SignInPage().enterLogin();
            new PasswordPage().enterPassword();
            new TheMainPage().assertLogIn();
            new TheMainPage().composeButton();
            new WriteLetterPage().enterNewMail();
            new WriteLetterPage().closeButton();
            new DraftsPage().verifyMailInDrafts();
            new WriteLetterPage().verifyDraft();
            new WriteLetterPage().sentEmail();
            new DraftsPage().verifyEmptyDrafts();
            new SentPage().verifySentFolderContainsMail();
            new TheMainPage().logOff();
        } finally {
            AbstractPage.kill();
        }
	}

	@AfterClass
	public void tearDown() {
	}
}
