import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageActionsTest {
    @Test
    public void navigate(){
        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");

        driver.navigate().to("https://selenium.dev"); // осуществляет переход к другой странице, но не через новое окно, а через это же (меняет url, а не добавляет новое окно)
        driver.navigate().back(); //возвращает на страницу назад
        driver.navigate().forward(); //переводит на страницу вперед
        driver.navigate().refresh(); //обновляет страницу


        driver.quit();
    }

}
