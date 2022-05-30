import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

'Load the website'
WebUI.openBrowser('http://mdb-release.diadeis.lan/Mediabox-independence/?MBI_datasource=UX_SEPHORA')

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

WebUI.takeScreenshot()

'Enter incorrect username'
WebUI.setText(findTestObject('null'), 'fake_user')

'Enter Password'
WebUI.setText(findTestObject('null'), 'xcalibur1')

'Click on Login button'
WebUI.click(findTestObject('null'))

'Verify that access is denied'
WebUI.verifyElementVisible(findTestObject('null'))

WebUI.delay(2)

'Clear Username'
WebUI.clearText(findTestObject('null'), FailureHandling.STOP_ON_FAILURE)

'Clear Password'
WebUI.clearText(findTestObject('null'), FailureHandling.STOP_ON_FAILURE)

'Enter correct username'
WebUI.setText(findTestObject('null'), 'jedun_irati2')

'Enter incorrect password'
WebUI.sendKeys(findTestObject('null'), 'yooo')

'Click on Login button'
WebUI.click(findTestObject('null'))

'Access should be denied'
WebUI.verifyElementVisible(findTestObject('null'))

WebUI.delay(2)

'Clear Username'
WebUI.clearText(findTestObject('null'), FailureHandling.STOP_ON_FAILURE)

'Clear Password'
WebUI.clearText(findTestObject('null'), FailureHandling.STOP_ON_FAILURE)

long ts1 = System.currentTimeMillis()

'Enter Username'
WebUI.setText(findTestObject('null'), 'jedun')

WebUI.sendKeys(findTestObject('null'), 'diadeis')

'Click on Login button'
WebUI.click(findTestObject('null'))

WebUI.waitForPageLoad(60)

'Click on Project tab'
WebUI.click(findTestObject('null'))

long ts2 = System.currentTimeMillis()

println(('Login duration: ' + (ts2 - ts1)) + ' miliseconds.')

WebUI.waitForPageLoad(30)

'Hover mouse on drop down with user\'s first name'
WebUI.mouseOver(findTestObject('null'))

'Click on LogOut button'
WebUI.click(findTestObject('null'))

WebUI.waitForPageLoad(30)

'Verify that user is back on login page'
WebUI.verifyElementVisible(findTestObject('null'))

WebUI.closeBrowser()

