package org.wsecu.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.wsecu.pages.OnlineBankingPage;
import org.wsecu.utilities.BrowserUtils;
import org.wsecu.utilities.ConfigurationReader;
import org.wsecu.utilities.Driver;

public class Task_stepDefs {
    OnlineBankingPage OB = new OnlineBankingPage();
    class NoSuchFieldException extends RuntimeException{
    }
    @When("user enters user name {string}")
    public void user_enters_user_name(String username) {// takes the test data from feature file >> avoid hard coding and increases re-usability
        OB.username.sendKeys(username);

    }
    @When("user clicks sign in button")
    public void user_clicks_sign_in_button() {
        OB.signInButton1.click();

    }
    @Then("user has to be redirected to {string} page")
    public void user_has_to_be_redirected_to_page(String expectedURL) {
        String actualURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);

    }

    @Given("user is on the WSECU Online Banking web site")
    public void user_is_on_the_wsecu_online_banking_web_site() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env2"));
    }

    @When("user enters {string} {string}")
    public void user_enters(String field, String value) {
        switch (field){
            case "password":
                OB.password.sendKeys(value);
                break;
            default:
                throw new NoSuchFieldException();
        }
    }
    @When("user clicks sign in button2")
    public void user_clicks_sign_in_button2() {
        OB.getSignInButton2.click();
    }

    @Then("user should see {string} message")
    public void user_should_see_message(String expectedMassage) {
        String actualMassage = OB.errorMassage.getText();
        Assert.assertEquals( expectedMassage, actualMassage);
    }
}
