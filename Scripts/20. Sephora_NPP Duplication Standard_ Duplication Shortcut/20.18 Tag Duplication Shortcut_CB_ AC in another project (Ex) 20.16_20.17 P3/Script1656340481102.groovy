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

//DATA FIELD USERNAME_PASSWORD (TAG)
def data_Tag = TestDataFactory.findTestData('Data Files/Username_Password/Tag')

String password_jedun = data_Tag.getValue(3, 1)

String password_suser = data_Tag.getValue(3, 21)

String password_aamiot = data_Tag.getValue(3, 29)

String password_daguirre = data_Tag.getValue(3, 30)

String password_aomoto = data_Tag.getValue(3, 31)

String password_apetit = data_Tag.getValue(3, 32)

//DATA FIELD URL
def data_urlRELAUTO = TestDataFactory.findTestData('Data Files/URL/URL_relauto')

String Url_Tag = data_urlRELAUTO.getValue(2, 3)

////cLear notepad
String Project_No = functions.I.readnotepad('D:\\Upoad_File\\Projet_ Login\\Tag\\20.16 Tag _Project_No\\20.16_Tag_ProjectNo.txt')

String refID1 = functions.I.readnotepad('D:\\Upoad_File\\Projet_ Login\\Tag\\20.16 Tag _Project_No\\20.16_Tag_refID1.txt')

String refID2 = functions.I.readnotepad('D:\\Upoad_File\\Projet_ Login\\Tag\\20.16 Tag _Project_No\\20.16_Tag_refID2.txt')

String DuplirefID1 = functions.I.readnotepad('D:\\Upoad_File\\Projet_ Login\\Tag\\20.16 Tag _Project_No\\20.16_Tagdupli_refID1.txt')

String DuplirefID2 = functions.I.readnotepad('D:\\Upoad_File\\Projet_ Login\\Tag\\20.16 Tag _Project_No\\20.16_Tagdupli_refID2.txt')

String Projno = 'MI003397'
String rf1 = '24387'
String rf2 = '24389'

///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag Release'
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

'Screenshot: Navigate to URL Tag Release'
WebUI.takeScreenshot()

// C&A
'Login as C&A - apetit '
functions.I.Login_password('aomoto', password_aomoto)


'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))


'Search project no'
functions.I.SearchProjectNo_xpath( Projno , '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[8]/button')

WebUI.delay(1)


'Click on the duplicate button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/div[1]/button']))

'Screenshot: ref List page '
WebUI.takeScreenshot()

WebUI.delay(1)

//SELECT DUPLI
'Select dupli option Duplicate CB + AC in another project'
String dupli_option1 = 'Duplicate CB + AC in another project'

int x = 1
while (x <= 4) {
	String dupli_name = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[1]/div[2]/span/div[1]/div/a[' +
				x) + ']']))

	if (dupli_name.contains(dupli_option1)) {
		WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[1]/div[2]/span/div[1]/div/a[' +
					x) + ']']))

		break
	}
	
	x = (x + 1)
}

WebUI.delay(1)

'Select mother ref + daughter'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_24387"]/td[1]/label']))
 

'Select daughter ref '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_24389"]/td[1]/label']))

WebUI.delay(1)

'Screenshot: Ref modif page '
WebUI.takeScreenshot()

'Click on confirm  '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnduplicatereference"]']))

WebUI.delay(1)

'Screenshot: Dupli popup'
WebUI.takeScreenshot()

WebUI.delay(1)


'Verify that the only button is In existing project'
functions.I.VerifyMatchText('//*[@id="list_project_type"]/label[1]', 'In existing project')

'Verify that the only button is in this project'
functions.I.VerifyMatchText('//*[@id="list_project_type"]/label[2]', 'In a new project')


//SElect PROJECT NO .
'Click the field Project name'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="is_old_project"]/div/span']))

WebUI.delay(1)

'Enter Project No: MI003407'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/span/span/span[1]/input']), Project_No)

WebUI.delay(1)

'Click the field Project name'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="select2-nbProject-results"]/li']))

WebUI.delay(1)

//MOTHER REF
int u = 1

while (u <= 2) {
	String ref_template1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('/html/body/div[1]/div[2]/div[5]/form/div/div/div/div[2]/div/div[10]/div[2]/div/div[' +
				u) + ']/div/span']))

	if (ref_template1 == 'Multiple artworks with a master design') {
		'Verify that ref template = Marketing project is selected'
		functions.I.VerifyMatchText('//*[@id="select2-ref_tpl5-container"]', 'Multiple artworks with a master design')

		'Verify that lifecycle template = 0 - Common Brief with Master Design'
		functions.I.VerifyMatchText('//*[@id="select2-lfc_tpl5-container"]', '0 - Common Brief with Master Design')

		u = (u + 1) 
		
		
		//DAUGHTER REF
	} else {
		'Verify that ref template = Artwork Brief (AC) is selected'
		functions.I.VerifyMatchText('//*[@id="select2-ref_tpl7-container"]', 'Artwork Brief (AC)')

		'Verify that lifecycle template = Marketing project is selected'
		functions.I.VerifyMatchText('//*[@id="select2-lfc_tpl7-container"]', 'C - Create an Artwork - Repro document (by repro agency)')

		u = (u + 1)
	}
}

//Name of the Duplicate button
'Verify that name of the duplication'
functions.I.VerifyMatchText('//*[@id="btn_submit_duplication"]', 'Duplicate CB + AC in another project')

'Click Duplicate'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_submit_duplication"]']))

//USER IS REDIRECTED TO THE DUPLICATED PROJECT
WebUI.delay(2)



//USER IS REDIRECTED TO THE DUPLICATED PROJECT
WebUI.delay(2)

'Get the project no.'
String Project_Nod = functions.I.ProjectNo()

WebUI.verifyMatch(Project_Nod, Project_No, false)

'Verify no of ref in the project'
functions.I.VerifyMatchText('//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[1]/h1/span', '8')


///*[@id="form_filters"]/div[3]/button
//Name of ref & GET REF id
'search ref'
functions.I.SearchRefNo_xpath('Copy 1 of SAS', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

String refID_Mother_Dupli1 = functions.I.href_RefID_Tag('/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[8]/a[1]')

String refID_daughter_Dupli1 = functions.I.href_RefID_Tag('/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[8]/a')

//MOTHER REF
'Click on the mother ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_' + refID_Mother_Dupli1 + '"]/td[8]/a[1]']))

WebUI.delay(1)

'Screenshot: Duplicated mother '
WebUI.takeScreenshot()

WebUI.delay(1)


'Click on  parent link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_view_ref_parent"]']))

WebUI.delay(1)

'Screenshot: Parent mother ref '
WebUI.takeScreenshot()

WebUI.delay(1)

String refIDA = functions.I.RefID_tag()

WebUI.verifyMatch(refIDA, rf1, false)


'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))


'Search project no'
functions.I.SearchProjectNo_xpath( Project_No , '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[8]/button')

WebUI.delay(1)



//DAUGHTER REF
'Click on the daughter ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_daughter_Dupli1) + '"]/td[8]/a[1]']))

WebUI.delay(1)

'Click on  parent link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_view_ref_parent"]']))

WebUI.delay(1)

'Screenshot: Parent daughter ref '
WebUI.takeScreenshot()

WebUI.delay(1)

String refIDB = functions.I.RefID_tag()

WebUI.verifyMatch(refIDB, rf2, false)


WebUI.delay(1)


'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))


'Search project no'
functions.I.SearchProjectNo_xpath( Project_No , '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[8]/button')

WebUI.delay(1)


'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+  refID_daughter_Dupli1 +'"]/td[15]/a[2]']))

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))


'Screenshot: ref list page'
WebUI.takeScreenshot()

//functions.I.status_lifecycle(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_view_ref_parent"]']),'')

WebUI.closeBrowser()