package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {
    public SearchPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "nav-search-label-id")
    public WebElement searchDropdownBox;


    @FindBy(xpath = "//span[text() = 'Free Shipping by Amazon']")
    public WebElement primeCheckBox;

    @FindBy(xpath= "//div[@data-component-type='s-search-result']")
    public List<WebElement> searchItems;

    @FindBy(xpath= "//div[@data-component-type='s-search-result']//i[contains(concat(' ', normalize-space(@class), ' '), ' a-icon-prime ')]")
    public List<WebElement> searchPrimeItems;


}
