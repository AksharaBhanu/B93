package day7;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo3 {

	public static void main(String[] args) throws InterruptedException {
		// login using xpath
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys("Admin");
		
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("admin123");
		
		WebElement login=driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
	    validateLogin(driver);	
	    fetchDateOfBirth(driver);
//	    driver.close();
	}

	

	private static void validateLogin(WebDriver driver) {
		// to validate login 
		  try {
	        	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(200));
	        	wait.until(ExpectedConditions.urlContains("dashboard"));
	        	System.out.println("Login success");
	        	
	        }
	        catch(Exception e)
	        {
	        	System.out.println("login failed");
	        	e.printStackTrace();
	        }
		  WebElement dashboard=driver.findElement(By.xpath("//span[text()='Dashboard']"));
		  if(dashboard.isDisplayed())
		  {
			  System.out.println("Landed to Dashboard");
		  }
		  else
		  {
			  System.out.println("Dashboard is not displayed");
		  }
	}
	
	private static void fetchDateOfBirth(WebDriver driver) throws InterruptedException {
		// Click on My Info and fetch DOB 
		WebElement myInfo=driver.findElement(By.xpath("//span[text()='My Info']"));
		myInfo.click();
		Thread.sleep(2000);
		WebElement personalDetail=driver.findElement(By.xpath("//h6[text()='Personal Details']"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2000));
		wait.until(ExpectedConditions.visibilityOf(personalDetail));
		
		Thread.sleep(2000);
		
		Actions action=new Actions(driver);
	
		
		String dob="//label[text()='Date of Birth']/../following-sibling::div/div/div/input";
		WebElement dobValue=driver.findElement(By.xpath(dob));
		
		action.scrollToElement(dobValue);
	
		System.out.println(dobValue.getAttribute("value"));
	}
}
