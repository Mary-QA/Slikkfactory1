package tests;

import org.junit.jupiter.api.*;
import pages.*;
import utils.*;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.*;

public class AuthTests {
    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.createDriver();
        mainPage = new MainPage(driver);
        driver.get(TestData.BASE_URL);
    }

    @Test
    @DisplayName("Попытка входа с неверными данными")
    public void testInvalidLogin() {
        loginPage = mainPage.clickLoginButton()
                .enterEmail("wrong@example.com")
                .enterPassword("wrongpass")
                .submitForm();

        assertTrue(loginPage.isErrorDisplayed(), "Должно отображаться сообщение об ошибке");
    }

    @Test
    @DisplayName("Восстановление пароля")
    public void testPasswordRecovery() {
        PasswordRecoveryPage recoveryPage = mainPage.clickLoginButton()
                .clickForgotPassword()
                .enterEmail("user@example.com")
                .submitRecovery();

        assertTrue(recoveryPage.isSuccessMessageDisplayed(), "Должно отображаться сообщение о восстановлении");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}