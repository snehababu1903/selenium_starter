package demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;

public class Automate_nested_frames_text {

    ChromeDriver driver;

    public Automate_nested_frames_text() {
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        // driver.close();
        driver.quit();
    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-left");

        System.out.println("value of left frame is: " + driver.findElement(By.tagName("body")).getText());

        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-middle");

        System.out.println("value of middle frame is: " + driver.findElement(By.tagName("body")).getText());

        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-right");

        System.out.println("value of right frame is: " + driver.findElement(By.tagName("body")).getText());

        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-bottom");

        System.out.println("value of bottom frame is: " + driver.findElement(By.tagName("body")).getText());

        driver.switchTo().defaultContent();

        System.out.println("end Test case: testCase01");

    }
}
