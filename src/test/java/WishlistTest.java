import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*Adăugati un test(o noua metoda) prin care să deschideți homepage-ul site-ului, apoi să navigați la categoria "Sale",
 apoi să deschideți pagina de detalii a primului produs și să încercați să îl adăugați în WishList, apăsând butonul
  Add to Wishlist. Pe viitor, după ce veți învăța să faceți și verificări, veți putea reveni pentru a vă asigura că
  adăugarea în wishlist poate fi realizată doar de utilizatorii autentificați. Apelati metoda aceasta in metoda main
  pentru a rula testul.*/
public class WishlistTest {
    private WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }
        @Test
        public void addToWishlistTestfromVIP(){


            driver.findElement(By.cssSelector("a[href*=\"#header-nav\"]")).click();
            driver.findElement(By.cssSelector("li[class*=\"level0 nav-6\"]")).click();
            driver.findElement(By.cssSelector("a[class*=\"wish\"]")).click();
            driver.findElement(By.id("email")).sendKeys("simina.dranca@yahoo.com");
            driver.findElement(By.id("pass")).sendKeys("654321");
            driver.findElement(By.id("send2")).click();

            WebElement wishlistTextElement = driver.findElement(By.cssSelector("#item_1278 > td.wishlist-cell1.customer-wishlist-item-info > h3 > a"));

            String expectedText = "LEXINGTON CARDIGAN SWEAER";
            String actualText = wishlistTextElement.getText();
            Assert.assertEquals(expectedText,actualText);

            /*if (actualText.equals(expectedText)) {
                System.out.println("Adăugat cu succes în wishlist-ul tău!");
            } else
                System.err.println("Produsul nu se află în wishlist-ul tău!");*/

        }

        @After
        public void quit()
        {
            driver.close();
        }
    }
