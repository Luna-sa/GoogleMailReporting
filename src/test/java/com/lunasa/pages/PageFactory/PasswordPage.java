package com.lunasa.pages.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordPage extends AbstractPage {
    @FindBy(name =("password"))
    WebElement password;

    @FindBy(id =("passwordNext"))
    WebElement nextButton;

    public void enterPassword ()

    {
        //      Enter your password:
        waitToBeClickable(By.name("password"));
        isElementDisplayed(By.name("password"));
        password.sendKeys("Rty67ui9");
        implicitlyWait();
        isElementDisplayed(By.id("passwordNext"));
        waitToBeClickable(By.id("passwordNext"));
        nextButton.click();
        implicitlyWait();

    }
}
