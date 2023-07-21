import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;

public class kongaTest {

    WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. open your Chrome browser
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); // Add any other necessary options
//
//        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50000));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //2. input your Konga Browser URL (https://www.konga.com/)
        driver.get("https://www.konga.com/");
        Thread.sleep(3000);
        //3. Maximise the browser
        driver.manage().window().maximize();
        //4. click on the Login/signup button to open the Login/Signup page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(3000);

    }

    @Test(priority = 0)
    public void ValidSignup() throws InterruptedException {
        //5. Input your email address or phone number in email/phone number field
        driver.findElement(By.cssSelector("input#username")).sendKeys(Constant.VALID_EMAIL);
        //6. Input your password in the password field
        driver.findElement(By.cssSelector("input#password")).sendKeys(Constant.VALID_PASSWORD);
//        driver.findElement(By.id("password")).sendKeys(Constant.VALID_PASSWORD);
        //7. Click on log in to log in to your account
        driver.findElement(By.xpath("//button[text()='Login']")).click();
//        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void SearchItem() throws InterruptedException {
        //9. From the categories, click on the computers and accessories
        driver.findElement(By.xpath("/html/body/div/div/section/div[3]/nav/div[2]/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //10. Click on the Laptop subcategory
        driver.findElement(By.xpath("//span[text()='Laptops']")).click();
        Thread.sleep(2000);
        //11. Click on the apple Macbooks
        driver.findElement(By.xpath("//span[text()='Apple MacBooks']")).click();
        Thread.sleep(2000);
        //12. Add an item to the cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[3]/div/div/div[2]/form/div[3]/button")).click();
        Thread.sleep(2000);
        //13. Click on my cart
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[1]")).click();
        Thread.sleep(5000);

    }

    @Test(priority = 2)
    public void CheckCart() throws InterruptedException {
        //14. Click checkout
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(2000);
        //15. Click Paynow
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        Thread.sleep(2000);
        //16. Click continue to make payment
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(5000);
        //Switch to iframe
        By locIframe = By.xpath("//*[@id=\"kpg-frame-component\"]");
        driver.switchTo().frame(driver.findElement(locIframe));
        Thread.sleep(2000);
        //17. Click card
        driver.findElement(By.xpath("//*[@id=\"channel-template\"]/div[2]/div/div[2]/button")).click();
        Thread.sleep(2000);
        //18. Input card details
        driver.findElement(By.id("card-number")).sendKeys("3333333388888888");
        Thread.sleep(2000);
        //19. Input Date
        driver.findElement(By.id("expiry")).sendKeys("7676");
        Thread.sleep(2000);
        //20. Input CVV
        driver.findElement(By.id("cvv")).sendKeys("211");
        Thread.sleep(2000);
        driver.findElement(By.id("card-pin-new")).click();
        //21. Input card pin
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[1]")).click();
        Thread.sleep(2000);
        //22. Click on Pay now
        driver.findElement(By.id("validateCardForm")).click();
        Thread.sleep(2000);
        //23. Print out error message
        if (driver.findElement(By.id("card-number_unhappy")).isDisplayed())
            System.out.println("Invalid Card Details");
        else
            System.out.println("Failed Test");
        Thread.sleep(2000);
        //24. Close the iframe that displays input card modal
        //Close iFrame
        WebElement ClosePopUp = driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside"));
        ClosePopUp.click();
        // Switch out of iFrame
        driver.switchTo().defaultContent();
        System.out.println("Close pop-up");
        //driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();
        Thread.sleep(2000);




    }

    @AfterTest
    public void closeBrowser() {
        //Quit the browser
        driver.quit();


    }


}

