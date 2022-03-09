package Selenium.Automationtesting;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MavenFacebook {
	
	MavenFacebook(WebDriver driver){
		this.driver=driver;
	}
	
	WebDriver driver;
	By createNewaccountLink = By.xpath("//a[text()='Create New Account']");
	By firstname = By.name("firstname");
	By secondname = By.name("lastname");
	By email = By.name("reg_email__");
	By password = By.name("reg_passwd__");
	
	public void clicknewaccountlink() {
		driver.findElement(createNewaccountLink).click();
		
	}
	
	public void enterfirstname(String fname) {
		driver.findElement(firstname).sendKeys(fname);
	}
	
	public void entersecondname(String sname) {
		driver.findElement(secondname).sendKeys(sname);
	}
	
	public void enteremail(String mail) {
		driver.findElement(email).sendKeys(mail);
	}
	
	public void enterpassword(String pword) {
		driver.findElement(password).sendKeys(pword);
	}
	
	public String printTitle() {
		return driver.getTitle();
	}
	
	public String printURL() {
		return driver.getCurrentUrl();
	}


}
