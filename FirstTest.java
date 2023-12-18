import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Array;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Set;

public class FirstTest {

    @Test
    public void testSearchGoogle(){
        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");

        WebElement searchBox = driver.findElement(By.name("q"));

        searchBox.sendKeys("ChromeDriver"); //  метод также позволяет отправлять файлы, указав путь к файлу
        // .clear() очищает поле ввода

        searchBox.submit(); // (тоже самое, что и нажать Enter, а .click() это уже клик, работает если кнопка находиться в теге form, и имеет type="submit"

        driver.quit();
    }
    @Test
    public void testSwitchWindow(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com/");
        String urlOld = driver.getCurrentUrl(); //получить url текущей страницы
        String currentTitle = driver.getTitle(); //получить title страницы
        Assert.assertEquals(currentTitle, "Google");
        System.out.println("URL Old: " + urlOld);
        String oldWindow = driver.getWindowHandle();
        System.out.println("window->" + oldWindow);

        ((JavascriptExecutor)driver).executeScript("window.open()"); //запускаем скрипт по открытию окна
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1)); //переключаем на второе окно
        driver.get("https://selenium.dev");
        String urlNew = driver.getCurrentUrl();
        System.out.println("URL New: " + urlNew);

        String newWindow = driver.getWindowHandle();
        System.out.println("newWindow->" + newWindow);

        driver.quit();

    }
}
