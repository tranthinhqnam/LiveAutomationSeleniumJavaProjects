package tutorialsninja.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_RF_002 {
    @Test
    public void verifyRegisterWithoutFillingFields(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//a[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        String expectedFirstNameWarning = "First Name must be between 1 and 32 characters!";
        String expectedLastNameWarning = "Last Name must be between 1 and 32 characters!";
        String expectedEmailWarning = "E-Mail Address does not appear to be valid!";
        String expectedTelephoneWarning = "Telephone must be between 3 and 32 characters!";
        String expectedPasswordWarning = "Password must be between 4 and 20 characters!";
        String expectedPrivacyPolicyWarning = "Warning: You must agree to the Privacy Policy!";

        String actualFirstNameWarning = driver.findElement(By.xpath("//input[@id=\"input-firstname\"]/following-sibling::div")).getText();
        String actualLastNameWarning = driver.findElement(By.xpath("//input[@id=\"input-lastname\"]/following-sibling::div")).getText();
        String actualEmailWarning = driver.findElement(By.xpath("//input[@id=\"input-email\"]/following-sibling::div")).getText();
        String actualTelephoneWarning = driver.findElement(By.xpath("//input[@id=\"input-telephone\"]/following-sibling::div")).getText();
        String actualPasswordWarning = driver.findElement(By.xpath("//input[@id=\"input-password\"]/following-sibling::div")).getText();
        String actualPrivacyPolicyWarning = driver.findElement(By.xpath("//div[contains(@class,'alert')]")).getText();

        Assert.assertEquals(expectedFirstNameWarning,actualFirstNameWarning);
        Assert.assertEquals(expectedLastNameWarning,actualLastNameWarning);
        Assert.assertEquals(expectedEmailWarning,actualEmailWarning);
        Assert.assertEquals(expectedTelephoneWarning,actualTelephoneWarning);
        Assert.assertEquals(expectedPasswordWarning,actualPasswordWarning);
        Assert.assertEquals(expectedPrivacyPolicyWarning,actualPrivacyPolicyWarning);
        driver.quit();
    }
}
