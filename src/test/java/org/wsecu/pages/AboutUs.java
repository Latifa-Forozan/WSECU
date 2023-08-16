package org.wsecu.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

    public class AboutUs extends BasePage {

        @FindBy(xpath = "(//span[text() = 'About Us'])[2]")
        public WebElement aboutUs;

        @FindBy( xpath = "(//a[text()='Financial Wellness Overview'])[2]")
        public WebElement financialSubMenu;


    }

