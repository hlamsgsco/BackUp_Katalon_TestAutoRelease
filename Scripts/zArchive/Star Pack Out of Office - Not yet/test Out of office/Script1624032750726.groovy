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

//USERNAME & PASSWORD FOR LOGIN - STARPACK : 11 June 2021

String password_adelamatanieves = 'dchi' //Packaging_1

String password_suser = 'dchi' //suser
String password_aherms ='diadeis' //supplier
String password_agluszczynska = 'diadeis'//agency_2
String password_jmaciaszczyk ='diadeis' //agency1
String password_aterreshernandez = 'diadeis' //Packaging_1
String password_amartin_arbol = 'diadeis' // Buyer
String  password_almeida = 'dchi' //supplier Out of Office [setup done]
String password_delegate1_OOO = 'dchi' //admin Out of Office [setup done]

////////////////////////////////////////////SCENARIO 1 : EXISTING USER WITH OUT OF OFFICE & « FROM TO » IS EXPIRED /////////////////////////////////
/* THE FOLLOWING SETUP HAS ALREADY BEEN DONE FOR USER  _almeida
 * MY ACTIVE DELGATIONS
 *  1. FROM 12/10/2020 TO 16/02/2021 HUGO LEMOS (username: _lemos)	
 *  2. FROM 01/06/2021 to 31/01/2025 delegate out of office 1 (username delegate1_OOO)
 */


///////////////////////////////////////////////////////////////
//Keyword log
////KeywordLogger log = new KeywordLogger()

//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Starpack Release >  http://mdb-release.diadeis.lan/Mediabox-independence/?MBI_datasource=REL_STARPACK'
WebUI.openBrowser('http://mdb-release.diadeis.lan/Mediabox-independence/?MBI_datasource=REL_STARPACK')

WebUI.maximizeWindow()


//LOG IN AS _almeida ~ dchi
'Log in as suser/ dchi'
functions.I.Login_password('_almeida', password_almeida)

//Go to my profile
functions.I.Go_to_MyProfile()

////////////////////////////////////////VERIFY THE TOOLTIP//////////////////////////////////////////////////////////////
/*
'Hover over from'
WebUI.mouseOver(findTestObject('Object Repository/Starpack Out of office/1.02 amalia id_kt_header_div_div2_div2_div2_a1',[('xpath'):'//*[@id="kt_aside_menu"]/ul/li[11]/div/ul/li[2]/a/span']))

'Verify tooltip from'
functions.I.Verify_tooltip(findTestObject('Object Repository/Starpack Out of office/1.02 amalia id_kt_header_div_div2_div2_div2_a1',[('xpath'):'//*[@id="kt_aside_menu"]/ul/li[11]/div/ul/li[2]/a/span']), 'Date at 00:00')

'Verify tooltip to'
String Atooltip_to = WebUI.getText(findTestObject('Object Repository/Starpack Out of office/1.02 amalia id_kt_header_div_div2_div2_div2_a1',[('xpath'):'/html/body/div[2]/div[2]']))

String Etooltip_to  = 'Date at 00:00'

WebUI.verifyMatch(Atooltip_to, Etooltip_to, false)
*/
