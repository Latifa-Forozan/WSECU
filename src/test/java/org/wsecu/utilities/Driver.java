package org.wsecu.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Driver class implementing Singleton design pattern with InheritableThreadLocal.
 *
 * This class manages the WebDriver instances using the Singleton pattern and the InheritableThreadLocal
 * mechanism. Each thread (and potentially its child threads) has its own WebDriver instance, ensuring
 * thread-safe parallel execution of tests.
 * The Singleton pattern ensures that a single instance of WebDriver is used throughout the test run.
 *
 * Usage:
 * Call Driver.getDriver() to obtain the WebDriver instance for the current thread.
 */

public class Driver {

    /** Private constructor to close access to obj of this class */
    private Driver() {
    }

    /** WebDriver private to close access from outside of class -- Static because we will use it inside static method
     */
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
    public static WebDriver getDriver() {

        if (driverPool.get() == null) {
            String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : ConfigurationReader.getProperty("browser");
            //-Dbrowser=chrome
            switch(browserName){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;

                case "remote-chrome":
                    try {
                        String gridAddress = ""; // assign grid server address
                        URL url = new URL("http://"+ gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "remote-firefox":
                    try {
                        String gridAddress = "";// assign grid server address
                        URL url = new URL("http://"+ gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("firefox");
                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
        driverPool.get().manage().window().maximize();
        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driverPool.get();
    }

    // This method will make sure our driver value is always null after using quit() method
    public static void closeDriver(){
        if(driverPool.get() != null){
            driverPool.get().quit(); // this line will terminate the existing driver session. with using this driver will not be even null
            driverPool.remove();  //driver = null
        }

    }
}
