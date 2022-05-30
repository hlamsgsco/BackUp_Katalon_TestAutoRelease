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

/* IN THIS TESTCASE, SCENARIO TESTED:
 * COMPLETED LIFECYCLE
 * USER CAN SUBMIT
 * USER CAN APPROVE DOC
 */
//DATA FILE : USERNAME & PASSWORD  - SEPHORA 
def data_Sephora = TestDataFactory.findTestData('Data Files/Username_Password/Sephora')

String password_atran = data_Sephora.getValue(2, 1 //R
    )

String password_marketing = data_Sephora.getValue(2, 2)

String password_regulatory = data_Sephora.getValue(2, 3)

String password_studio = data_Sephora.getValue(2, 4)

String password_cmouzawak = data_Sephora.getValue(2, 6)

String password_aalbeaux = data_Sephora.getValue(2, 7)

String password_hgarnier = data_Sephora.getValue(2, 8)

String password_iraz = data_Sephora.getValue(2, 5)

//DATA FILE : URL - SEPHORA
def data_urlRELAUTO = TestDataFactory.findTestData('Data Files/URL/URL_relauto')

String Url_Sephora = data_urlRELAUTO.getValue(2, 1)

//CLEAR NOTEPAD
functions.I.clearnotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\3.01\\3.01_Sephora_ProjectNo.txt')

functions.I.clearnotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\3.01\\3.01_Sephora_refID.txt')



/////////////////////////////////////////////////TEST START /////////////////////////////////////////
'Navigate to Sephora'
WebUI.openBrowser(Url_Sephora)

'Maximize Window'
WebUI.maximizeWindow()

'Screenshot: Login page'
WebUI.takeScreenshot()

'Log in as Devfs  : atran/ diadeis'
functions.I.Login_password('atran', password_atran)

'Screenshot: Log as atran'
WebUI.takeScreenshot()

'Click on LHS menu - Project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

//CREATION OF PROJECT
'Click on + icon to create project '
WebUI.click(findTestObject('Object Repository/1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/a[1]']))

'Screenshot: Click + button'
WebUI.takeScreenshot()

//DEFINE PROJECT NAME
def project_name = (('AutoTest_Chrome_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(10)) + '_') + functions.I.gettimedate()

'Enter Project name'
WebUI.setText(findTestObject('HL Full Lifecycle/4 CreateProjPage_inputProjectname'), project_name)

'Screenshot: Create Project Page'
WebUI.takeScreenshot()

'Click on the button create project'
WebUI.click(findTestObject('HL Full Lifecycle/4 CreateProjPage_Create Project_Bluebutton'))

'Screenshot: Modification Project Page: Field filled'
WebUI.takeScreenshot()

// MODIFY PROJECT PAGE
'Set Text: Project Field - 12345'
WebUI.setText(findTestObject('HL Full Lifecycle/5 ModifyProjPage_input_code_project_field'), '12345')

'Select List Category - Hair'
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/5 ModifyProjPage_dropdown_category_field'), 'Hair', true)

'Select List Segment - Bath Body'
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/5 ModifyProjPage_dropdown_segment_field'), 'BATH BODY', true)

'Select List Type - One Shot'
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/5 ModifyProjPage_dropdown_type_field'), 'One Shot', true)

'Select Multiple list List Scope - 20'
WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_Scope_field'), '20', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Add_Scope_field'))

'Select List MAD - Christmas '
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/5 ModifyProjPage_dropdown_MAD_field'), 'Christmas', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_date_select2-var_35-container_field'))

'Select List Year - 119'
WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_dropdown_year_field'), '119', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_date_select2-var_35-container_field'))

'Select Multiple List DevPack - devpack'
WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_DevPack_field'), 'devpack', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Add_DevPack_field'))

'Select Multiple List DevFS - atran'
WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_DevFS_field'), 'atran', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_Add_DevFS_button'))

'Select Multiple List Marketing - marketing'
WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_Marketing_field'), 'marketing', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_Add_Marketing_button'))

'Select Multiple List Regulatory - Regulatory'
WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_Regulatory_field'), 'regulatory', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_Add_Regulatory_button'))

'Select Multiple List Studio - Studio'
WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_Studio_field'), 'studio', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_Add_Studio_button'))

'delay 5'
WebUI.delay(5)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Update'))

'delay 5'
WebUI.delay(5)

//END OF MODIFY PROJECT PAGE
// GET PROJECT NO.
String Project_No = functions.I.ProjectNo()

'Click on + button to create ref'
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPage_createrefbutton'))

'Click on create button'
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPaga_Create a component_button'))

WebUI.waitForPageLoad(25)

'Select Lifecycle template  : FS PROCESS'
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/6 ReferenceList_Choose Lifecycle'), 'FS process', false)

//DEFINE REFERENCE NAME
def ref_name = (org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(10) + '_') + functions.I.gettimedate()

'Enter ref name'
WebUI.setText(findTestObject('HL Full Lifecycle/6 Reference_input_Component name_field'), 'Component_' + ref_name)

'Screenshot: Create Reference Page: Lifecycle FS Process selected & Name filled\r\n'
WebUI.takeScreenshot()

'Click on create button'
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferencePg_Create a component_bluebutton'))

WebUI.delay(5)

//GET THE ID OF THE REF
String refID = functions.I.RefID()

//MODIFICATION OF REFERENCE FORM//
'DDC Status'
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/7 ModifyRefPage_Select_DDC Status_field'), 'Complete', false)

'Closing date DDC & sending date of the decor doc'
WebUI.click(findTestObject('Object Repository/Control Tag/2.4 Closing Date'))

WebUI.click(findTestObject('Object Repository/Control Tag/2.5 Closing date (choose date)'))

'delay 1'
WebUI.delay(1)

WebUI.click(findTestObject('HL Full Lifecycle/7 ModifyRefPage_la-calendar_field'))

'delay 1'
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
'User atran: Proceed to next Phase\r\n'
WebUI.click(findTestObject('HL Full Lifecycle/8 ReferencePage_ActionButton', [('refID') : 'source_' + refID]))

//REFERENCE PAGE: CLICK ON PROCCEED TO NEXT PHASE BUTTON
'User atran: Click on send to marketing button\r\n'
WebUI.click(findTestObject('HL Full Lifecycle/8 ReferencePage_button_Send to Marketing'))

// LOGOUT AS ATRAN
'Logout as atran'
functions.I.Logout()

//*************LOG IN AS MARKETING / dchi
'Log in as marketing\n'
functions.I.Login_password('marketing', password_marketing)

'Log as marketing'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//REF LIST PAGE: CLICK ON ACTION BUTTON
'User marketing: Proceed to next phase'
WebUI.click(findTestObject('HL Full Lifecycle/9 RefPage_i_B_fa fa-arrow-circle-right_1', [('refID') : 'source_' + refID]))

// REF PAGE: CLICK PROCEED TO NEXT PHASE
'User marketing: click on send to regulatory\r\n'
WebUI.click(findTestObject('HL Full Lifecycle/9 RefPage_button_Send to Regulatory'))

//LOGOUT AS MARKETING
'Logout as marketing\r\n'
functions.I.Logout()

//********************LOGIN AS REGULATORY
'Log in as regulatory'
functions.I.Login_password('regulatory', password_regulatory)

'Screenshot: Log as regulatory'
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

//LOGIN AS STUDIO - dchi
'Login as studio\r\n'
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
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_133"]']), '282', false)

// CLICK ON ACCEPT BRIEF
WebUI.click(findTestObject('HL Full Lifecycle/11 RefPage_Button_AcceptBrief', [('refID') : 'source_' + refID]))

//CLICK ACTION BUTTON FOR PROD
'99'
String color1 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[8]/a']), 
    'color', FailureHandling.OPTIONAL)

functions.I.print(color1)

while (color1 == 'rgba(255, 255, 255, 1)') {
    WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[8]/a']))

    //UPLOAD A DOC - PDF
    functions.I.UploadDoc_sendkey_Prod(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/input[2]']), 
        'D:\\Upoad_File\\Upload doc\\testdata1.jpg', 'testdata1')

    'Screenshot: Production phase Field Upload doc'
    WebUI.takeScreenshot()

    WebUI.delay(10)

    //REF PAGE: CLICK ON PROCEED TO NEXT PHASE
    WebUI.click(findTestObject('HL Full Lifecycle/12 ReferncePage_Button_Updatensenddoc'))

    WebUI.delay(5)

    //color1 = WebUI.getCSSValue(findTestObject('Object Repository/HL Full Lifecycle/12 Reference_ButtonAction_Prod', [('refID') : 'source_' +  refID]), 'color', FailureHandling.OPTIONAL)
    color1 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[8]/a']), 
        'color', FailureHandling.OPTIONAL)
}

'Logout as studio'
functions.I.Logout()

'Log in as marketing'
functions.I.Login_password('marketing', password_marketing)

'Log as marketing'
WebUI.takeScreenshot()

// CLICK ON SIDE BAR MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//CLICK ON REF LINK
////*[@id="source_3415"]/td[7]/a
'107'
functions.I.AWF_approve_byaction(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[7]/a']))

// LOGOUT AS MARKETNG
functions.I.Logout()

//********************LOGIN AS REgulatory
'Log in as regulatory'
functions.I.Login_password('regulatory', password_regulatory)

// CLICK ON SIDE BAR MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search a Project No'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

WebUI.waitForPageLoad(10)

//AWF: DEVFS APPROVE A DOC
//functions.I.AWF_approve()
'User marketing: Click on view doc'
functions.I.AWF_approve_byaction(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[7]/a']))

WebUI.takeScreenshot()

//LOGOUT AS Marketing
'Logout as marketing'
functions.I.Logout()

//********************LOGIN AS FS atran
'Login as atran'
functions.I.Login_password('atran', password_atran)

'Login as atran'
WebUI.takeScreenshot()

// CLICK ON SIDE BAR MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//CLICK ON REF LINK
WebUI.delay(10)

//AWF: DEVFS APPROVE A DOC
functions.I.AWF_approve_byaction(findTestObject('Object Repository/HL Full Lifecycle/Function AWFAction2', [('refID') : 'source_' + 
            refID]))

WebUI.delay(1)

//REFERENCE LIST PAGE: ACTION BUTTON
'User atran: Submit to next phase'
WebUI.click(findTestObject('HL Full Lifecycle/15 RefPage_Button_Submit_AurelieTran', [('refID') : 'source_' + refID]))

WebUI.delay(1)

//MODIFICATION REFERENCE PAGE
WebUI.click(findTestObject('HL Full Lifecycle/15 RefPage_Question_sendtodiadeis', [('refID') : 'source_' + refID]))

WebUI.delay (3)
WebUI.setText(findTestObject('HL Full Lifecycle/15 RefPage_Field_CODEEAN'), 'Code EAn Test')

WebUI.setText(findTestObject('HL Full Lifecycle/15 RefPg_Field_Brief_photogravuremandatory'), 'Brief photogravuremandatory')

WebUI.setText(findTestObject('HL Full Lifecycle/15 RefPg_Field_Brief_Field_NoRepro'), 'Number of colors Repromandatory')

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/15 RefPg_Field_Brief_Field_PrinterType'), '109', false)

WebUI.click(findTestObject('HL Full Lifecycle/15 RefPg_Field_Brief_Field_ML_add'))

WebUI.click(findTestObject('HL Full Lifecycle/15 RefPg_Field_Brief_Field_MAD_suppliermandatory'))

WebUI.click(findTestObject('HL Full Lifecycle/15 RefPg_Field_Brief_Field_MAD_yr'))

WebUI.click(findTestObject('HL Full Lifecycle/15 RefPg_Field_Brief_Field_MAD_suppliermandatory'))

WebUI.scrollToElement(findTestObject('HL Full Lifecycle/15 RefPage_Button_Submittodiadies'), 5)

'Screenshot : User atran > Edit Reference '
WebUI.takeScreenshot()

functions.I.click_button_javascript(findTestObject('HL Full Lifecycle/15 RefPage_Button_Submittodiadies'))



'Logout as atran\r\n'
functions.I.Logout()

'Log in as Cyril \r\n'
functions.I.Login_password('cmouzawak', password_cmouzawak)

'Log as Cyril'
WebUI.takeScreenshot()

//CLICK ON SIDE BAR MENU: PROJET(FR)
WebUI.waitForElementClickable(findTestObject('HL Full Lifecycle/2 LHSMenu_Projet(FR)'), 10)

WebUI.click(findTestObject('HL Full Lifecycle/2 LHSMenu_Projet(FR)'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/2 Filter_ Button_FR_Apply'))

//REFERENCE LIST PAGE: CLICK SUBMIT BUTTON
WebUI.waitForElementClickable(findTestObject('HL Full Lifecycle/16 RefListPg_Button_Submit_Cyril', [('refID') : 'source_' + 
            refID]), 10)

'148'
WebUI.click(findTestObject('HL Full Lifecycle/16 RefListPg_Button_Submit_Cyril', [('refID') : 'source_' + refID]))

//UPOAD A DOC
'User Cyril: Upload adoc'
WebUI.delay(1)

functions.I.UploadDoc_sendkey_field('//*[@id="var_123"]', 'D:\\Upoad_File\\Upload doc\\testdata1.jpg', 'testdata1')

// //*[@id="ModifFiche"]/div[2]/div[2]/div/label
WebUI.delay(1)

//REF PAGE: CLICK SUBMIT
WebUI.click(findTestObject('HL Full Lifecycle/16 RefPg_Button_SubmitCyril'))

'Screenshot: Upload doc'
WebUI.takeScreenshot()

//LOGOUT AS CYRIL
'Logout as Cyril'
functions.I.Logout()

//LOGIN AS IRAZ - diadeis
'Log in as Iraz\r\n'
functions.I.Login_password('lraz', password_iraz)

'Log as Iraz\r\n'
WebUI.takeScreenshot()

// CLICK ON SIDE BAR MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

WebUI.delay(3)

//PRODUCTION PHASE: UPLOAD DOC
//CLICK ACTION BUTTON FOR PROD
String color2 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[8]/a']), 
    'color', FailureHandling.OPTIONAL)

functions.I.print(color2)

while (color2 == 'rgba(255, 255, 255, 1)') {
    WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[8]/a']))

    //UPLOAD A DOC
    functions.I.UploadDoc_sendkey_Prod(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/input[2]']), 
        'D:\\Upoad_File\\Upload doc\\testdata1.jpg', 'testdata1')

    'Screenshot: Production phase Field Upload doc'
    WebUI.takeScreenshot()

    WebUI.delay(10)

    //REF PAGE: CLICK ON PROCEED TO NEXT PHASE
    WebUI.click(findTestObject('HL Full Lifecycle/9.1 REfPg_Button_Upload_IR_Part 1'))

    WebUI.delay(5)

    color2 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[8]/a']), 
        'color', FailureHandling.OPTIONAL)
}

'Logout as Iraz'
functions.I.Logout()

//LOGIN AS FS Aurelie tran
'Login as atran'
functions.I.Login_password('atran', password_atran)

'Login as atran'
WebUI.takeScreenshot()

'CLICK ON SIDE BAR MENU: PROJECTS'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search Project'
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

'Click on ref link'
WebUI.click(findTestObject('HL Full Lifecycle/14 RefListPg_Reflink2', [('refID') : 'source_' + refID]))

'User atran approve doc'
functions.I.AWF_approve()

'Screenshot: User atran approve doc'
WebUI.takeScreenshot()

'CLICK ON ACTION BUTTON – QUESTION PHASE'
WebUI.click(findTestObject('HL Full Lifecycle/17 Ref_Button_Submit_question', [('refID') : 'source_' + refID]))

'CLICK ON DDC UPDATED - OPTION'
WebUI.click(findTestObject('HL Full Lifecycle/17 Ref_Options_DDCupdated', [('refID') : 'source_' + refID]))

'Click on DDC Updated'
WebUI.click(findTestObject('HL Full Lifecycle/17.1 Ref_Question_DDCUpdated'))

'Verify Status: Completed'
functions.I.status(findTestObject('HL Full Lifecycle/Status', [('refID') : 'source_' + refID]))

'Status: LC Completed'
WebUI.takeScreenshot()

//NOTEPAD WRITE THE PROJECT AND REF ID
functions.I.writenotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\3.01\\3.01_Sephora_ProjectNo.txt', Project_No)

functions.I.writenotepad('D:\\Upoad_File\\Projet_ Login\\Sephora\\3.01\\3.01_Sephora_refID.txt', refID)

'Close Browser'
WebUI.closeBrowser()
