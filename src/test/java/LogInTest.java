import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogInTest {
    private WebDriver driver;
    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver=new ChromeDriver();


        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }


    @Test
    public void LogInWithValidData() {



        driver.findElement(By.cssSelector("[data-target-element~=\"#header-account\"]")).click();
        driver.findElement(By.cssSelector("a[title*=\"Log In\"]")).click();
        driver.findElement(By.id("email")).sendKeys("simina.dranca@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("654321");
        driver.findElement(By.id("send2")).click();

        WebElement welcomeTextElement = driver.findElement(By.cssSelector("p strong"));

        String expectedText = "Hello, Dranca Anca Simina!";
        String actualText = welcomeTextElement.getText();

        /*if (actualText.equals(expectedText)) {
            System.out.println("Logat cu succes!");         Inlocuit de ASSERT din JUnit
        } else
            System.err.println("Logare eșuată");*/


        Assert.assertEquals(expectedText, actualText);
        //verifica daca cele doua variabile, definite anterior sunt egale. Rezultatul assert-ului,
        // daca este TRUE, nu "spune" nimic, inseamna ca s-a rulat cu succes. Daca variabilele
        // NU SUNT egale, arata un mesaj de eroare, testul cade si zice exact de ce a cazut in consola - link

        Assert.assertTrue(actualText.equals(expectedText));
        //verifica daca e adevarata conditia. Daca e adevarata testul trece, daca e falsa testul cade. DAR
        //in caz ca nu este TRUE doar specifica ca a cazut dar nu indica de ce anume a cazut testul

        WebElement myAccount = driver.findElement(By.cssSelector("div[class*=\"block-a\"] "));
        Assert.assertTrue(myAccount.isDisplayed());//verifica daca elementul MyAccount din dashboard e afisat ->(logare cu succes)
        //metoda returneaza TRUE sau FALSE
        //rezultatul - displayed, testul trece
        //rezultatul - not displyed, testul cade
        //RECOMANDAT la verificarea daca pretul produsului din catalog coincide cu cel din cos, cantitatea...



    }
    @After
    public void quit(){
        driver.close();
    }
}
