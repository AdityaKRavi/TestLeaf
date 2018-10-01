package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnFrameAndAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver chrome=new ChromeDriver();
		chrome.manage().window().maximize();
		chrome.get("http://layout.jquery-dev.com/demos/iframe_local.html");
		chrome.findElementByXPath("//div[contains(text(),'West')]/p/button").click();
		chrome.findElementByXPath("//div[contains(text(),'East')]/p/button").click();
		WebDriver frame = chrome.switchTo().frame("childIframe");
		frame.findElement(By.xpath("//div[contains(text(),'Iframe West')]/p/button")).click();
		frame.findElement(By.xpath("//div[contains(text(),'Iframe East')]/p/button")).click();
		frame.switchTo().defaultContent();
		chrome.close();
	}
}
