package org.wsecu.stepDefinitions;

import org.wsecu.pages.AboutUs;
import org.wsecu.utilities.BrowserUtils;
import io.cucumber.java.en.*;

public class AboutUs_stepDefs {
        AboutUs aboutUs = new AboutUs();
        @Given("user is on the WSECU homepage")
        public void user_is_on_the_WSECU_homepage() {
            //This step is implemented in hooks class
        }

        @When("user selects {string} menu")
        public void user_selects_Menu(String mainMenu) {
            aboutUs.aboutUs.click();
        }

        @When("user selects {string} submenu")
        public void user_selects_submenu(String subMenu) {
            aboutUs.financialSubMenu.click();
        }

        @Then("verify title contains {string}")
        public void user_sees_is_in_the_title(String keywordInTitle) {
            BrowserUtils.verifyTitleContains(keywordInTitle);
        }
    }
