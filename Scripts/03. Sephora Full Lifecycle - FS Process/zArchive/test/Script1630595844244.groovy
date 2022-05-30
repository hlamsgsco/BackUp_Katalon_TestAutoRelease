import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.junit.After as After
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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger

//USERNAME & PASSWORD FOR LOGIN
//Username for Admin = hgarnier / diadeis
String password_atran = 'dchi'

String password_marketing = 'dchi'

String password_regulatory = 'dchi'

String password_studio = 'dchi'

String password_iraz = 'diadeis'

String password_cmouzawak = 'diadeis'

///////////////////////////////////////////////////////////////
//Keyword log
KeywordLogger log = new KeywordLogger()

//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Sephora Release >  http://mdb-release.diadeis.lan/Mediabox-independence/?MBI_datasource=REL_SEPHORA'
WebUI.openBrowser('http://mdb-release.diadeis.lan/Mediabox-independence/?MBI_datasource=REL_SEPHORA')

WebUI.maximizeWindow()

WebUI.takeScreenshot()

//LOG IN AS ATRAN ~ DIADEIS
// username = atran / password = diadies
//functions.I.Login('atran', '0oeet+Yo3dw=')
'Log in as Devfs  : atran/ diadeis'
functions.I.Login_password('atran', password_atran)

'Screenshot: Log as atran'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

//CLICK ON CREATE PROJECT BUTTON
'Click on + icon '
WebUI.click(findTestObject('xxx Todelete/3 ProjectListPage_Create_Project_Button'))

//CLICK ON CREATE PROJECT
WebUI.click(findTestObject('HL Full Lifecycle/4 CreateProjPage_Create Project_Bluebutton'))

////////////////////////////////PROJECT NAME  - ERROR MESSAGE (HARD CODED)///////////////////////////////////////////////
// The star should be displayed
'The star *  is displayed next to project name & Toastr  is displayed'
functions.I.verifystar('Project name', findTestObject('Object Repository/Control Tag/1.2 asteriximage_controltag', [('field_name') : 'prj_name']), 
    log)

//TOASTR SHOULD BE DISPLAYED
'Toastr is displayed "Project: Please fill project name" '
functions.I.verifyErrormsg_toastr('Project name ', findTestObject('Control Tag/1.1Toastr_name_msg'), 'Please fill project name', 
    log)

//CLICK ON CANCEL BUTTON
WebUI.click(findTestObject('Object Repository/Control Tag/1.3 ProjectCreationPage_cancelbutton'))

////////////////////////////////END PROJECT NAME  - ERROR MESSAGE///////////////////////////////////////////////
//CLICK ON CREATE PROJECT BUTTON
'Click on + icon '
WebUI.click(findTestObject('xxx Todelete/3 ProjectListPage_Create_Project_Button'))

'Screenshot: Creation of Project page'
WebUI.takeScreenshot()

//DEFINE PROJECT NAME
def project_name = (('AutoTest_Controltag_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(10)) + '_') + 
functions.I.gettimedate()

//NAME THE PROJECT
WebUI.setText(findTestObject('HL Full Lifecycle/4 CreateProjPage_inputProjectname'), project_name)

//CLICK ON CREATE PROJECT
WebUI.click(findTestObject('HL Full Lifecycle/4 CreateProjPage_Create Project_Bluebutton'))

'Screenshot: Modfication Project Page'
WebUI.takeScreenshot()

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_DevFS_field'), 'atran', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_Add_DevFS_button'))

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Update'))

WebUI.waitForPageLoad(10)

//END OF MODIFY PROJECT PAGE
// GET PROJECT NO.
String Project_No = functions.I.ProjectNo()

//CREATE REFERENCE
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPage_createrefbutton'))

WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPaga_Create a component_button'))

WebUI.waitForPageLoad(25)

////////////////////////////////LIFECYCLE AND COMPONENT  NAME  - ERROR MESSAGE (Hard coded)///////////////////////////////////////////////
/*// The star should be displayed
'Screenshot: The star should be displayed next to Lifecycle field & Component field'
WebUI.takeScreenshot()*/
'The star is displayed next to Lifecycle name field'
functions.I.verifystar('Lifecycle', findTestObject('Object Repository/Control Tag/1.2 asteriximage_controltag', [('field_name') : 'lifecycle_block']), 
    log)

'The star is displayed next to Component name field'
functions.I.verifystar('Component name', findTestObject('Object Repository/Control Tag/1.2 asteriximage_controltag', [('field_name') : 'ref_name']), 
    log)

//CHOOSE LIFECYCLE : FS PROCESS
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/6 ReferenceList_Choose Lifecycle'), 'FS process', false)

//CLICK ON CREATE REF BUTTON
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferencePg_Create a component_bluebutton'))

'Screenshot: Toastr is displayed for component name"'
WebUI.takeScreenshot()

//TOASTR SHOULD BE DISPLAYED - Component name
String ErrorMsg1 = 'Please fill in a component name'

functions.I.verifyErrormsg_toastr('Component name field ', findTestObject('Control Tag/1.1Toastr_name_msg'), ErrorMsg1, 
    log)

//DESELECT LIFECYCLE FROM LIST
WebUI.click(findTestObject('Object Repository/Control Tag/1.4 Refpage_deselect'))

//DEFINE REFERENCE NAME
def ref_name = (org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(10) + '_') + functions.I.gettimedate()

//INPUT REFERENCE NAME
WebUI.setText(findTestObject('HL Full Lifecycle/6 Reference_input_Component name_field'), 'Component_' + ref_name)

//CLICK ON CREATE REF BUTTON
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferencePg_Create a component_bluebutton'))

'Screenshot:Toastr displayed for lifecycle'
WebUI.takeScreenshot()

//TOASTR SHOULD BE DISPLAYED - Lifecycle
String ErrorMsg2 = 'Please select a life cycle'

functions.I.verifyErrormsg_toastr('Lifecycle  field ', findTestObject('Control Tag/1.1Toastr_name_msg'), ErrorMsg2, log)

//CHOOSE LIFECYCLE : FS PROCESS
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/6 ReferenceList_Choose Lifecycle'), 'FS process', false)

'Screenshot: Create Reference Page: Lifecycle FS Process selected & Name filled\r\n'
WebUI.takeScreenshot()

//CLICK ON CREATE REF BUTTON
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferencePg_Create a component_bluebutton'))

//GET THE ID OF THE REF
String refID = functions.I.RefID()

////////////////////////////////ENF OF LIFECYCLE AND COMPONENT  NAME  - ERROR MESSAGE///////////////////////////////////////////////
WebUI.click(findTestObject('HL Full Lifecycle/7 ModifyRefPage_button_Save'))

//REF LIST PAGE: CLICK ON ACTION BUTTON
'User atran: Proceed to next phase'
WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/2 Reflist_submit(atran)', [('refID') : 'source_' + refID]))

' Screenshot: Modification Reference Page'
WebUI.takeScreenshot()

////////////////////////////////REFERENCE FIELD  - ERROR MESSAGE///////////////////////////////////////////////
// VERIFCATION OF STAR NEXT TO FIELD
'Closing date DDC'
functions.I.verifystar('Closing date DDC', findTestObject('Object Repository/Control Tag/1.5 Controltag_onForm', [('field_id') : '2']), 
    log)

'Sending date of the decor document'
functions.I.verifystar('Sending date of the decor document', findTestObject('Object Repository/Control Tag/1.5 Controltag_onForm', 
        [('field_id') : '2']), log)

'Pack type'
functions.I.verifystar('Pack typemandatory', findTestObject('Object Repository/Control Tag/1.5 Controltag_onForm', [('field_id') : '2']), 
    log)

WebUI.scrollToElement(findTestObject('Object Repository/Control Tag/1.5 Controltag_onForm', [('field_id') : '2']), 1)

'Component type'
functions.I.verifystar('Component type', findTestObject('Object Repository/Control Tag/1.5 Controltag_onForm', [('field_id') : '2']), 
    log)

//REFERENCE PAGE: CLICK ON PROCCEED TO NEXT PHASE BUTTON
'User atran: Click on send to marketing button\r\n'
WebUI.executeJavaScript('window.scrollTo(0, document.body.scrollHeight)', [])

WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/8 sendtomarketing(atran)'))

//ERROR MESSAGE PAGE - Project & Reference
'Screenshot: Verification ERROR message page - Project & Reference \r\n '
WebUI.takeScreenshot()

//Error msg - Project

String bError_msg_actualP = WebUI.getText(findTestObject('Object Repository/Control Tag/1.12 CT Project (atran)'))

List<String> lines2P = new ArrayList<String>()

line2sP = bError_msg_actualP.split('\n')

//CHECK ALL LINE
if ((((lines2P.contains('Type is missing') && lines2P.contains('Category is missing')) && lines2P.contains('Segment is missing')) && 
lines2P.contains('MAD is missing')) && lines2P.contains('Year is missing')) {
    System.out.println('Error messages are displayed for the Project fields: "Category is missing" , "Segment is missing", "MAD is missing" & "Year is missing"')
	assert true
} else {
    System.out.println('KO - Missing Control tag on Project')

    log.logFailed('WARNING! The Project Control tag error messages are not displayed the fields: Category, Segment, MAD, Year,  -  Test KO')


    
}

//Error Msg - Ref
String bError_msg_actual = WebUI.getText(findTestObject('Object Repository/Control Tag/2.1 CT_ref(atran)'))

List<String> lines2 = new ArrayList<String>()

line2s = bError_msg_actual.split('\n')

//CHECK ALL LINE
if (((lines2.contains('Sending date of the decor document is missing') && lines2.contains('Closing date DDC is missing')) && 
lines2.contains('Component type is missing')) && lines2.contains('Pack type is missing')) {
    System.out.println('Error messages are displayed on Ref : "Sending date of the decor document is missing", "Closing date DDC is missing", "Component type is missing" & "Pack type is missing"')
	assert true
	} else {
    System.out.println('KO - Missing Control Tag on Reference')

    log.logFailed('WARNING! The Reference Control tag error messages are not displayed the fields: Closing date DDC,Sending date of the decor document,Pack type, Component type -  Test KO')

   
}

//END OF ERROR MESSAGE PAGE - Project & Reference
'ATRAN: click on modify project button'
WebUI.click(findTestObject('Object Repository/Control Tag/2.2 ButtonModifyProject'))

' Screenshot: Redirect to Modification Project Page \r\n'
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

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_Marketing_field'), 'marketing', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_Add_Marketing_button'))

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_Regulatory_field'), 'regulatory', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_Add_Regulatory_button'))

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_Studio_field'), 'studio', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_Add_Studio_button'))

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Update'))

//REF LIST PAGE: CLICK ON ACTION BUTTON
'User atran: Proceed to next phase \r\n'
WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/2 Reflist_submit(atran)', [('refID') : 'source_' + refID]))

/////////
//ATRAN: SEND TO MARKETING
WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/8 sendtomarketing(atran)'))

'Screenshot: Verification ERROR message page - Reference '
WebUI.takeScreenshot()

//Error Msg - Ref
String bError_msg_actual1 = WebUI.getText(findTestObject('Object Repository/Control Tag/2.1 CT_ref(atran)'))

List<String> lines21 = new ArrayList<String>()

line2s = bError_msg_actual1.split('\n')

//CHECK ALL LINE
if (((lines21.contains('Sending date of the decor document is missing') && lines21.contains('Closing date DDC is missing')) && 
lines21.contains('Component type is missing')) && lines21.contains('Pack type is missing')) {
    System.out.println('Error messages are displayed on Ref fields: "Sending date of the decor document is missing", "Closing date DDC is missing", "Component type is missing" & "Pack type is missing"')
	assert true
	} else {
    System.out.println('KO - Missing Control Tag on Reference')

    log.logFailed('WARNING! The Control tag error messages are not displayed the fields: Closing date DDC,Sending date of the decor document,Pack type, Component type -  Test KO')


}

WebUI.delay(1)

//ATRAN CLICK ON MODIFY REF
'User atran: click on modify component button \r\n'
WebUI.click(findTestObject('Object Repository/Control Tag/2.23 Button Modify Component (atran)'))

//CLICK ON CANCEL
'User atran: click on cancel button\r\n'
WebUI.click(findTestObject('Object Repository/Control Tag/2.3 cancelbutton(atran)'))

//REF LIST PAGE: CLICK ON ACTION BUTTON
'User atran: Proceed to next phase'
WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/2 Reflist_submit(atran)', [('refID') : 'source_' + refID]))

'User atran: modify the following fields:'

//MODIFICATION OF REFERENCE FORM//
'1. DDC Status'
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/7 ModifyRefPage_Select_DDC Status_field'), 'Complete', false)

'2. Closing date DDC & sending date of the decor doc'
WebUI.click(findTestObject('Object Repository/Control Tag/2.4 Closing Date'))

WebUI.click(findTestObject('Object Repository/Control Tag/2.5 Closing date (choose date)'))

WebUI.delay(1)

WebUI.click(findTestObject('HL Full Lifecycle/7 ModifyRefPage_la-calendar_field'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Control Tag/2.5 Closing date (choose date)'))

'3. Pack type'
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/7 ModifyRefPage_Select_Pack_Type'), 'Primaire', false)

'4. Component type'
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/7 ModifyRefPage_Select_Component_Type'), 'Etui', false)

'5. Printer'
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/7 ModifyRefPage_Select_printer'), 'AIRCOS', false)

WebUI.waitForPageLoad(5)

// END OF MODIFICATION OF REFERENCE FORM
//REFERENCE PAGE: CLICK ON PROCCEED TO NEXT PHASE BUTTON
'User atran: Click on send to marketing button\r\n'
WebUI.executeJavaScript('window.scrollTo(0, document.body.scrollHeight)', [])

WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/8 sendtomarketing(atran)'))

// LOGOUT AS ATRAN
'Logout as atran\r\n'
functions.I.Logout()

//*************LOG IN AS MARKETING / dchi
//functions.I.Login('marketing', '0oeet+Yo3dw=')
'Log in as marketing\n'
functions.I.Login_password('marketing', password_marketing)

'Screenshot: Log as marketing'
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

'Screenshot: user marketing: Successfully send next phase '
WebUI.takeScreenshot()

//LOGOUT AS MARKETING
'Logout as marketing\r\n'
functions.I.Logout()

//********************LOGIN AS REGULATORY
//functions.I.Login('regulatory', '0oeet+Yo3dw=')
'Log in as regulatory\r\n'
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

'Screenshot: user studio: Successfully send next phase '
WebUI.takeScreenshot()

// LOGOUT AS REGULATORY
'Logout as regulatory\r\n'
functions.I.Logout()

//********************LOGIN AS STUDIO - dchi
//functions.I.Login('studio', '0oeet+Yo3dw=')
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

// CLICK ON ACCEPT BRIEF
WebUI.click(findTestObject('HL Full Lifecycle/11 RefPage_Button_AcceptBrief', [('refID') : 'source_' + refID]))

//PRODUCTION PHASE: UPLOAD DOC
//CLICK ACTION BUTTON FOR PROD
WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/12 Reference_ButtonAction_Prod', [('refID') : 'source_' + 
            refID]))

//UPLOAD A DOC
functions.I.UploadDoc('C:\\Users\\lamhe\\Desktop\\Upoad_File\\testdata1.pdf', findTestObject('HL Full Lifecycle/12 ReferencePage_Field_ProdUploadField'))

'Screenshot: Production phase Field Upload doc'
WebUI.takeScreenshot()

//REF PAGE: CLICK ON PROCEED TO NEXT PHASE
WebUI.scrollToElement(findTestObject('HL Full Lifecycle/12 ReferncePage_Button_Updatensenddoc'), 1)

WebUI.click(findTestObject('HL Full Lifecycle/12 ReferncePage_Button_Updatensenddoc'))

WebUI.delay(2)

'Screenshot: user studio: Successfully send next phase '
WebUI.takeScreenshot()

// LOGOUT AS STUDIO
'Log out as studio\r\n'
functions.I.Logout()

//LOGIN AS MArketing
//functions.I.Login('marketing', '0oeet+Yo3dw=')
functions.I.Login_password('marketing', password_marketing)

'Screenshot: Log in as marketing'
WebUI.takeScreenshot()

// CLICK ON SIDE BAR MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//CLICK ON REF LINK
functions.I.AWF_approve_byaction(findTestObject('HL Full Lifecycle/Function_AWFbyactionbutton', [('refID') : 'source_' + 
            refID]))

'Screenshot: user marketing: Successfully approved doc '
WebUI.takeScreenshot()

//LOGOUT AS MARKETING
'Screenshot: Log out as studio'
functions.I.Logout()

//********************LOGIN AS Regulatory
//functions.I.Login('regulatory', '0oeet+Yo3dw=')
functions.I.Login_password('regulatory', password_regulatory)

'Screenshot: Log in as regulatory'
WebUI.takeScreenshot()

// CLICK ON SIDE BAR MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//CLICK ON REF LINK
WebUI.waitForPageLoad(10)

'User regulatory: Click on view doc'
functions.I.AWF_approve_byaction(findTestObject('HL Full Lifecycle/Function_AWFbyactionbutton', [('refID') : 'source_' + 
            refID]))

'Screenshot: user regulatory: Successfully approved doc '
WebUI.takeScreenshot()

//LOGOUT AS reg
'Logout as reg'
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

WebUI.waitForPageLoad(5)

//AWF: DEVFS APPROVE A DOC
functions.I.AWF_approve_byaction(findTestObject('Object Repository/HL Full Lifecycle/Function AWFAction2', [('refID') : 'source_' + 
            refID]))

WebUI.delay(1)

//REFERENCE LIST PAGE: ACTION BUTTON
'User atran: Submit to next phase'
WebUI.click(findTestObject('HL Full Lifecycle/15 RefPage_Button_Submit_AurelieTran', [('refID') : 'source_' + refID]))

WebUI.delay(1)

WebUI.click(findTestObject('HL Full Lifecycle/15 RefPage_Question_sendtodiadeis', [('refID') : 'source_' + refID]))

////////////////////////////////REFERENCE FIELDS  - ERROR MESSAGE///////////////////////////////////////////////
//*[@id="card_phase_group_7183_ModifFiche"]/div[2]/div[2]/label/img
WebUI.scrollToElement(findTestObject('Object Repository/Control Tag/3.0 codeEANCT(atran)'), 1)

'The star is displayed next to Code EAN field'
functions.I.verifystar('Code EAN', findTestObject('Object Repository/Control Tag/3.0 codeEANCT(atran)'), log)

WebUI.executeJavaScript('window.scrollTo(0, document.body.scrollHeight)', [])

//*[@id="card_phase_group_7188_ModifFiche"]/div[2]/div[1]/label/img
'The star is displayed next to Brief photogravure'
functions.I.verifystar('Brief photogravure', findTestObject('Object Repository/Control Tag/3.1 BP_CT'), log)

//*[@id="card_phase_group_7188_ModifFiche"]/div[2]/div[2]/label/img
'The star is displayed next to Number of colors Repro field'
functions.I.verifystar('Number of colors Repro', findTestObject('Object Repository/Control Tag/3.1 NoColorCT'), log)

//*[@id="card_phase_group_7188_ModifFiche"]/div[2]/div[4]/label/img
'The star is displayed next to MAD supplier'
functions.I.verifystar('MAD supplier', findTestObject('Object Repository/Control Tag/3.1 MADCT'), log)

//*[@id="card_phase_group_7188_ModifFiche"]/div[2]/div[3]/label/img
'The star is displayed next to Print type'
functions.I.verifystar('Print type', findTestObject('Object Repository/Control Tag/3.1 PrinterTypeCT'), log)

WebUI.scrollToElement(findTestObject('HL Full Lifecycle/15 RefPage_Button_Submittodiadies'), 5)

WebUI.click(findTestObject('HL Full Lifecycle/15 RefPage_Button_Submittodiadies'))

//Toastr
//*[@id="toast-container"]/div/div[2]
'Screenshot: Verification Toastr message on Reference '
WebUI.takeScreenshot()

//TOASTR SHOULD BE DISPLAYED
'Toastr is displayed'
String btoastr_P_msg = WebUI.getText(findTestObject('Object Repository/Control Tag/1.12 Toastr_name_msg_2'))

List<String> lines = new ArrayList<String>()

lines = btoastr_P_msg.split('\n')

//CHECK ALL LINE
if ((((lines.contains('Number of colors Repro is missing') && lines.contains('MAD supplier is missing')) && lines.contains(
    'Brief photogravure is missing')) && lines.contains('Code EAN is missing')) && lines.contains('Print type is missing')) {
    System.out.println('Error messages are displayed for the fields: "Number of colors Repro is missing", "MAD supplier is missing", "Brief photogravure is missing", "Code EAN is missing" & "Print type is missing" - Test OK')
} else {
    System.out.println('KO')

    log.logFailed('WARNING! The Control tag error messages are not displayed the fields: "Number of colors Repro is missing", "MAD supplier is missing", "Brief photogravure is missing", "Code EAN is missing" & "Print type is missing" - Test KO ')

    assert true
}

//CLICK CANCEL BUTTON
WebUI.click(findTestObject('Object Repository/Control Tag/3.1 cancel(atran)'))

////////////////////////////////END REFERENCE FIELDS  - ERROR MESSAGE///////////////////////////////////////////////
//REFERENCE LIST PAGE: ACTION BUTTON
'User atran: Submit to next phase'
WebUI.click(findTestObject('HL Full Lifecycle/15 RefPage_Button_Submit_AurelieTran', [('refID') : 'source_' + refID]))

WebUI.delay(1)

WebUI.click(findTestObject('HL Full Lifecycle/15 RefPage_Question_sendtodiadeis', [('refID') : 'source_' + refID]))

WebUI.delay(1)

//MODIFICATION REFERENCE PAGE
'Screenshot: Modification Ref Page '
WebUI.takeScreenshot()

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

WebUI.click(findTestObject('HL Full Lifecycle/15 RefPage_Button_Submittodiadies'))

//LOGOUT AS ATRAN (DEVFS)
'Logout as atran\r\n'
functions.I.Logout()

//LOGIN AS STUDIO - dchi
//functions.I.Login('studio', '0oeet+Yo3dw=')
'Log in as Studio \r\n'
functions.I.Login_password('studio', password_studio)

'Log as studio'
WebUI.takeScreenshot()

// CLICK ON SIDE BAR MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

WebUI.waitForElementClickable(findTestObject('Object Repository/HL Full Lifecycle/16.11 Ref_Submit Studio(studio)', [('refID') : 'source_' + 
            refID]), 10)

WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/16.11 Ref_Submit Studio(studio)', [('refID') : 'source_' + 
            refID]))

WebUI.delay(1)

//*[@id="ModifFiche"]/div[2]/div[2]/label/img
'The star is displayed next to Exe files'
functions.I.verifystar('Print type', findTestObject('Object Repository/Control Tag/1.2.1 asterix exe'), log)

//REF PAGE: CLICK SUBMIT
WebUI.click(findTestObject('HL Full Lifecycle/16 RefPg_Button_SubmitCyril'))

'Screenshot: Verification Error message on Reference '
WebUI.takeScreenshot()

//VERIFY ERROR MSG
functions.I.verifyErrormsg_EXACT('Exe files archive', findTestObject('Object Repository/Control Tag/3.3 Errormsg(studio)'), 
    'Exe files archive is missing', log)

//CLICK ON MODIFY PROJECT
WebUI.click(findTestObject('Control Tag/2.2 ButtonModifyProject'))

//UPOAD A DOC
WebUI.delay(1)

//*[@id="ModifFiche"]/div[2]/div[2]/div[2]/div/label
functions.I.UploadDoc('C:\\Users\\lamhe\\Desktop\\Upoad_File\\testdata1.pdf', findTestObject('Object Repository/HL Full Lifecycle/16.1 ref_field_studio'))

WebUI.delay(1)

'Screenshot: Upload field  '
WebUI.takeScreenshot()

//CLICK SAVE
//*[@id="type_save"]
WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/16.2 savebutton(studio)'))

//REFERENCE LIST PAGE: CLICK SUBMIT BUTTON
//*[@id="source_3135"]/td[7]/a[2]
WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/16.11 Ref_Submit Studio(studio)', [('refID') : 'source_' + 
            refID]))

//CLICK SUBMIT
//*[@id="ModifFiche"]/div[1]/div/button[2]
WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/16.3 submit(studio)'))

//LOGOUT AS studio
functions.I.Logout()

//LOGIN AS IRAZ - diadeis
//functions.I.Login('lraz', '0oeet+Yo3dw=')
'Log in as Iraz\r\n'
functions.I.Login_password('lraz', password_iraz)

'Log as Iraz\r\n'
WebUI.takeScreenshot()

// CLICK ON SIDE BAR MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//PRODUCTION PHASE: UPLOAD DOC
//CLICK ACTION BUTTON FOR PROD
WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/12 Reference_ButtonAction_Prod', [('refID') : 'source_' + 
            refID]))

//UPLOAD A DOC
'User Iraz upload doc'
functions.I.UploadDoc('C:\\Users\\lamhe\\Desktop\\Upoad_File\\testdataaddition1.pdf', findTestObject('HL Full Lifecycle/12 ReferencePage_Field_ProdUploadField'))

WebUI.delay(1)

'Upload doc'
WebUI.takeScreenshot()

//CLICK ON SUBMIT BUTTON
WebUI.click(findTestObject('HL Full Lifecycle/9.1 REfPg_Button_Upload_IR_Part 1'))

//LOGOUT AS IRAZ
'Logout as Iraz'
functions.I.Logout()

//***************LOGIN AS FS Aurelie tran
//functions.I.Login('atran', '0oeet+Yo3dw=')
functions.I.Login_password('atran', password_atran)

'Login as atran\r\n'
WebUI.takeScreenshot()

// CLICK ON SIDE BAR MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//CLICK ON  REview button
WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/14.1 RefList_Eye(Atran)', [('refID') : 'source_' + refID]))

// AWF : ATRAN APPROVES DOC
WebUI.delay(1)

'Screenshot: User atran approve doc\r\n'
WebUI.takeScreenshot()

//functions.I.AWF_approve()
functions.I.AWF_approve_view()

'Screenshot: User atran approve doc'
WebUI.takeScreenshot()

//CLICK ON ACTION BUTTON – QUESTION PHASE
WebUI.click(findTestObject('HL Full Lifecycle/17 Ref_Button_Submit_question', [('refID') : 'source_' + refID]))

'User atran question phase option'
WebUI.takeScreenshot()

//CLICK ON DDC UPDATED - OPTION
WebUI.click(findTestObject('HL Full Lifecycle/17 Ref_Options_DDCupdated', [('refID') : 'source_' + refID]))

//CLICK ON DDC UPDATED
WebUI.click(findTestObject('HL Full Lifecycle/17.1 Ref_Question_DDCUpdated'))

//CHECK FOR THE STATUS
'Verify Status: completed\r\n'
functions.I.status(findTestObject('HL Full Lifecycle/Status', [('refID') : 'source_' + refID]))

'Status: Completed\r\n'
WebUI.takeScreenshot()

WebUI.closeBrowser()

