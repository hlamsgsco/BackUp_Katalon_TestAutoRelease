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


/*
 DEMO: THIS TESTCASE User will login and logout . [SEPHORA]
 */


//DATA FILES : USERNAME_PASSWORD  - SEPHORA 
def data_Sephora = TestDataFactory.findTestData("Data Files/Username_Password/Sephora")
String password_suser	= data_Sephora.getValue(2,10)

//DATA FILES : URL  - SEPHORA
def data_urlRELAUTO = TestDataFactory.findTestData("Data Files/URL/URL_relauto")
String Url_Sephora = data_urlRELAUTO .getValue(2, 1)


//////////////////////////////////////////////////////////////////////TEST START: Log in as suser ///////////////////////////////////////////////////


'Navigate to URL Sephora Release >  http://mdb-release.diadeis.lan/Mediabox-independence/?MBI_datasource=RELTESTAUTO_SEPHORA'
WebUI.openBrowser(Url_Sephora)

WebUI.maximizeWindow()

'Screenshot: Login page'
WebUI.takeScreenshot()

'Enter text in the username field: suser'
WebUI.setText(findTestObject('HL Full Lifecycle/1 LoginPage_input_Login_field'), 'suser')

'Enter text in the password field: password'
WebUI.setText(findTestObject('HL Full Lifecycle/1 LoginPage_input_Password_Field'), 'fail')

'Screenshot: User Login'
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on the login button'
WebUI.click(findTestObject('HL Full Lifecycle/1 LoginPage_login_button'), FailureHandling.STOP_ON_FAILURE)

//Keywords: LOGOUT
functions.I.Logout()

'Screenshot: User Logout'
WebUI.takeScreenshot()

WebUI.closeBrowser()