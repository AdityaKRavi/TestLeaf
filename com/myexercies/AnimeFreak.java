package com.myexercies;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AnimeFreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ChromeDriver driver = new ChromeDriver();
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("http://www.animefreak.tv/tracker");
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript(script, args)
		driver.findElementByLinkText("Detective Conan Episode 914").click();
		
//		driver.findElementByXPath("//div[text()='Close & Continue']").click();
	}
}
