package week2day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa"); 
        driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("testleaf"); 
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("shabna"); 
	    driver.findElement(By.id("createLeadForm_lastName")).sendKeys("vk");
	    

	    WebElement webelement1= driver.findElement(By.id("createLeadForm_dataSourceId")); 
	    Select d=new Select(webelement1);
	    d.selectByValue("LEAD_CONFERENCE");
	    
	    driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("shabnav");
	    driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("cse");
	    driver.findElement(By.id("createLeadForm_description")).sendKeys("test");
	    driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("test@gmail.com");
	    
	    WebElement webelement2= driver.findElement(By.name("generalStateProvinceGeoId")); 
	    Select stateDropdown=new Select(webelement2);
	    stateDropdown.selectByVisibleText("New York");
	    
		

		driver.findElement(By.name("submitButton")).click();
		
		Thread.sleep(100);
		String title1 = driver.getTitle();
		System.out.println(title1);
		
		
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("cts");
		driver.findElement(By.id("createLeadForm_firstName")).clear(); 
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Insha"); 
		driver.findElement(By.name("submitButton")).click();
		
		Thread.sleep(100);
		String title2 = driver.getTitle();
		System.out.println(title2);
		
		
		
		driver.close();
	}

}
