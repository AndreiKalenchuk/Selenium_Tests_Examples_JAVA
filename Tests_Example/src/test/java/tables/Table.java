package tables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Table {
	private WebElement tableElement;
	private WebDriver driver;

// constructor    
	public Table(WebElement tableElement, WebDriver driver) {
		this.tableElement = tableElement;
		this.driver = driver;
	}

// return List of all rows in table excluded header
	public List<WebElement> getRows() {
		List<WebElement> rows = tableElement.findElements(By.xpath(".//tr"));
		rows.remove(0);
		return rows;
	}

// return List of headers of the table
	public List<WebElement> getHeadings() {
		List<WebElement> headers = tableElement.findElements(By.xpath(".//tr[1]/th"));
		return headers;
	}

// loop for each row of table divide by columns 
// and put it like a List<WebElement> in List<List<WebElement>> rowWithColumns 
// return List of Lists with columns as WebElements    
	public List<List<WebElement>> getRowsWithColumns() {
		List<WebElement> rows = getRows();
		List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();
		for (WebElement row : rows) {
			List<WebElement> rowWithColumns = row.findElements(By.xpath(".//td"));
			rowsWithColumns.add(rowWithColumns);
		}
		return rowsWithColumns;
	}

// will get Text from rowNum as a index of List<WebElement>
// then get Text from columnNum as a inner index    
	public String getValueFromCell(int rowNumber, int columnNumber) {
		List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
		WebElement cell = rowsWithColumns.get(rowNumber - 1).get(columnNumber - 1);
		return cell.getText();
	}
// take a header index + table row WebEl as a Map
// assign it to List<Map<String, WebElement>>   
// Example  Company:Alfreds Futterkie; Contact: Maria Anders ...
//           Company:Centro comercial; Contact: Fransco Chang ....

	public List<Map<String, WebElement>> getRowsWithColumnsByHeadings() {
		List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
		List<Map<String, WebElement>> rowsWithColumnsByHeadings = new ArrayList<Map<String, WebElement>>();
		Map<String, WebElement> rowByHeadings = new HashMap<String, WebElement>();
		List<WebElement> headingColumns = getHeadings(); // created to get quantity of table columns
		for (List<WebElement> row : rowsWithColumns) {
			for (int i = 0; i < headingColumns.size(); i++) {
				String heading = headingColumns.get(i).getText();// go throw the row of hesders el return String
				WebElement cell = row.get(i); // go throw table body rows return WebElement
				rowByHeadings.put(heading, cell);// assigne Str and WebEl to HasMap
			}
			rowsWithColumnsByHeadings.add(rowByHeadings); // add map is List of maps
		}
		return rowsWithColumnsByHeadings;
	}

// receive row Num and key
// call method getRowsWithColumnsByHeadings() contains map header + WebElement
// return Text of WebElement fined by header name  
	public String getValueFromCell(int rowNumber, String columnName) {
		List<Map<String, WebElement>> rowsWithColumnsByHeadings = getRowsWithColumnsByHeadings();
		return rowsWithColumnsByHeadings.get(rowNumber - 1).get(columnName).getText();
	}
}
