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
/*
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Sephora Release >  http://mdb-release.diadeis.lan/Mediabox-independence/?MBI_datasource=REL_SEPHORA'
WebUI.openBrowser('http://mdb-release.diadeis.lan/Mediabox-independence/?MBI_datasource=REL_SEPHORA')

WebUI.maximizeWindow()

WebUI.takeScreenshot()

//LOG IN AS ATRAN ~ DIADEIS
// username = atran / password = diadies
'Log in as Devfs  : atran/ diadeis'
functions.I.Login('atran', '0oeet+Yo3dw=')

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
def project_name = (('Test_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(10)) + '_') + functions.I.gettimedate()

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

//dropdown category
functions.I.Firefox_List(findTestObject('HL Full Lifecycle/Firefox1.1 dropdownCategory'))

functions.I.Firefox_List(findTestObject('Object Repository/HL Full Lifecycle/Firefox1.2 dropdownsegment'))

functions.I.Firefox_List(findTestObject('Object Repository/HL Full Lifecycle/Firefox1.3 dropdowntype'))




WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_Scope_field'), '20', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Add_Scope_field'))

functions.I.Firefox_List(findTestObject('Object Repository/HL Full Lifecycle/Firefox1.4 dropdownMAD'))

functions.I.Firefox_List(findTestObject('Object Repository/HL Full Lifecycle/Firefox1.5 dropdownYear'))


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

WebUI.waitForPageLoad(25)*/

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

WebUI.click(findTestObject('HL Full Lifecycle/7 ModifyRefPage_inputgr_field'))

WebUI.click(findTestObject('HL Full Lifecycle/7 ModifyRefPage_td_25'))

WebUI.click(findTestObject('HL Full Lifecycle/7 ModifyRefPage_la-calendar_field'))

WebUI.click(findTestObject('HL Full Lifecycle/7 ModifyRefPage_td_26'))

'Pack type'
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/7 ModifyRefPage_Select_Pack_Type'), 'Primaire', false)

'Component type'
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/7 ModifyRefPage_Select_Component_Type'), 'Etui', false)

WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/7 ModifyRefPage_Select_printer'), 'AIRCOS', false)

WebUI.scrollToElement(findTestObject('HL Full Lifecycle/7 ModifyRefPage_button_Save'), 10)

WebUI.click(findTestObject('HL Full Lifecycle/7 ModifyRefPage_button_Save'))

'Screenshot: Modification Reference Page: Fields Filled\r\n'
WebUI.takeScreenshot()

WebUI.waitForPageLoad(25)

// END OF MODIFICATION OF REFERENCE FORM
//REFERENCE LIST PAGE: CLICK ON PROCCEED TO NEXT PHASE BUTTON
'User atran: Proceed to next Phase\r\n'
WebUI.click(findTestObject('HL Full Lifecycle/8 ReferencePage_ActionButton', [('refID') : 'source_' + refID]))

//REFERENCE PAGE: CLICK ON PROCCEED TO NEXT PHASE BUTTON
'User atran: Click on send to marketing button\r\n'
WebUI.click(findTestObject('HL Full Lifecycle/8 ReferencePage_button_Send to Marketing'))

// LOGOUT AS ATRAN
'Logout as atran\r\n'
functions.I.Logout()

//*************LOG IN AS MARKETING 
'Log in as marketing\r\n'
functions.I.Login('marketing', '0oeet+Yo3dw=')

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
'Log in as regulatory\r\n'
functions.I.Login('regulatory', '0oeet+Yo3dw=')

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

//********************LOGIN AS STUDIO
'Login as studio\r\n'
functions.I.Login('studio', '0oeet+Yo3dw=')

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
WebUI.click(findTestObject('HL Full Lifecycle/12 Reference_ButtonAction_Prod', [('refID') : 'source_' + refID]))

//UPLOAD A DOC
functions.I.UploadDoc('C:\\Users\\lamhe\\Desktop\\Upoad_File\\testdata1.pdf', findTestObject('HL Full Lifecycle/12 ReferencePage_Field_ProdUploadField'))

'Screenshot: Field Upload doc'
WebUI.takeScreenshot()

//REF PAGE: CLICK ON PROCEED TO NEXT PHASE
WebUI.click(findTestObject('HL Full Lifecycle/12 ReferncePage_Button_Updatensenddoc'))

WebUI.delay(2)

// LOGOUT AS STUDIO
functions.I.Logout()

//LOGIN AS MArketing
'Log in as marketing'
functions.I.Login('marketing', '0oeet+Yo3dw=')

'Log as marketing'
WebUI.takeScreenshot()

// CLICK ON SIDE BAR MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//CLICK ON REF LINK
//WebUI.waitForElementClickable(findTestObject('HL Full Lifecycle/10.11 REfPg_RefLink', [('refID') : 'source_' +    refID]), 10)
//WebUI.click(findTestObject('HL Full Lifecycle/10.11 REfPg_RefLink', [('refID') : 'source_' + refID]))
//WebUI.waitForPageLoad(10)
//AWF: DEVFS APPROVE A DOC
//functions.I.AWF_approve()
functions.I.AWF_approve_byaction(findTestObject('HL Full Lifecycle/Function_AWFbyactionbutton', [('refID') : 'source_' + 
            refID]))

//WebUI.click(findTestObject('HL Full Lifecycle/Function_AWFbyactionbutton',  [('refID') : 'source_' +  refID]))
//WebUI.waitForElementClickable(findTestObject('Object Repository/HL Full Lifecycle/Function_hoverimage'),5)
//WebUI.click(findTestObject('Object Repository/HL Full Lifecycle/Function_Access to viewer'))
///WebUI.delay(1)
//WebUI.click(findTestObject('HL Full Lifecycle/Function_AppButton'))
//WebUI.delay(1)
//WebUI.click(findTestObject('HL Full Lifecycle/Function_Appbutton2'))
//WebUI.delay(1)
// LOGOUT AS MARKETNG
functions.I.Logout()

//********************LOGIN AS REgulatory
functions.I.Login('regulatory', '0oeet+Yo3dw=')

// CLICK ON SIDE BAR MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//CLICK ON REF LINK
//WebUI.waitForElementClickable(findTestObject('HL Full Lifecycle/10.12 RefPage_REflink', [('refID') : 'source_' +  refID]), 10)
//WebUI.click(findTestObject('HL Full Lifecycle/10.12 RefPage_REflink', [('refID') : 'source_' + refID]))
WebUI.waitForPageLoad(10)

//AWF: DEVFS APPROVE A DOC
//functions.I.AWF_approve()
'User marketing: Click on view doc'
functions.I.AWF_approve_byaction(findTestObject('HL Full Lifecycle/Function_AWFbyactionbutton', [('refID') : 'source_' + 
            refID]))

WebUI.takeScreenshot()

//LOGOUT AS REGULATORY
'Logout as marketing'
functions.I.Logout()

//********************LOGIN AS FS atran
'Login as atran'
functions.I.Login('atran', '0oeet+Yo3dw=')

'Login as atran'
WebUI.takeScreenshot()

// CLICK ON SIDE BAR MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//CLICK ON REF LINK
//WebUI.waitForElementClickable(findTestObject('HL Full Lifecycle/10.13 RefPg_RefLink', [('refID') : 'source_' +     refID]), 10)
//WebUI.click(findTestObject('HL Full Lifecycle/10.13 RefPg_RefLink', [('refID') : 'source_' + refID]))
WebUI.waitForPageLoad(5)

//AWF: DEVFS APPROVE A DOC
//functions.I.AWF_approve()
functions.I.AWF_approve_byaction(findTestObject('Object Repository/HL Full Lifecycle/Function AWFAction2', [('refID') : 'source_' + 
            refID]))

WebUI.delay(1)

//REFERENCE LIST PAGE: ACTION BUTTON
'User atran: Submit to next phase'
WebUI.click(findTestObject('HL Full Lifecycle/15 RefPage_Button_Submit_AurelieTran'))

WebUI.delay(1)

//MODIFICATION REFERENCE PAGE
WebUI.click(findTestObject('HL Full Lifecycle/15 RefPage_Question_sendtodiadeis'))

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

//LOGIN AS CYRIL
'Log in as Cyril\r\n'
functions.I.Login('cmouzawak', '0oeet+Yo3dw=')

'Log as Cyril'
WebUI.takeScreenshot()

//CLICK ON SIDE BAR MENU: PROJET(FR)
WebUI.waitForElementClickable(findTestObject('HL Full Lifecycle/2 LHSMenu_Projet(FR)'), 10)

WebUI.click(findTestObject('HL Full Lifecycle/2 LHSMenu_Projet(FR)'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/2 Filter_ Button_FR_Apply'))

//REFERENCE LIST PAGE: CLICK SUBMIT BUTTON
WebUI.waitForElementClickable(findTestObject('HL Full Lifecycle/16 RefListPg_Button_Submit_Cyril'), 10)

WebUI.click(findTestObject('HL Full Lifecycle/16 RefListPg_Button_Submit_Cyril'))

//UPOAD A DOC
'User Cyril: Upload adoc'
functions.I.UploadDoc('C:\\Users\\lamhe\\Desktop\\Upoad_File\\testdata1.pdf', findTestObject('HL Full Lifecycle/16 ref_Field_UploadDoc_Cyril'))

//REF PAGE: CLICK SUBMIT
WebUI.click(findTestObject('HL Full Lifecycle/16 RefPg_Button_SubmitCyril'))

'Screenshot: Upload doc'
WebUI.takeScreenshot()

//LOGOUT AS CYRIL
'Logout as Cyril'
functions.I.Logout()

//LOGIN AS IRAZ
'Log in as Iraz\r\n'
functions.I.Login('lraz', '0oeet+Yo3dw=')

'Log as Iraz\r\n'
WebUI.takeScreenshot()

// CLICK ON SIDE BAR MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//CLICK ACTION BUTTON FOR PROD
WebUI.click(findTestObject('HL Full Lifecycle/9 _RefPg_Button_Upload_IR'))

//UPLOAD A DOC
'User Iraz upload doc'
functions.I.UploadDoc('C:\\Users\\lamhe\\Desktop\\Upoad_File\\testdataaddition1.pdf', findTestObject('HL Full Lifecycle/12 ReferencePage_Field_ProdUploadField'))

'Upload doc'
WebUI.takeScreenshot()

//CLICK ON SUBMIT BUTTON
WebUI.click(findTestObject('HL Full Lifecycle/9.1 REfPg_Button_Upload_IR_Part 1'))

//LOGOUT AS IRAZ
'Logout as Iraz'
functions.I.Logout()

//***************LOGIN AS FS Aurelie tran
'Login as atran'
functions.I.Login('atran', '0oeet+Yo3dw=')

'Login as atran\r\n'
WebUI.takeScreenshot()

// CLICK ON SIDE BAR MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//CLICK ON REFERENCE LINK
WebUI.click(findTestObject('HL Full Lifecycle/14 RefListPg_Reflink2'))

// AWF : ATRAN APPROVES DOC
'User atran approve doc\r\n'
functions.I.AWF_approve()

'User atran approve doc'
WebUI.takeScreenshot()

//CLICK ON ACTION BUTTON – QUESTION PHASE
WebUI.click(findTestObject('HL Full Lifecycle/17 Ref_Button_Submit_question'))

//CLICK ON DDC UPDATED - OPTION
WebUI.click(findTestObject('HL Full Lifecycle/17 Ref_Options_DDCupdated'))

//CLICK ON DDC UPDATED
WebUI.click(findTestObject('HL Full Lifecycle/17.1 Ref_Question_DDCUpdated'))

//CHECK FOR THE STATUS
'Verify Status: completed\r\n'
functions.I.status(findTestObject('HL Full Lifecycle/Status', [('refID') : 'source_' + refID]))

'Status: Completed\r\n'
WebUI.takeScreenshot()

WebUI.closeBrowser()

