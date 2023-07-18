package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.WebElement;

public class Automate_count_hyperlinks {

    ChromeDriver driver;

    public Automate_count_hyperlinks() {
        System.out.println("inside constructor");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        // navigate to URL https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");

        List<WebElement> anchorTags = driver.findElements(By.tagName("a"));
        int elemSize = anchorTags.size();
        System.out.println("the count of hyperlinks i the page is: " + elemSize);

        System.out.println("end Test case: testCase01");

    }
}