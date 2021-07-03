import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTest {
    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
    }

    @Test
    public void aboutHome() {
        List<WebElement> elements = wd.findElements(By.tagName("a"));
        WebElement about = elements.get(1);
        about.click();
        WebElement home = elements.get(0);
        home.click();
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
}
