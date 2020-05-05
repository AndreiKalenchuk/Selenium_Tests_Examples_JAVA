package tables;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class TablesUdemi {
	static WebDriver driver;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/chromedriver79/chromedriver.exe");
//		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	void test() {
		WebElement tableElement = driver.findElement(By.xpath("//table[@id ='customers']"));
		Table table = new Table(tableElement, driver);
		System.out.println(table.getRows().size() + " is number of rows");
		System.out.println(table.getValueFromCell(1, 3));
		System.out.println(table.getValueFromCell(4, 1));
		System.out.println(table.getValueFromCell(4, "Company"));
		System.out.println(table.getValueFromCell(1, "Country"));
		System.out.println(table.getValueFromCell(2, "Contact"));
		assertEquals(table.getHeadings().get(0).getText(), "Company");
	}
}
