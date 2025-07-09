package tests;

import org.junit.jupiter.api.*;
import pages.*;
import utils.*;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.*;

public class FormTests {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.createDriver();
        mainPage = new MainPage(driver);
        driver.get(TestData.BASE_URL);
    }

    @Test
    @DisplayName("Проверка формы 'Получить консультацию'")
    public void testConsultationForm() {
        ConsultationForm form = mainPage.openConsultationForm();
        form.enterName("Тест Тестович")
                .enterEmail("test@example.com")
                .enterPhone("+79991234567");

        assertFalse(form.isSubmitEnabled(), "Кнопка должна быть неактивна до согласия");
        form.acceptPolicy();
        assertTrue(form.isSubmitEnabled(), "Кнопка должна стать активной");
    }

    @Test
    @DisplayName("Валидация email в форме")
    public void testEmailValidation() {
        ConsultationForm form = mainPage.openConsultationForm();
        form.enterEmail("invalid-email");
        form.acceptPolicy();

        assertTrue(form.isEmailErrorDisplayed(), "Должна отображаться ошибка валидации");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}