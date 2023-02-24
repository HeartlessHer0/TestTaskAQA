package baseEntities;

import org.openqa.selenium.WebDriver;
import pages.*;

public class BaseStep {
    protected WebDriver driver;
    protected BooksPage booksPage;
    protected LoginPage loginPage;
    protected ProfilePage profilePage;


    public BaseStep(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        booksPage = new BooksPage(driver);
        profilePage= new ProfilePage(driver);
    }
}
