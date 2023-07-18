package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class BookMyShowCount {

    ChromeDriver driver;

    public BookMyShowCount() {
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
        // navigate to URL https://www.google.com
        driver.get("https://www.google.com");

        // Enter search value Using Locator "Name" q /amazon
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("amazon");
        searchBox.sendKeys(Keys.ENTER);

        // Validate the text Using Locator "XPath" //*[text()='Amazon.in']
        List<WebElement> searchList = driver.findElements(By.xpath("//*[contains(text(),'Amazon.in')]"));
        int elemSize = searchList.size();
        // get list of element & size of the list containing amazon value
        System.out.println("the list size is: " + elemSize);

        for (int i = 0; i < elemSize; i++) {
            if (searchList.get(i).getText().contains("Amazon.in"))
                System.out.println("value is present");
        }
        System.out.println("end Test case: testCase01");
    }
}