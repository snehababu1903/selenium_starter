/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo;

import java.net.MalformedURLException;

public class App {
    public void getGreeting() throws InterruptedException, MalformedURLException {
        // TestCases tests = new TestCases(); // Initialize your test class
        // SearchAmazon srcAmz = new SearchAmazon();
        // Automate_count_hyperlinks ach = new Automate_count_hyperlinks();
        // Automate_image_urls aiu = new Automate_image_urls();
        // Automate_nested_frames_text anft = new Automate_nested_frames_text();
        Automate_imdb_ratings air = new Automate_imdb_ratings();

        air.testCase01();

        air.endTest(); // End your test by clearning connections and closing browser
    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        new App().getGreeting();
    }
}
