package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import steps.LoginStep;
import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(LoginStep.class);

    @Test(priority = 1)
    public void successLoginTest() {
        logger.info("Success Login test is started");
        Assert.assertTrue(loginStep.successLogin(user.getString("userName"),ReadProperties.password()).isPageOpened());
        logger.info("Success Login test is passed");
    }
    @Test(priority = 2)
    public void incorrectUsernameLoginTest() {
        logger.info("Incorrect Username Login test is started");
        Assert.assertTrue(
                loginStep.incorrectLogin(
                        ReadProperties.browserName(), ReadProperties.password()).getInvalidUsernameOrPasswordMessageElement().isDisplayed());
        logger.info("Incorrect Username Login test is passed");
    }
    @Test(priority = 3)
    public void incorrectPasswordLoginTest() {
        logger.info("Incorrect Username Login test is started");
        Assert.assertTrue(
                loginStep.incorrectLogin(
                        user.getString("userName"), ReadProperties.username()).getInvalidUsernameOrPasswordMessageElement().isDisplayed());
        logger.info("Incorrect Username Login test is passed");
    }

    @Test(priority = 4)
    public void usernameIsNullLoginTest() {
        logger.info("Login without Username Test is started");
        Assert.assertTrue(
                loginStep.loginWithoutUsername( "", ReadProperties.password()).getUsernameIsNullElement().isDisplayed());
        logger.info("Login without Username Test is passed");
    }
    @Test(priority = 5)
    public void passwordIsNullLoginTest() {
        logger.info("Login without Password Test is started");
        Assert.assertTrue(
                loginStep.loginWithoutPassword( user.getString("userName"), "").getPasswordIsNullElement().isDisplayed());
        logger.info("Login without Password Test is passed");
    }
    @Test(priority = 6)
    public void passwordAndUsernameIsNullLoginTest() {
        logger.info("Login without Username and Password Test is started");
        Assert.assertTrue(
                loginStep.loginWithoutUsernameAndPassword().getPasswordIsNullElement().isDisplayed());
        logger.info("Login without Username and Password Test is passed");
    }
}