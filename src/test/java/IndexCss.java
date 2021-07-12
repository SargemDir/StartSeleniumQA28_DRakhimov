import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IndexCss {
    WebDriver wd;
    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("file:///C:/Users/User/Downloads/IT/QA_manual/7.08_28A/index.html");
    }
    @Test
    public void itemTest(){
        WebElement item1 = wd.findElement(By.cssSelector("li:first-child"));
        item1.click();
        WebElement alert = wd.findElement(By.cssSelector("#alert"));
//        if (alert.getText().contains(item1.getText())){
//            System.out.println("Test passed");
//        }else {
//            System.out.println("Test failed");
//        }
        Assert.assertTrue(alert.getText().contains(item1.getText()));
    }
    @Test
    public void formTest(){
        WebElement name = wd.findElement(By.name("name"));
        name.click();
        name.clear();
        name.sendKeys("Hello");
        WebElement surename = wd.findElement(By.name("surename"));
        surename.click();
        surename.clear();
        surename.sendKeys("Hello");
        wd.findElement(By.cssSelector(".btn")).click();
        WebElement alert = wd.findElement(By.cssSelector("#alert"));
        Assert.assertTrue(alert.getText().contains("Hello Hello"));
    }
    @AfterMethod
    public void tearDown(){
        wd.close();
    }
}
