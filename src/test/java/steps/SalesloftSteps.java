package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import utils.DropdownHandler;
import utils.Waiter;

import static steps.Hooks.*;

public class SalesloftSteps {
    @When("user types in {string} input box {string}")
    public void userTypesInInputBox(String input, String text) {
        switch (input) {
            case "Search":
                homePage.searchInput.sendKeys(text);
                break;
            default:
                System.out.println("Invalid Input Error!!!");
        }
    }

    @Then("user should select {string} category from {string} dropdown")
    public void userShouldSelectCategoryFromDropdown(String value, String dropdownName) {
        switch (dropdownName) {
            case "SearchDropdown":
            case "SearchDropDown":
                DropdownHandler.selectOptionByVisibleText(homePage.selectedDropdownBox, value);
                break;
            case "Quantity":
                DropdownHandler.selectOptionByVisibleText(itemPage.quantityDropdown, value);
                break;
            default:
                System.out.println("Invalid Dropdown Name Error!!!");
        }
    }

    @Then("user should click {string}")
    public void userShouldClickButton(String buttonName) {
        switch (buttonName){
            case "Search Button":
                homePage.searchSubmitButton.click();
                break;
            case "Prime Checkbox":
                searchPage.primeCheckBox.click();
                break;
            case "Magnifying Glass Item":
                searchPage.searchItems.get(0).click();
                break;
            case "Add to Cart Button":
                itemPage.addToCartButton.click();
                break;
            case "Cart":
                itemPage.cartButton.click();
                break;
            case "Compare with similar items":
                cartPage.compareButton.click();
                break;
            case "Close Pop up Box":
                cartPage.closeCompareItemsPopUp.click();
                break;
            default:
                System.out.println("Invalid Button Name Error!!!");
        }
    }


    @Then("verify {string} in the search bar and {string} category are still selected")
    public void verifyInTheSearchBarAndCategoryAreStillSelected(String inputText, String category) {
        Assert.assertEquals(inputText, homePage.searchInput.getAttribute("value"));
        Assert.assertEquals(category, searchPage.searchDropdownBox.getText());



    }

    @Then("verify all items listed prime delivery only")
    public void verifyAllItemsListedPrimeDeliveryOnly() {
        int searchItemCount = searchPage.searchItems.size();
        int searchPrimeItemCount = searchPage.searchPrimeItems.size();
        Assert.assertEquals(searchPrimeItemCount, searchItemCount);
    }

    @Then("verify {string} displays {string}")
    public void verifyDisplays(String field, String value) {
        switch (field){
            case "Cart Confirmation Alert":
                Waiter.waitForVisibilityOfElement(driver, itemPage.addedToCartAlert, 5);
                Assert.assertEquals(value, itemPage.addedToCartAlert.getText());
                break;
            case "Quantity":
                Assert.assertEquals(value, cartPage.quantityNumber.getText());
                break;
            case "Compare with similar items":
                 Assert.assertEquals(value, String.valueOf(cartPage.compareItemsPopUp.isDisplayed()));
                break;
            default:
                System.out.println("Invalid Text Error!!!");
        }

    }
}
