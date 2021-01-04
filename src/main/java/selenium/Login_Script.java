package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_Script {
    public static WebDriver driver = null;

    public static void main(String[] agrs) throws InterruptedException {
//                启动火狐浏览器
        driver = new ChromeDriver();
//                最大化
        driver.manage().window().maximize();
//                打开开源中国网址
        driver.get("http://sempreprod.vevor.net/login");
//                关闭浏览器
        driver.quit();
    }
}
