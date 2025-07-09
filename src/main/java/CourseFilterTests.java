package tests;

import org.junit.jupiter.api.*;
import pages.*;
import utils.*;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.*;

public class CourseFilterTests {
    private WebDriver driver;
    private CoursesPage coursesPage;

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.createDriver();
        coursesPage = new CoursesPage(driver);
        driver.get(TestData.BASE_URL + "/courses");
    }

    @Test
    @DisplayName("Фильтрация курсов по направлению 'Программирование'")
    public void testFilterByProgramming() {
        int initialCount = coursesPage.getCoursesCount();
        coursesPage.applyFilter("Программирование");
        int filteredCount = coursesPage.getCoursesCount();

        assertAll(
                () -> assertTrue(filteredCount > 0, "Должны отображаться курсы"),
                () -> assertTrue(filteredCount < initialCount, "Количество должно уменьшиться")
        );
    }

    @Test
    @DisplayName("Сброс фильтров")
    public void testResetFilters() {
        int initialCount = coursesPage.getCoursesCount();
        coursesPage.applyFilter("Программирование")
                .resetFilters();

        assertEquals(initialCount, coursesPage.getCoursesCount(), "Количество должно вернуться к исходному");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}