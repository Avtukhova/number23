import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CallbackTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
    }

    @BeforeEach
    void setUp() {

        driver = new ChromeDriver();
    }

     @Test
    void shouldTestV1() {
        driver.get("http://localhost:9999");
        List<WebElement> inputField = driver.findElements(By.className("input__control"));
        inputField.get(0).sendKeys("Василий");
        inputField.get(1).sendKeys("+79270000000");
        driver.findElement(By.className("checkbox__text")).click();
        driver.findElement(By.tagName("button")).click();
        String actualMessage = driver.findElement(By.className("paragraph")).getText();
        String expectedMessage = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expectedMessage, actualMessage.trim());


    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }


}
