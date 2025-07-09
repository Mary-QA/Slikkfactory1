package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(css = "header .main-nav__login")
    private WebElement loginButton;

    @FindBy(css = ".main-screen__title")
    private WebElement mainTitle;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMainTitleDisplayed() {
        return mainTitle.isDisplayed();
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}