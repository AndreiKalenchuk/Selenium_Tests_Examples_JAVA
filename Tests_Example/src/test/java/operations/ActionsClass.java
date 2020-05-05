package operations;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

class ActionsClass {
	WebDriver driver;
	WebElement element;
	WebDriverWait wait;

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
		driver.get("https://ebay.com");
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	void test() {
		WebElement fashion = driver.findElement(By.linkText("Fashion"));
		WebElement sport = driver.findElement(By.linkText("Sporting Goods"));
		Actions actions = new Actions(driver);
		actions.moveToElement(fashion).build().perform();
		actions.moveToElement(sport).build().perform();
		actions.dragAndDrop(fashion, sport).build().perform();
		actions.clickAndHold(fashion).moveToElement(sport).release().build().perform();
		actions.doubleClick(fashion);
		
// imitation right click		
		actions.contextClick(fashion);
		
// can make a Action method - build couple actions
		Action moveFashion = actions.clickAndHold(fashion).moveToElement(sport).release().build();
		moveFashion.perform();
	}
}
