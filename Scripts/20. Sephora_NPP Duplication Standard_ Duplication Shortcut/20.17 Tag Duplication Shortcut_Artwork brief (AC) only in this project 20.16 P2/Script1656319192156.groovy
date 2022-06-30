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
functions.I.Login_password('jedun', password_jedun)


'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))


'Search project no'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[7]/button')

WebUI.delay(1)


//REF LIST PAGE
'search for ref'
functions.I.SearchRefNo_xpath('Copy 1 of', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[5]/button')

'Click on the duplicate button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/div[1]/button']))

'Screenshot: ref List page '
WebUI.takeScreenshot()

WebUI.delay(1)

//SELECT DUPLI
'Select dupli option Duplicate Duplicate Artwork brief (AC) only in this project'
String dupli_option1 = 'Duplicate Artwork brief (AC) only in this project'

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

'Select daughter ref '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+DuplirefID2+'"]/td[1]/label']))

WebUI.delay(1)

'Screenshot: Ref modif page '
WebUI.takeScreenshot()

'Click on confirm  '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnduplicatereference"]']))

WebUI.delay(1)

'Screenshot: Dupli popup'
WebUI.takeScreenshot()

WebUI.delay(1)


'Verify that the only button is in this project'
functions.I.VerifyMatchText('//*[@id="list_project_type"]/label[1]', 'In this project')

'Verify that there is only 1 button present'
////*[@id="source_ref"]
WebUI.verifyElementNotPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="list_project_type"]/label[2]']),
	3)

'Verify that there is only 1 option on the linked reference'
int lr = WebUI.getNumberOfTotalOption(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_ref"]']))
WebUI.verifyEqual(lr, 1)

'Verify the linked reference Copy 1 of TC_AUTO_MOTHERREF_Fake_Beauty Seal_100CM2_'
functions.I.VerifyMatchText('//*[@id="select2-source_ref-container"]', 'Copy 1 of TC_AUTO_MOTHERREF_Fake_Beauty Seal_100CM2_')

//DUPLI DETAILS
'Verify that name of the duplication'
functions.I.VerifyMatchText('//*[@id="select2-ref_tpl7-container"]', 'Artwork Brief (AC)')

'Verify that name of the duplication'
functions.I.VerifyMatchText('//*[@id="select2-lfc_tpl7-container"]', 'G - Create an US Artwork - Repro document (managed by C&A Europe)')

'Verify that name of the duplication'
functions.I.VerifyMatchText('//*[@id="btn_submit_duplication"]', 'Duplicate Artwork brief (AC) only in this project')

'Click on + FOR NO OF COPIES: 2 '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="div_multiple_copies"]/div/div/span/button[1]']))


'Click on Duplicate button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_submit_duplication"]']))


WebUI.delay(1)

'Screenshot: Ref level page '
WebUI.takeScreenshot()

'Refresh filter'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="form_filters"]/div[5]/a[2]']))

WebUI.delay(1)

'Verify no of ref in the project'
functions.I.VerifyMatchText('//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[1]/h1/span', '6')

WebUI.delay(1)

'search for ref'
functions.I.SearchRefNo_xpath('Copy 1 of TC_AUTO_MOTHERREF_Fake_Beauty Seal_100CM2_', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[5]/button')

'Verify ref is linked to mother ref'
functions.I.VerifyMatchText('//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[1]/h1/span', '4')


int y = 1


String refid9 = ''
while (y <= 4)
{
String refID_name = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr['+y+']/td[8]/a']))

if (refID_name.contains ('Copy 2 of Copy 1'))
	
{
	 refid9 = functions.I.href_RefID_Tag('/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr['+y+']/td[8]/a')
	WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr['+y+']/td[8]/a']))
	
	WebUI.delay(1)
	
	'Screenshot: Ref link page '
	WebUI.takeScreenshot()
	
	WebUI.delay(1)
	
	'Click on  parent link'
	WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_view_ref_parent"]']))
	
	
	WebUI.delay(1)
	
	String refIDA = functions.I.RefID_tag()
	
	WebUI.verifyMatch(refIDA, DuplirefID2, false)
	
	WebUI.delay(1)
	
	'Click on the breadcrum'
	WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))
	
	y=y+1
	}
	
	else {
	y =y+1}
	

}


WebUI.delay(1)

'Screenshot: Ref level page '
WebUI.takeScreenshot()

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+  refid9+'"]/td[17]/a[3]']))

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

WebUI.closeBrowser()
