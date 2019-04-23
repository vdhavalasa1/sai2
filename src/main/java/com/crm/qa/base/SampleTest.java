package com.crm.qa.base;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.rules.Timeout;
import org.omg.Messaging.SyncScopeHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SampleTest {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/login.cfm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Minutes, Timeout.seconds(seconds))
		WebElement usr = driver.findElement(By.xpath("//input[@placeholder='Login']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value='kurmajyothi'",usr);
		//jse.executeScript("return document.readyState").equals("complete"), arg1)
		//driver.findElement(By.xpath("//input[@name='username']")).sendKeys("kurmajyothi");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("sathyas@i123");
		WebElement w = driver.findElement(By.xpath("//input[@type='submit']"));
		//driver.navigate().refresh();
		//driver.findElement(By.xpath("//input[@name='username']")).sendKeys("kurmajyothi");
		//driver.findElement(By.xpath("//input[@name='password']")).sendKeys("sathyas@i123");
		w.click();
		driver.switchTo().frame("mainpanel");
		WebElement contact = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		contact.click();
		driver.findElement(By.partialLinkText("partha s")).click();
		//String s= driver.findElement(By.xpath("//input[@class='button_help']/parent::td/parent::tr/child::td[contains(text(),'Status')]")).getText();
		//String s= driver.findElement(By.cssSelector("input.button_help/parent::td/parent::tr/child::td[contains(text(),'Status')]")).getText();
		//String s= driver.findElement(By.xpath("//input[@name='cs_name']/parent::td/parent::tr/child::td[contains(text(),'Name')]")).getText();
		//System.out.println(s);
		//if(s.contains("Name"))
		driver.findElement(By.xpath("//input[@name='cs_name']")).sendKeys("Sai");
		driver.findElement(By.xpath("//td[contains(text(),'Status')]/following-sibling::td/input[@class='button_help']")).click();
		driver.findElement(By.xpath("//input[@label='Save Search']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'1.1 1,2')]/parent::td/preceding-sibling::td/input")).click();
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;
		WebDriverWait ww= new WebDriverWait(driver,60);
		ww.until(ExpectedConditions.titleContains("TVS"))
	//	Set<String> names= new HashSet<>();
		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		ArrayList list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		Iterator it = list.iterator();
		while(it.hasNext())
			System.out.println(it.next());
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		 	}
		driver.switchTo().window(subWindowHandler);
		driver.findElement(By.xpath("//input[@type='button' and @value='X']")).click();
		driver.switchTo().window(parentWindowHandler); 
		}

}
