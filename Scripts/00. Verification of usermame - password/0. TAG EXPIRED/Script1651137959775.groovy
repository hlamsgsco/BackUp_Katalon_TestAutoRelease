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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.common.WebUiCommonHelper

import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
//adaniel - DMI

//jrademakers	- Local mkt
//daco - adminn

//ymaruichi - plant
///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//DATA FILE USERNAME_PASSWORD [TAG]
def data_Tag = TestDataFactory.findTestData('Data Files/Username_Password/Tag')

String password_jedun = data_Tag.getValue(3, 1)

//DATA FILE URL [TAG]
def data_urlRELAUTO = TestDataFactory.findTestData('Data Files/URL/URL_relauto')

String Url_Tag = data_urlRELAUTO.getValue(2, 3)

//////////////////////////////////////////////////////////////////////TEST START ///////////////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

functions.I.Login_password('jedun', password_jedun)

'Click on Menu LHS Settings '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_aside_menu"]/ul/li[11]/a/span[2]']))

WebUI.delay(1)

'Click on Menu LHS Settings > Usermanagement '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_aside_menu"]/ul/li[11]/div/ul/li[2]/a']))

WebUI.delay(5)
'Search for adaniel'
WebUI.setText(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="users_table_filter"]/label/input']), 'adaniel')
 WebUI.delay(1)
 
 'Click onedit user '
 WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="adaniel"]/td[2]/a']))
 
 'Change expiry date'
 WebUI.click(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="datepicker"]']))
 WebUI.delay(1)
 ////*[@id="kt_body"]/div[3]/div[1]/table/thead/tr[1]/th[2]
 WebUI.click(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="kt_body"]/div[3]/div[1]/table/thead/tr[1]/th[2]']))
  
 ////*[@id="kt_body"]/div[3]/div[2]/table/thead/tr/th[1]
 WebUI.click(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="kt_body"]/div[3]/div[2]/table/thead/tr/th[1]']))
 WebUI.click(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="kt_body"]/div[3]/div[2]/table/thead/tr/th[1]']))
 WebUI.click(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="kt_body"]/div[3]/div[2]/table/thead/tr/th[1]']))
 WebUI.click(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="kt_body"]/div[3]/div[2]/table/thead/tr/th[1]']))
 WebUI.click(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="kt_body"]/div[3]/div[2]/table/thead/tr/th[1]']))
 WebUI.click(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="kt_body"]/div[3]/div[2]/table/thead/tr/th[1]']))
 WebUI.click(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="kt_body"]/div[3]/div[2]/table/thead/tr/th[1]']))
 WebUI.click(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="kt_body"]/div[3]/div[2]/table/thead/tr/th[1]']))
 WebUI.click(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="kt_body"]/div[3]/div[2]/table/thead/tr/th[1]']))
 WebUI.click(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="kt_body"]/div[3]/div[2]/table/thead/tr/th[1]']))
 
 
 WebUI.click(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="kt_body"]/div[3]/div[2]/table/tbody/tr/td/span[3]']))
 
 //*[@id="kt_body"]/div[3]/div[1]/table/tbody/tr[3]/td[4]
 WebUI.click(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="kt_body"]/div[3]/div[1]/table/tbody/tr[3]/td[4]']))
  
 WebUI.click(findTestObject('1. Constant/xpath',[('xpath'):'//*[@id="UpdateUser"]/div[2]/div/div[2]/div/button']))
  
 WebUI.closeBrowser()
  