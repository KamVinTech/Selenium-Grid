package messageModule;

import org.testng.annotations.Test;
import org.testng.internal.thread.TestNGThread;
import org.yaml.snakeyaml.tokens.Token.ID;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class MessgaeModule {
	WebDriver driver;
	@BeforeTest
	public void beforeTest() {
		driver=new FirefoxDriver();
		driver.get("http://localhost:8585/do/");
		driver.manage().window().maximize();
		driver.findElement(By.name("principal")).sendKeys("admin");
		driver.findElement(By.cssSelector("input#cyclosPassword")).sendKeys("1234");
		driver.findElement(By.className("button")).click();

	}
	//this module is for checking the authentication and authorization of the application by applying the correct credentials.

	@Test(priority=2)
	public void LoggedIn() throws InterruptedException {
	/*	driver.findElement(By.name("principal")).sendKeys("admin");
		driver.findElement(By.cssSelector("input#cyclosPassword")).sendKeys("1234");
		driver.findElement(By.className("button")).click();
	*/
	String expected=driver.getCurrentUrl();
	
		String actual="http://localhost:8585/do/admin/home";
		//System.out.println(driver.getTitle());

		if(expected.equals(actual))
		{
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/ul/li[9]/span[2]")).click();
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/ul/li[9]/ul/li[1]/span[2]")).click();
		}
		else
		{
			System.out.println("go to login page.");
		}

		Thread.sleep(3000);

		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[3]/table[1]/tbody/tr/td/input")).click();
		WebElement sendTo=driver.findElement(By.id("sendToSelect"));
		List <WebElement> msg=sendTo.findElements(By.tagName("Option"));

		Select select=new Select(driver.findElement(By.id("sendToSelect")));
		select.selectByVisibleText("Member");
		System.out.println(msg.size());
		for(int i=0; i<msg.size();i++)
		{

			System.out.println(msg.get(i).getText());
			if(msg.get(i).getText().equals("Member")){
				//when in SendTo column, you have selected "Member".

				System.out.println("right function.");

				{
					driver.findElement(By.id("memberUsername")).sendKeys("saanvi");
					Thread.sleep(3000);


					//driver.findElement(By.id("memberName")).sendKeys("samsaravanan");
					//driver.findElement(By.id("memberName")).sendKeys();
				//	WebElement list=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[3]/form/table/tbody/tr[2]/td/table/tbody/tr[5]/td[1]"));
					Thread.sleep(3000);
					driver.findElement(By.id("subjectText")).sendKeys("change password");
					Thread.sleep(3000);
					driver.findElement(By.tagName("iframe")).sendKeys("my name is sachin sharma and i want to become a scientist.");
					TestNGThread.sleep(3000);
					driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[3]/form/table/tbody/tr[2]/td/table/tbody/tr[8]/td/input")).click();}}					
			Thread.sleep(3000);		
			Alert alert=driver.switchTo().alert();
			alert.accept();

			driver.get("http://localhost:8585/do/admin/listMessageCategories?fromMenu=true");
			driver.findElement(By.id("newButton")).click();
			driver.findElement(By.name("messageCategory(name)")).sendKeys("sachin sharma");
			driver.findElement(By.id("saveButton")).click();
			Alert alert1=driver.switchTo().alert();
			alert1.accept();

			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[3]/table[1]/tbody/tr[2]/td/table/tbody/tr[6]/td[2]/img[2]")).click();

			Alert alert2=driver.switchTo().alert();
			alert2.accept();
			Thread.sleep(2000);
			System.out.println("the element is removed.");}
		
		
	}
	
@Test (priority=1)
	
	public void fe() throws InterruptedException{
//this module is for checking the authentication and authorization of the application by applying the correct credentials.

	/*	driver.findElement(By.name("principal")).sendKeys("admin");
		driver.findElement(By.cssSelector("input#cyclosPassword")).sendKeys("1234");

       driver.findElement(By.className("button")).click();
	*/	
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
	driver.navigate().to("http://localhost:8585/do/admin/home");
	Thread.sleep(2000);
}
	//till here.

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
