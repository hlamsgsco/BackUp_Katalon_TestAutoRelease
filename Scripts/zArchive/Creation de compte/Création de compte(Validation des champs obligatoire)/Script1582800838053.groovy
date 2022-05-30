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

'Login to account'
WebUI.setText(findTestObject('null'), 'jedun')

WebUI.setEncryptedText(findTestObject('null'), 'NOZHw6sL/1I=')

WebUI.click(findTestObject('null'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(30)

WebUI.verifyElementVisible(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.delay(5)

WebUI.verifyElementVisible(findTestObject('null'))

'Open User management'
WebUI.click(findTestObject('null'))

WebUI.waitForPageLoad(30)

WebUI.click(findTestObject('null'))

WebUI.waitForPageLoad(30)

WebUI.setText(findTestObject('null'), '')

WebUI.setText(findTestObject('null'), 'New')

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

'Custome keyword created for generating random email address'
String Login = ''

WebUI.setText(findTestObject('null'), 'test1234')

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
    'Devt_Packaging', true)

WebUI.click(findTestObject('null'))

WebUI.delay(1)

'Verifier que le nom est present'
WebUI.verifyElementVisible(findTestObject('null'), FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot()

WebUI.delay(5)

WebUI.setText(findTestObject('null'), 'User')

WebUI.clearText(findTestObject('null'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('null'))

WebUI.delay(1)

'Verifier que le prenom est present'
WebUI.verifyElementVisible(findTestObject('null'), FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot()

WebUI.delay(5)

WebUI.setText(findTestObject('null'), 'New')

WebUI.clearText(findTestObject('null'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('null'))

WebUI.delay(1)

'Verifier que l\'addresse mail est presente'
WebUI.verifyElementVisible(findTestObject('null'), FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot()

WebUI.delay(5)

WebUI.setText(findTestObject('null'), mail)

WebUI.delay(1)

WebUI.selectOptionByValue(findTestObject('null'), '', true)

WebUI.delay(2)

WebUI.click(findTestObject('null'))

WebUI.delay(1)

'Verifier que la valeur est selectionnée pour la liste deroulante "Company"'
WebUI.verifyElementVisible(findTestObject('null'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUI.selectOptionByValue(findTestObject('null'), 
    '1', true)

WebUI.clearText(findTestObject('null'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.click(findTestObject('null'))

WebUI.delay(1)

'Verifier que le login est bien present'
WebUI.verifyElementVisible(findTestObject('null'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(10)

WebUI.setText(findTestObject('null'), 'tes')

WebUI.delay(1)

WebUI.click(findTestObject('null'))

WebUI.delay(1)

'Verifier que la longueur du login est suffisante'
WebUI.verifyElementVisible(findTestObject('null'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUI.click(findTestObject('null'))

WebUI.selectOptionByValue(findTestObject('null'), 
    '', true)

WebUI.click(findTestObject('null'))

WebUI.delay(1)

'Verifier que le User role a été selectionné'
WebUI.verifyElementVisible(findTestObject('null'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUI.selectOptionByValue(findTestObject('null'), 
    'Devt_Packaging', true)

WebUI.submit(findTestObject('null'))

WebUI.waitForPageLoad(0)

WebUI.closeBrowser()

