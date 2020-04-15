package acana.com;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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

class FooterLinks {
	private static WebDriver driver;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		WebDriverManager.chromedriver().setup();
	}

	private Object String;

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
	void countOfFooterLinksIs37() {
		List<WebElement> countOfLinks = driver.findElements(By.id("globalFooter"));
		assertTrue(countOfLinks.size() == 37);
	}

	@Test
	void allLinksIsCleakable() {
		List<WebElement> countOfLinks = driver.findElements(By.id("globalFooter"));
		for (int i = 0; i < countOfLinks.size(); i++) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(countOfLinks.get(i)));
			String str = countOfLinks.get(i).getAttribute("href");
			countOfLinks.get(i).click();
			assertTrue(driver.getCurrentUrl().contains(str));
			driver.get("https://asana.com/");
		}
	}
}