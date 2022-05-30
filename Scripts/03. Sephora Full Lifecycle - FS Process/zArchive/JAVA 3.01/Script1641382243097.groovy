import org.openqa.selenium.*
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver as FirefoxDriver
import java.io.IOException as IOException
import java.net.URL as URL
import java.util.List as List
import static org.apache.commons.lang3.RandomStringUtils.*
import java.io.*
import java.nio.file.Files as Files
import java.nio.file.Path as Path
import java.text.DateFormat as DateFormat
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.ArrayList as ArrayList
import java.util.Date as Date
import java.util.Map as Map
import functions.I as I
import org.openqa.selenium.By as By
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import functions.J as J
import org.openqa.selenium.remote.DesiredCapabilities as DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver as RemoteWebDriver
import org.openqa.selenium.support.ui.ExpectedConditions as ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait as WebDriverWait

//  ChromeDriver driver = new ChromeDriver();
// Capabilities capabilities = driver.getCapabilities();
//  Map<String, Object> asMap = capabilities.asMap();
// debuggerAddress=localhost:63154
// driver.get("http://mdb-release.diadeis.lan/MediaboxIndependence/?MBI_datasource=RELTESTAUTO_SEPHORA");
///END OF TeST 1
/*

        // Test 2
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "localhost:59466");
        ChromeDriver driver = new ChromeDriver(options);
        Capabilities capabilities = driver.getCapabilities();
        Map<String, Object> asMap = capabilities.asMap();
        asMap.forEach((key, value) -> {
            System.out.println("Key " + key + " Value " + value);
        });
         //END OF TEST 2
*/
/* IN THIS TESTCASE, SCENARIO TESTED:
 * COMPLETED LIFECYCLE
 * USER CAN SUBMIT
 * USER CAN APPROVE DOC
 */
//DATA FILE : USERNAME & PASSWORD  - SEPHORA 
def data_Sephora = TestDataFactory.findTestData('Data Files/Username_Password/Sephora')

String password_atran = data_Sephora.getValue(2, 1)

String password_marketing = data_Sephora.getValue(2, 2)

String password_regulatory = data_Sephora.getValue(2, 3)

String password_studio = data_Sephora.getValue(2, 4)

String password_iraz = data_Sephora.getValue(2, 5)

String password_cmouzawak = data_Sephora.getValue(2, 6)

String password_aalbeaux = data_Sephora.getValue(2, 7)

String password_hgarnier = data_Sephora.getValue(2, 8)

//DATA FILE : URL - SEPHORA
def data_urlRELAUTO = TestDataFactory.findTestData('Data Files/URL/URL_relauto')

String Url_Sephora = data_urlRELAUTO.getValue(2, 1)

//START BROWSER
System.setProperty('webdriver.chrome.driver', 'D:\\Jar\\chromedriver.exe')

WebDriver driver = new ChromeDriver()

//MAXIMISE BROWSER
//WebDriver driver = new ChromeDriver();
driver.manage().window().maximize()

//NAVIGATE TO SEPHORA RELEASE
J.Navigate_Chrome(driver, Url_Sephora)

//LOG IN AS ATRAN
J.Login_password(driver, 'atran', password_atran)

//CLICK ON THE LHS MENU
J.Click(driver, '//*[@id="menu_2"]/a')

//CLICK ON THE + BUTTON TO CREATE A PROJECT
J.Click(driver, '//div[@id=\'kt_content\']/div[3]/div/div/div/div[2]/a/i')

//DEFINE PROJECT NAME
String project_name = (('AutoTest_Chrome_FS_FullLifecyle' + randomAlphabetic(5)) + '_') + J.gettimedate()

//SET TEXT: PROJECT NAME
J.SetText(driver, '//*[@id="nomProjet"]', project_name)

//CLICK CREATE PROJECT BUTTON
J.Click(driver, '//button[@name=\'UpdateAndSubmit\']')

//MODIFICATION OF PROJECT PAGE
//SET TEXT: Code project - 1234
J.SetText(driver, '//*[@id="var_27"]', '123')

//SELECT FROM LIST: CATEGORY - HAIR
J.SelectFromList(driver, '//*[@id="var_28"]', '240')

//SELECT FROM LIST: SEGMENT - BATH BODY
J.SelectFromList(driver, '//*[@id="var_29"]', '46')

//SELECT FROM LIST: TYPE - ONE SHOT
J.SelectFromList(driver, '//*[@id="var_31"]', '16')

//SELECT FROM MULTIPLE LIST: SCOPE - Europe
J.SelectFromMultipleList(driver, '//*[@id="selSource_32"]', '//*[@id="btnAdd_32"]', '20')

//SELECT FROM LIST: MAD - Christmas
J.SelectFromList(driver, '//*[@id="var_34"]', '30')

//SELECT FROM LIST: YEAR - 2021
J.SelectFromList(driver, '//*[@id="var_35"]', '119')

//SCROLL TO ELEMENT
J.ScrollToElement(driver, '//*[@id="var_35"]')

//SELECT FROM MULTIPLE LIST: Dev Pack - devpack
J.SelectFromMultipleList(driver, '//*[@id="selSource_22"]', '//*[@id="btnAdd_22"]', 'devpack')

J.ScrollToElement(driver, '/html/body/div[1]/div[2]/div[4]/div[3]/div/form/div[3]/div/button')

//SELECT FROM MULTIPLE LIST: Devt FS - atran
J.SelectFromMultipleList(driver, '//*[@id="selSource_23"]', '//*[@id="btnAdd_23"]', 'atran')

//SELECT FROM MULTIPLE LIST: MARKETING - marketing
J.SelectFromMultipleList(driver, '//*[@id="selSource_21"]', '//*[@id="btnAdd_21"]', 'marketing')

//SELECT FROM MULTIPLE LIST: Regulatory - regulatory
J.SelectFromMultipleList(driver, '//*[@id="selSource_25"]', '//*[@id="btnAdd_25"]', 'regulatory')

//SELECT FROM MULTIPLE LIST: Studio - studio
J.SelectFromMultipleList(driver, '//*[@id="selSource_24"]', '//*[@id="btnAdd_24"]', 'studio')

//PAGE DOWN
functions.J.Pagedown(driver)

//CLICK ON UPDATE BUTTON
J.Click(driver, '//*[@id="ModifFiche"]/div[3]/div/button')

//WAIT FOR PAGE TO LOAD
Thread.sleep(5 * 1000)
//END OF MODIFICATION PROJECT PAGE
//REF LIST PAGE
//GET THE PROJECT NO
String Project_No = J.ProjectNo(driver)


//WAIT FOR PAGE TO LOAD
Thread.sleep(10 * 1000)

//CLICK ON + TO CREATE NEW REF
J.Click(driver, '//div[@id=\'create_ref_btn\']/button/i')

//CLICK CREATE A REF OPTION
J.Click(driver, '//div[@id=\'create_ref_btn\']/div/a')

//SELECT FROM  Lifecycle template  : FS PROCESS
J.SelectFromList(driver, '//*[@id="lfc_tpl"]', '24')

//DEFINE REF NAME
String ref_name = (('AutoTest_Ref_' + randomAlphabetic(10)) + '_') + J.gettimedate()

//SET TEXT : COMPONENT NAME - ref name
J.SetText(driver, '//input[@id=\'var_name\']', ref_name)

//CLICK ON CREATE COMPONENT BUTTON
J.Click(driver, '(//button[@name=\'UpdateAndSubmit\'])[2]')

//GET REF ID
String refID = J.RefNo(driver)

//MODIFICATION OF THE REF FORM
//SELECT FROM LIST: DDC STATUS - Complete
J.SelectFromList(driver, '//*[@id="var_152"]', '255')

//SET TEXT: CLOSING DATE DDC
J.SetText(driver, '//*[@id="var_36"]', '22/02/2030')

//SET TEXT: CSending date of the decor document
J.SetText(driver, '//*[@id="var_37"]', '22/02/2030')

//SELECT FROM LIST: PACK TYPE - Primaire
J.SelectFromList(driver, '//*[@id="var_50"]', '63')

//SELECT FROM LIST: COMPONENT TYPE - ETUI
J.SelectFromList(driver, '//*[@id="var_49"]', '83')

//SELECT FROM LIST: PRINTER - AIRCOS
J.SelectFromList(driver, '//*[@id="var_18"]', '182')

//PAGE DOWN
J.Pagedown(driver)

Thread.sleep(2 * 1000)

//CLICK ON SAVE
J.Click_Button_JS(driver, '//*[@id="type_save"]')

//WAIT FOR PAGE LOAD
Thread.sleep(3 * 1000)

//END OF THE MODIFICATION OF REF FORM
//REF LIST PAGE
//CLICK ON SUBMIT PHASE
J.Click(driver, ('//*[@id=\'source_' + refID) + '\']/td[7]/a')

//CLICK ON SEND ON MKT BUTTON
J.Click(driver, '//*[@id="ModifFiche"]/div[1]/div/button[2]')

//LOGOUT AS ATRAN
J.Logout(driver)

//LOGIN AS MARKETING
J.Login_password(driver, 'marketing', password_marketing)

//CLICK ON THE LHS MENU
J.Click(driver, '//*[@id="menu_2"]/a')

//WAIT FOR PAGE TO LOAD
Thread.sleep(2 * 1000)

//PROJECT LIST PAGE
//SEARCH FOR PROJECT
J.SearchProjectNo(driver, Project_No, '//*[@id="form_filters"]/div[4]/button')

//REF LIST PAGE
//CLICK ON SUBMIT
J.Click(driver, ('//*[@id=\'source_' + refID) + '\']/td[7]/a')

//ON THE REF MODIF PAGE
//PROCEED TO NEXT PHASE
J.Click(driver, '//*[@id="ModifFiche"]/div[1]/div/button[2]')

//LOGOUT AS MARKETING
J.Logout(driver)

//LOGIN AS REGULATORY
J.Login_password(driver, 'regulatory', password_regulatory)

//CLICK ON THE LHS MENU
J.Click(driver, '//*[@id="menu_2"]/a')

//PROJECT LIST PAGE
//SEARCH FOR PROJECT
J.SearchProjectNo(driver, Project_No, '//*[@id="form_filters"]/div[4]/button')

//REF LIST PAGE
//CLICK ON ACTION QUESTION BUTTON
J.Click(driver, ('//*[@id=\'source_' + refID) + '\']/td[7]/div/button')

//WAIT FOR 1 SEC
Thread.sleep(1 * 1000)

//CLICK ON THE 1ST OPTION TO PROCEED TO NEXT PHASE
J.Click(driver, ('//*[@id=\'source_' + refID) + '\']/td[7]/div/div/a[1]')

//REF MODIF PAGE
//PROCEED TO NEXT PHASE
J.Click(driver, '//*[@id="ModifFiche"]/div[1]/div/button[2]')

//LOGOUT AS REGULATORY
J.Logout(driver)

//LOGIN AS STUDIO
J.Login_password(driver, 'studio', password_studio)

//CLICK ON THE LHS MENU
J.Click(driver, '//*[@id="menu_2"]/a')

//PROJECT LIST PAGE
//SEARCH FOR PROJECT
J.SearchProjectNo(driver, Project_No, '//*[@id="form_filters"]/div[4]/button')

//REF LIST PAGE
//CLICK ON ACTION QUESTION BUTTON
J.Click(driver, ('//*[@id=\'source_' + refID) + '\']/td[8]/div/button')

//WAIT FOR 1 SEC
Thread.sleep(1 * 1000)

//CLICK ON THE 1ST OPTION TO PROCEED TO NEXT PHASE
J.Click(driver, ('//*[@id=\'source_' + refID) + '\']/td[8]/div/div/a')

//SELECT FROM LIST : External Agency :MR ARTWORKS
J.SelectFromList(driver, '//*[@id="var_133"]', '282')

//CLICK ON PROCEED TO NEXT PHASE
J.Click(driver, '//*[@id="ModifFiche"]/div[1]/div/button[2]')

//PRODUCTION PHASE: UPLOAD A DOC - PART 1
//VERIFY IF THE  BUTTON BECOMES WHITE AFTER UPLOADING A FILE
String background_color1 = driver.findElement(By.xpath(('//*[@id=\'source_' + refID) + '\']/td[8]/a')).getCssValue('color')

J.Print('test1 == ' + background_color1)

'84'
while (true) {
    ////*[@id="source_3463"]/td[8]/a
    J.Click(driver, ('//*[@id="source_' + refID) + '"]/td[8]/a')

    J.Upload_File(driver, '//*[@id="kt_body"]/input[2]', 'D:\\Upoad_File\\Upload doc\\testdata1.jpg', 'Remove file')

    Thread.sleep(10 * 1000)

    J.Click(driver, '//*[@id="ModifFiche"]/div[1]/div/button')

    Thread.sleep(5 * 1000)
///*[@id="source_3498"]/td[8]/a
    if (!(driver.findElements(By.xpath(('//*[@id=\'source_' + refID) + '\']/td[8]/a')).isEmpty())) {
        //THEN CLICK ON THE SUBMIT BUTTON
        background_color1 = driver.findElement(By.xpath(('//*[@id=\'source_' + refID) + '\']/td[8]/a')).getCssValue('color') //DO SOMETHING ELSE AS SUBMIT BUTTON IS NOT THERE
		J.Print('test2 == ' + background_color1)
		
		} else {
        background_color1 = driver.findElement(By.xpath(('//*[@id=\'source_' + refID) + '\']/td[8]/a')).getCssValue('color')
		J.Print('test3 == ' + background_color1)
		 }
    
    if (background_color1.contains ( 'rgba(255, 255, 255, 1)')) {
		
		J.Print('test4 == ' + background_color1)
		
        continue
    } else {
        break
    }
}

//LOGOUT AS STUDIO
J.Logout(driver)

//LOGIN AS MARKETING
J.Login_password(driver, 'marketing', password_marketing)

//CLICK ON THE LHS MENU
J.Click(driver, '//*[@id="menu_2"]/a')

//PROJECT LIST PAGE
//SEARCH FOR PROJECT
J.SearchProjectNo(driver, Project_No, '//*[@id="form_filters"]/div[4]/button')

//APPROVE DOC BY VIEWER BUTTON
J.AWF_approve_byviewer(driver, ('//*[@id="source_' + refID) + '"]/td[7]/a')

//LOGOUT AS MARKETING
J.Logout(driver)

//LOGIN AS REGULATORY
J.Login_password(driver, 'regulatory', password_regulatory)

//CLICK ON THE LHS MENU
J.Click(driver, '//*[@id="menu_2"]/a')

//PROJECT LIST PAGE
//SEARCH FOR PROJECT
J.SearchProjectNo(driver, Project_No, '//*[@id="form_filters"]/div[4]/button')

Thread.sleep(2 * 1000)

//APPROVE DOC BY VIEWER BUTTON
J.AWF_approve_byviewer(driver, ('//*[@id="source_' + refID) + '"]/td[7]/a')

//LOGOUT AS MARKETING
J.Logout(driver)

//LOGIN AS ATRAN
J.Login_password(driver, 'atran', password_atran)

//CLICK ON THE LHS MENU
J.Click(driver, '//*[@id="menu_2"]/a')

//PROJECT LIST PAGE
//SEARCH FOR PROJECT
J.SearchProjectNo(driver, Project_No, '//*[@id="form_filters"]/div[4]/button')

//APPROVE DOC BY VIEWER BUTTON
J.AWF_approve_byviewer(driver, ('//*[@id="source_' + refID) + '"]/td[7]/a')

Thread.sleep(1 * 1000)

//QUESTION PHASE: CLICK ON SUBMIT
J.Click(driver, ('//*[@id="source_' + refID) + '"]/td[7]/div[1]/button')

//WAIT FOR 1SEC
Thread.sleep(1 * 1000)

//CLICK ON THE 2nd OPTION: SEND TO DIADEIS
J.Click(driver, ('//*[@id="source_' + refID) + '"]/td[7]/div[1]/div/a[2]')

//MODIFICATION OF REF LIST PAGE
//SET TEXT : CODE EAN - CODE EAN TEST 123
J.SetText(driver, '//*[@id="var_53"]', 'code ean test 123')

//SET TEXT : Brief photogravure  - Test Alpha Brief photogravure
J.SetText(driver, '//*[@id="var_52"]', 'Test Alpha Brief photogravure')

//SET TEXT : No of colors  - Color test mandatory
J.SetText(driver, '//*[@id="var_120"]', 'Color test mandatory')

//PAGE DOWN
J.Pagedown(driver)

//WAIT FOR 1 SEC
Thread.sleep(1 * 1000)

//SELECT FROM MULTIPLE LIST : PRINT TYPE - MAC
J.SelectFromMultipleList(driver, '//*[@id="selSource_121"]', '//*[@id="btnAdd_121"]', '109')

//SET TEXT: DATE MAD SUPPLIER - 1/01/2040
J.SetText(driver, '//*[@id="var_122"]', '01/01/2040')

//PAGE DOWN
J.Pagedown(driver)

//CLICK ON SUBMIT
J.Click(driver, '//*[@id="ModifFiche"]/div[3]/div/button[2]')

//LOGOUT AS ATRAN
J.Logout(driver)

//LOGIN AS Cyril
J.Login_password(driver, 'cmouzawak', password_cmouzawak)

//CLICK ON THE LHS MENU
J.Click(driver, '//*[@id="menu_2"]/a')

//PROJECT LIST PAGE
//SEARCH FOR PROJECT
J.SearchProjectNo(driver, Project_No, '//*[@id="form_filters"]/div[7]/button')

//REF LIST PAGE
//CLICK ON SUBMIT
J.Click(driver, ('//*[@id="source_' + refID) + '"]/td[11]/a')

//UPLOAD A FILE
J.Upload_File(driver, '//*[@id="var_123"]', 'D:\\Upoad_File\\Upload doc\\testdata1.jpg', 'testdata1')

//WAIT FOR 1 SEC
Thread.sleep(3 * 1000)

//PROCEED TO NEXT PHASE
J.Click(driver, '//*[@id="ModifFiche"]/div[3]/div/button[2]')

//LOGOUT AS CYRIL
J.Logout(driver)

//LOGIN AS lraz
J.Login_password(driver, 'lraz', password_iraz)

//CLICK ON THE LHS MENU
J.Click(driver, '//*[@id="menu_2"]/a')

//PROJECT LIST PAGE
//SEARCH FOR PROJECT
J.SearchProjectNo(driver, Project_No, '//*[@id="form_filters"]/div[4]/button')

//PRODUCTION PHASE: UPLOAD A DOC - PART 2
//VERIFY IF THE  BUTTON BECOMES WHITE AFTER UPLOADING A FILE
String background_color2 = driver.findElement(By.xpath(('//*[@id=\'source_' + refID) + '\']/td[8]/a')).getCssValue('color')

J.Print('test == ' + background_color2)

while (true) {
    J.Click(driver, ('//*[@id="source_' + refID) + '"]/td[8]/a')

    J.Upload_File(driver, '//*[@id="kt_body"]/input[2]', 'D:\\Upoad_File\\Upload doc\\testdata1.jpg', 'Remove file')

    Thread.sleep(10 * 1000)

    J.Click(driver, '//*[@id="ModifFiche"]/div[1]/div/button')

    Thread.sleep(5 * 1000)

    if (!(driver.findElements(By.xpath(('//*[@id=\'source_' + refID) + '\']/td[8]/a')).isEmpty())) {
        //THEN CLICK ON THE SUBMIT BUTTON
        background_color2 = driver.findElement(By.xpath(('//*[@id=\'source_' + refID) + '\']/td[8]/a')).getCssValue('color') //DO SOMETHING ELSE AS SUBMIT BUTTON IS NOT THERE
    } else {
        background_color2 = driver.findElement(By.xpath(('//*[@id=\'source_' + refID) + '\']/td[8]/a')).getCssValue('color')
    }
    
    if (background_color2 == 'rgba(255, 255, 255, 1)') {
        continue
    } else {
        break
    }
}

//LOGOUT AS
J.Logout(driver)

//LOGIN AS atran
J.Login_password(driver, 'atran', password_atran)

//CLICK ON THE LHS MENU
J.Click(driver, '//*[@id="menu_2"]/a')

//PROJECT LIST PAGE
//SEARCH FOR PROJECT
J.SearchProjectNo(driver, Project_No, '//*[@id="form_filters"]/div[4]/button')

//APPROVE DOC BY REF LINK
J.AWF_approve_byreflink(driver, ('//*[@id=\'source_' + refID) + '\']/td[4]/a')

//QUESTION PHASE: SUBMIT PHASE
J.Click(driver, ('//*[@id=\'source_' + refID) + '\']/td[7]/div[1]/button/i')

//WAIT FOR 1SEC
Thread.sleep(1 * 1000)

//CLICK ON 1ST OPTION: DDC UPDATED
J.Click(driver, ('//*[@id=\'source_' + refID) + '\']/td[7]/div[1]/div/a[1]')

//REF MODIF PAGE
//CLICK ON PROCEED TO NEXT PHASE
J.Click(driver, '//*[@id="ModifFiche"]/div[1]/div/button[2]')

//VERIFY LIFECYCLE STATUS IS COMPLETE
////*[@id='${refID}']/td[5]/span
J.LC_status(driver, ('//*[@id=\'source_' + refID) + '\']/td[5]/span', 'Complete')

//CLOSE BROWSER
driver.quit()

