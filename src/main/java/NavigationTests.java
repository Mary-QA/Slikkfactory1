package tests;

import org.junit.jupiter.api.*;
import pages.*;
import utils.*;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.*;

public class NavigationTests {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.createDriver();
        mainPage = new MainPage(driver);
        driver.get(TestData.BASE_URL);
    }

    @Test
    @DisplayName("Переход на страницу 'Все курсы'")
    public void testNavigateToCourses() {
        CoursesPage coursesPage = mainPage.navigateToCourses();
        assertTrue(coursesPage.getCoursesCount() >= TestData.MIN_EXPECTED_COURSES);
    }

    @Test
    @DisplayName("Переход на страницу 'Контакты'")
    public void testNavigateToContacts() {
        ContactsPage contactsPage = mainPage.navigateToContacts();
        assertTrue(contactsPage.isMapDisplayed());
    }
}