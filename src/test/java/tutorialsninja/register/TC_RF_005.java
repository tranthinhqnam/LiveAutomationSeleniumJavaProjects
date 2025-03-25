package tutorialsninja.register;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TC_RF_005 {

    @Test
    public void verifyRegisterUsingInvalidEmail() throws InterruptedException, IOException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");

        driver.findElement(By.xpath("//a[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.id("input-firstname")).sendKeys("Thinh");
        driver.findElement(By.id("input-lastname")).sendKeys("Tran");
        driver.findElement(By.id("input-email")).sendKeys("tranthinh@gmail");
        driver.findElement(By.id("input-telephone")).sendKeys("123456789");
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.id("input-confirm")).sendKeys("12345");
        driver.findElement(By.name("agree")).click();

        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        Thread.sleep(3000);
        File srcScreenshot1 = driver.findElement(By.xpath("//form[@class='form-horizontal']")).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(srcScreenshot1, new File(System.getProperty("user.dir") + "/Screenshots/sc1Actual.png"));

        BufferedImage actualImg= ImageIO.read(new File(System.getProperty("user.dir")+ "/Screenshots/sc1Actual.png" ));
        BufferedImage expectedIMG = ImageIO.read( new File(System.getProperty("user.dir")+"/Screenshots/sc1Expected.png"));

        ImageDiffer imgDiffer = new ImageDiffer();
        ImageDiff imgDifference = imgDiffer.makeDiff(expectedIMG,actualImg);
        boolean b = imgDifference.hasDiff();
        System.out.println(b);
        driver.quit();

    }
}
