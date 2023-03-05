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
    public void addToWishlistTestfromVIP(){

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-6 > a")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > a")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > ul.add-to-links > li:nth-child(1) > a")).click();
        driver.findElement(By.id("email")).sendKeys("simina.dranca@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("654321");
        driver.findElement(By.id("send2")).click();
        //driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-6 > a")).click();
        //driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > a")).click();
        //driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > ul.add-to-links > li:nth-child(1) > a")).click();


        WebElement wishlistTextElement = driver.findElement(By.cssSelector("#item_1278 > td.wishlist-cell1.customer-wishlist-item-info > h3 > a"));

        String expectedText = "LEXINGTON CARDIGAN SWEATER";
        String actualText = wishlistTextElement.getText();

        if (actualText.equals(expectedText)) {
            System.out.println("Adăugat cu succes în wishlist-ul tău!");
        } else
            System.err.println("Produsul nu se află în wishlist-ul tău!");

    }
}
