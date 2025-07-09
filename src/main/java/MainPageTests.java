package tests;

import org.junit.jupiter.api.*;
import pages.MainPage;
import utils.TestData;
import utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.*;

public class MainPageTests {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.createDriver();
        mainPage = new MainPage(driver);
        driver.get(TestData.BASE_URL);
    }

    @Test
    @DisplayName("Проверка заголовка страницы")
    public void testPageTitle() {
        assertEquals(TestData.EXPECTED_TITLE, driver.getTitle());
    }

    @Test
    @DisplayName("Проверка видимости основного заголовка")
    public void testMainTitleVisibility() {
        assertTrue(mainPage.isMainTitleDisplayed());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}