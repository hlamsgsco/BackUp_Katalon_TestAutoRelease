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

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('http://mdb-release.diadeis.lan/Mediabox-independence/?MBI_datasource=REL_SEPHORA')

WebUI.setText(findTestObject('null'), 'jedun')

WebUI.setText(findTestObject('null'), 'pass')

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.waitForPageLoad(30)

WebUI.click(findTestObject('null'))

WebUI.waitForPageLoad(30)

WebUI.verifyTextNotPresent('Create a component', false)

WebUI.mouseOver(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.waitForPageLoad(30)

WebUI.waitForElementVisible(findTestObject('null'), 0)

WebUI.setText(findTestObject('null'), 'cvanuxem')

WebUI.setText(findTestObject('null'), 'pass')

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.waitForPageLoad(30)

WebUI.click(findTestObject('null'))

WebUI.verifyElementVisible(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.waitForPageLoad(30)

WebUI.setText(findTestObject('null'), 'Test Reference - 1')

WebUI.selectOptionByLabel(findTestObject('null'), 'FS process', false)

WebUI.click(findTestObject('null'))

WebUI.waitForPageLoad(30)

WebUI.verifyElementPresent(findTestObject('null'), 0)

WebUI.click(findTestObject('null'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.setText(findTestObject('null'), 'tester')

WebUI.click(findTestObject('null'))

