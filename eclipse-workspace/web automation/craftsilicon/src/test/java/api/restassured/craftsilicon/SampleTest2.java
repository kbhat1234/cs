package api.restassured.craftsilicon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest2 {

WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		//co.addArguments("start-maximized");
		//co.addArguments("disable-infobars");
		//co.addArguments("--disable-extensions");
		co.setAcceptInsecureCerts(true);
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
	}
	
	@Test
	public void studentRegForm() {
		System.out.println("Welcome to student registration form");
		driver.get("https://demoqa.com/automation-practice-form");
		
		WebElement fname = driver.findElement(By.id("firstName"));
		fname.sendKeys("Karthik");
		
		WebElement lname = driver.findElement(By.id("lastName"));
		lname.sendKeys("Bhat");
		
		WebElement email = driver.findElement(By.id("userEmail"));
		email.sendKeys("kbhat.anurag@gmail.com");
		
		WebElement genderMale = driver.findElement(By.xpath("//label[contains(text(),'Male')]"));
		genderMale.click();
		
		WebElement mobile = driver.findElement(By.id("userNumber"));
		mobile.sendKeys("9886867677");
		
		//WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
		//dob.click();
		
		WebElement subjects = driver.findElement(By.xpath("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']"));
		subjects.sendKeys("Physics, Chemistry, Biology");
		
	}
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

}
