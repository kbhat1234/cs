package api.restassured.craftsilicon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest1{
	
	public static void main(String args[]) {
		WebDriver driver;
		ChromeOptions co = new ChromeOptions();
		co.setAcceptInsecureCerts(true);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);
		
		driver.get("http://www.craftsilicon.com");
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();
		driver.quit();
		
	}
}