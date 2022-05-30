import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import org.openqa.selenium.WebDriver

import org.openqa.selenium.logging.LogEntries

import org.openqa.selenium.logging.LogEntry


import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.logging.LogEntries
import org.openqa.selenium.logging.LogEntry

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.driver.WebUIDriverType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//create a new project 
//do not fill in any field
//create a ref
//do not fill in any field
//performa mass submit
//error message for both ref and prject
//fill in the ref field
//mass submit
// fiil in the project field
//mass submit




///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//USERNAME & PASSWORD  - tag
def data_Tag = TestDataFactory.findTestData('Data Files/Username_Password/Tag')

String password_jedun = data_Tag.getValue(3, 1)
String password_rrowland = data_Tag .getValue(3, 2)
String password_stest = data_Tag.getValue(3, 3)

String password_itroin = data_Tag.getValue(3, 4)

String password_igedik = data_Tag.getValue(3, 5)

String password_mderdour = data_Tag.getValue(3, 6)
String password_achatin = data_Tag .getValue(3, 7)
String password_tliu = data_Tag.getValue(3, 8)

String password_ccaramella = data_Tag.getValue(3, 9)

String password_achay = data_Tag.getValue(3, 10)
String password_cbono = data_Tag.getValue(3,11)
String password_pmareri = data_Tag.getValue(3,12)
String password_qeuzen = data_Tag.getValue(3,13)

//CLEAR NOTEPAD
functions.I.clearnotepad('D:\\Upoad_File\\Projet_ Login\\Tag\\6.03 Tag_ProjectNo\\6.03_Tag_ProjectNo.txt')

functions.I.clearnotepad('D:\\Upoad_File\\Projet_ Login\\Tag\\6.03 Tag_ProjectNo\\6.03_Tag_refID.txt')

//URL
def data_urlRELAUTO = TestDataFactory.findTestData('Data Files/URL/URL_relauto')

String Url_Tag = data_urlRELAUTO.getValue(2, 3)


///////////////////////////// TEST BEGIN /////////////////////////////////////////

//String refID = '15100'
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag Release'
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

'Screenshot: Navigate to URL Tag Release'
WebUI.takeScreenshot()

//CREATION OF PROJECT
//////////////////////////// LOGIN AS NON ADMIN International agency  ///////////////////////////////////

'Log in as ADMIN – rrowland'
functions.I.Login_password('rrowland', password_rrowland)

'Screenshot: Log in as rrowland'
WebUI.takeScreenshot()

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Click on + to create project'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/div[1]/button']))


WebUI.delay(1)
'Click on Create on project'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/div[1]/div/a[2]']))

'Screenshot: Create Project page'
WebUI.takeScreenshot()

'Select Project template '
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="project_template"]']), '14', false)

'Screenshot: creation project page'
WebUI.takeScreenshot()

'Click on create the project'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))
 
WebUI.delay(5)

String Project_No= functions.I.ProjectNo()

'Screenshot: Project modif page'
WebUI.takeScreenshot()

'Click on Update'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button/i']))

WebUI.delay(1)

'Screenshot: ref list page'
WebUI.takeScreenshot()

'Click on + to create ref'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

 'Click on ref'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a']))

'Select ref template'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ref_type"]']), '13', false)
WebUI.delay(1)
'Screenshot: creation ref page'
WebUI.takeScreenshot()

'Click on create ref'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button']))

WebUI.delay(1)
String refID = functions.I.RefID_tag()
functions.I.print(refID)

'Screenshot: Edit ref page'
WebUI.takeScreenshot()

'Click cancel'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div[1]/a']))

'Click mass submit'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/div/button']))

'Screenshot'
WebUI.takeScreenshot()

WebUI.delay(1)
'Choose send c&A'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[1]/div[2]/span/div/div/a[5]']))

'Screenshot'
WebUI.takeScreenshot()

WebUI.delay(1)
'Check checkbox 1'
////*[@id="15098"]
///html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr/td[1]/label/input[1]
WebUI.check(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[1]/label']))

'Click confirm selection'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="action_btnMassSubmit"]']))
 
'Screenshot: Popup mass submit'
WebUI.takeScreenshot()

'Verify error message'
String Actual_text1= WebUI.getText (findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="tablecontentNOK"]/table/tbody/tr/td[2]']))
functions.I.print(Actual_text1)

WebUI.verifyMatch(Actual_text1, 'Missing mandatory information at project level'+ '\n'+ 'Missing mandatory information at reference level', false)

'Click cancel'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="modal_mass_submit"]/div/div/div[2]/div[2]/div/button[1]']))
 
'Screenshot'

WebUI.takeScreenshot()
'Click on submit'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[15]/a']))
 
'Screenshot:ref modif page'
WebUI.takeScreenshot()

///FILL IN COTNTROL TAG FIELD
'Marketing product name'
WebUI.setText (findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_117"]']), 'MKT_PART_1')

'PC > Select from list: FAke'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_57"]']), '134', false)

'PF > Select form list : aCcesory'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_28"]']), '15738', false)

'Click update'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[1]']))
 
'Click mass submit'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/div/button']))
 
WebUI.delay(1)
'Choose send c&A'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[1]/div[2]/span/div/div/a[5]']))

WebUI.delay(1)
'Check checkbox 1'

WebUI.check(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[1]/label']))

'Screenshot'
WebUI.takeScreenshot()

'Click confirm selection'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="action_btnMassSubmit"]']))
'Screenshot'
WebUI.takeScreenshot()

'Verify error message'
String Actual_text2= WebUI.getText (findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="tablecontentNOK"]/table/tbody/tr/td[2]']))
functions.I.print(Actual_text2)

WebUI.verifyMatch(Actual_text2, 'Missing mandatory information at project level', false)

'Click cancel'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="modal_mass_submit"]/div/div/div[2]/div[2]/div/button[1]']))
 WebUI.delay(1)
 'Screenshot'
 
 WebUI.takeScreenshot()

//MODIFY PRIJECT
'Click MODIFY PROJECT'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="card_project"]/div[2]/div/div[3]/a[2]']))
 
'Project name: Project name mass submit'
WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_141"]']), 'Project name - mass submit ')

'Project type: Animation '
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_12"]']), '16291', false)
 
'PAD: 10/10/2030 '
WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_14"]']), '10/10/2030 ')
 
WebUI.scrollToElement(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_18"]']), 5)
'Brand: Acne'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_18"]']), '14527', false)
 
'Axis: Fragrance'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_20"]']), '3773', false)
 
WebUI.scrollToElement(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="selSource_24"]']), 5)

'C&A contacts: Adrien Etheve'
functions.I.select_multiplelist('//*[@id="selSource_24"]', '//*[@id="btnAdd_24"]', 'aetheve')

'Screenshot: Project Modif PAge'
WebUI.takeScreenshot()

'Click on update'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))

WebUI.delay(1)
//PERFORM MASS SUBMIT
'Click mass submit'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/div/button']))
'Screenshot: Masss submit option'
WebUI.takeScreenshot()

WebUI.delay(1)
'Choose send c&A'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[1]/div[2]/span/div/div/a[5]']))

WebUI.delay(1)
'Screenshot: send C&A'
WebUI.takeScreenshot()
'Check checkbox 1'

WebUI.check(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[1]/label']))
'Screenshot: Confirm selection'
WebUI.takeScreenshot()

'Click confirm selection'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="action_btnMassSubmit"]']))

'Screenshot: popup mass submit'
WebUI.takeScreenshot()

'Verify List reference ready for submission'
String Actual_text3= WebUI.getText (findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="card_submitable_references"]/div[1]/div[1]']))
functions.I.print(Actual_text3)

WebUI.verifyMatch(Actual_text3, 'List of references ready for submission (1)', false)
'Verify next phase'
String Actual_text4= WebUI.getText (findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="tablecontentOK"]/table/tbody/tr']))
functions.I.print(Actual_text4)

WebUI.verifyMatch(Actual_text4, 'MKT_PART_1_Fake_Accessory_ C&A: Brief completion', false)



'Click send to agency'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="btn_submit_mass_submit"]']))


///POPUP PROGREEsS BAR
//'Object Repository/StarPack - Full Lifecycle (AWIS)/xpath', [('xpath') : '//*[@id="btn_submit_mass_submit"]']
//WebUI.waitForElementVisible(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="modal_submit_progress"]"]']), 30)


'Verify toastr msf'
String Actual_text6= WebUI.getText (findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']))
 functions.I.print(Actual_text6)
 WebUI.verifyMatch(Actual_text6,'Success: the selected references have been successfully submitted',false)
 
 'Screenshot:ref list page'
 WebUI.takeScreenshot()
 
'Lifecycle status'
String Actual_text7= WebUI.getText (findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[12]/span[1]']))
functions.I.print(Actual_text7)

WebUI.verifyMatch(Actual_text7, 'C&A: Brief completion', false)


functions.I.writenotepad('D:\\Upoad_File\\Projet_ Login\\Tag\\6.03 Tag_ProjectNo\\6.03_Tag_ProjectNo.txt', Project_No)

functions.I.writenotepad('D:\\Upoad_File\\Projet_ Login\\Tag\\6.03 Tag_ProjectNo\\6.03_Tag_refID.txt', refID)

WebUI.closeBrowser()