package com.myexercies;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver chrome = new ChromeDriver();
		chrome.get("http://leaftaps.com/opentaps");
		//chrome.manage().window().maximize();
		
		chrome.findElementById("username").sendKeys("DemoSalesManager");
		chrome.findElementById("password").sendKeys("crmsfa");
		chrome.findElementByClassName("decorativeSubmit").click();

		chrome.findElementByLinkText("CRM/SFA").click();
		chrome.findElementByLinkText("Leads").click();
		chrome.findElementByLinkText("Find Leads").click();
		
		List <WebElement> tableHead = chrome.findElementsByClassName("x-grid3-hd-row");
		for(WebElement web:tableHead)
			System.out.println(web.getText());
		
		Dimension d= chrome.findElementByLinkText("Find Leads").getSize();
		System.out.println(d.getHeight());
		System.out.println(d.getWidth());
		
		Point p =chrome.findElementByLinkText("Find Leads").getLocation();
		System.out.println(p.x+"  "+p.y);

	}

}
