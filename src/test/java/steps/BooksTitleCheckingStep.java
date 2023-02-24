package steps;

import baseEntities.BaseStep;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.BooksPage;


public class BooksTitleCheckingStep extends BaseStep {

    private static final Logger logger = LogManager.getLogger(BooksTitleCheckingStep.class);
    public BooksTitleCheckingStep(WebDriver driver) {
        super(driver);
    }
    public BooksPage openBooksPage(String bookName){
        driver.get(booksPage.getBooksPageURL());
        logger.info("Books page is opened");
        booksPage.getBookTitle(bookName);
        return booksPage;
    }

}
