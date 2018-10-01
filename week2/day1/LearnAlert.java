package week2.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver chrome = new ChromeDriver();
		chrome.manage().window().maximize();
		chrome.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		WebDriver frame = chrome.switchTo().frame("iframeResult");
		frame.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert alert = chrome.switchTo().alert();
		String name = "Aditya";
		alert.sendKeys(name);
		alert.accept();
		String text = frame.findElement(By.id("demo")).getText();
		if(text.equals("Hello "+name+"! How are you today?"))
			System.out.println("Name verified");
		else
			System.out.println("Name not verified");
//		chrome.findElementByXPath("//button[@text()='Alert Box']").click();
//		Alert alert = chrome.switchTo().alert();
//		alert.getText();
//		System.out.println(alert.getText());
//		alert.accept();
	}

}
