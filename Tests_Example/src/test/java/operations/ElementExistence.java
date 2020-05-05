package operations;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class ElementExistence {
	private static WebDriver driver;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/chromedriver79/chromedriver.exe");
	}

	@BeforeEach
	void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.kmart.com/");
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
// verify page does't have id = "Deleted"
	void verifyExistance() {
		List<WebElement> list = driver.findElements(By.id("Deleted"));
		assertTrue(list.size() == 0);
// verify Element exist on the page		
		assertTrue(driver.findElements(By.name("free")).size() != 0);
	}
	
	
	@Test
	void scrollingVertically() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0, 5000)"); // 0 horizontal 5000 vertically 
	}
	
	@Test
	void example() {
		selectCheckBox("Bosh");
		selectCheckBox("Acon");
		selectCheckBox("Micro");
		
		deselectCheckBox("Bosh");
	}
	
// will select element if it's not selected
	public static void selectCheckBox(String name) {
		String el = "//label[text()='%s']/span";
		if(!driver.findElement(By.xpath(String.format(el, name) + "/input")).isSelected())
			driver.findElement(By.xpath(String.format(el, name))).click();
	}
	// will deselect element if it's  selected
	public static void deselectCheckBox(String name) {
		String el = "//label[text()='%s']/span";
		if(driver.findElement(By.xpath(String.format(el, name) + "/input")).isSelected())
			driver.findElement(By.xpath(String.format(el, name))).click();
	}
	
}
