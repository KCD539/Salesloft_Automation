Feature: Salesloft Validation and Automation

  Background:
    Given user navigates to "https://www.amazon.com/"
    Then user should see the title "Amazon.com. Spend less. Smile more."

@salesloft
  Scenario: Section A.1
    When user types in "Search" input box "Magnifying Glass"
    Then user should select "Industrial & Scientific" category from "SearchDropdown" dropdown
    Then user should click "Search Button"
    Then verify "Magnifying Glass" in the search bar and "Industrial & Scientific" category are still selected
    Then user should click "Prime Checkbox" 
    Then verify all items listed prime delivery only
    Then user should click "Magnifying Glass Item"
    Then user should select "7" category from "Quantity" dropdown
    Then user should click "Add to Cart Button"
    Then verify "Cart Confirmation Alert" displays "Added to Cart"
    Then user should click "Cart"
    Then verify "Quantity" displays "7"
    Then user should click "Compare with similar items"
    Then verify "Compare with similar items" displays "true"
    Then user should click "Close Pop up Box"
  
  @fail
  Scenario: Section A.2 Intentional Fail
    When user types in "Search" input box " "
    Then user should select "All Departments" category from "SearchDropDown" dropdown
    Then user should click "Search Button"
    Then user should click "Magnifying Glass Item"
    Then user should click "Add to Cart Button"
    # IndexOutOfBoundsException due to search not navigating to located "magnifying class item"
    # validating blank search will not navigate user to product page
    # user remains on homepage after blank search input and clicked search button
   # failed report target > cucumber-reports > index.html (includes screenshot)




    
