package day1;

import org.openqa.selenium.edge.EdgeDriver;

public class Demo2 {

	public static void main(String[] args) {
		//Open the browser
		EdgeDriver driver=new EdgeDriver();
		//Enter the URL
		driver.get("http://www.google.com");
		//print the title of the page
		System.out.println(driver.getTitle());
		//close the browser
		driver.quit();

	}

}
