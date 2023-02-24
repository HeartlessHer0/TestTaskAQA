package test;

import baseEntities.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BooksTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(BooksTest.class);

    @Test
    public void checkBooksTest() {
        int i;
        for (i = 0; i < titles.size(); i++) {
            Assert.assertTrue(booksTitleCheckingStep.openBooksPage(titles.get(i)).isPageOpened());
            logger.info("The book with the title " + titles.get(i) + " is on the page");
        }
    }
}
