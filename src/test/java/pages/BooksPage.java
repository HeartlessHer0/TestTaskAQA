package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BooksPage extends BasePage {

    private String booksPageURL = "https://demoqa.com/books";

    private String bookTitleLocator = "//div[@role='rowgroup']//span[@id=\"see-book-Replace\"]"; //подставлять title
    private By searchBoxLocator = By.xpath("//*[@id='searchBox']");

    public BooksPage(WebDriver driver) {
        super(driver);
    }
    @Override
    protected By getPageIdentifier() {
        return searchBoxLocator;
    }

    public String getBooksPageURL() {
        return booksPageURL;
    }
    public WebElement getBookTitle(String title) {
        return waitsService.waitForPresenceOfElement(By.xpath(bookTitleLocator.replace("Replace", title)));
    }

}
