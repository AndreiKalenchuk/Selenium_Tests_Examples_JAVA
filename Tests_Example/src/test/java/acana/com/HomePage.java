package acana.com;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

class HomePage {
private static WebDriver driver;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeEach
	void setUp() {
		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://asana.com/");
	}

	@AfterEach
	void tearDown() {
		driver.quit();
	}

	@Test
	void WhyAsanaLink(){
		driver.findElement(By.id("navigation__dropdown-toggle-why-asana")).click();
		
		WebElement dropDown = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".navigation__dropdown.-active")));
		assertTrue(dropDown.isDisplayed());
	}
}