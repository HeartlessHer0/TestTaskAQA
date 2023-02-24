package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private String loginPageURL = "https://demoqa.com/login";

    private By emailInputLocator = By.xpath("//*[@id='userName']");
    private By pswInputLocator = By.xpath("//*[@id='password']");
    private By logInSubmitButtonLocator = By.xpath("//*[@id='login']");
    private By usernameIsNullTextLocator = By.xpath("//*[@class='mr-sm-2 is-invalid form-control' and @id='userName']");
    private By passwordIsNullTextLocator = By.xpath("//*[@class='mr-sm-2 is-invalid form-control' and @id='password']");
    private By invalidUsernameOrPasswordLocator = By.xpath("//p[contains(text(), 'Invalid username or password!')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return emailInputLocator;
    }

    public String getLoginPageURL() {
        return loginPageURL;
    }

    public WebElement getUsernameInput() {
        return waitsService.waitForVisibilityLocatedBy(emailInputLocator);
    }

    public WebElement getPswInput() {
        return waitsService.waitForVisibilityLocatedBy(pswInputLocator);
    }

    public WebElement getLoginButton() {
        return waitsService.waitForVisibilityLocatedBy(logInSubmitButtonLocator);
    }

    public WebElement getPasswordIsNullElement() {
        return waitsService.waitForVisibilityLocatedBy(passwordIsNullTextLocator);
    }

    public WebElement getUsernameIsNullElement() {
        return waitsService.waitForVisibilityLocatedBy(usernameIsNullTextLocator);
    }

    public WebElement getInvalidUsernameOrPasswordMessageElement () {
        return waitsService.waitForVisibilityLocatedBy(invalidUsernameOrPasswordLocator);
    }
}
