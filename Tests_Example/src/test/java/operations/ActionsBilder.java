package operations;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class ActionsBilder {
	private static WebDriver driver;
	private Actions builder;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/driversSelenium/chromedriver.exe");
	}

	@BeforeEach
	void setUp() throws Exception {
		driver = new ChromeDriver();
		builder = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	void moveMouseWithAlert() {
		driver.get("http://book.theautomatedtester.co.uk/chapter4");
		WebElement mouseOver = driver.findElement(By.id("hoverOver")); 
		
		builder.moveToElement(mouseOver).perform(); // move mouse to mouseOver element on a page
		Alert alert = driver.switchTo().alert(); // move driver to popUp window
		alert.accept(); // OK
		alert.dismiss(); // dismiss, cancel
	}
	
	@Test
	void moveMouseWithOffset() {
		driver.get("https://webminal.org/");
		WebElement btn = driver.findElement(By.linkText("Register"));
// point p = btn.getLocation();
		builder.moveByOffset(btn.getLocation().getX() + 6, btn.getLocation().getY() + 6)
						.click().perform();  // getting btn location and move 6phl to center and click
		assertEquals("Join", driver.getTitle());
	}
	
	@Test
	void dragAndDrop() {
		driver.get("https://demoqa.com/droppable");
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		builder.dragAndDrop(source, target).perform();;  // move el source to el target and perform
		assertEquals("Dropped", target.getText());
	}
	
	@Test
		void dragByOffset() throws InterruptedException {
		
		driver.get("https://demoqa.com/droppable");
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		int xSource = source.getLocation().getX();
		int ySource = source.getLocation().getY();
		
		int xTarget = target.getLocation().getX();
		int yTarget = target.getLocation().getY();
		
		int xMove = xTarget - xSource + 11;
		int yMove = yTarget - yTarget + 11;
				
		builder.dragAndDropBy(source, xMove, yMove).perform(); // move el from source to X(move) and Y(move) 
		
		Thread.sleep(3000);
		
		assertEquals("Dropped", target.getText());
		
		}
	@Test
	void seriosOfActions() {
		
	}
	
//	@Test
//	void dragByOffsetBinance() throws InterruptedException {
//	driver.get("https://accounts.binance.com/en/login");
//	driver.findElement(By.name("email")).sendKeys("andrey.kalenchyk@gmail.com");
//	driver.findElement(By.name("password")).sendKeys(pass);
//	Thread.sleep(5000);
//	driver.findElement(By.className("css-1hv630j")).click();
//	Thread.sleep(2000);	
//	WebElement roll = driver.findElement(By.className("geetest_result_content"));
//	int random = Math.floor(Math.random()*160);
//	do {
//		driver.findElement(By.className("geetest_refresh_1")).click();
//		Thread.sleep(1500);	
//	WebElement source = driver.findElement(By.cssSelector(".geetest_slider_button"));
//	builder.dragAndDropBy(source, random, 0).perform();
//	Thread.sleep(1000);
//	} 
//	while(roll.isDisplayed());
//	assertEquals("Two-factor Authentication | Binance", driver.getTitle());	
//	}
	
}
