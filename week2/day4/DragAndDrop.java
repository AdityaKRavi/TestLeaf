package week2.day4;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://jqueryui.com/draggable/");
		
		driver.switchTo().frame(0);
		WebElement elementById = driver.findElementById("draggable");
		Actions builder = new Actions(driver);
		Point p =elementById.getLocation();
		System.out.println(p.x+"  "+p.y);
		builder.dragAndDropBy(elementById, (p.getX()+20), (p.getY()+20)).perform();		
	}
}
