package com.croma.WindowHandles;

import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class WindowHandle {
	
	WebDriver d;
  @Test
  public void test() throws InterruptedException {
	 
	  d=new FirefoxDriver();
	  d.get("http://www.w3schools.com/html/html_links.asp");
	  d.manage().window().maximize();
	  String parent= d.getWindowHandle();
	  System.out.println(parent);
	
	  d.findElement(By.linkText("Exercise 1 »")).click();
	 Set<String> set=d.getWindowHandles();
	  set.remove(parent);
	  String First=(String)set.toArray()[0];
	  System.out.println(First);
	 
	 d.findElement(By.linkText("Exercise 2 »")).click();
	 set=d.getWindowHandles();
	 set.remove(First);set.remove(parent);
	 String Second=(String)set.toArray()[0];
	 System.out.println(Second);
	 
	 d.findElement(By.linkText("Exercise 3 »")).click();
	 set=d.getWindowHandles();
	 set.remove(First);set.remove(parent);set.remove(Second);
	String Third=(String)set.toArray()[0];
	System.out.println(Third);
	 set=d.getWindowHandles();
	 
	 // To close all the popups on the parent page. Use the below logic.
	 Iterator<String> Iter=set.iterator();
	 while(Iter.hasNext())
	 {
		 String window=Iter.next();
		 if(!window.equals(parent))
		 d.switchTo().window(window).close();
	 }
  }
}
