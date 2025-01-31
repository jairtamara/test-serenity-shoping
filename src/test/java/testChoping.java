import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class testChoping {

    WebDriver driver;

    @Before
    public void openBrowser() {

        // asignar ruta de chrome_driver
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-blink-features=AutomationControlled");  // Evita detección de Selenium

        driver = new ChromeDriver(options);

    }

    @Test
    public void chopingClothes() {
        // rutA TEST
        driver.get("http://www.automationpractice.pl/index.php");

        WebElement btnLogin = driver.findElement(By.className("login"));
        btnLogin.click();
        WebElement inputEmail = driver.findElement(By.id("email"));
        inputEmail.sendKeys("jairfabian93@gmail.com");
        WebElement inputPassword = driver.findElement(By.cssSelector("#passwd"));
        inputPassword.sendKeys("123123");
        WebElement btnSunmit = driver.findElement(By.cssSelector("button[id='SubmitLogin'] span"));
        btnSunmit.click();

    }

    @After
    public void closeBrowser() {
        //  driver.quit();
    }


}
