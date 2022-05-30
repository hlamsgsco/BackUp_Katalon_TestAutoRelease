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
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.openqa.selenium.Keys as Keys

'Load the website'
WebUI.openBrowser(Website)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

WebUI.setText(findTestObject('null'), 'jedun')

WebUI.setEncryptedText(findTestObject('null'), 'NOZHw6sL/1I=')

WebUI.click(findTestObject('null'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(30)

WebUI.verifyElementVisible(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.delay(5)

WebUI.verifyElementVisible(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.waitForPageLoad(30)

WebUI.click(findTestObject('null'))

WebUI.waitForPageLoad(30)

WebUI.setText(findTestObject('null'), 'ancel')

WebUI.setText(findTestObject('null'), 'C')

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.setText(findTestObject('null'), 'cancel@testautodiadeis.com')

WebUI.selectOptionByValue(findTestObject('null'), 
    '1', true)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.selectOptionByValue(findTestObject('null'), 
    'Devt_Packaging', true)

WebUI.click(findTestObject('null'))

WebUI.waitForPageLoad(30)

WebUI.setText(findTestObject('null'), 'cancel')

WebUI.delay(1)

WebUI.verifyTextNotPresent('cancel@testautodiadeis.com', false)

WebUI.takeScreenshot()

WebUI.closeBrowser()

