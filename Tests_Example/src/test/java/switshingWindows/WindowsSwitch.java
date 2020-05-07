package switshingWindows;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class WindowsSwitch {
	private WebDriver driver;
	private String secondTitle = "New Window";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/chromedriver79/chromedriver.exe");
	}

	@BeforeEach
	void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/windows");
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}
	@Test
	void swithBetweenTabs() throws InterruptedException {
		String firstWindow = driver.getWindowHandle(); // Assign current window handle to variable
		driver.findElement(By.linkText("Click Here")).click();
		
		String secondWindow = null;
				
		Set<String> allWindows = driver.getWindowHandles(); // assign all opened windows handleS to Set
		
		for(String handle: allWindows)  
			if (!handle.equals(firstWindow)) 
				secondWindow = handle;       // if current handle not equal firstWin --> it is a second
			
		////   OR   without
		 for(String handle: driver.getWindowHandles())  
			  if (!handle.equals(firstWindow)) 
			      secondWindow = handle; 	

			   // Get last opened window
			for(String handler: driver.getWindowHandles() )
			      driver.switchTo().window( handler );
          //////////////
		
		driver.switchTo().window(secondWindow);
		assertEquals(secondTitle, driver.getTitle()); 
		
		driver.switchTo().window(firstWindow);

		driver.close(); // will close current Window(driver)--> first window 
		                // after jump to second Window
		Thread.sleep(2000);
	}
	
}
