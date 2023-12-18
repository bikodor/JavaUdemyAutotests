import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTests {
    @Test
    public void testAlert(){
        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");

        Alert alert = driver.switchTo().alert();
        // alert.accept(); // принять поп-ап
        // alert.dismiss(); // отклонить поп-ап (если определенный алёрт)
        // alert.getText(); // получить текст поп-апа (если определенный алёрт)
        // alert.sendKeys("some text"); // отправить в поп-ап сообщение (если определённый алёрт)

    }
    @Test
    public void testFrames(){
        // переключаем фрейм:
//        driver.switchTo().frame(0); // по индексу
//        driver.switchTo().frame("frameName"); // по названию
//        driver.switchTo().frame(webElement); // по переменной элемента
//
        // переключаем к дочернему через родительский:
//        driver.switchTo().frame("main_frame")
//                .switchTo().frame(0)
//                .switchTo().frame("sub_frame"); // подключаем к дочернему
//
//        driver.switchTo()
//                .frame("main_frame.0.sub_frame"); // или через точку
//
//        driver.switchTo().defaultContent(); // переключает к родительскому
//
//        wait.until(ExpectedConditions
//                .frameToBeAvailableAndSwitchToIt(locatorOfFrame)); //проверяем возможно ли переключение на фрейм, если да, то переключаем


    }
}
