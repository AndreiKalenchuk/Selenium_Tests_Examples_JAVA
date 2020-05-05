package operations;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
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
import org.openqa.selenium.support.ui.Select;

class DropDownSelect {
	private static WebDriver driver;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/chromedriver79/chromedriver.exe");
//		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.compendiumdev.co.uk/selenium/basic_html_form.html");
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	void testSelect() {
		WebElement dropDown = driver.findElement(By.name("dropdown"));
		Select s = new Select(dropDown);
		s.selectByVisibleText("Drop Down Item 6");
		s.selectByIndex(1);
		s.selectByValue("dd1");
		System.out.println(s.getFirstSelectedOption().getText());
		
// get all dropdown options 
		// 1
		List<WebElement> list = driver.findElements(By.name("dropdown"));
		for (WebElement element : list)
			System.out.println(element.getText());
		// 2
		List<WebElement> options = s.getOptions();
		System.out.println(options.size() + "..................");
// creating List with all dropDown options (fill List using Select.getOptions)
		List<WebElement> listOptions = s.getOptions();
		int lenth = listOptions.size();
		// OR //
		List<WebElement> listOfOptions = new ArrayList<>();
		listOfOptions.addAll(s.getOptions());
// verify all options values String.format	
		for (int i = 0; i < lenth; i++) {
			s.selectByIndex(i);
			assertEquals(s.getFirstSelectedOption().getAttribute("value"), String.format("dd%d", i + 1));
		}
// compare all options text with List data		
		for (int i = 0; i < lenth; i++) {
			s.selectByIndex(i);
			assertEquals(s.getFirstSelectedOption().getText(), listOptions.get(i).getText());
		}
	}

// compare values from List of data to actual	
	@Test
	void validateFromList() {
		List<String> dataList = new ArrayList<>();
		dataList.add("Drop Down Item 1");
		dataList.add("Drop Down Item 2");
		dataList.add("Drop Down Item 3");
		dataList.add("Drop Down Item 4");
		dataList.add("Drop Down Item 5");
		dataList.add("Drop Down Item 6");
		WebElement el = driver.findElement(By.name("dropdown"));
		Select select = new Select(el);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			select.selectByIndex(i);
			System.out.println(select.getFirstSelectedOption().getText());
			assertTrue(select.getFirstSelectedOption().getText().contains(dataList.get(i)));
		}
	}

// verify every iteration select only one option	
	@Test
	void confirmWasSelectedOne() {
		WebElement el = driver.findElement(By.name("dropdown"));
		Select select = new Select(el);
//		List<WebElement> listOfSelected = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			select.selectByIndex(i);
			System.out.println(select.getAllSelectedOptions().size() + "..... .getAllSelectedOptions().size() ");
			assertEquals(1, select.getAllSelectedOptions().size());
		}
	}

	@Test
	void multiSelect() throws InterruptedException {
		WebElement multi = driver.findElement(By.name("multipleselect[]"));
		Select s = new Select(multi);
// deselect items before selection		
		s.deselectAll();
		s.selectByIndex(0);
		s.selectByIndex(1);
		s.deselectAll();
		s.selectByValue("ms3");
	}
}
