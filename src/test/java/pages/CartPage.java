package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    public CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='a-dropdown-prompt']")
    public WebElement quantityNumber;

    @FindBy(xpath = "//input[@value='Compare with similar items']")
    public WebElement compareButton;

    @FindBy(xpath = "//div[@class='a-popover-wrapper']")
    public WebElement compareItemsPopUp;

    @FindBy(xpath = "//button[@class=' a-button-close a-declarative a-button-top-right']")
    public WebElement closeCompareItemsPopUp;





}
