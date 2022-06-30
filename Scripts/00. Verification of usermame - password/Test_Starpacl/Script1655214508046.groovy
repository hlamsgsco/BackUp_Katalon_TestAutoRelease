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

/* SCENARIO TESTED :
THIS TESTCASE SHOULD BE RUN BEFORE EXECUTING THE OTHER TEST SUITE SO THAT IT DOES NOT MAKE CONFLICT WITH THE TESTING.

IN THIS TESTCASE, IT WILL VERIFY THE PASSWORD OF THE USERS USED IN THE TESTSUITE. [STARPACK]
*/


///////////////////////////DATA FILE:  USERNAME - PASSWORD - URL////////////////////////////////////
//DATA FILES USERNAME_PASSWORD [STARPACK]
def data = TestDataFactory.findTestData("Data Files/Username_Password/Starpack (10June2021)")
String password = 'diadeis'

/*

mdelrio,dchi,2099,13
packaging2,dchi,2099,14

*/

//DATA FILES URL [STARPACK]
def data_urlRELAUTO = TestDataFactory.findTestData('Data Files/URL/URL_relauto')
String Url_Starpack = data_urlRELAUTO.getValue(2, 2)


//////////////////////////////////////////////////////////////////////TEST START ///////////////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
WebUI.openBrowser( 'https://mdb-v3-test.diadeis.com/MediaboxIndependence/?MBI_datasource=RELTEST_STARPACK')

WebUI.maximizeWindow()


//VERIFICATION OF PASSSWORD FOR:

//1. suser
functions.I.Login_password('suser', password)
functions.I.Logout()

//2. aherms
functions.I.Login_password('aherms', password)
functions.I.Logout()

//3. agluszczynska
functions.I.Login_password('agluszczynska', password)
functions.I.Logout()

//4. jmaciaszczyk
functions.I.Login_password('jmaciaszczyk', password)
functions.I.Logout()

//5. aterreshernandez
functions.I.Login_password('aterreshernandez', password)
functions.I.Logout()

//6. amartin_arbol
functions.I.Login_password('amartin_arbol', password)
functions.I.Logout()

//7. adelamatanieves
functions.I.Login_password('adelamatanieves', password)
functions.I.Logout()

//8. kcannoosamy_dia
functions.I.Login_password('kcannoosamy_dia', password)
functions.I.Logout()

//9 jmarest
functions.I.Login_password('jmarest', password)
functions.I.Logout()


//10 jmartinez_almarza
functions.I.Login_password('jmartinez_almarza', password)
functions.I.Logout()




//11 dcrow
functions.I.Login_password('dcrow', password )
functions.I.Logout()


//12 ncurnier 
functions.I.Login_password('ncurnier', password )
functions.I.Logout()

//13 mdelrio
functions.I.Login_password('mdelrio', password)
functions.I.Logout()

//14  1packaging2 
functions.I.Login_password('1packaging2', password )
functions.I.Logout()

//15 afro
functions.I.Login_password('afron', password)
functions.I.Logout()

// 16 String password_ysanzmonedero = data.getValue(2, 16)
functions.I.Login_password('ysanzmonedero', password)
functions.I.Logout()

// 17 String password_bsolletbravo = data.getValue(2, 17)
functions.I.Login_password('bsolletbravo', password)
functions.I.Logout()

// 18 String password_agarciasanchez = data.getValue(2, 18)
functions.I.Login_password('agarciasanchez', password)
functions.I.Logout()

//CLOSE BROWSER
WebUI.closeBrowser()

//////////////////////////////////////////////////////////////////////END TEST ///////////////////////////////////////////////////
