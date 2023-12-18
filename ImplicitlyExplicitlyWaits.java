import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ImplicitlyExplicitlyWaits {
    @Test
    public void testImplicitlyWait(){
        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");

        WebElement element = driver.findElement(By.name("q"));
        Assert.assertTrue(element.isDisplayed());
//        Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("///")))); // проверяем неотображение элемента

//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //неявные ожидания, будут выполняться при каждом поиске элемента

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //явные ожидания, в течении времени будет выполнять то что дальше, если за это время даже не найдет, то фейлится тест
        WebElement someElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q"))); //ждать пока элемент не отобразится (за указанное время выше)


//        WebElement someElement = wait.until(ExpectedConditions.elementToBeClickable(By.name("q"))); //ждать пока элемент не станет кликабельным (за указанное время выше)


        }
    @Test
    public void testDissapearedElement(){
        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement someElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));

        someElement.sendKeys("ChromeDriver");
        someElement.submit();
//        wait.until(ExpectedConditions.stalenessOf(someElement)); // выводит true, если возникает исключение StaleElementReferenceException (ранее найденный элемент пропал)
        Assert.assertTrue(wait.until(ExpectedConditions.stalenessOf(someElement))); // проверяем, что ранее найденный и используемый элемент сейчас пропал
    }

    @Test
    public void otherTimeouts(){
        // wait.until(ExpectedConditions.titleIs("You live Online-Bank")); // ждать пока title не будет содержать указанное значение
        // wait.until(ExpectedConditions.urlContains("money-transfer/card")); // ждать пока url не будет содержать указанное значение
        // wait.until(ExpectedConditions.alertIsPresent()); // ждать пока не будет проверено, закрыто ли диалоговое окно или нет
        // wait.until(ExpectedConditions.numberOfWindowToBe(1)); // ждать пока не будет отображаться определенное количество окон

        // wait.until(ExpectedConditions.attributeContains(By.xpath("///"), "class", "visible")); // ждем пока аттрибут не будет содержать по определенному локатору, указываем какое значение, видимость или нет его
        // wait.until(ExpectedConditions.textToBePresentInElement(buttonRefresh, "Refresh")); // проверяем что текст элемента не изменился
        // wait.until(ExpectedConditions.elementToBeClickable(buttonRefresh)); // проверяет что элемент находится на странице + не имеет свойство disabled


    }

}
