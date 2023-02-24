package baseEntities;


import configuration.Endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.testng.annotations.*;
import steps.LoginStep;
import steps.BooksTitleCheckingStep;
import configuration.ReadProperties;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import services.BrowsersService;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {

    protected WebDriver driver;
    protected LoginStep loginStep;
    protected BooksTitleCheckingStep booksTitleCheckingStep;
    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    public List<String> titles = new ArrayList<>();

    protected JSONObject user = new JSONObject();

    String RandomString = RandomStringUtils.randomAlphabetic(10);

    @BeforeTest
    public void addUser() {
        user.put("userName",RandomString);
        user.put("password", ReadProperties.password());
        logger.info("User Generated");

        RestAssured.given().
                header("Content-Type", "application/json")
                .body(user.toString())
                .when()
                .post(ReadProperties.getUrl()+Endpoints.ADD_USER)
                .then()
                .log().all()
                .statusCode(201);
        logger.info("User with username: "+user.get("userName") +" is added");
    }
   @BeforeSuite
    public void bookTitles() {
       JsonPath books = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when()
                .get(ReadProperties.getUrl()+Endpoints.GET_BOOKS)
                .getBody()
                .jsonPath();
        logger.info("JSON body with Books added");
        titles = books.get("books.title");
        logger.info("Book titles added to the List");
    }

  @BeforeMethod
    public void setup() {
        driver = new BrowsersService().getDriver();

        logger.info("WebDriver initialized");

        loginStep = new LoginStep(driver);

        booksTitleCheckingStep = new BooksTitleCheckingStep(driver);

    }

 @AfterMethod
    public void tearDown() {
        Allure.getLifecycle().addAttachment(
                "screenshot", "image/png", "png",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)
        );
        logger.info("Screenshot taken");
        driver.quit();
    }
}