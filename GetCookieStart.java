import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class GetCookieStart {
    @Test
    public void cookieTest(){

        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("ChromeDriver");
        searchBox.submit();
        // есть еще .click(), но он работает как клик и нужно именно по кнопке производить

        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("cookies->" + cookies);

//        Cookie authCookie = new Cookie("", ""); //сюда указать куки для авторизации, for test
//        driver.manage().addCookie(authCookie); //добавляет куки, используется для авторизации, например
//        driver.navigate().refresh(); //но чтобы заработала авторизация нужно обновление страницы

//        driver.manage().getCookieNamed("user_name"); //позволяет по определенному ключу найти определенный куки
//        driver.manage().deleteCookieNamed("user_name"); // позволяет по определенному ключу удалить определенный куки

        driver.manage().deleteAllCookies(); //удаляет куки
        System.out.println("deleteAllCookies->" + driver.manage().getCookies());

    }

}
