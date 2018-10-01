package week2.day4;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import wdmethods.SeMethods;


public class IndeedJobs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.indeed.co.in/Fresher-jobs");

		List<WebElement> jobLinks = driver.findElementsByXPath("((//td[@id='resultsCol'])//a[@data-tn-element='jobTitle'])");	
		int size = jobLinks.size();
		for(int i =0; i<size; i++) {
			Actions builder = new Actions(driver);
				builder.keyDown(Keys.CONTROL).click(jobLinks.get(i)).keyUp(Keys.CONTROL).perform();
				Set<String> allWindows = driver.getWindowHandles();
				List<String> window = new ArrayList<String>();
				window.addAll(allWindows);
				driver.switchTo().window(window.get(1));
				System.out.println(driver.getTitle());
				driver.close();
				driver.switchTo().window(window.get(0));
		}
		driver.quit();
	}
}
