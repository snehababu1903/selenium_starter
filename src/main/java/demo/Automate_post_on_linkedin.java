package demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Automate_post_on_linkedin {

    ChromeDriver driver;

    public Automate_post_on_linkedin() {
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
        // navigate to URL https://www.linkedin.com/
        driver.get("https://www.linkedin.com/");

        WebElement userfield = driver.findElement(By.id("session_key"));
        userfield.sendKeys("abc@gmail.com");

        WebElement pwdfield = driver.findElement(By.id("session_password"));
        pwdfield.sendKeys("*****");

        WebElement signIn = driver.findElement(By.linkText(" Sign in"));
        signIn.click();

        WebElement profCount = driver.findElement(By.xpath("//a[@href='/me/profile-views/']//div//strong"));
        String profileViewct = profCount.getText();
        System.out.println("Profile view count: " + profileViewct);

        WebElement startPost = driver.findElement(By.id("ember29"));
        startPost.click();

        WebElement visibilityView = driver
                .findElement(By.xpath("//*[local-name()='svg'][@data-test-icon='caret-medium']"));
        visibilityView.click();

        WebElement connBtn = driver.findElement(By.id("sharing-shared-generic-list-radio-CONNECTIONS_ONLY"));
        connBtn.click();

        WebElement visiblityDone = driver.findElement(By.id("ember474"));
        visiblityDone.click();

        System.out.println("end Test case: testCase01");
    }
}