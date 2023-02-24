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

    @Test
    public void successLoginTest() {
        logger.info("Success Login test is started");
        Assert.assertTrue(loginStep.successLogin(ReadProperties.username(),ReadProperties.password()).isPageOpened());
        logger.info("Success Login test is passed");
    }
    @Test
    public void incorrectUsernameLoginTest() {
        logger.info("Incorrect Username Login test is started");
        Assert.assertTrue(
                loginStep.incorrectLogin(
                        ReadProperties.browserName(), ReadProperties.password()).getInvalidUsernameOrPasswordMessageElement().isDisplayed());
        logger.info("Incorrect Username Login test is passed");
    }
    @Test
    public void incorrectPasswordLoginTest() {
        logger.info("Incorrect Username Login test is started");
        Assert.assertTrue(
                loginStep.incorrectLogin(
                        ReadProperties.username(), ReadProperties.username()).getInvalidUsernameOrPasswordMessageElement().isDisplayed());
        logger.info("Incorrect Username Login test is passed");
    }

    @Test
    public void usernameIsNullLoginTest() {
        logger.info("Login without Username Test is started");
        Assert.assertTrue(
                loginStep.loginWithoutUsername( "", ReadProperties.password()).getUsernameIsNullElement().isDisplayed());
        logger.info("Login without Username Test is passed");
    }
    @Test
    public void passwordIsNullLoginTest() {
        logger.info("Login without Password Test is started");
        Assert.assertTrue(
                loginStep.loginWithoutPassword( ReadProperties.username(), "").getPasswordIsNullElement().isDisplayed());
        logger.info("Login without Password Test is passed");
    }
    @Test
    public void passwordAndUsernameIsNullLoginTest() {
        logger.info("Login without Username and Password Test is started");
        Assert.assertTrue(
                loginStep.loginWithoutUsernameAndPassword().getPasswordIsNullElement().isDisplayed());
        logger.info("Login without Username and Password Test is passed");
    }
}