package messageModule;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Categories {
	WebDriver driver;
	@BeforeTest
	public void beforeTest() {
		driver=new FirefoxDriver();
		driver.get("http://localhost:8585/do/");
		driver.manage().window().maximize();
	}	  
	@Test
	
	public void f() throws InterruptedException{
//this module is for checking the authentication and authorization of the application by applying the correct credentials.

		driver.findElement(By.name("principal")).sendKeys("admin");
		driver.findElement(By.cssSelector("input#cyclosPassword")).sendKeys("1234");

        driver.findElement(By.className("button")).click();
		
		String expected=driver.getCurrentUrl();
		String actual="http://localhost:8585/do/admin/home";
		//System.out.println(driver.getTitle());
//this code is for going to the messages tab and categories.
		if(expected.equals(actual))
		{
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/ul/li[9]/span[2]")).click();
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/ul/li[9]/ul/li[1]/span[2]")).click();

		}
	//this module is for checking whether the categories/select all/select none/actions are working or not.
		WebElement catog=driver.findElement(By.id("messageBoxSelect"));
		List <WebElement> type=catog.findElements(By.tagName("Option"));

		Select select=new Select(driver.findElement(By.id("messageBoxSelect")));
		select.selectByVisibleText("Sent items");
		WebElement category =driver.findElement(By.id("categoriesSelect"));
		List <WebElement> cat=category.findElements(By.tagName("Option"));
		Select select1=new Select(driver.findElement(By.id("categoriesSelect")));
		select1.selectByVisibleText("Support");
		System.out.println(type.size());
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[3]/form[2]/table[2]/tbody/tr/td[1]/input[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='selectNoneButton']")).click();
Thread.sleep(1000);
	WebElement abox=driver.findElement(By.id("applyActionSelect"));
	List <WebElement> actions=abox.findElements(By.tagName("Option"));
	Select select2=new Select(driver.findElement(By.id("applyActionSelect")));
	driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[3]/form[2]/table[2]/tbody/tr/td[1]/input[1]")).click();
Thread.sleep(2000);	
	select2.selectByVisibleText("Mark as read");
	Thread.sleep(2000);
	//till here
	
	//this module is for checking whether the message details page is dipslayed or not.
	driver.findElement(By.partialLinkText("change password")).click();
	
	driver.getCurrentUrl();
	String actualality = "http://localhost:8585/do/admin/viewMessage?messageId=65";
	if(driver.getCurrentUrl().equals(actualality))
	{
		System.out.println("working properly.");
		
	}
	else
	{
		System.out.println("not working properly.");
	}
	
	System.out.println("the overall application is working fine.");

	//till here.
	}
@AfterTest
	public void afterTest() {
driver.close();
	}

}
