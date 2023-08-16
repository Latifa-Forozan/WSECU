package org.wsecu.stepDefinitions;

import org.wsecu.utilities.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before ("@ui")
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @After("@ui")
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        Driver.closeDriver();
    }

    @Before ("@db")
    public void setUpDB() {
        //Create connection to the DB
    }

    @After ("@db")
    public void destroyDB() {
        //Close connection to the DB
    }
}
