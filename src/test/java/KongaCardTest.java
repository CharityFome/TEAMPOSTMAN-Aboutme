//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import java.time.Duration;
//import java.util.concurrent.TimeUnit;
//
//public class KongaCardTest {
//    private WebDriver driver;
//
//    @BeforeTest
//    public void startChrome() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.get("https://www.konga.com/");
//        Thread.sleep(5000);
//
//
//        //1. Open your chrome browser
//        driver = new ChromeDriver();
//        //2. maximize the window
//        driver.manage().window().maximize();
//        //3. Visit the URL Konga
//        driver.get("https://www.konga.com/");
//        //wait Globally for full loading
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50000));
//        Thread.sleep(10000);
//        //4. Sign in to Konga
//        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
//
//    }
//       @Test(priority = 0)
//       public void signIn () {
//       //5. Locate the username field and input the username
//        driver.findElement(By.id("username")).sendKeys("enifome@mailinator.com");
//       //7. Locate the password field and input your password on the password field
//        driver.findElement(By.id("pasasword")).sendKeys("Password6$");
//       //8. Click on Login
//        driver.findElement(By.id("Login")).click();
//       //9. From the categories, click on the computers and accessories
//        driver.findElement(By.linkText("Computers and Accessories")).click();
//       //10. Click on the Laptop subcategory
//        driver.findElement(By.xpath("(//a[@class='_2181f_1540Z']//span)[3]")).click();
//       //11. Click on the apple Macbooks
//        driver.findElement(By.xpath("//span[text()='Apple MacBooks']")).click();
//       //12. Add an item to the cart
//        driver.findElement(By.xpath("(//button[text()='Add To Cart'])[1]")).click();
//       //13. Click on my cart
//        driver.findElement(By.xpath("//span[text()='My Cart']")).click();
//       //14. Click checkout
//        driver.findElement(By.xpath("Checkout")).click();
//       //15. Click Paynow
//        driver.findElement(By.xpath("kpaygateway")).click();
//       //16.
//
//
//
//
//    }
//}
//
//
//
//
//
//// * 9. click checkout
//// * 10. click paynow
//// * 11. Click continue to make payment
//// * 12. Select a card payment method
//// * 13. Input invalid card details
//// * 14. Print out the error message: Invalid card number
//// * 15. Close the iframe that displays input card modal
//// * 16. Quit the browser
