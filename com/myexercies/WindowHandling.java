package com.myexercies;

import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.getLocalStorage();
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");

	}

}
