package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage {
    public ItemPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "quantity")
    public WebElement quantityDropdown;

    @FindBy(id="add-to-cart-button")
    public WebElement addToCartButton;

    @FindBy(id= "attachDisplayAddBaseAlert")
    public WebElement addedToCartAlert;


    @FindBy(xpath= "//form[@id='attach-view-cart-button-form']//input")
    public WebElement cartButton;







}
