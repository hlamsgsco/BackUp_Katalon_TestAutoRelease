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

/*Scenario tested
 * 
 * 
 */

//DATA FILE 
//DATA FILES USERNAME_PASSWORD [STARPACK]
def data = TestDataFactory.findTestData('Data Files/Username_Password/Starpack (10June2021)')

String password_suser = data .getValue(2, 1)
String password_aherms =data .getValue(2, 2)
String password_agluszczynska = data .getValue(2, 3)
String password_jmaciaszczyk =data .getValue(2, 4)
String password_aterreshernandez = data .getValue(2, 5)
String password_amartin_arbol = data .getValue(2, 6)
String password_adelamatanieves = data .getValue(2, 7)
String password_kcannoosamy_dia = data .getValue(2, 8)
String password_jmarest	=  data .getValue(2, 9)

//DATA FILES URL [STARPACK]
def data_urlRELAUTO = TestDataFactory.findTestData('Data Files/URL/URL_relauto')
String Url_Starpack = data_urlRELAUTO.getValue(2, 2)

/* SCENARIO TESTED:
EXISTING USER - VERIFY THAT THE PERIOD ARE DEACTIVATED WHEN OVER
DELEGATION PERIOD CAN BE REACTIVATED FROM MY PROFILE



*/