import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

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
        WebElement btnSubmit = driver.findElement(By.cssSelector("button[id='SubmitLogin'] span"));
        btnSubmit.click();
        WebElement btnShirt = driver.findElement(By.xpath("(//a[@title='T-shirts'][normalize-space()='T-shirts'])[2]"));
        btnShirt.click();

        // crear accion para Selenium
        Actions accion = new Actions(driver);
        WebElement mouseHover = driver.findElement(By.xpath("(//img[@title='Faded Short Sleeve T-shirts'])[1]"));
        accion.moveToElement(mouseHover).perform();

        WebElement moreDetails = driver.findElement(By.xpath("//span[.='More']"));
        moreDetails.click();

        WebElement colorDress = driver.findElement(By.cssSelector("#color_14"));
        colorDress.click();

        // vamos a cambiar de pagina  a Women

        WebElement womenPagen = driver.findElement(By.xpath("(//a[@class='sf-with-ul'][normalize-space()='Women'])[1]"));
        womenPagen.click();
    }

    @After
    public void closeBrowser() {
        //  driver.quit();
    }


}
