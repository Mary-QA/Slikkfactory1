package tests;

import org.junit.jupiter.api.*;
import pages.*;
import utils.*;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.*;

public class SocialLinksTests {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.createDriver();
        mainPage = new MainPage(driver);
        driver.get(TestData.BASE_URL);
    }

    @Test
    @DisplayName("Проверка ссылки на VK")
    public void testVkLink() {
        String originalWindow = driver.getWindowHandle();
        SocialPage socialPage = mainPage.clickVkLink();

        assertAll(
                () -> assertEquals(2, driver.getWindowHandles().size(), "Должно открыться новое окно"),
                () -> assertTrue(socialPage.isVkPageOpened(), "Должна открыться страница VK")
        );

        driver.switchTo().window(originalWindow);
    }

    @Test
    @DisplayName("Проверка ссылки на Telegram")
    public void testTelegramLink() {
        String originalWindow = driver.getWindowHandle();
        SocialPage socialPage = mainPage.clickTelegramLink();

        assertAll(
                () -> assertEquals(2, driver.getWindowHandles().size(), "Должно открыться новое окно"),
                () -> assertTrue(socialPage.isTelegramPageOpened(), "Должна открыться страница Telegram")
        );

        driver.switchTo().window(originalWindow);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}