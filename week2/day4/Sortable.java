package week2.day4;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sortable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/sortable/");
		
		driver.switchTo().frame(0);
		WebElement item1 = driver.findElementByXPath("//li[text()='Item 1']");
		WebElement item5 = driver.findElementByXPath("//li[text()='Item 5']");
		Actions builder = new Actions(driver);
		Point p = item5.getLocation();
		System.out.println(p.getX()+" "+p.getY());
		builder.dragAndDropBy(item1, p.getX(), p.getY()+5).perform();
//		builder.clickAndHold(item1).moveToElement(item5, p.getX(), p.getY()+5).release(item1).perform();
	}
}
