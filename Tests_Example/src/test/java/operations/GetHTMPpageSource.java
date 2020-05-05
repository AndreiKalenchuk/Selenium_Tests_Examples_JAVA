package operations;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class GetHTMPpageSource {
	private static WebDriver driver;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/driversSelenium/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://book.theautomatedtester.co.uk/");
	}
	
	@AfterAll
	void tearDown() throws Exception {
		driver.quit();
	}
		
	@Test
	static void getPageHtml() {
		String body = driver.getPageSource();
		System.out.println(body);
		assertTrue(body.contains("Selenium11"));
	}
}
