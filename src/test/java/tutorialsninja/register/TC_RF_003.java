package tutorialsninja.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class TC_RF_003 {

    @Test
    public void verifyRegisterBySubscribingToNewsletter() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");

        driver.findElement(By.xpath("//a[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.id("input-firstname")).sendKeys("Thinh");
        driver.findElement(By.id("input-lastname")).sendKeys("Tran");
        driver.findElement(By.id("input-email")).sendKeys(generateEmail());
        driver.findElement(By.id("input-telephone")).sendKeys("123456789");
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.id("input-confirm")).sendKeys("12345");
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        driver.findElement(By.linkText("Continue")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Subscribe')]")).click();
        driver.findElement(By.xpath("//input[@name=\"newsletter\"][@value=1]")).click();
        driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();

        String expectedAlert = "Success: Your newsletter subscription has been successfully updated!";
        String actualAlert = driver.findElement(By.xpath("//div[contains(@class, 'alert-success')]")).getText();
        Assert.assertEquals(expectedAlert,actualAlert);
    }

    public String generateEmail(){
        String dateString = new Date().toString();
        String noSpaceString = dateString.replaceAll("\\s", "");
        String noSpaceAndnoColonsString = noSpaceString.replaceAll(":","");
        return noSpaceAndnoColonsString+"@gmail.com";
    }
}
