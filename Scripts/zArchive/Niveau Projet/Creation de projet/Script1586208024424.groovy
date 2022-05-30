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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('http://mdb-release.diadeis.lan/Mediabox-independence/?MBI_datasource=REL_SEPHORA')

WebUI.waitForPageLoad(30)

'Enter Username'
WebUI.setText(findTestObject('null'), 'jedun')

'Enter Password'
WebUI.setText(findTestObject('null'), 'pass')

'Click on Login button'
WebUI.click(findTestObject('null'))

WebUI.waitForPageLoad(15)

WebUI.click(findTestObject('null'))

WebUI.verifyElementNotPresent(findTestObject('null'), 0)

'Hover mouse on drop down with user\'s first name'
WebUI.mouseOver(findTestObject('null'))

'Click on LogOut button'
WebUI.click(findTestObject('null'))

WebUI.waitForPageLoad(15)

'Enter Username'
WebUI.setText(findTestObject('null'), 'cvanuxem')

'Enter Password'
WebUI.setText(findTestObject('null'), 'pass')

'Click on Login button'
WebUI.click(findTestObject('null'))

long ts1 = System.currentTimeMillis()

WebUI.click(findTestObject('null'))

WebUI.waitForPageLoad(15)

WebUI.verifyElementPresent(findTestObject('null'), 0)

long ts2 = System.currentTimeMillis()

println(('Login duration: ' + (ts2 - ts1)) + ' miliseconds.')

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.delay(1)

WebUI.verifyElementVisible(findTestObject('null'))

WebUI.setText(findTestObject('null'), 'Nouveau Projet Auto')

WebUI.click(findTestObject('null'))

WebUI.setText(findTestObject('null'), 'code projet')

WebUI.selectOptionByValue(findTestObject('null'), '19', true)

WebUI.click(findTestObject('null'))

WebUI.selectOptionByValue(findTestObject('null'), '19', true)

WebUI.click(findTestObject('null'))

WebUI.selectOptionByValue(findTestObject('null'), 'devpack', 
    true)

WebUI.click(findTestObject('null'))

WebUI.selectOptionByValue(findTestObject('null'), 'cvanuxem', 
    true)

WebUI.click(findTestObject('null'))

WebUI.selectOptionByValue(findTestObject('null'), 'marketing', 
    true)

WebUI.click(findTestObject('null'))

WebUI.selectOptionByValue(findTestObject('null'), 'regulatory', 
    true)

WebUI.click(findTestObject('null'))

WebUI.selectOptionByValue(findTestObject('null'), 'studio', 
    true)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.waitForPageLoad(30)

WebUI.verifyElementVisible(findTestObject('null'))

WebUI.verifyElementVisible(findTestObject('null'))

WebUI.verifyTextPresent('Nouveau Projet Auto', false)

WebUI.delay(5, FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

