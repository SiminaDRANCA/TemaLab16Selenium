import io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;

public class Main {
    public static void main(String[] args) {

       // LogInTest logInTest = new LogInTest();
        // logInTest.LogInWithValidData();

       //WishlistTest wishlistCreator = new WishlistTest();
        //wishlistCreator.addToWishlistTestfromVIP();

        RegisterTest registration = new RegisterTest();
        registration.enrollNewUser();




    }
}
