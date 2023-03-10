package steps;

import baseEntities.BaseStep;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProfilePage;
import test.BooksTest;

public class LoginStep extends BaseStep {
    private static final Logger logger = LogManager.getLogger(LoginStep.class);

    public LoginStep(WebDriver driver) {
        super(driver);
    }
    public ProfilePage successLogin(String username, String password){
        login(username, password);
        return profilePage;
    }
    public LoginPage incorrectLogin(String username, String password){
        login(username, password);
        return loginPage;
    }
    public LoginPage loginWithoutUsername(String username, String password){
        login(username, password);
        return loginPage;
    }
    public LoginPage loginWithoutPassword(String username,String password){
        login(username, password);
        return loginPage;
    }
    private void login(String username, String password){
        driver.get(loginPage.getLoginPageURL());
        logger.info("Login Page is opened");
        loginPage.getUsernameInput().sendKeys(username);
        loginPage.getPswInput().sendKeys(password);
        loginPage.getLoginButton().click();
    }
    public LoginPage loginWithoutUsernameAndPassword(){
        driver.get(loginPage.getLoginPageURL());
        loginPage.getLoginButton().click();
        return loginPage;

    }
}
