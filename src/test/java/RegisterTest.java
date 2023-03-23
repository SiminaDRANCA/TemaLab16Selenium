import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
    private WebDriver driver;
    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver=new ChromeDriver();


        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");}


    @Test
    public void enrollNewUser() {

        driver.findElement(By.cssSelector("a[class*=\"skip-a\"]")).click();
        driver.findElement(By.cssSelector("a[title*=\"Reg\"]")).click();
        driver.findElement(By.id("firstname")).sendKeys("Dranca");
        driver.findElement(By.id("middlename")).sendKeys("FirstBorn");
        driver.findElement(By.id("lastname")).sendKeys("Liza");
        driver.findElement(By.id("email_address")).sendKeys("liza@meowmeow.com");
        driver.findElement(By.id("password")).sendKeys("Boabe51Lapte");
        driver.findElement(By.id("confirmation")).sendKeys("Boabe51Lapte");
        driver.findElement(By.id("is_subscribed")).click();
        //driver.findElement(By.cssSelector("button[title*=\"Reg\"]"")).click();
    }
    @Test

        public void enrollRegisteredUser() {
            driver.findElement(By.cssSelector("a[class*=\"skip-a\"]")).click();
            driver.findElement(By.cssSelector("a[title*=\"Reg\"]")).click();
            driver.findElement(By.id("firstname")).sendKeys("Dranca");
            driver.findElement(By.id("middlename")).sendKeys("FirstBorn");
            driver.findElement(By.id("lastname")).sendKeys("Liza");
            driver.findElement(By.id("email_address")).sendKeys("liza@miowmiow.com");
            driver.findElement(By.id("password")).sendKeys("Boabe51Lapte");
            driver.findElement(By.id("confirmation")).sendKeys("Boabe51Lapte");
            driver.findElement(By.id("is_subscribed")).click();
            driver.findElement(By.cssSelector("button[title*=\"Reg\"]")).click();

            WebElement alreadyRegistered = driver.findElement(By.cssSelector("li[class*=er]"));

            String expectedText = "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.";
            String actualText = alreadyRegistered.getText();

            Assert.assertEquals(actualText, expectedText);

        }


    @After
    public void quit(){
        driver.close();
    }
}
