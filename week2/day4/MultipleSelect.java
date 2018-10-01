package week2.day4;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultipleSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://jqueryui.com/selectable/");
		driver.switchTo().frame(0);
		Actions builder = new Actions(driver);
		WebElement item1 = driver.findElementByXPath("//li[text()='Item 1']");
		WebElement item4 = driver.findElementByXPath("//li[text()='Item 4']");
		WebElement item7 = driver.findElementByXPath("//li[text()='Item 7']");
//		builder.keyDown(Keys.CONTROL).click(item1).click(item4).click(item7).perform();
		builder.contextClick(item1).perform();
		
	}
}
