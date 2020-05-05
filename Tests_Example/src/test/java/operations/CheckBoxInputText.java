package operations;

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

class CheckBoxInputText {
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
		driver.get("http://book.theautomatedtester.co.uk/chapter1");
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	void confirmTitle() throws InterruptedException {
		String title = driver.getTitle();
		assertEquals("Selenium: Beginners Guide", title);
	}

	@Test
	void getStatusCheckBox() throws InterruptedException {
		
// verify all checkBox is Displayed		
		List<WebElement> checkBox = driver.findElements(By.name("selected(1234)"));
		
		for(WebElement el: checkBox)
			assertTrue(el.isDisplayed());
		
		for(WebElement el: checkBox)
		el.click();
		
		for(WebElement el: checkBox)
		assertTrue(el.isSelected());
	}

// verify inserted text in textArea
	@Test
	void readInputField() throws InterruptedException {
		String inputText = "Hello";
		WebElement inputValue = driver.findElement(By.id("q"));
		inputValue.sendKeys(inputText);
//		driver.findElement(By.id("q")).sendKeys(inputText);
		assertEquals(inputText, inputValue.getAttribute("value"));
	}
}
