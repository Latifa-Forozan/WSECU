package org.wsecu.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
    public class OnlineBankingPage extends BasePage{

        @FindBy( xpath = "//input[@name ='username']")
        public WebElement username;

        @FindBy( xpath = "//input[@type ='submit']")
        public WebElement signInButton1;

        @FindBy( xpath = "//input[@name ='password']")
        public WebElement password;

        @FindBy(xpath = "//button[@type ='submit']")
        public WebElement getSignInButton2;

        @FindBy(xpath = "//div[. = 'Sorry, incorrect username.']")
        public WebElement errorMassage;

    }

