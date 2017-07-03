import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Task30LoginToRmsysTest {

    private  WebDriver driver;

    @Test
    public void fillingLoginFormAndLogin() {

        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://192.168.100.26/");

        WebElement usernameField = driver.findElement(By.xpath("//*[@id='Username']"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id='Password']"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='SubmitButton']"));

        usernameField.sendKeys("EugenBorisik");
        passwordField.sendKeys("qwerty12345");
        loginButton.click();

        WebElement nameDiv = driver.findElement(By.xpath("//*[@id='name']"));

        Assert.assertEquals(nameDiv.getText(), "Borisik, Eugen");
        driver.quit();
    }
}
