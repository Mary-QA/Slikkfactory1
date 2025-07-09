package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CoursesPage extends BasePage {
    @FindBy(css = ".courses__item")
    private List<WebElement> courseItems;

    public CoursesPage(WebDriver driver) {
        super(driver);
    }

    public int getCoursesCount() {
        return courseItems.size();
    }
}