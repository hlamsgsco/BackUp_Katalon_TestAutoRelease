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
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory


//DATA FILE : USERNAME & PASSWORD  - SEPHORA
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

String password_suser = data_Sephora.getValue(2, 10)

String password_lmorel = data_Sephora.getValue(2, 11)

String password_ageindreau = data_Sephora.getValue(2, 12)

String password_ytallant = data_Sephora.getValue(2, 13)

//DATA FILE : URL - SEPHORA
def data_urlRELAUTO = TestDataFactory.findTestData('Data Files/URL/URL_relauto')

String Url_Sephora = data_urlRELAUTO.getValue(2, 1)

/////////////////////////////////////////////////TEST START /////////////////////////////////////////
'Navigate to Sephora'
WebUI.openBrowser(Url_Sephora)

'Maximize Window'
WebUI.maximizeWindow()

'Screenshot: Login page'
WebUI.takeScreenshot()

//USER ATRAN
'Log in as Devfs  : atran/ diadeis'
functions.I.Login_password('atran', password_atran)

'Screenshot: Log as atran'
WebUI.takeScreenshot()

'Click on LHS menu'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

//CREATION OF PROJECT
'Click on + icon '
WebUI.click(findTestObject('xxx Todelete/3 ProjectListPage_Create_Project_Button'))

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

'42'
WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_Add_Marketing_button'))

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_Regulatory_field'), 'regulatory', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_Add_Regulatory_button'))

WebUI.selectOptionByValue(findTestObject('HL Full Lifecycle/5 ModifyProjPage_select_Studio_field'), 'studio', true)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_Add_Studio_button'))

WebUI.delay(8)

WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Update'))

WebUI.delay(2)

//END OF MODIFY PROJECT PAGE
// GET PROJECT NO.
String Project_No = functions.I.ProjectNo()

'Click on + button to create ref'
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPage_createrefbutton'))

WebUI.delay(2)
'Click on create button'
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPaga_Create a component_button'))

WebUI.waitForPageLoad(25)

'Select Lifecycle template  : Ticket 5399 Lifecycle'
WebUI.selectOptionByLabel(findTestObject('HL Full Lifecycle/6 ReferenceList_Choose Lifecycle'), 'Ticket 5399 Lifecycle', 
    false)

//DEFINE REFERENCE NAME
def ref_name = (org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(10) + '_') + functions.I.gettimedate()

'Enter ref name'
WebUI.setText(findTestObject('HL Full Lifecycle/6 Reference_input_Component name_field'), 'Component_' + ref_name)

'Screenshot: Create Reference Page'
WebUI.takeScreenshot()

'Select Printer - ACP SAS 49260'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_18"]']), '180', false)

'Click on create button'
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferencePg_Create a component_bluebutton'))

WebUI.delay(5)

//GET THE ID OF THE REF
String refID = functions.I.RefID()

WebUI.click(findTestObject('HL Full Lifecycle/7 ModifyRefPage_button_Save'))

'Screenshot: Modification Reference Page: Fields Filled\r\n'
WebUI.takeScreenshot()

WebUI.delay(3)

//Standard phase
'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[7]/a']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

//Question phase
'27 Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[7]/div[1]/button']))

WebUI.delay(1)

'CChoose 2nd option'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[7]/div[1]/div/a[2]']))

'Select Printer - AIRCOS'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_18"]']), '182', false)

'CChoose 2nd option'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'73'
functions.I.Logout()

//*************LOG IN ageindreau	
'Log in as ageindreau\t'
functions.I.Login_password('ageindreau', password_ageindreau)

'Log as ageindreau'
WebUI.takeScreenshot()

////*[@id="kt_header"]/div/div[2]/div[1]/div[1]
'Task no'
String t1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]']))

int a = Integer.parseInt(t1)

'Click on task'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]']))

WebUI.delay(1)

int u = 1

//TASK
'verify the projectno'
String result = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[2]']), 
        FailureHandling.OPTIONAL)

if (result.contains(Project_No)) {
    WebUI.verifyEqual(2, 1)
} else {
    WebUI.verifyEqual(1, 1)
}

functions.I.Logout()

//*************LOG IN ageindreau
'Log in as Yann Tallant\t'
functions.I.Login_password('ytallant', password_ytallant)

'Log as ytallant'
WebUI.takeScreenshot()



'Task no'
String t2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/span']))

'Click on task'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]']))

int b = Integer.parseInt(t2)

WebUI.delay(1)

int c = 1

//TASK
//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[2]/a[1]
////*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[2]/a[2]
'verify the projectno'
while (c <= b) {
	//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[2]/a[2]/div[2]/span[1]
	//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[2]/a[3]/div[2]/span[1]
   String result1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[2]/a['+c+']/div[2]/span[1]')]))
//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[2]/a[3]
    if (result1.contains('ProjectNo. '+Project_No+' /RefID. '+ refID)) {
        WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[2]/a['+c+']')]))

        break
    } else {
        c = (c + 1)
		
		if(c>b)
		{break}
    }
}

//Standard phase
'95 Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[7]/a']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

int r = 1

while (r <= b) {
    result1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[2]/a[' + 
                r) + ']']))

    if (result1.contains('ProjectNo. '+Project_No+' /RefID. '+ refID)) {
        WebUI.verifyEqual(1, 2)

        break
    } else {
        r = (r + 1)

        if (r == b) {
            WebUI.verifyEqual(1, 1)

            break
        }
    }
}


functions.I.Logout()

//*************LOG IN ageindreau
'Log in as suser'
functions.I.Login_password('suser', password_suser)

'Log in'
WebUI.takeScreenshot()


'LHS click the project tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="menu_2"]/a']))

'Search project no'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[10]/button')

WebUI.delay(1)

'Screenshot: ref List page '
WebUI.takeScreenshot()

'Click on ...'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID+'"]/td[14]/div/button']))
 
WebUI.delay(1)

'Click on delete'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID+'"]/td[14]/div/div/a[3]']))
WebUI.delay(1)

'Click on ok'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/div[9]/div/div/div[2]/button[2]']))
 
'Click on close this project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_project"]/div[2]/div/div[3]/a[4]']))
 

WebUI.closeBrowser()
