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

/*
//USERNAME & PASSWORD  - SEPHORA -  10 Aug 2021
String password_atran = 'dchi1'
String password_marketing = 'dchi1'
String password_regulatory ='dchi1'
String password_studio = 'dchi1'
String password_iraz ='dchi'
String password_cmouzawak = 'dchi2'
String password_aalbeaux ='dchi'
String password_hgarnier ='diadeis'*/
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

///////////////////////////////////////////////////////////////
String Project_No = 'MI001305'

String refID = '3315'


//BROWSE & MAXIMIZE BROWSER

WebUI.openBrowser('http://mdb-release.diadeis.lan/Mediabox-independenceOld/?MBI_datasource=RELTESTAUTO_SEPHORA')

WebUI.maximizeWindow()

WebUI.takeScreenshot()

//LOG IN AS ATRAN ~ DIADEIS
// username = atran / password = diadies
'Log in as Devfs  : atran/ diadeis'
//functions.I.Login('atran', '0oeet+Yo3dw=')
functions.I.Login_password('atran', password_atran)

'Screenshot: Log as atran'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

//CLICK ON CREATE PROJECT BUTTON
'Click on + icon '
WebUI.click(findTestObject('xxx Todelete/3 ProjectListPage_Create_Project_Button'))

'Screenshot: Click + button'
WebUI.takeScreenshot()

//DEFINE PROJECT NAME
def project_name = (('AutoTest_Chrome_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(10)) + '_') + functions.I.gettimedate()

//NAME THE PROJECT
WebUI.setText(findTestObject('HL Full Lifecycle/4 CreateProjPage_inputProjectname'), project_name)

'Screenshot: Create Project Page'
WebUI.takeScreenshot()

//CLICK ON CREATE PROJECT
WebUI.click(findTestObject('HL Full Lifecycle/4 CreateProjPage_Create Project_Bluebutton'))

' Screenshot: Modification Project Page: Field filled'
WebUI.takeScreenshot()

// MODIFY PROJECT PAGE
WebUI.setText(findTestObject('HL Full Lifecycle/5 ModifyProjPage_input_code_project_field'), '12345')

WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/5 ModifyProjPage_dropdown_category_field'), 'Hair', true)

WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/5 ModifyProjPage_dropdown_segment_field'), 'BATH BODY', true)

WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/5 ModifyProjPage_dropdown_type_field'), 'One Shot', true)

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_Scope_field'), '20', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Add_Scope_field'))

WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/5 ModifyProjPage_dropdown_MAD_field'), 'Christmas', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_date_select2-var_35-container_field'))

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_dropdown_year_field'), '119', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_date_select2-var_35-container_field'))

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_DevPack_field'), 'devpack', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Add_DevPack_field'))

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_DevFS_field'), 'atran', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_Add_DevFS_button'))

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_Marketing_field'), 'marketing', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_Add_Marketing_button'))

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_Regulatory_field'), 'regulatory', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_Add_Regulatory_button'))

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_Studio_field'), 'studio', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_Add_Studio_button'))

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Update'))

WebUI.waitForPageLoad(30)

//END OF MODIFY PROJECT PAGE
// GET PROJECT NO.
String Project_No = functions.I.ProjectNo()

//CREATE REFERENCE
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPage_createrefbutton'))

WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPaga_Create a component_button'))

WebUI.waitForPageLoad(25)

//CHOOSE LIFECYCLE : FS PROCESS
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/6 ReferenceList_Choose Lifecycle'), 'FS process', false)



//DEFINE REFERENCE NAME
def ref_name = (org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(10) + '_') + functions.I.gettimedate()



//INPUT REFERENCE NAME
WebUI.setText(findTestObject('HL Full Lifecycle/6 Reference_input_Component name_field'), 'Component_' + ref_name)

'Screenshot: Create Reference Page: Lifecycle FS Process selected & Name filled\r\n'
WebUI.takeScreenshot()

//CLICK ON CREATE REF BUTTON
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferencePg_Create a component_bluebutton'))

//GET THE ID OF THE REF
String refID = functions.I.RefID()

//MODIFICATION OF REFERENCE FORM//
'DDC Status'
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/7 ModifyRefPage_Select_DDC Status_field'), 'Complete', false)


//WebUI.click(findTestObject('HL Full Lifecycle/7 ModifyRefPage_inputgr_field'))

//WebUI.click(findTestObject('HL Full Lifecycle/7 ModifyRefPage_td_25'))
//WebUI.delay(1)

//WebUI.click(findTestObject('HL Full Lifecycle/7 ModifyRefPage_la-calendar_field'))
//WebUI.delay(1)
//WebUI.click(findTestObject('HL Full Lifecycle/7 ModifyRefPage_td_26'))

'Closing date DDC & sending date of the decor doc'

WebUI.click(findTestObject('Object Repository/Control Tag/2.4 Closing Date'))

WebUI.click(findTestObject('Object Repository/Control Tag/2.5 Closing date (choose date)'))
WebUI.delay(1)

WebUI.click(findTestObject('HL Full Lifecycle/7 ModifyRefPage_la-calendar_field'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/Control Tag/2.5 Closing date (choose date)'))

'Pack type'
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/7 ModifyRefPage_Select_Pack_Type'), 'Primaire', false)

'Component type'
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/7 ModifyRefPage_Select_Component_Type'), 'Etui', false)

WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/7 ModifyRefPage_Select_printer'), 'AIRCOS', false)

WebUI.scrollToElement(findTestObject('HL Full Lifecycle/7 ModifyRefPage_button_Save'), 10)

WebUI.click(findTestObject('HL Full Lifecycle/7 ModifyRefPage_button_Save'))

'Screenshot: Modification Reference Page: Fields Filled\r\n'
WebUI.takeScreenshot()
WebUI.delay(3)

// END OF MODIFICATION OF REFERENCE FORM
//REFERENCE LIST PAGE: CLICK ON PROCCEED TO NEXT PHASE BUTTON
//*[@id="source_3205"]/td[7]/a
'User atran: Proceed to next Phase\r\n'
WebUI.click(findTestObject('HL Full Lifecycle/8 ReferencePage_ActionButton', [('refID') : 'source_' + refID]))

//REFERENCE PAGE: CLICK ON PROCCEED TO NEXT PHASE BUTTON
'User atran: Click on send to marketing button\r\n'
WebUI.click(findTestObject('HL Full Lifecycle/8 ReferencePage_button_Send to Marketing'))

// LOGOUT AS ATRAN
'Logout as atran\r\n'
functions.I.Logout()

//*************LOG IN AS MARKETING / dchi
'Log in as marketing\n'
//functions.I.Login('marketing', '0oeet+Yo3dw=')
functions.I.Login_password('marketing', password_marketing)


'Log as marketing'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//REF LIST PAGE: CLICK ON ACTION BUTTON
////*[@id="source_3206"]/td[7]/a
'User marketing: Proceed to next phase'
WebUI.click(findTestObject('HL Full Lifecycle/9 RefPage_i_B_fa fa-arrow-circle-right_1', [('refID') : 'source_' + refID]))

// REF PAGE: CLICK PROCEED TO NEXT PHASE
'User marketing: click on send to regulatory\r\n'
WebUI.click(findTestObject('HL Full Lifecycle/9 RefPage_button_Send to Regulatory'))

//LOGOUT AS MARKETING
'Logout as marketing\r\n'
functions.I.Logout()


//********************LOGIN AS REGULATORY
'Log in as regulatory\r\n'
//functions.I.Login('regulatory', '0oeet+Yo3dw=')
functions.I.Login_password('regulatory', password_regulatory)


'Screenshot: Log as regulatory\r\n'
WebUI.takeScreenshot()

// CLICK ON SIDE BAR MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//REFERENCE LIST PAGE: CLICK ON ACTION QUESTION BUTTON
'User regulatory: Proceed to next phase (Question)\r\n'
WebUI.click(findTestObject('HL Full Lifecycle/10.1_RefPage_questionphase', [('refID') : 'source_' + refID]))

'Screenshot: User reulatory proceed next phase'
WebUI.takeScreenshot()

//REF LIST PAGE: CLICK ON OPTION
WebUI.click(findTestObject('HL Full Lifecycle/10.2 ReferencPAge_button_Send to studio', [('refID') : 'source_' + refID]))

//REF PAGE: CLICK PROCEED TO NEXT PHASE
WebUI.click(findTestObject('HL Full Lifecycle/10.3 RefPage_Submitstudio'))

// LOGOUT AS REGULATORY
'Logout as regulatory\r\n'
functions.I.Logout()





//********************LOGIN AS STUDIO - dchi
'Login as studio\r\n'
//functions.I.Login('studio', '0oeet+Yo3dw=')
functions.I.Login_password('studio', password_studio)

'Screenshot: Log as studio\r\n'
WebUI.takeScreenshot()

// CLICK ON SIDE BAR MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))
//REF LIST PAGE: QUESTION PHASE CLICK ON ACTION BUTTON
WebUI.waitForElementClickable(findTestObject('HL Full Lifecycle/10.10 RefPage_Question', [('refID') : 'source_' + refID]), 
    10)


'User studio: proceed to next phase\r\n'
WebUI.click(findTestObject('HL Full Lifecycle/10.10 RefPage_Question', [('refID') : 'source_' + refID]))

WebUI.click(findTestObject('HL Full Lifecycle/11 ReferencePage_Question_a_Accept the brief', [('refID') : 'source_' + refID]))

// SELECT OPTIONS FROM LIST
WebUI.click(findTestObject('HL Full Lifecycle/11 ReferencePAge_List_S2-var_133-container'))

functions.I.SelectList()


// CLICK ON ACCEPT BRIEF
WebUI.click(findTestObject('HL Full Lifecycle/11 RefPage_Button_AcceptBrief', [('refID') : 'source_' + refID]))



//PRODUCTION PHASE: UPLOAD DOC
//CLICK ACTION BUTTON FOR PROD
WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/12 Reference_ButtonAction_Prod', [('refID') : 'source_' + refID]))

WebUI.delay(2)

//UPLOAD A DOC
functions.I.UploadDoc('C:\\Users\\lamhe\\Desktop\\Upoad_File\\testdata1.pdf', findTestObject('HL Full Lifecycle/12 ReferencePage_Field_ProdUploadField'))
//functions.I.UploadDoc_sendkey_Prod(findTestObject('Object Repository/HL Full Lifecycle/Prod_Upload'), 'C:\\Users\\lamhe\\Desktop\\Upoad_File\\testdata1.pdf','testdata1.pdf')
WebUI.delay(1)





//	public static void UploadDoc_sendkey( Object xpath_field, String filePath,String filename)
//functions.I.UploadDoc_sendkey_Prod('//*[@id="kt_body"]/input[1]', 'C:\\Users\\lamhe\\Desktop\\Upoad_File\\testdata1.pdf','testdata1.pdf')
//functions.I.UploadDoc_sendkey_field('//*[@id="kt_body"]/input[1]', 'C:\\Users\\lamhe\\Desktop\\Upoad_File\\testdata1.pdf','testdata1.pdf')
'Screenshot: Field Upload doc'
WebUI.takeScreenshot()

//REF PAGE: CLICK ON PROCEED TO NEXT PHASE
WebUI.click(findTestObject('HL Full Lifecycle/12 ReferncePage_Button_Updatensenddoc'))

WebUI.delay(2)

