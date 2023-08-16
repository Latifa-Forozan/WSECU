package org.wsecu.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BrowserUtils {

    /**
     * Verifies that the current page title contains the expected text
     * <p>
     * This method asserts that the title of the current web page contains the specified
     * text. If the expected text is not found in the title, an assertion failure occurs.
     *
     * @param expectedInTitle The text expected to be present in the page title
     */
    public static void verifyTitleContains(String expectedInTitle) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));
    }

    /**
     * Verifies that the current page title matches the expected title.
     * <p>
     * This method asserts that the title of the current web page is equal to the specified
     * expected title. If the titles do not match, an assertion failure occurs.
     *
     * @param expectedTitle The expected title of the page.
     * @throws AssertionError If the page title does not match the expected title.
     */

    public static void verifyTitle(String expectedTitle) {
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }

    /**
     * Selects an option from a dropdown element based on visible text.
     * <p>
     * This method interacts with a provided dropdown WebElement and selects an option
     * that matches the specified visible text. The selection is performed using the
     * Select class from the Selenium WebDriver library.
     *
     * @param element  The WebElement representing the dropdown element.
     * @param category The visible text of the option to be selected.
     */

    public static void selectOptionDropdown(WebElement element, String category) {

        Select select = new Select(element);

        select.selectByVisibleText(category);
    }

}
