package functions

import graphql.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;



import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class J {


	//****** BASIC FUNCTION


	// FUNCTION: NAVIGATE TO URL - OK
	public static void Navigate_Chrome(WebDriver driver, String url) {


		driver.manage().window().maximize()
		driver.get(url)

	}
	// FUNCTION: TO PRINT

	public static void Print(String text) {

		System.out.println(text)


	}

	// FUNCTION: TO CLICK BUTTON

	public static void Click(WebDriver driver, String xpath) {

		driver.findElement(By.xpath(xpath)).click()

	}

	// FUNCTION: TO UPLOAD A FILE

	public static void Upload_File(WebDriver driver, String xpath, String filepath, String textPresent) throws InterruptedException {

		WebElement uploadElement = driver.findElement(By.xpath(xpath))

		// enter the file path onto the file-selection input field
		uploadElement.sendKeys(filepath)

		Thread.sleep(3 * 1000)

		while (true) {
			if (driver.getPageSource().contains(textPresent)==false)
			{uploadElement.sendKeys(filepath)
				break
			}
			else if (driver.getPageSource().contains(textPresent)==true)
			{

				break
			}

		}}




	// FUNCTION: TO SCROLL TO ELEMENT

	public static void ScrollToElement (WebDriver driver, String xpath) throws InterruptedException {

		WebElement element = driver.findElement(By.xpath(xpath))
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element)
		Thread.sleep(500)
	}

	//FUNCTION: PAGE DOWN THE PAGE
	public static void Pagedown (WebDriver driver) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver

		//This will scroll the web page till end.
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)")

		Thread.sleep(500)

	}

	//FIELD
	// FUNCTION: TO SELECT FROM LIST

	public static void SelectFromList(WebDriver driver, String xpath, String value) {

		new Select(driver.findElement(By.xpath(xpath))).selectByValue(value)

	}

	// FUNCTION: TO CHOOSE 1 OPTION FROM MULTIPLE LIST

	public static void SelectFromMultipleList(WebDriver driver, String xpath_Multiplelist, String xpath_addbutton, String value) throws InterruptedException {
		//SELECT FROM LIST
		new Select(driver.findElement(By.xpath(xpath_Multiplelist))).selectByValue(value)

		Thread.sleep(1*1000)

		//CLICK ADD BUTTON
		driver.findElement(By.xpath( xpath_addbutton)).click()


	}

	// FUNCTION: TO SET TEXT

	public static void SetText(WebDriver driver, String xpath, String text) {

		driver.findElement(By.xpath(xpath)).sendKeys(text)

	}

	// FUNCTION: TO MOUSE OVER

	public static void Hover(WebDriver driver, String xpath) {

		//Instantiate Action Class
		Actions actions = new Actions(driver)
		//Retrieve WebElement 'Music' to perform mouse hover
		WebElement menuOption = driver.findElement(By.xpath(xpath))
		//Mouse hover menuOption 'Music'
		actions.moveToElement(menuOption).perform()

	}

	// FUNCTION: TO CLICK ON JS

	public static void Click_Button_JS (WebDriver driver, String xpath) {

		WebElement element = driver.findElement(By.xpath(xpath))
		JavascriptExecutor executor = (JavascriptExecutor)driver
		executor.executeScript("arguments[0].click();", element)


	}

	// FUNCTION: TO GET PROJECT NO

	public static String ProjectNo (WebDriver driver) {

		String url = driver.getCurrentUrl()
		String Project_No = url.substring(url.length() - 8)
		return Project_No

	}
	// FUNCTION: TO GET REF NO
	public static String RefNo (WebDriver driver) {

		String urlref = driver.getCurrentUrl()
		String myrefId = urlref.split("id_ref=")[1]
		String refID = myrefId.substring(0,4)
		return refID
	}

	// FUNCTION: TO GET REF NO TAG
	public static String RefNo_tag (WebDriver driver) {

		String urlref = driver.getCurrentUrl()
		String myrefId = urlref.split("id_ref=")[1]
		String refID = myrefId.substring(0,5)
		return refID

	}




	// FUNCTION: TO LOGIN MEDIABOX
	public static void Login_password(WebDriver driver,String username, String password) throws InterruptedException {

		//SET TEXT USERNAME
		driver.findElement(By.xpath("//input[@id='MDB_WebUserCode']")).sendKeys(username)
		Thread.sleep(1000)

		//SET TEXT PASSWORD
		driver.findElement(By.xpath("//*[@id=\"formLogin\"]/div[3]/div/input")).sendKeys(password)
		Thread.sleep(1000)

		//CLICK LOGIN BUTTON
		driver.findElement(By.xpath("//button[@type='submit']")).click()

	}
	// FUNCTION: TO LOGOUT MEDIABOX
	public static void Logout(WebDriver driver) throws InterruptedException {

		//CLICK ON MY PROFILE
		driver.findElement(By.xpath("//div[@id='kt_header']/div/div[2]/div[2]/div/div/span/img")).click()

		Thread.sleep(1*1000)

		//CLICK ON LOGOUT
		driver.findElement(By.xpath("//div[@id='kt_header']/div/div[2]/div[2]/div[2]/a[3]")).click()

	}
	// FUNCTION: TO LOGOUT XPATH MEDIABOX
	public static void Logout_Xpath(WebDriver driver, String xpath) throws InterruptedException {

		//CLICK ON MY PROFILE
		driver.findElement(By.xpath("//div[@id='kt_header']/div/div[2]/div[2]/div/div/span/img")).click()

		Thread.sleep(1*1000)

		//CLICK ON LOGOUT
		driver.findElement(By.xpath(xpath)).click()

	}
	// FUNCTION: TO SEARCH PROJECT IN MEDIABOX
	public static void SearchProjectNo(WebDriver driver, String text, String xpath_Apply) throws InterruptedException {

		//SET TEXT : KEYWORDS
		driver.findElement(By.xpath("//*[@id=\"keynum_project\"]")).sendKeys(text)

		//WAIT
		Thread.sleep(2*1000)

		//CLICK ON APPLY
		driver.findElement(By.xpath(xpath_Apply)).click()


	}



	// FUNCTION: TO GET SYSTEM DATE
	public static String gettimedate ()  {

		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("MMMddyyyy_HHmmss")

		//get current date time with Date()
		Date date = new Date()

		// Now format the date
		String date1= dateFormat.format(date)

		//RETURN DATE
		return date1
	}

	// FUNCTION: TO VERIFY THE STATUS OF THE LIFECYCLE

	public static void LC_status (WebDriver driver, String xpath, String Expected_Status) throws InterruptedException {

		String text =  driver.findElement(By.xpath(xpath)).getText()
		J.Print("status > "+ text)


		if(text.contains(Expected_Status))
		{

			Assert.assertTrue(text.contains(Expected_Status))
			J.Print("status > PASS")

		}
		else
		{
			J.Print("status > FAIL")
			Assert.assertTrue(false)
			J.Print("status > FAIL")

		}


	}


	// FUNCTION: TO APPROVE A DOC IN MEDIABOX USING THE EXTENDED VIEWER BUTTON

	public static void AWF_approve_byviewer (WebDriver driver, String xpath) throws InterruptedException {

		driver.findElement(By.xpath(xpath)).click()
		Thread.sleep(2*1000)

		J.Pagedown(driver)

		//Instantiate Action Class
		Actions actions = new Actions(driver)
		//Retrieve WebElement to perform mouse hover
		WebElement menuOption = driver.findElement(By.xpath("//*[@id=\"tab_doc_preview\"]/div/div[2]/div[1]/div/img"))
		//Mouse hover IMAGE
		actions.moveToElement(menuOption).perform()

		Thread.sleep(1*1000)

		//CLICK ON THE VIEWER
		J.Click(driver, "//*[@id=\"tab_doc_preview\"]/div/div[2]/div[1]/div/a/div/i")

		Thread.sleep(3*1000)

		//ON THE VIEWER
		//CLICK ON APPROVE BUTTON
		J.Click(driver, "//*[@id=\"BtnapproveButton\"]")

		Thread.sleep(1*1000)

		//CLICK ON APPROVE DOC BUTTON TO APPROVE DOC
		J.Click(driver, "//*[@id=\"approveButton\"]")

		Thread.sleep(5*1000)




	}


	// FUNCTION: TO APPROVE A DOC IN MEDIABOX USING THE EXTENDED VIEWER BUTTON

	public static void AWF_approve_byreflink (WebDriver driver, String xpath) throws InterruptedException {
		//CLICK ON REF LINK
		driver.findElement(By.xpath(xpath)).click()

		Thread.sleep(2*1000)

		//CLICK ON THE LIFECYCLE TAB
		driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div[3]/div/ul/li[2]/a")).click()

		Thread.sleep(5*1000)

		//Instantiate Action Class
		Actions actions = new Actions(driver)
		//Retrieve WebElement 'Music' to perform mouse hover
		WebElement menuOption = driver.findElement(By.xpath("//*[@id=\"tab_doc_preview\"]/div/div[2]/div[1]/div/img"))
		//Mouse hover IMAGE
		actions.moveToElement(menuOption).perform()

		Thread.sleep(1*1000)

		//CLICK ON THE VIEWER
		J.Click(driver, "//*[@id=\"tab_doc_preview\"]/div/div[2]/div[1]/div/a/div/i")

		Thread.sleep(3*1000)

		//ON THE VIEWER
		//CLICK ON APPROVE BUTTON
		J.Click(driver, "//*[@id=\"BtnapproveButton\"]")

		Thread.sleep(1*1000)

		//CLICK ON APPROVE DOC BUTTON TO APPROVE DOC
		J.Click(driver, "//*[@id=\"approveButton\"]")

		Thread.sleep(5*1000)




	}

	///////////////READ FROM CSV
	// FUNCTION: READ URL DATA FROM CSV - OK
	public static List<String> Read_CSV_URL(String filename) throws IOException {
		BufferedReader reader = Files.newBufferedReader(Path.of(filename))
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("Mediabox", "URL").withIgnoreHeaderCase().withTrim())
		List<String> UrlList = new ArrayList<>()

		for (CSVRecord csvRecord: csvParser) {
			// Accessing Values by Column Index
			String URL = csvRecord.get(1)

			//ADDING URL IN LIST
			UrlList.add(URL)
		}
		//RETURN A LIST OF URL
		return UrlList
	}

	// FUNCTION: READ PASSWORD DATA FROM CSV - OK
	public static List<String> Read_Password_URL(String filename) throws IOException {

		BufferedReader reader = Files.newBufferedReader(Path.of(filename))
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("Username", "Password", "Expiry").withIgnoreHeaderCase().withTrim())
		List<String> PasswordList = new ArrayList<>()

		for (CSVRecord csvRecord: csvParser) {
			// Accessing Values by Column Index
			String Password = csvRecord.get(1)

			//ADDING URL IN LIST
			PasswordList.add(Password)
		}
		//RETURN A LIST OF URL
		return PasswordList
	}






}
