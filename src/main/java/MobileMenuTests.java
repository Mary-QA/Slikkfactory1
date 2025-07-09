package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.*;
import static org.junit.jupiter.api.Assertions.*;

public class MobileMenuTests {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.createMobileDriver(); // Специальный метод для мобильного вида
        mainPage = new MainPage(driver);
        driver.get(TestData.BASE_URL);
    }

    @Test
    @DisplayName("Открытие мобильного меню")
    public void testMobileMenuOpen() {
        MobileMenu menu = mainPage.openMobileMenu();
        assertTrue(menu.isMenuDisplayed(), "Меню должно отображаться");
    }

    @Test
    @DisplayName("Навигация через мобильное меню")
    public void testMobileMenuNavigation() {
        CoursesPage coursesPage = mainPage.openMobileMenu()
                .selectMenuItem("Курсы");
        assertTrue(coursesPage.isPageLoaded(), "Должна загрузиться страница курсов");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}