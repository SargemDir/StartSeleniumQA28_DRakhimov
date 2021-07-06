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
    @Test
    public void homeLogin(){
        //open login form
        wd.findElement(By.cssSelector("[href='/login']")).click();
        WebElement email = wd.findElement(By.cssSelector("input[placeholder='Email']"));
        email.click();
        email.clear();
        email.sendKeys("anat@gmail.com");
        WebElement password = wd.findElement(By.cssSelector("input[placeholder='Password']"));
        password.click();
        password.clear();
        password.sendKeys("Aa12345$");
        wd.findElement(By.cssSelector("button:nth-child(4)")).click();
    }
    @Test
    public void findItaly(){
        wd.navigate().to("https://www.w3schools.com/css/css_table.asp");
        wd.findElement(By.cssSelector(".alt:last-child td:last-child"));
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
}
