package day11;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//how to run JS using selenium in the browser?
public class Demo6 {

	public static void main(String[] args) throws InterruptedException, IOException {
	
		WebDriver driver=new ChromeDriver();
		driver.get("https://aksharatraining.com/");
		driver.manage().window().maximize();
		JavascriptExecutor j=(JavascriptExecutor) driver; //type casting
		//scroll down
		for(int i=1;i<=3;i++)
		{
			TakesScreenshot t=(TakesScreenshot)driver;
			File srcFile=t.getScreenshotAs(OutputType.FILE);
			File dstFile=  new File("./images/akshara"+i+".png");
			FileUtils.copyFile(srcFile, dstFile);
			Thread.sleep(1000);
			j.executeScript("window.scrollBy(0,1000)");
			Thread.sleep(1000);
			
		}
		
		driver.quit();
		
		
	}

}
