package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Automate_imdb_ratings {
    ChromeDriver driver;

    public Automate_imdb_ratings() {
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

        driver.get("https://www.imdb.com/chart/top");

        WebElement highestRtd = driver.findElement(By.xpath(
                "//ul[@class='ipc-metadata-list ipc-metadata-list--dividers-between sc-3a353071-0 wTPeg compact-list-view ipc-metadata-list--base']/li[1]/div[2]//a/h3"));
        System.out.println("Highest rated movie name: " + highestRtd.getText());

        List<WebElement> moviesList = driver.findElements(By.xpath(
                "//ul[@class='ipc-metadata-list ipc-metadata-list--dividers-between sc-3a353071-0 wTPeg compact-list-view ipc-metadata-list--base']/li/div[2]//a/h3"));
        int listSize = moviesList.size();
        System.out.println("movies count is: " + listSize);

        List<WebElement> yearList = driver
                .findElements(By.xpath("//ul/li//div[@class='sc-14dd939d-5 cPiUKY cli-title-metadata']/span[1]"));
        listSize = yearList.size();
        System.out.println("movies count is: " + listSize);

        int yearvalue = 0;
        WebElement moviename = driver.findElement(By.xpath(
                "//ul/li//div[@class='sc-14dd939d-5 cPiUKY cli-title-metadata']/span[contains(text(),'" + yearvalue
                        + "')]/ancestor::div[@class='sc-14dd939d-0 fBusXE cli-children']//h3"));

        int smallestNum = 0;
        int largestNum = 0;
        int value = 0;
        smallestNum = Integer.parseInt(yearList.get(0).getText());
        largestNum = Integer.parseInt(yearList.get(0).getText());

        for (int i = 0; i < yearList.size(); i++) {
            value = Integer.parseInt(yearList.get(i).getText());

            if (value < smallestNum) {
                smallestNum = value;
            } else if (value > largestNum) {
                largestNum = value;
            }

        }
        System.out.println("oldest year is: " + smallestNum);
        String mvnm = "";

        yearvalue = smallestNum;
        moviename = driver.findElement(By.xpath(
                "//ul/li//div[@class='sc-14dd939d-5 cPiUKY cli-title-metadata']/span[contains(text(),'" + yearvalue
                        + "')]/ancestor::div[@class='sc-14dd939d-0 fBusXE cli-children']//h3"));
        mvnm = moviename.getText();
        System.out.println("oldest movie name is :" + mvnm);

        System.out.println("recent year is: " + largestNum);
        yearvalue = largestNum;
        moviename = driver.findElement(By.xpath(
                "//ul/li//div[@class='sc-14dd939d-5 cPiUKY cli-title-metadata']/span[contains(text(),'" + yearvalue
                        + "')]/ancestor::div[@class='sc-14dd939d-0 fBusXE cli-children']//h3"));
        mvnm = moviename.getText();
        System.out.println("oldest movie name is :" + mvnm);

        List<WebElement> ratingList = driver
                .findElements(By.xpath(
                        "//ul/li//span[@class='sc-14dd939d-1 PnacM']//span[@class='ipc-rating-star ipc-rating-star--base ipc-rating-star--imdb ratingGroup--imdb-rating']"));

        float largestNumm = 0;
        float valuee = 0;
        largestNumm = Float.valueOf(ratingList.get(0).getText());

        for (int i = 0; i < ratingList.size(); i++) {
            valuee = Float.valueOf(ratingList.get(i).getText());

            if (valuee > largestNumm) {
                largestNumm = valuee;
            }
        }
        System.out.println("highest rating is: " + largestNumm);
        WebElement hstratngMvname = driver
                .findElement(By.xpath("//ul/li//span[@class='sc-14dd939d-1 PnacM']//span[contains(text(),'"
                        + largestNumm + "')]/ancestor::div[@class='sc-14dd939d-0 fBusXE cli-children']//h3"));
        System.out.println("highest rating movie name is: " + hstratngMvname.getText());

        System.out.println("end Test case: testCase01");

    }
}