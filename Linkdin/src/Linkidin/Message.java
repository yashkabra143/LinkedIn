package Linkidin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Message {

	public static void main(String[] args) throws InterruptedException {
		openChrome();
	}

	

	public static void openChrome() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();//intiate chrome browser
		driver.manage().window().maximize();// maximize browser
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://www.linkedin.com");// navigate to url
		Thread.sleep(40000);
		for(int i=1;i<=20;i++){
		
		int j=1;	
		
		if(j<=10) {
			
		WebElement msg = driver.findElement(By.xpath("(//button[text()='Message'])["+i+"]"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// wait 10 sec 
		msg.click();//click on message icon
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// wait 10 sec
		String user = driver.findElement(By.xpath("//span[@class='artdeco-pill__text']")).getText();// get user name
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// wait 10 sec
		//driver.switchTo().activeElement().sendKeys("hii " + user);// enter message
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// wait 8 sec
	  //  driver.switchTo().activeElement().findElement(By.xpath("//button[@class='msg-form__send-button artdeco-button artdeco-button--1']")).click();//press send button
	    Thread.sleep(8000);
	    driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);// close message window
	    js.executeScript("arguments[0].scrollIntoView();", msg);
	    j++;
	    System.out.println(" Value of J  : " + j);
	    //  js.executeScript("window.scrollBy(0,1000)");
		}
		else
		{
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			Thread.sleep(3000);
			i--;
			System.out.println(i);
		}
}}

	}
	

