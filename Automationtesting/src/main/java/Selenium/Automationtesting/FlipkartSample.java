package Selenium.Automationtesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlipkartSample {
	WebDriver driver;
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "B:\\work space\\Automationtesting\\Drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.flipkart.com");
	}
	@Test
	public void test() {
		String title = driver.getTitle();
		String url = driver.getCurrentUrl();
		System.out.println(title);
		System.out.println(url);
		Reporter.log(title,true);
		Reporter.log(url,true);
		
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
