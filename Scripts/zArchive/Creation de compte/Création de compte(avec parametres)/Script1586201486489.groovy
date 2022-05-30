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

WebUI.setText(findTestObject('null'), 'User')

WebUI.setText(findTestObject('null'), 'Retest')

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

'Custome keyword created for generating random email address'
String Login = ''

Login = WebUI.getText(findTestObject('null'))

String mail = CustomKeywords.'keyword_RandomEmail.getEmail'('testauto', 'testdiadeis.com')

WebUI.setText(findTestObject('null'), mail)

WebUI.selectOptionByValue(findTestObject('null'), 
    '1', true)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.selectOptionByValue(findTestObject('null'), 
    'Agency', true)

WebUI.selectOptionByValue(findTestObject('null'), 
    '268', true)

WebUI.click(findTestObject('null'))

WebUI.submit(findTestObject('null'))

WebUI.waitForPageLoad(0)

WebUI.setText(findTestObject('null'), 'user')

WebUI.verifyTextPresent(mail, false)

WebUI.takeScreenshot()

WebUI.closeBrowser()

