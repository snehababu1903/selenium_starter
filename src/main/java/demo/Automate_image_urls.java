package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Automate_image_urls {

    ChromeDriver driver;

    public Automate_image_urls() {
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

    public void testCase01() throws InterruptedException {
        System.out.println("Start Test case: testCase01");
        // navigate to URL https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        Thread.sleep(10000);
        List<WebElement> linkList = driver.findElements(
                By.xpath("//div[@class='sc-lnhrs7-0 hCzkOF']//div[@class='sc-133848s-2 sc-1t5vwh0-1 TsmVt']/img"));
        int listCount = linkList.size();
        System.out.println("list of recommended movies count: " + listCount);

        for (int i = 0; i < listCount; i++) {
            System.out.println("value is : " + linkList.get(i).getAttribute("src"));
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,650)", "");

        WebElement movieName = driver
                .findElement(By.xpath("//div[@class='sc-lnhrs7-4 dJDNWO']/div[2]//div[@class='sc-7o7nez-0 fyTNyu']"));
        // js.executeScript("arguments[0].scrollIntoView();", movieName);

        String mvname = movieName.getText();
        System.out.println("2nd movie name in premiere list : " + mvname);

        WebElement movieLang = driver
                .findElement(By.xpath("//div[@class='sc-lnhrs7-4 dJDNWO']/div[2]//div[@class='sc-7o7nez-0 eeVqLW']"));
        String mvlng = movieLang.getText();
        System.out.println("2nd movie name in premiere list : " + mvlng);

        System.out.println("end Test case: testCase01");
    }
}