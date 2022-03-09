package Selenium.Automationtesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcase1 {
	
	WebDriver driver;
	
	public String readdatafromproperty(String key) throws IOException {
		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream("B:\\work space\\Automationtesting\\Testdata1.properties");
		properties.load(fileInputStream);
		String value = properties.getProperty(key);
		return value;
	}
	
	public void takeScreenshot(String name) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File ScrFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("B:\\work space\\Automationtesting\\ScreenShot"+name+".png");
		FileUtils.copyFile(ScrFile, DestFile);

	}
	
	
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "B:\\work space\\Automationtesting\\Drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.facebook.com");
	}
	
    @Test
	public void test() throws InterruptedException, IOException {
		
		MavenFacebook mavenFacebook = new MavenFacebook(driver);
		mavenFacebook.clicknewaccountlink();
		takeScreenshot("facebookpage");
		Thread.sleep(2000);
		mavenFacebook.enterfirstname("sai");
		mavenFacebook.entersecondname("kumar");
		mavenFacebook.enteremail("sai123");
		mavenFacebook.enterpassword("sai123");
		takeScreenshot("data");
		

	
	}
    
    
    @Test
    public void verifyTitle() throws IOException {
		MavenFacebook mavenFacebook = new MavenFacebook(driver);
    	String actualTitle = mavenFacebook.printTitle();
    	String expectedTitle = "facebook";
		takeScreenshot("title");
    	Assert.assertEquals(actualTitle, expectedTitle);
    }
    
    @Test
    public void verifyURL() throws IOException {
		MavenFacebook mavenFacebook = new MavenFacebook(driver);
		String actualURL = mavenFacebook.printURL();
		String expectedURL = "https://www.facebook.com/";
		takeScreenshot("url");
    	Assert.assertEquals(actualURL, expectedURL);


    }
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
		
	}

}
