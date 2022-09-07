package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchInput;

    @FindBy(id = "searchDropdownBox")
    public WebElement selectedDropdownBox;

    @FindBy(id = "nav-search-submit-button")
    public WebElement searchSubmitButton;

}
