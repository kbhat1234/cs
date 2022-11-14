package api.restassured.craftsilicon;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

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
	
	/*@Test(priority=0)
	public void testCase1() {
		driver.get("https://www.google.co.in");
		String currURL = driver.getCurrentUrl();
		String title = driver.getTitle();
		System.out.println("Current URL is "+currURL);
		System.out.println("Title is "+title);
	}*/
	
	/*@Test(priority=1)
	public void testCase2() {
		driver.get("https://demoqa.com/books");
		System.out.println(driver.getTitle());
		System.out.println(driver.hashCode());
		WebElement sbox = driver.findElement(By.id("searchBox"));
		sbox.sendKeys("git");
		WebElement prod1 = driver.findElement(By.linkText("Git Pocket Guide"));
		prod1.click();
		WebElement publisher = driver.findElement(By.id("publisher-label"));
		System.out.println("Publisher name is "+publisher);
		WebElement data1 = driver.findElement(By.xpath("//label[contains(text(),\"O'Reilly Media\")]"));
		boolean d1 = data1.equals("O'Reilly Media");
		System.out.println(d1);
	}*/
	
	/*@Test
	public void testCase3() {
		driver.get("https://demoqa.com/books");
		WebElement loginBtn = driver.findElement(By.id("login"));
		loginBtn.click();	
	}*/
	
	/*@Test
	public void testCase4() {
		driver.get("https://demoqa.com/register");
		WebElement fname = driver.findElement(By.xpath("//input[@id='firstname']"));
		fname.sendKeys("k11");
		
		WebElement lname = driver.findElement(By.xpath("//input[@id='lastname']"));
		lname.sendKeys("b11");
		
		WebElement uname = driver.findElement(By.xpath("//input[@id='userName']"));
		uname.sendKeys("kbhat1234");
		
		WebElement pswd = driver.findElement(By.xpath("//input[@id='password']"));
		pswd.sendKeys("Myname@2376");
		
		WebElement iframeSwitch = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[6]/div[1]"));
		driver.switchTo().frame(iframeSwitch);
		driver.findElement(By.cssSelector("div.recaptcha-checkbox-checkmark")).click();
		
		WebElement regBtn = driver.findElement(By.xpath("//button[@id='register']"));		
		regBtn.click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	}*/
	
	@Test
	public void textBox() {
		
		driver.get("https://demoqa.com/text-box");
		
		//Take the screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
        //Copy the file to a location and use try catch block to handle exception
        try {
            FileUtils.copyFile(screenshot, new File("C:\\Users\\Karthik.bhat\\eclipse-workspace\\web automation\\craftsilicon\\src\\test\\textbox.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }	
        
		WebElement uname = driver.findElement(By.id("userName"));
		uname.sendKeys("Karthik K Bhat");
		
		WebElement email = driver.findElement(By.id("userEmail"));
		email.sendKeys("kbhat.anurag@gmail.com");
		
		WebElement curAddr = driver.findElement(By.id("currentAddress"));
		curAddr.sendKeys("Kolte Patil Raaga Apts, B502, Kannuru, 562149");
		
		WebElement perAddr = driver.findElement(By.id("permanentAddress"));
		perAddr.sendKeys("Anurag old state bank lane, Udupi 576101");
		
		WebElement submitBtn = driver.findElement(By.id("submit"));
		submitBtn.click();
			
	}
	/*
	@Test
	public void radioBtn() {
		driver.get("https://demoqa.com/radio-button");
		
		//Take the screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
        //Copy the file to a location and use try catch block to handle exception
        try {
            FileUtils.copyFile(screenshot, new File("C:\\Users\\Karthik.bhat\\eclipse-workspace\\web automation\\craftsilicon\\src\\test\\yesRadioBtn.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        WebElement yesBtn = driver.findElement(By.id("yesRadio"));
        System.out.println(yesBtn.isDisplayed());
        System.out.println(yesBtn.isEnabled());
        System.out.println(yesBtn.isSelected());
        
        WebElement impressiveBtn = driver.findElement(By.id("impressiveRadio"));
        System.out.println(impressiveBtn.isDisplayed());
        System.out.println(impressiveBtn.isEnabled());
        System.out.println(impressiveBtn.isSelected());
        
        WebElement NoBtn = driver.findElement(By.id("noRadio"));
        System.out.println(NoBtn.isDisplayed());
        System.out.println(NoBtn.isEnabled());
        System.out.println(NoBtn.isSelected());      
	}*/
	
	@AfterMethod
	public void tearDown() {
		//System.out.println("testCase1 is completed");
		//System.out.println("testCase2 is completed");
		//driver.close();
		driver.quit();
	}
}