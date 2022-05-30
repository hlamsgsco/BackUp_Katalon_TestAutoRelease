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
import java.awt.Robot as Robot
import java.awt.Toolkit as Toolkit
import java.awt.datatransfer.StringSelection as StringSelection
import java.awt.event.KeyEvent as KeyEvent
import com.kms.katalon.core.annotation.Keyword as Keyword
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

//USERNAME & PASSWORD  - SEPHORA -  10 Aug 2021
def data_Sephora = TestDataFactory.findTestData('Data Files/Username_Password/Sephora')

String password_atran = data_Sephora.getValue(2, 1)

String password_marketing = data_Sephora.getValue(2, 2)

String password_regulatory = data_Sephora.getValue(2, 3)

String password_studio = data_Sephora.getValue(2, 4)

String password_iraz = data_Sephora.getValue(2, 5)

String password_cmouzawak = data_Sephora.getValue(2, 6)

String password_aalbeaux = data_Sephora.getValue(2, 7)

String password_hgarnier = data_Sephora.getValue(2, 8)

String password_emartineau = data_Sephora.getValue(2, 9)

def data_urlRELAUTO = TestDataFactory.findTestData('Data Files/URL/URL_relauto')

String Url_Sephora = data_urlRELAUTO.getValue(2, 1)

///////////////////////////////////////////////////////////////
/*String Project_No = 'MI001304'
String refID = '3314'
*/
//BROWSE & MAXIMIZE BROWSER
WebUI.openBrowser(Url_Sephora)

// http://mdb-release.diadeis.lan/MediaboxIndependence/?MBI_datasource=
WebUI.maximizeWindow()

WebUI.takeScreenshot()

//LOG IN AS ATRAN ~ DIADEIS
'Log in as Devfs  : password_emartineau/ diadeis'
functions.I.Login_password('emartineau', password_emartineau)

'Screenshot: Log as emartineau'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

//////////////////////////////////////////////////CREATION OF PROJECT NAME ///////////////////////////////////
//CLICK ON CREATE PROJECT BUTTON
'Click on + icon '
WebUI.click(findTestObject('xxx Todelete/3 ProjectListPage_Create_Project_Button'))

'Screenshot: Click + button'
WebUI.takeScreenshot()

//DEFINE PROJECT NAME
def project_name = (('AutoTest_Chrome_EmptyGroup_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(10)) + 
'_') + functions.I.gettimedate()

//NAME THE PROJECT
WebUI.setText(findTestObject('HL Full Lifecycle/4 CreateProjPage_inputProjectname'), project_name)

'Screenshot: Create Project Page'
WebUI.takeScreenshot()

//CLICK ON CREATE PROJECT
WebUI.click(findTestObject('HL Full Lifecycle/4 CreateProjPage_Create Project_Bluebutton'))

' Screenshot: Modification Project Page: Field filled'
WebUI.takeScreenshot()

///// EXPAND & COLLAPSE OF Project
//////COLLAPSE
WebUI.delay(1)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_4294_ModifFiche"]/div[1]/div[2]/a']))

WebUI.delay(1)

WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_4294_ModifFiche"]/div[2]']), 
    FailureHandling.OPTIONAL)

'Screenshot: Collapse'
WebUI.takeScreenshot()

//////EXPAND
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_4294_ModifFiche"]/div[1]/div[2]/a']))

WebUI.delay(1)

WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_4294_ModifFiche"]/div[2]']), 
    FailureHandling.OPTIONAL)

WebUI.delay(10)

'Screenshot: Expand'
WebUI.takeScreenshot()

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Update'))



//END OF MODIFY PROJECT PAGE
// GET PROJECT NO.
String Project_No = functions.I.ProjectNo()

//////////////////////////////////////////////////CREATION OF REF ///////////////////////////////////
//CREATE REFERENCE
'39'
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPage_createrefbutton'))

WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPaga_Create a component_button'))

WebUI.waitForPageLoad(25)

//CHOOSE LIFECYCLE :LIFECYCLE TEMPTY GROUP
WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/6 ReferenceList_Choose Lifecycle'), '32', false)

//DEFINE REFERENCE NAME
def ref_name = (org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(10) + '_EmptyGroup_') + functions.I.gettimedate()

//INPUT REFERENCE NAME
WebUI.setText(findTestObject('HL Full Lifecycle/6 Reference_input_Component name_field'), 'Component_' + ref_name)

'Screenshot: Create Reference Page: Lifecycle selected & Name filled\r\n'
WebUI.takeScreenshot()

//CLICK ON CREATE REF BUTTON
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferencePg_Create a component_bluebutton'))

//GET THE ID OF THE REF
String refID = functions.I.RefID()

' Screenshot: Modification ref Page'
WebUI.takeScreenshot()

///// EXPAND & COLLAPSE OF REF
//////COLLAPSE
WebUI.delay(1)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_7196_ModifFiche"]/div[1]/div[2]/a']))

WebUI.delay(1)

WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_7196_ModifFiche"]/div[2]']), 
    FailureHandling.OPTIONAL)

'Screenshot: Collapse'
WebUI.takeScreenshot()

//////EXPAND
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_7196_ModifFiche"]/div[1]/div[2]/a']))

WebUI.delay(1)

WebUI.verifyElementVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_phase_group_7196_ModifFiche"]/div[2]']), 
    FailureHandling.OPTIONAL)

WebUI.delay(1)

'Screenshot: Expand'
WebUI.takeScreenshot()

'Click save'
WebUI.click(findTestObject('HL Full Lifecycle/7 ModifyRefPage_button_Save'))

WebUI.delay(3)

///////////////////////////////////STEP 1 - PHASE 1.1///////////////////////
'User : Proceed to next Phase\r\n'
WebUI.click(findTestObject('HL Full Lifecycle/8 ReferencePage_ActionButton', [('refID') : 'source_' + refID]))

//REFERENCE PAGE: CLICK ON PROCCEED TO NEXT PHASE BUTTON
//*[@id="ModifFiche"]/div[1]/div/button[2]
//*[@id="ModifFiche"]/div[3]/div/button[2]
'62 User: Click on send to'
WebUI.click(findTestObject('Object Repository/TAG/id_ModifFiche_div3_div_button2'))

/////////////////////////////EMPTY GROUP PAGE 1 - USER FIELD  /////////////////////
'Screenshot: Empty Group user field'
WebUI.takeScreenshot()

String Actual_Error_msg1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="cardctrlphase"]/div[2]']))

functions.I.print(Actual_Error_msg1)

String Expected_Error_msg1 = ((('Studio (Project)' + '\n') + 'This group has no related user') + '\n') + 'Modify this project'

WebUI.verifyMatch(Actual_Error_msg1, Expected_Error_msg1, false)

'click on modify this project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="cardctrlphase"]/div[2]/div[2]/div/a']))

//////////////////////////PROJECT PAGE//////////////////////////////
'Screenshot: Project PAge'
WebUI.takeScreenshot()

WebUI.delay(1)

'Select Studio'
functions.I.select_multiplelist('//*[@id="selSource_24"]', '//*[@id="btnAdd_24"]', 'studio')

'72 Click on update '
functions.I.click_button_javascript(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))

'Screenshot: Ref List page'
WebUI.takeScreenshot()

//*[@id="source_3356"]/td[7]/a
'Click on submit'
WebUI.click(findTestObject('HL Full Lifecycle/8 ReferencePage_ActionButton', [('refID') : 'source_' + refID]))

'User: Click on send to'
WebUI.click(findTestObject('Object Repository/TAG/id_ModifFiche_div3_div_button2'))

///////////////////////////////////STEP 1 - PHASE 1.2///////////////////////
'Verify that the phase has changed'
String Actual_status1 = WebUI.getText(findTestObject('Object Repository/TAG/id_refid_td5_span1', [('refID') : 'source_' + 
            refID]))

WebUI.verifyMatch(Actual_status1, 'Phase 1.2', false)

//*[@id="source_3356"]/td[7]/a
'Click on submit'
WebUI.click(findTestObject('HL Full Lifecycle/8 ReferencePage_ActionButton', [('refID') : 'source_' + refID]))

'Screenshot: ref modif page'
WebUI.takeScreenshot()

'User: Click on send to'
WebUI.click(findTestObject('Object Repository/TAG/id_ModifFiche_div3_div_button2'))

/////////////////////////////EMPTY GROUP PAGE 2 - USER FIELD  /////////////////////
'Screenshot: Empty Group filtered group'
WebUI.takeScreenshot()

String Actual_Error_msg2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="cardctrlphase"]/div[2]']))

functions.I.print(Actual_Error_msg2)

String Expected_Error_msg2 = ((((('Printer_FG' + '\n') + 'Potential problem with these fields:') + '\n') + 'Printer (Component)') + 
'\n') + 'Modify this component brief'

WebUI.verifyMatch(Actual_Error_msg2, Expected_Error_msg2, false)

'click on Modify this component brief'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="cardctrlphase"]/div[2]/div[3]/div/a']))

//////////////////////////////MODIFY REF//////////////////////////////////////
'Screenshot: ref modif page'
WebUI.takeScreenshot()

WebUI.delay(1)

'SEelect printer'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_18"]']), 
    '180', false)

//*[@id="type_save"]
'Click on save'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="type_save"]']))

//*[@id="source_3356"]/td[7]/a
'Click on submit'
WebUI.click(findTestObject('HL Full Lifecycle/8 ReferencePage_ActionButton', [('refID') : 'source_' + refID]))

'User: Click on send to'
WebUI.click(findTestObject('Object Repository/TAG/id_ModifFiche_div3_div_button2'))

///////////////////////////////////STEP 2 - PHASE 2.1///////////////////////
'Screenshot: ref list page '
WebUI.takeScreenshot()

'Verify that the phase has changed'
String Actual_status2 = WebUI.getText(findTestObject('Object Repository/TAG/id_refid_td5_span1', [('refID') : 'source_' + 
            refID]))

WebUI.verifyMatch(Actual_status2, 'Phase 2.1', false)

WebUI.takeScreenshot()

'97 Click on send to complete'
functions.I.submitquesiton_ref(findTestObject('Object Repository/TAG/id_refid_td7_div_1', [('refID') : 'source_' + refID]), 
    findTestObject('Object Repository/TAG/id_refid_td7_div1_div_a1', [('refID') : 'source_' + refID]))

'Screenshot: modif page'
WebUI.takeScreenshot()

' Select from list '
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_133"]']), 
    '268', false)

//*[@id="ModifFiche"]/div[1]/div/button[2]
'User: Click on send to'
WebUI.click(findTestObject('Object Repository/TAG/id_ModifFiche_div3_div_button2'))

/////////////////////////////EMPTY GROUP PAGE 3 - USER FIELD + Group Approval /////////////////////
'Screenshot: Empty Group User field + group approval'
WebUI.takeScreenshot()

String Actual_Error_msg3 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="cardctrlphase"]/div[2]']))

functions.I.print(Actual_Error_msg3)

String Expected_Error_msg3 = ((((((('Studio (Project)' + '\n') + 'Potential problem with these fields:') + '\n') + 'External agency (Component)') + 
'\n') + 'ANAIS LEFEVRE') + '\n') + 'Modify this component brief'

WebUI.verifyMatch(Actual_Error_msg3, Expected_Error_msg3, false)

'click on Modify this component brief'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="cardctrlphase"]/div[2]/div[3]/div/a']))

//////////////////////////////MODIFY REF//////////////////////////////////////
'Screenshot: ref modif page'
WebUI.takeScreenshot()

WebUI.delay(1)

//*[@id="type_save"]
'Click on save'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="type_save"]']))

///*[@id="source_3356"]/td[7]/div[1]/div/a[2]
'110 Click on road 1'
functions.I.submitquesiton_ref(findTestObject('Object Repository/TAG/id_refid_td7_div_1', [('refID') : 'source_' + refID]), 
    findTestObject('Object Repository/TAG/id_refid_td7_div1_div_a2', [('refID') : 'source_' + refID]))

//*[@id="ModifFiche"]/div[1]/div/button[2]
'User: Click on send to'
WebUI.click(findTestObject('Object Repository/TAG/id_ModifFiche_div3_div_button2'))

/////////////////////////////EMPTY GROUP PAGE 4 - USER FIELD + Group Approval /////////////////////
'Screenshot: Empty Group User field + group approval'
WebUI.takeScreenshot()

String Actual_Error_msg4 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="cardctrlphase"]/div[2]']))

functions.I.print(Actual_Error_msg4)

String Expected_Error_msg4 = ((((((('Studio (Project)' + '\n') + 'Potential problem with these fields:') + '\n') + 'External agency (Component)') + 
'\n') + 'ANAIS LEFEVRE') + '\n') + 'Modify this component brief'

WebUI.verifyMatch(Actual_Error_msg4, Expected_Error_msg4, false)

'click on Modify this component brief'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="cardctrlphase"]/div[2]/div[3]/div/a']))

//////////////////////////////MODIFY REF//////////////////////////////////////
'Screenshot: ref modif page'
WebUI.takeScreenshot()

WebUI.delay(1)

'120 SEelect External agency'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_133"]']), 
    '253', false)

//*[@id="type_save"]
'Click on save'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="type_save"]']))

///*[@id="source_3356"]/td[7]/div[1]/div/a[2]
'Click on road 1'
functions.I.submitquesiton_ref(findTestObject('Object Repository/TAG/id_refid_td7_div_1', [('refID') : 'source_' + refID]), 
    findTestObject('Object Repository/TAG/id_refid_td7_div1_div_a2', [('refID') : 'source_' + refID]))

//*[@id="ModifFiche"]/div[1]/div/button[2]
'User: Click on send to'
WebUI.click(findTestObject('Object Repository/TAG/id_ModifFiche_div3_div_button2'))

///////////////////////////////////STEP 1 - PHASE 1.2///////////////////////
'Screenshot: ref list page '
WebUI.takeScreenshot()

//*[@id="source_3356"]/td[5]/span[1]
'Verify that the phase has changed'
String Actual_status3 = WebUI.getText(findTestObject('Object Repository/TAG/id_refid_td5_span1', [('refID') : 'source_' + 
            refID]))

WebUI.verifyMatch(Actual_status3, 'Phase 1.2', false)

//*[@id="source_3356"]/td[7]/a
'User: Click on send to'
WebUI.click(findTestObject('HL Full Lifecycle/8 ReferencePage_ActionButton', [('refID') : 'source_' + refID]))

//*[@id="ModifFiche"]/div[1]/div/button[2]
'User: Click on send to'
WebUI.click(findTestObject('Object Repository/TAG/id_ModifFiche_div3_div_button2'))

///////////////////////////////////STEP 2 - PHASE 2.1///////////////////////
'Screenshot: ref list page '
WebUI.takeScreenshot()

//*[@id="source_3356"]/td[5]/span[1]
'Verify that the phase has changed'
String Actual_status4 = WebUI.getText(findTestObject('Object Repository/TAG/id_refid_td5_span1', [('refID') : 'source_' + 
            refID]))

WebUI.verifyMatch(Actual_status4, 'Phase 2.1', false)

WebUI.takeScreenshot()

'Click on send to complete'
functions.I.submitquesiton_ref(findTestObject('Object Repository/TAG/id_refid_td7_div_1', [('refID') : 'source_' + refID]), 
    findTestObject('Object Repository/TAG/id_refid_td7_div1_div_a1', [('refID') : 'source_' + refID]))

'Screenshot: modif page'
WebUI.takeScreenshot()

//*[@id="ModifFiche"]/div[1]/div/button[2]
'User: Click on send to'
WebUI.click(findTestObject('Object Repository/TAG/id_ModifFiche_div3_div_button2'))

///////////////////////////////////Complete///////////////////////
'Screenshot: ref list page '
WebUI.takeScreenshot()

//*[@id="source_3356"]/td[5]/span
'Verify that the phase has changed'
String Actual_status5 = WebUI.getText(findTestObject('Object Repository/TAG/id_refid_td5_span', [('refID') : 'source_' + 
            refID]))

WebUI.verifyMatch(Actual_status5, 'Complete', false)

'Close Browser'
WebUI.closeBrowser()

