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

WebUI.openBrowser('')

WebUI.navigateToUrl('http://mdb-release.diadeis.lan/Mediabox-independence/?MBI_datasource=REL_SEPHORA')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('HL Full Lifecycle/1 LoginPage_input_Login_field'), 'hgarnier')

WebUI.setEncryptedText(findTestObject('HL Full Lifecycle/1 LoginPage_input_Password_Field'), 'wOxEJATfpk0=')

WebUI.click(findTestObject('HL Full Lifecycle/1 LoginPage_login_button'))

WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

WebUI.click(findTestObject('xxx Todelete/3 ProjectListPage_Create_Project_Button'))

WebUI.waitForPageLoad(0)

def project_name = 'Test_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(10)

WebUI.setText(findTestObject('HL Full Lifecycle/4 CreateProjPage_input_Project name_field'), project_name)

WebUI.click(findTestObject('HL Full Lifecycle/4 CreateProjPage_Create Project_Bluebutton'))

WebUI.setText(findTestObject('HL Full Lifecycle/5 ModifyProjPage_input_code_project_field'), '12345')

WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/5 ModifyProjPage_dropdown_category_field'), 'Hair', true)

WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/5 ModifyProjPage_dropdown_segment_field'), 'BATH BODY', true)

WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/5 ModifyProjPage_dropdown_type_field'), 'One Shot', true)

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_Scope_field'), '20', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Add_Scope_field'))

WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/5 ModifyProjPage_dropdown_MAD_field'), 'Christmas', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_date_select2-var_35-container_field'))

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_dropdown_year_field'), '119', true)

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_DevPack_field'), 'devpack', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Add_DevPack_field'))

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_DevFS_field'), 'devfs', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_Add_DevFS_button'))

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_Marketing_field'), 'marketing', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_Add_Marketing_button'))

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_Regulatory_field'), 'regulatory', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_Add_Regulatory_button'))

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_Studio_field'), 'studio', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_Add_Studio_button'))

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Update'))

WebUI.waitForPageLoad(30)

WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPage_createrefbutton'))

WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPaga_Create a component_button'))

WebUI.waitForPageLoad(25)

WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/6 ReferenceList_Choose Lifecycle'), 'FS process', false)

def ref_name = org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(10)

WebUI.setText(findTestObject('HL Full Lifecycle/6 Reference_input_Component name_field'), 'Component_' + ref_name)

WebUI.click(findTestObject('HL Full Lifecycle/6 ReferencePg_Create a component_bluebutton'))

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

WebUI.click(findTestObject('HL Full Lifecycle/7 ModifyRefPage_button_Save'))

WebUI.waitForPageLoad(25)

WebUI.click(findTestObject('HL Full Lifecycle/8 ReferencePage_ActionButton'))

WebUI.click(findTestObject('HL Full Lifecycle/8 ReferencePage_button_Send to Marketing'))

WebUI.click(findTestObject('HL Full Lifecycle/z LogoutPage_img_d_avatar-circle-small'))

WebUI.click(findTestObject('Object Repository/Logout_Link'))

WebUI.waitForPageLoad(15)

WebUI.setText(findTestObject('xxx Todelete/input_Login_MDB_WebUserCode'), 'marketing')

WebUI.setEncryptedText(findTestObject('Object Repository/input_Password_MDB_WebUserPwd'), '0oeet+Yo3dw=')

WebUI.click(findTestObject('xxx Todelete/button_Login'))

WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

WebUI.click(project_name)

WebUI.waitForPageLoad(0)

WebUI.click(findTestObject('HL Full Lifecycle/9 RefPage_i_B_fa fa-arrow-circle-right_1'))

WebUI.click(findTestObject('HL Full Lifecycle/9 RefPage_button_Send to Regulatory'))

WebUI.click(findTestObject('HL Full Lifecycle/z LogoutPage_img_d_avatar-circle-small'))

WebUI.click(findTestObject('Object Repository/a_Logout_1'))

WebUI.setText(findTestObject('xxx Todelete/input_Login_MDB_WebUserCode'), 'regulatory')

WebUI.setEncryptedText(findTestObject('Object Repository/input_Password_MDB_WebUserPwd'), '0oeet+Yo3dw=')

WebUI.click(findTestObject('xxx Todelete/button_Login'))

WebUI.waitForPageLoad(0)

WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

WebUI.click(findTestObject('Object Repository/a_Test_aTMfbjo5UN_1'))

WebUI.waitForPageLoad(0)

WebUI.click(findTestObject('HL Full Lifecycle/10 ReferencePAge_i_B_fa fa-random'))

WebUI.click(findTestObject('HL Full Lifecycle/10 ReferencePage a_Send to studio'))

WebUI.waitForPageLoad(0)

WebUI.click(findTestObject('HL Full Lifecycle/10.2 ReferencPAge_button_Send to studio'))

WebUI.click(findTestObject('HL Full Lifecycle/z LogoutPage_img_d_avatar-circle-small'))

WebUI.click(findTestObject('Object Repository/Logout_Link'))

WebUI.setText(findTestObject('xxx Todelete/input_Login_MDB_WebUserCode'), 'studio')

WebUI.setEncryptedText(findTestObject('Object Repository/input_Password_MDB_WebUserPwd'), '0oeet+Yo3dw=')

WebUI.click(findTestObject('xxx Todelete/button_Login'))

WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

WebUI.click(findTestObject('xxx Todelete/a_Test_aTMfbjo5UN_1_2'))

WebUI.click(findTestObject('HL Full Lifecycle/10 ReferencePAge_i_B_fa fa-random'))

WebUI.click(findTestObject('HL Full Lifecycle/11 ReferencePage_Question_a_Accept the brief'))

WebUI.click(findTestObject('HL Full Lifecycle/11 ReferencePAge_List_S2-var_133-container'))

WebUI.click(findTestObject('null'))

