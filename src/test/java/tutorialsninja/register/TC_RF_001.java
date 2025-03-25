package tutorialsninja.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class TC_RF_001 {

    @Test
        public void verifyRegisterWithMandatoryFields() {

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

        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());

        String expectedHeading = "Your Account Has Been Created!";
        String actualHeading = driver.findElement(By.xpath("//div[@id='content']//h1")).getText();
        Assert.assertEquals(actualHeading,expectedHeading);

        String properDetailOne = "Congratulations! Your new account has been successfully created!";
        String properDetailTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
        String properDetailThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
        String properDetailFour = "contact us.";

        String expectedContentDetail = driver.findElement(By.id("content")).getText();
        Assert.assertTrue(expectedContentDetail.contains(properDetailOne));
        Assert.assertTrue(expectedContentDetail.contains(properDetailTwo));
        Assert.assertTrue(expectedContentDetail.contains(properDetailThree));
        Assert.assertTrue(expectedContentDetail.contains(properDetailFour));

        driver.findElement(By.xpath("//a[text()=\"Continue\"]")).click();
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
        driver.quit();
    }

    public String generateEmail(){
        String dateString = new Date().toString();
        String noSpaceString = dateString.replaceAll("\\s", "");
        String noSpaceAndnoColonsString = noSpaceString.replaceAll(":","");
        return noSpaceAndnoColonsString+"@gmail.com";
    }
}
