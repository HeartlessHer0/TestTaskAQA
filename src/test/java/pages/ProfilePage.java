package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage extends BasePage {

    private String profilePageURL = "https://demoqa.com/profile";

    private By userNameLocator = By.xpath("//*[@id='userName-value']");
    private By logoutButtonLocator = By.xpath("//*[@id='userName-value']/following-sibling::button");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return logoutButtonLocator;
    }

    public String getProfilePageURL() {
        return profilePageURL;
    }

    public WebElement getUsername() {
        return waitsService.waitForVisibilityLocatedBy(userNameLocator);
    }

    public WebElement getLogoutButton() {
        return waitsService.waitForVisibilityLocatedBy(logoutButtonLocator);
    }

}