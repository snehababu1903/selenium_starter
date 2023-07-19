package demo;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automate_window_handle {

    ChromeDriver driver;

    public Automate_window_handle() {
        System.out.println("inside the constructor");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest() {
        System.out.println("testcase is completed");
        driver.close();
    }

    public void testCase01() {
        System.out.println("testcase is started");

        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");

        driver.switchTo().frame("iframeResult");
        System.out.println("The web page title of child window is:"
                + driver.findElement(By.xpath("//body[@contenteditable='false']//h1")).getText());

        WebElement tryItBtn = driver.findElement(By.xpath("//button[@onclick='myFunction()']"));
        tryItBtn.click();
        // window handler methods to switch bw windows

        String MainWindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String childWindow = i1.next();
            if (!MainWindow.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
                String pageTitle = driver.getTitle();
                System.out.println("The web page title of child window is:" + pageTitle);
                System.out.println("The URL of child window is:" + driver.getCurrentUrl());

                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(screenshot, new File(
                            "C:\\Users\\snehab\\workspace\\selenium_starter\\src\\main\\java\\demo\\childwindowScreenshot.png"));
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                driver.close();
                System.out.println("Child window closed");
            }
        }

        driver.switchTo().window(MainWindow);
        System.out.println("The URL of current window is:" + driver.getCurrentUrl());

    }
}
