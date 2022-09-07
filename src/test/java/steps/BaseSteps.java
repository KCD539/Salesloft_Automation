package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import utils.Waiter;
import static steps.Hooks.*;

public class BaseSteps {

    @Given("user navigates to {string}")
    public void userNavigatesTo(String pageUrl) {
        driver.get(pageUrl);
    }
    @Then("user should see the title {string}")
    public void userShouldSeeTheTitle(String title) {
        Waiter.waitUntilTitleIs(driver, 5, title);
        Assert.assertEquals(title, driver.getTitle());
    }

}
