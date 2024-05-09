package com.lms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class seleniumLibrary {

	WebDriver driver = new ChromeDriver();

	
	@Test	
	public void PonniyinSelvanIsAvailable() {
		driver.get("http://localhost:3000/");
		driver.manage().window().maximize();
		driver.findElement(By.id("search")).sendKeys("historical");
		driver.findElement(By.cssSelector(".btn")).click();
		driver.findElement(By.cssSelector(".btn")).click();
		String Text=driver.findElement(By.xpath("//td[contains(.,'Ponniyin Selvan')]")).getText();
		assertEquals("Ponniyin Selvan", Text);
	}

	@Test	
	public void SearchRomanceNoresult() {
		driver.get("http://localhost:3000/");
		driver.manage().window().maximize();
		driver.findElement(By.id("search")).sendKeys("romance");
		String text =driver.findElement(By.xpath("//h3[@id='result']")).getText();
		System.out.println(text);
		assertEquals("No results", text);
		
	}
	
	
	@Test		
	public void BorrowHorror() throws InterruptedException {
		driver.get("http://localhost:3000/");
		driver.manage().window().maximize();
		driver.findElement(By.id("search")).sendKeys("horror");
		driver.findElement(By.cssSelector(".btn")).click();
		driver.findElement(By.cssSelector(".btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("borrow")).click();
		String text = driver.findElement(By.xpath("//td[contains(.,'Haunted')]")).getText();
		System.out.println(text);
		assertEquals("Haunted", text);

	}
	
	@Test	
	public void deleteBookPonniyinSelvan() {
		driver.get("http://localhost:3000/");
		driver.manage().window().maximize();	
		driver.findElement(By.id("borrow")).click();
		driver.findElement(By.xpath("//tbody/tr[1]/td[6]/button[1]")).click();

	}

}
