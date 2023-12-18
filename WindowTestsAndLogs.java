import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.Set;

public class WindowTestsAndLogs {
    @Test
    public void testWindow(){

        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");

        WebElement searchBox = driver.findElement(By.name("q"));

        searchBox.sendKeys("ChromeDriver");

        searchBox.submit();

        driver.manage().window().setSize(new Dimension(1000, 1000)); //меняет размер окна
        driver.manage().window().maximize(); //fullscreen делает
        driver.manage().window().fullscreen(); //делает тоже самое
        System.out.println("getSize->" + driver.manage().window().getSize()); //получаем размер окна на момент вызова метода
        System.out.println("getPosition->" + driver.manage().window().getPosition()); // даёт позицию (расположение) окна на момент вызова метода (по осям х и у относительно левого верхнего края)
        driver.manage().window().setPosition(new Point(50, 100)); // устанавливает расположение окна

        driver.quit();

    }
    @Test
    public void testLogs(){
        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");

        Set<String> allLogsType = driver.manage().logs().getAvailableLogTypes();
        System.out.println("allLogsType-> " + allLogsType);

        LogEntries logs = driver.manage().logs().get(LogType.BROWSER); //Даёт логи браузера
        for (
                LogEntry entry: logs
        )
            System.out.println("logs->" + entry);

    }

}
