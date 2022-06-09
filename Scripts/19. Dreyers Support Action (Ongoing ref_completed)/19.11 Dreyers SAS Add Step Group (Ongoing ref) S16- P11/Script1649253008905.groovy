import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.google.common.base.Functions as Functions
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

/* Powerpoint S16: ADD STEP GROUP(contains more than one step)
 If ongoing reference (no last phase last step )
 Add step group (same step group as the current one)
 
 Result: step group is added in the different steps after from where the support action was executed
 
 SAS: S15 - Add Step Group A & C
  */

///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//USERNAME & PASSWORD  - Dreyers
def data_Dreyers = TestDataFactory.findTestData('Data Files/Username_Password/Dreyer')

String password_suser = data_Dreyers.getValue(2, 1) //R
String password_blemco = data_Dreyers.getValue(2, 2) //R
String password_nturner = data_Dreyers.getValue(2, 6) //R
String password_lmary = data_Dreyers.getValue(2, 13) //R

//URL
def data_urlRELAUTO = TestDataFactory.findTestData('Data Files/URL/URL_relauto')

String Url_Dreyer = data_urlRELAUTO.getValue(2, 4)


//READ NOTEPAD FROM TC 19.01
String Project_No = functions.I.readnotepad('D:\\Upoad_File\\Projet_ Login\\Dreyers\\19.1\\19.1_Dreyers_ProjectNo.txt')

String refID = functions.I.readnotepad('D:\\Upoad_File\\Projet_ Login\\Dreyers\\19.1\\19.1_Dreyers_refID.txt')

//String refID11 = '3717'

///////////////////////////// TEST BEGIN /////////////////////////////////////////

'Navigate to URL Dreyers Release'
WebUI.openBrowser(Url_Dreyer)
WebUI.maximizeWindow()

'Log in as suser'
functions.I.Login_password('suser', password_suser)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot: suser Ref list page'
WebUI.takeScreenshot()

//CREATE A NEW REF
'Click on + to create ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

WebUI.delay(1)

'Click start a design phase button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a']))

WebUI.delay(1)

'Select Lifecycle'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="lfc_tpl"]']), '36', false)

'settext Deliverable name'
def ref_name = ('P11_Auto_SAS_S16_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(5)) + functions.I.gettimedate()

WebUI.delay(1)

WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_name"]']), ref_name)

'Screenshot: create ref page'
WebUI.takeScreenshot()

'Click on Create a deliverable button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="createRefBottom"]']))

WebUI.delay(1)

'Screenshot: Ref Form page'
WebUI.takeScreenshot()

'get refiD '
String refID11 = functions.I.RefID()

'Click on save'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="type_save"]']))

//PHASE 1.1
'Screenshot: Ref List page'
WebUI.takeScreenshot()

WebUI.delay(1)

functions.I.SearchRefNo_xpath('P11_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID11+'"]/td[14]/a[3]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

//PHASE 1.2
'Screenshot: Ref List page'
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID11+'"]/td[14]/a[3]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

//PHASE 2.1
'Screenshot: Ref List page'
WebUI.takeScreenshot()

WebUI.delay(1)

//CLICK ACTION BUTTON FOR PROD
' Upload  file for Production Phase '
String color1 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' +
			refID11) + '"]/td[14]/a[2]']), 'color', FailureHandling.OPTIONAL)

while (color1 == 'rgba(255, 255, 255, 1)') {
	WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' +
				refID11) + '"]/td[14]/a[2]']))

	//UPLOAD A DOC - PDF
	functions.I.UploadDoc_sendkey_Prod(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/input[2]']),
		'D:\\Upoad_File\\Upload doc\\testdata1.pdf', 'testdata1')

	'Screenshot: Production phase Field Upload doc'
	WebUI.takeScreenshot()

	WebUI.delay(8)

	//REF PAGE: CLICK ON PROCEED TO NEXT PHASE
	WebUI.click(findTestObject('HL Full Lifecycle/12 ReferncePage_Button_Updatensenddoc'))

	WebUI.delay(4)

	color1 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' +
				refID11) + '"]/td[14]/a[2]']), 'color', FailureHandling.OPTIONAL)
}

'Screenshot: Ref List page'
WebUI.takeScreenshot()

'Click on the ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID11+'"]/td[6]/a']))
 
 'Screenshot:Ref'
WebUI.takeScreenshot()

WebUI.delay(1)

'Approve for others'
functions.I.Approveforothers('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[2]/div/div[3]/div/div[2]/div[1]/div/div[2]/div/div[2]/div[2]/div/div/div[1]/img','/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[2]/div/div[3]/div/div[2]/div[1]/div/div[2]/div/div[2]/div[2]/div/div/div[6]/a[2]/span')

WebUI.delay(1)

'Go back to reflist page'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))

WebUI.delay(1)


// Phase 3.1
'Question: Submit phase'
functions.I.submitquesiton_ref(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID11+'"]/td[14]/div[1]/button']), findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID11+'"]/td[14]/div[1]/div/a[1]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

// Phase 3.2
'Screenshot:Ref'
WebUI.takeScreenshot()

'Question: Submit phase'
functions.I.submitquesiton_ref(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID11+'"]/td[14]/div[1]/button']), findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID11+'"]/td[14]/div[1]/div/a[1]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

// PHASE 3.3
'Screenshot:Ref'
WebUI.takeScreenshot()

'Click on submit'
///*[@id="source_3667"]/td[14]/a[3]
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID11+ '"]/td[14]/a[3]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'Click on the ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID11) + '"]/td[6]/a']))

'Click Lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

'Screenshot:Lifecycle tab'
WebUI.takeScreenshot()

'Click on the SAS button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[3]/div/div[4]/div/div[1]/div[2]/div/button']))

WebUI.delay(1)

'Screenshot: SAS option'
WebUI.takeScreenshot()

WebUI.delay(1)
//CLCICK ON THE SAS WITH THE LABEL
'no of option present '
int x = 10
int i = 1

while ( i <=x)
{
	String Expected_SAS_Selected = 'SAS: S15 - Add Step Group A & C'
	String xpath_SAS ='/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[3]/div/div[4]/div/div[1]/div[2]/div/div/a['+i+']'
	
	
	String Actual_SAS = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : xpath_SAS]))
	functions.I.print(i)
	
	if (Actual_SAS.contains(Expected_SAS_Selected))
	{
		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : xpath_SAS]))
		
		break
		}
		i =i+1
	}
/*
'Choose the 4th option-   S15 - Add Step Group A & C'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[3]/div/div[4]/div/div[1]/div[2]/div/div/a[3]']))
*/
'Screenshot: SAS popup'
WebUI.takeScreenshot()

'click on ok'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="confirmSupportActionShortcut"]']))

'Screenshot: SAS option'
WebUI.takeScreenshot()

'Click Lifecycle tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[3]/a']))

'Screenshot: Lifecycle tab page'
WebUI.takeScreenshot()

//PHASE 3.5
 //SAS SUPPORT ACTION S15
'Screenshot:Ref'
WebUI.takeScreenshot()

//1st STEP C - Phase 3.5 IS ACTIVE
'Verify that attribute of step C - active'
String StepC_1 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[3]/a']),
	'class')

WebUI.verifyMatch(StepC_1, 'nav-link timeline-badge badge-xl  bg-pending active', false)

String StepC_11 = functions.I.Get_Stepname('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[3]/a')

WebUI.verifyMatch(StepC_11, 'SASStepC', false)

//PHASE 3.4 IS STILL ACTIVE
String Started_StepCP4_1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[3]/div/div[4]/div/div[2]/div[1]']))

if (Started_StepCP4_1.contains('Started')) {
	WebUI.verifyEqual(1, 1)
} else {
	WebUI.verifyEqual(1, 2)
}

//VERIFY THAT THERE IS NO PHASE AFTER
'Verify that there is no phase after 3.5'
WebUI.verifyElementNotPresent(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/div/div[3]/div/div[6]']),
	10)

// 2nd STEP A -
String StepA_2 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[4]/a']),
	'class')

WebUI.verifyMatch(StepA_2, 'nav-link timeline-badge badge-xl  bg-waiting ', false)

String StepA_22 = functions.I.Get_Stepname('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[4]/a')

WebUI.verifyMatch(StepA_22, 'SASStepA', false)

// 3rd STEP C -
String StepC_3 = WebUI.getAttribute(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[5]/a']),
	'class')

WebUI.verifyMatch(StepC_3, 'nav-link timeline-badge badge-xl  bg-waiting ', false)

String StepC_33 = functions.I.Get_Stepname('/html/body/div[1]/div[2]/div[8]/div[3]/div/div[3]/div[3]/div/ul/li[5]/a')

WebUI.verifyMatch(StepC_33, 'SASStepC', false)

'Go the ref list page'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[8]/div[2]/div/nav/ol/li[2]/a']))

functions.I.Logout()

'Login as nturner '
functions.I.Login_password('nturner', password_nturner)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot: nturner Ref list page'
WebUI.takeScreenshot()

'Search for ref '
functions.I.SearchRefNo_xpath('P11_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

WebUI.delay(1)


//Phase Step C - Phase  3.4
'Verify lifecycle status'
String Lifecycle_Status1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_' + refID11 +'"]/td[12]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status1, 'Phase 3.4 [Standard]', false)

'click on Submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID11+'"]/td[13]/a[2]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

//Phase Step C - Phase  3.5
'Verify lifecycle status'
String Lifecycle_Status2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_' + refID11 +'"]/td[12]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status2, 'Phase 3.5[Prod]', false)

functions.I.Logout()

'Login as lmary'
functions.I.Login_password('lmary', password_lmary)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot: lmry -Ref list page'
WebUI.takeScreenshot()

'Search for ref '
functions.I.SearchRefNo_xpath('P11_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Screenshot:Ref'
WebUI.takeScreenshot()

//CLICK ACTION BUTTON FOR PROD
' Upload  file for Production Phase '
String color3 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID11) +
			'"]/td[13]/a']), 'color', FailureHandling.OPTIONAL)

while (color3 == 'rgba(255, 255, 255, 1)') {
	WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID11) + '"]/td[13]/a']))

	'SELECT APPROVAL WORKFLOW'
	WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="id_approval_flow_tpl"]']),
		'80', false)

	//UPLOAD A DOC - PDF
	functions.I.UploadDoc_sendkey_Prod(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/input[2]']),
		'D:\\Upoad_File\\Upload doc\\testdata1.jpg', 'testdata1')

	'Screenshot: Production phase Field Upload doc'
	WebUI.takeScreenshot()

	WebUI.delay(10)

	//REF PAGE: CLICK ON PROCEED TO NEXT PHASE
	WebUI.click(findTestObject('HL Full Lifecycle/12 ReferncePage_Button_Updatensenddoc'))

	WebUI.delay(5)

	color3 = WebUI.getCSSValue(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID11) + '"]/td[13]/a']),
		'color', FailureHandling.OPTIONAL)
}

'Logout'
functions.I.Logout()


'Login as blemco '
functions.I.Login_password('blemco', password_blemco)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot: blemco Ref list page'
WebUI.takeScreenshot()

'Search for ref '
functions.I.SearchRefNo_xpath('P11_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Approve a doc'
functions.I.AWF_approve_byaction(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID11) +
			'"]/td[13]/a[2]']))

//ADDED PHASE 1.1
'Verify lifecycle status'
String Lifecycle_Status3 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID11) +
			'"]/td[12]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status3, 'Phase 1.1 [Standard]', false)

functions.I.Logout()

'Login as nturner '
functions.I.Login_password('nturner', password_nturner)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'Search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot: nturner Ref list page'
WebUI.takeScreenshot()

'Search for ref '
functions.I.SearchRefNo_xpath('P11_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

WebUI.delay(1)

//Added Phase Step A - Phase  1.1
'Verify lifecycle status'
String Lifecycle_Status4 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID11) +
			'"]/td[12]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status4, 'Phase 1.1 [Standard]', false)


functions.I.Logout()

'Log in as blemco'
functions.I.Login_password('blemco', password_blemco)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot: blemco Ref list page'
WebUI.takeScreenshot()

'Search for ref '
functions.I.SearchRefNo_xpath('P11_Auto', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

'Screenshot: Ref list page'
WebUI.takeScreenshot()

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_' + refID11 + '"]/td[13]/a[3]']))

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

//Added Phase Step A - Phase  1.2
'Verify lifecycle status'
String Lifecycle_Status5 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_' + refID11 +
			'"]/td[12]/span[1]']))

WebUI.verifyMatch(Lifecycle_Status5, 'Phase 1.2 [Standard Phase]', false)

WebUI.closeBrowser()

