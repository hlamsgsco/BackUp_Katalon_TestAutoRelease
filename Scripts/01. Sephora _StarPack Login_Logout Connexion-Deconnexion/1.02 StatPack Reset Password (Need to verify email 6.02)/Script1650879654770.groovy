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

//USERNAME & PASSWORD FOR LOGIN - STARPACK : 10 June 2021
/*

String password_suser = 'dchi' //suser
String password_aherms ='dchi' //supplier
String password_agluszczynska = 'dchi'//agency_2
String password_jmaciaszczyk ='dchi' //agency1
String password_aterreshernandez = 'dchi' //Packaging_1
String password_amartin_arbol = 'dchi1' // Buyer
String password_adelamatanieves = 'dchi1' //Packaging_1
String password_kcannoosamy_dia = 'dchi1'
*/
def data = TestDataFactory.findTestData('Data Files/Username_Password/Starpack (10June2021)')

String password_suser = data.getValue(2, 1 //1
    )

def data_urlRELAUTO = TestDataFactory.findTestData('Data Files/URL/URL_relauto')

String Url_Starpack = data_urlRELAUTO.getValue(2, 2)

String login = 'flndhx162043'

//GMAIL: Mediabox.modif.com
String password_mediaboxCreation = 'Diadeis*1'

/////////////////////////////////////TEST START ///////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Starpack Release >  http://mdb-release.diadeis.lan/Mediabox-independence/?MBI_datasource=REL_STARPACK'
WebUI.openBrowser(Url_Starpack)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

'functions Login'
functions.I.Login_password('suser', password_suser)

'Screenshot : Log in as suser'
WebUI.takeScreenshot()

'Click on the Menu > Settings'
WebUI.click(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="kt_aside_menu"]/ul/li[11]/a/span[2]']))

'Screenshot : Settings Menu'
WebUI.takeScreenshot()


'delay 3'
WebUI.delay(3)

'Click on user management'
WebUI.click(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="kt_aside_menu"]/ul/li[11]/div/ul/li[2]/a/span']))


'delay 1'
WebUI.delay(1)

'Search for login'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="users_table_filter"]/label/input']), login)

WebUI.delay(1)


'Screenshot : Search'
WebUI.takeScreenshot()

'delay 1'
WebUI.delay(1)

'click reset password'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="flndhx162043"]/td[14]/a']))

'Screenshot : Sucess message'
WebUI.takeScreenshot()

String actualmsg = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']))

String Expectedmsg = 'Login information email sent to ' + login

'Verify Equal: Login information email sent to <LOGIN> '
WebUI.verifyEqual(actualmsg, Expectedmsg)

'Close Browser'
WebUI.closeBrowser()

