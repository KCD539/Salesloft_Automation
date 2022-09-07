package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.HomePage;
import pages.ItemPage;
import pages.SearchPage;
import utils.Driver;

public class Hooks {

   public static WebDriver driver;
   public static HomePage homePage;
   public static SearchPage searchPage;
   public static ItemPage itemPage;

   public static CartPage cartPage;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        itemPage = new ItemPage(driver);
        cartPage = new CartPage(driver);

    }

    @After
    public void teardown(Scenario scenario){
        System.out.println("Scenario = " + scenario.getName() + "\nStatus = " +  scenario.getStatus());
        try{
            if(scenario.isFailed()){
                byte[] screenshot = ((TakesScreenshot)Driver.getDriver())
                        .getScreenshotAs(OutputType.BYTES);

                scenario.embed(screenshot, "image/png");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            Driver.quitDriver();
        }
    }
}