package Selenium.Automationtesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestingSample {
	WebDriver driver;
	
	public String readdata(String key) throws IOException {
		Properties properties = new Properties();
		FileInputStream fileinputstream = new FileInputStream("B:\\work space\\Automationtesting\\TestingSample.properties");
		properties.load(fileinputstream);
		String value = properties.getProperty(key);
		return value;
	}
	@BeforeTest
	public void launchingBrowser() {
		System.setProperty("webdriver.chrome.driver", "B:\\softwares\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//maximize the browser
		driver.manage().window().maximize();
	}
	
	public void navigateToURL(String URL) {
		driver.get(URL);
	}
	
	@Test(priority=0)
    public void test1() throws InterruptedException, IOException {
    	navigateToURL(readdata("url"));
    	Actions actions = new Actions(driver);
    	actions.sendKeys(Keys.PAGE_DOWN).build().perform();
    	Thread.sleep(2000);
    	actions.sendKeys(Keys.PAGE_UP).build().perform();
    	Thread.sleep(2000);
	}
   
	@Test(priority=1)
   public void test2() throws InterruptedException, IOException {
	   navigateToURL(readdata("url1"));
	   driver.findElement(By.xpath("(//img[@class=\"logo-img\"])[1]")).click();
	   driver.findElement(By.xpath("(//img[@class=\"logo-img\"])[2]")).click();
	   driver.findElement(By.xpath("(//img[@class=\"logo-img\"])[3]")).click();
	   Thread.sleep(2000);

	   String link = driver.getWindowHandle();
	   System.out.println(link);
	   Set<String> links = driver.getWindowHandles();
	   ArrayList<String> allLinks = new ArrayList<String>(links);
	   for(int i=0;i<allLinks.size();i++) {
	   driver.switchTo().window(allLinks.get(i));
	   System.out.println(driver.getTitle());
	   }
	   
	   driver.switchTo().window(allLinks.get(1));
	    List<WebElement> title = driver.findElements(By.tagName("a"));
	    System.out.println(title.size());
	    for(int i=0;i<allLinks.size();i++) {
	    	System.out.println(title.get(i).getText());
	    }
	    
	    driver.switchTo().window(allLinks.get(0));
	    driver.switchTo().window(allLinks.get(2));
	    List<WebElement> title1 = driver.findElements(By.tagName("a"));
	    System.out.println(title1.size());
	    for(int i=0;i<allLinks.size();i++) {
	    	System.out.println(title1.get(i).getText());
	    }
	    
	    driver.switchTo().window(allLinks.get(0));
	    driver.switchTo().window(allLinks.get(3));
	    List<WebElement> title2 = driver.findElements(By.tagName("a"));
       System.out.println(title2.size());
       for(int i=0;i<allLinks.size();i++) {
	    	System.out.println(title2.get(i).getText());
	    	Thread.sleep(2000);
	    } 
	}
	
	@Test(priority=2)
    public void test3() throws InterruptedException, IOException {
		navigateToURL(readdata("url2"));    	
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
    	driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
    	driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
    	driver.findElement(By.xpath("//a[@id='menu_leave_viewLeaveModule']")).click();
    	driver.findElement(By.xpath("//input[@id='calFromDate']")).click();
    	Thread.sleep(2000);
    	WebElement month = driver.findElement(By.className("ui-datepicker-month"));
    	Select obj = new Select(month);
    	obj.selectByVisibleText("Feb");
    	Thread.sleep(2000);
    	WebElement year = driver.findElement(By.className("ui-datepicker-year"));
    	Select obj1 = new Select(year);
    	obj1.selectByValue("2000");
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("(//a[@class='ui-state-default'])[19]")).click();
    	Thread.sleep(2000);
    	
    }
	
	@Test(priority=3)
    public void test4() throws InterruptedException, IOException {
		navigateToURL(readdata("url3"));
		driver.findElement(By.xpath("//input[@id='simple']")).click();
    	Alert alert = driver.switchTo().alert();
    	Thread.sleep(2000);
    	alert.accept();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//button[@id='confirm']")).click();
    	Alert alert2 = driver.switchTo().alert();
    	alert2.dismiss();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//button[@id='prompt']")).click();
    	Thread.sleep(2000);
    	Alert alert3 = driver.switchTo().alert();
    	alert3.sendKeys("sai");
    	Thread.sleep(2000);
    	alert3.accept();
    	Thread.sleep(2000);
    }
	
	@Test(priority=4)
    public void test5() throws InterruptedException, IOException {
		navigateToURL(readdata("url4"));
		System.out.println(driver.getTitle());
    	System.out.println(driver.getCurrentUrl());
    	System.out.println(driver.getPageSource());
    	Thread.sleep(2000);
    }
	
	@Test(priority=0)
    public void test6() throws InterruptedException, IOException {
		navigateToURL(readdata("url5"));
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
    	System.out.println(allLinks.size());
    	Thread.sleep(2000);
    }
	
	@Test(priority=5)
    public void test7() throws InterruptedException, IOException {
		navigateToURL(readdata("url6"));
		WebElement option1 = driver.findElement(By.id("vfb-7-1"));
    	option1.click();
    	System.out.println("Radio Button option1 is selected");
    	Thread.sleep(2000);
    	driver.findElement(By.id("vfb-6-0")).click();	
    	Thread.sleep(2000);
    	driver.findElement(By.id("vfb-6-1")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.id("vfb-6-2")).click();
    	Thread.sleep(2000);
    }
	
	@Test(priority=6)
    public void test8() throws IOException, InterruptedException {
    	navigateToURL(readdata("url7"));
    	WebElement text = driver.findElement(By.xpath("//a[text()='Services']"));
    	Actions actions = new Actions(driver);
    	actions.moveToElement(text).build().perform();
    	Thread.sleep(2000);
    	driver.get("https://demo.guru99.com/test/simple_context_menu.html");
    	WebElement content = driver.findElement(By.xpath("//span[text()='right click me']"));
    	Actions actions1 = new Actions(driver);
    	actions1.contextClick(content).build().perform();
    	Thread.sleep(2000);
    	WebElement click = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
    	Actions actions2 = new Actions(driver);
    	actions2.doubleClick(click).build().perform();
    	Thread.sleep(2000);
    	Alert alert = driver.switchTo().alert();
    	alert.accept();
    	Thread.sleep(2000);
    	driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
    	WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
    	WebElement destination = driver.findElement(By.xpath("//div[@id='droppable']"));
    	Actions actions3 = new Actions(driver);
    	Thread.sleep(2000);
    	actions3.dragAndDrop(source, destination).build().perform();
    	Thread.sleep(2000);
    }
	
	@Test(priority=7)
    	public void test9() throws InterruptedException, IOException {
    	navigateToURL(readdata("url8"));
    	driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
    	//takeScreenshot(driver,"landingpage");
    	Thread.sleep(2000);
    	driver.findElement(By.name("firstname")).sendKeys(readdata("name"));
    	driver.findElement(By.name("lastname")).sendKeys(readdata("name2"));
    	driver.findElement(By.name("reg_email__")).sendKeys(readdata("email"));
    	driver.findElement(By.name("reg_passwd__")).sendKeys(readdata("password"));
    	//takeScreenshot(driver,"details");
    	Thread.sleep(2000);
    	
    	TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File ScrFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("B:\\work space\\Automationtesting\\ScreenShot\\facebook.png");
		FileUtils.copyFile(ScrFile, DestFile);
		Thread.sleep(2000);
    
	}
	
    	
	@AfterTest
    public void closeBrowser() {
		driver.quit();
		
	}


}
