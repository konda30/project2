package Nam;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test4 {
	
	WebDriver driver;
	private String Url = "https://www.webmath.com/";

	@BeforeClass
	public void launch() {
		// Set up the WebDriver and open the browser
		System.setProperty("webdriver.chrome.driver","C:/Users/Maharshi/eclipse-workspace/Jar files/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Url);

	}
	
	@BeforeMethod
	public void ToMathForEveryone() {
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@title='Math for Everyone']")).click();	
		
	}
	
	@AfterMethod
	public void tomainframe() {
		driver.switchTo().defaultContent();
	}
	
	@AfterClass
	public void close() {
		driver.quit();
	}
	
	@Test(priority=1, description = "Verify that the driver is being redirected to Length converter page")
	public void lengthunits() {
		
		driver.findElement(By.xpath("//*[text()='Length']")).click();
		String ttl = driver.getTitle();
		String expectedttl = "Units Conversions on Lengths - WebMath";
		Assert.assertEquals(ttl,expectedttl,"Test failed, Driver is not redirected to the expected page");
		
	}
	
	@Test(priority=2)
	public void converts() {
		
		driver.findElement(By.xpath("//*[text()='Length']")).click();
		WebElement lngth = driver.findElement(By.xpath("//*[@name='param0']"));
		WebElement units = driver.findElement(By.xpath("//select[@name='param1']"));
		WebElement tounit = driver.findElement(By.xpath("//select[@name='param2']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
		
		Assert.assertTrue(lngth.isDisplayed(),"Test failed, length input box is not displayed");
		Assert.assertTrue(units.isDisplayed(),"Test failed, Units dropdown is not displayed");
		Assert.assertTrue(tounit.isDisplayed(),"Test failed, Units to be converted dropdown is not displayed");
		Assert.assertTrue(submit.isDisplayed(),"Test failed, Submit button is not displayed");
	
		Assert.assertTrue(lngth.isEnabled(),"Test failed, length input box is not enabled");
		Assert.assertTrue(units.isEnabled(),"Test failed, Units dropdown box is not enabled");
		Assert.assertTrue(tounit.isEnabled(),"Test failed,  Units to be converted dropdown is not enabled");
		Assert.assertTrue(submit.isEnabled(),"Test failed, Submit button is not enabled");
	}
	
	@Test(priority=3)
	public void inches() {
		
		driver.findElement(By.xpath("//*[text()='Length']")).click();
		WebElement lngth = driver.findElement(By.xpath("//*[@name='param0']"));
		WebElement units = driver.findElement(By.xpath("//select[@name='param1']"));
		WebElement tounit = driver.findElement(By.xpath("//select[@name='param2']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
		
		lngth.sendKeys("12");
		Select s = new Select(units);
		s.selectByVisibleText("inch(es)");
		Select s1 = new Select(tounit);
		s1.selectByVisibleText("centimeter(s)");
		submit.click();
		
		WebElement resultframe = driver.findElement(By.id("centerContentFrame"));
		Assert.assertTrue(resultframe.isDisplayed(),"Test failed, calculation not done");
		driver.switchTo().frame(resultframe);
		String result = driver.findElement(By.xpath("/html/body/font/font/font/p[1]")).getText();
		String expectedresult = "Or, as a final answer, 12 inch(es) is 30.480000 centimeter(s)";
		Assert.assertEquals(result, expectedresult,"Test failed, calculation is not correct");
		
	}
	
	@Test(priority=4)
	public void masses() {
		
		driver.findElement(By.xpath("//*[text()='mass']")).click();
		String ttl = driver.getTitle();
		String expectedttl = "Units Conversions on Masses - WebMath";
		Assert.assertEquals(ttl,expectedttl,"Test failed, Driver is not redirected to the expected page");
		
	}
	
	@Test(priority=5)
	public void grams() {
		
		driver.findElement(By.xpath("//*[text()='mass']")).click();
		WebElement mass = driver.findElement(By.xpath("//*[@name='param0']"));
		WebElement units = driver.findElement(By.xpath("//select[@name='param1']"));
		WebElement tounit = driver.findElement(By.xpath("//select[@name='param2']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
		
		mass.sendKeys("1000");
		Select s = new Select(units);
		s.selectByVisibleText("gram(s)");
		Select s1 = new Select(tounit);
		s1.selectByVisibleText("kilogram(s)");
		submit.click();
		
		WebElement resultframe = driver.findElement(By.id("centerContentFrame"));
		Assert.assertTrue(resultframe.isDisplayed(),"Test failed, calculation not done");
		driver.switchTo().frame(resultframe);
		String result = driver.findElement(By.xpath("/html/body/font/font/font/p[1]")).getText();
		String expectedresult = "Or, as a final answer, 1000 gram(s) is 1.000000 kilogram(s)";
		Assert.assertEquals(result, expectedresult,"Test failed, calculation is not correct");
		
	}
	
	@Test(priority=6)
	public void area() {
		
		driver.findElement(By.xpath("//*[text()='area']")).click();
		String ttl = driver.getTitle();
		String expectedttl = "Units Conversions on Areas - WebMath";
		Assert.assertEquals(ttl,expectedttl,"Test failed, Driver is not redirected to the expected page");
		
	}
	
	@Test(priority=7)
	public void square() {
		
		driver.findElement(By.xpath("//*[text()='area']")).click();
		WebElement area = driver.findElement(By.xpath("//*[@name='param0']"));
		WebElement units = driver.findElement(By.xpath("//select[@name='param1']"));
		WebElement tounit = driver.findElement(By.xpath("//select[@name='param2']"));
		WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
		
		area.sendKeys("1000");
		Select s = new Select(units);
		s.selectByVisibleText("square foot/feet");
		Select s1 = new Select(tounit);
		s1.selectByVisibleText("square meter(s)");
		submit.click();
		
		WebElement resultframe = driver.findElement(By.id("centerContentFrame"));
		Assert.assertTrue(resultframe.isDisplayed(),"Test failed, calculation not done");
		driver.switchTo().frame(resultframe);
		String result = driver.findElement(By.xpath("/html/body/font/font/font/p[1]")).getText();
		String expectedresult = "Or, as a final answer, 1000 square foot/feet is 92.936806 square meter(s)";
		Assert.assertEquals(result, expectedresult,"Test failed, calculation is not correct");
		
	}
	
	@Test(priority=8)
	public void volume() {
		
		driver.findElement(By.xpath("//*[text()='volume']")).click();
		String ttl = driver.getTitle();
		String expectedttl = "Units Conversions on Volumes - WebMath";
		Assert.assertEquals(ttl,expectedttl,"Test failed, Driver is not redirected to the expected page");
		
	}
}
	
	
