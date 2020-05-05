package tables;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class Tables {
	private static WebDriver driver;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/driversSelenium/chromedriver.exe");
	}

	@BeforeEach
	void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/tables");
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}
// print quantity of rows
	@Test
	void tableTest() {
		List<WebElement> rows = driver.findElements(By.xpath("//table[2]//tbody//tr"));
		System.out.println("Number of rows " + rows.size());
		
//	print value from dues	
//		for(WebElement row: rows)
//			System.out.println(row.findElement(By.className("dues")).getText());
// or 		
//		System.out.println(row.getText().split(" ")[3]);
//OR	
		String element;
		for(int i = 1; i <= rows.size(); i++) {
			element = "//table[2]/tbody/tr[" + i + "]/td[4]";
			System.out.println(driver.findElement(By.xpath(element)).getText());
		}
	}
}
