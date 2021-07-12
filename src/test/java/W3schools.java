import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class W3schools {
    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://www.w3schools.com/css/css_table.asp");
    }

    @Test
    public void w3schoolsTest() {
        List<WebElement> rows = wd.findElements(By.cssSelector("tr"));
        System.out.println("Number of rows: " + rows.size());
        List<WebElement> columns = wd.findElements(By.cssSelector("tr:first-child th"));
        System.out.println("Number of columns: " + columns.size());
        List<WebElement> row3 = wd.findElements(By.cssSelector("tr:nth-child(3)"));
        for (WebElement i : row3){
            System.out.println(i.getText());
        }
        List<WebElement> lastColumns = wd.findElements(By.cssSelector("tr :last-child"));
        for (WebElement i : lastColumns){
            System.out.println(i.getText());
        }
        WebElement maria = wd.findElement(By.cssSelector("tr:nth-child(2) td:nth-child(2)"));
        System.out.println(maria.getText());
    }

    @AfterMethod
    public void tearDown() {
        wd.close();
    }
}
