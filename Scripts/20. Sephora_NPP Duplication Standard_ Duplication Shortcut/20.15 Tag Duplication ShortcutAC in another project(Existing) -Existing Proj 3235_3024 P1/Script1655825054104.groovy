import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.google.common.base.Functions
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

/* Duplication Shortcut: CB + AC in a [In a new project]
 */



//DATA FIELD USERNAME_PASSWORD (TAG)
def data_Tag = TestDataFactory.findTestData('Data Files/Username_Password/Tag')

String password_aamar = data_Tag.getValue(3, 37) //R
	
//DATA FIELD URL
def data_urlRELAUTO = TestDataFactory.findTestData('Data Files/URL/URL_relauto')

String Url_Tag = data_urlRELAUTO.getValue(2, 3)


String Project_No1 ='MI003235'
String Project_No2 = 'MI003024'

String ref_no = '9'
///////////////////////////// TEST BEGIN /////////////////////////////////////////


//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag Release'
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

'Screenshot: Navigate to URL Tag Release'
WebUI.takeScreenshot()

'Login as coordinator dalfi '
functions.I.Login_password('aamar', password_aamar)

'LHS click the project tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="menu_2"]/a']))

'Search project no'
functions.I.SearchProjectNo_xpath(Project_No1, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[8]/button')

WebUI.delay(2)


//REF LIST PAGE
'Click on the duplicate button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/div[1]/button']))

'Screenshot: ref List page '
WebUI.takeScreenshot()

WebUI.delay(1)

//SELECT DUPLI
'Select dupli option Duplicate Artwork brief (AC) only in another project'
String dupli_option1 = 'Duplicate Artwork brief (AC) only in another project'

int x = 1
while (x <=4)
{
	
String dupli_name = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[1]/div[2]/span/div[1]/div/a['+x+']']))

if (dupli_name.contains( dupli_option1))
{
	WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[1]/div[2]/span/div[1]/div/a['+x+']']))
	break
	 
}
x= x+1
}

WebUI.delay(1)


'Select 2nd refs '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_23229"]/td[1]/label']))

WebUI.delay(1)

'Screenshot: ref List page '
WebUI.takeScreenshot()

'Verify you are not allowed to duplicate several refs msg is displayed'
functions.I.Verify_Mouse_Over_tooltip( '//*[@id="source_23227"]/td[1]/i', '/html/body/div[9]/div[2]', 'You are not allowed to duplicate several references at the same time')


'Click on confirm  '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnduplicatereference"]']))

WebUI.delay(1)



'Screenshot: Dupli popup'
WebUI.takeScreenshot()

WebUI.delay(1)

'Verify that the only button is  existing project'
functions.I.VerifyMatchText( '//*[@id="list_project_type"]/label[1]', 'In existing project')

'Verify that there is only 1 button present'
WebUI.verifyElementNotVisible(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="list_project_type"]/label[2]']))

WebUI.delay(1)

//SElect PROJECT NO . 
'Click the field Project name'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="is_old_project"]/div/span']))

WebUI.delay(1)

'Enter Project No: MI003024'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_body"]/span/span/span[1]/input']), Project_No2)

WebUI.delay(1)

'Click the field Project name'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="select2-nbProject-results"]/li']))

//DAUGHTER REF
'Verify that ref template = Artwork Brief (AC) is selected'
functions.I.VerifyMatchText('//*[@id="select2-ref_tpl7-container"]', 'Artwork Brief (AC)')

'Verify that lifecycle template = Marketing project is selected'
functions.I.VerifyMatchText('//*[@id="select2-lfc_tpl7-container"]', 'A - Create a document (managed by local agencies)')

WebUI.delay(1)

'Select mother ref linked ref'
//LOTION TANNING OIL 200ML_FG_Label back_200ML_Bilingual
functions.I.SelectFromList_Value('//*[@id="source_ref"]', '21834')

//Name of the Duplicate button
'Verify that name of the duplication'
functions.I.VerifyMatchText('//*[@id="btn_submit_duplication"]', 'Duplicate Artwork brief (AC) only in another project')



'Click Duplicate'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_submit_duplication"]']))

//USER IS REDIRECTED TO THE DUPLICATED PROJECT
WebUI.delay(2)

'Get the project no.'
String Project_No3 = functions.I.ProjectNo()

WebUI.verifyMatch(Project_No3, Project_No2, false)

'Screenshot: USER IS REDIRECTED TO THE DUPLICATED PROJECT'
WebUI.takeScreenshot()

'Verify no of ref in the project'
functions.I.VerifyMatchText('//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[1]/h1/span', '10')


//Name of ref & GET REF id
functions.I.SearchRefNo_xpath('Copy 1 of LOTION TANNING OIL 200ML_FG_Label back_200ML___DE_FR', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')


'Verify the mother name of the ref'
functions.I.VerifyMatchText('//*[@id="source_21834"]/td[8]/a[1]', 'LOTION TANNING OIL 200ML_FG_Label back_200ML_Bilingual')
 
'Verify daughter ref has been created under the mother ref'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[8]', 'Copy 1 of LOTION TANNING OIL 200ML_FG_Label back_200ML___DE_FR___')

WebUI.delay(2)

'Click daughter ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[8]/a']))


WebUI.delay(1)

//VERIFY FIELD OF Daughter REF
//PLANT / C&A - Artwork information
'Verify Languages :German / French'
functions.I.VerifyMatchText('//*[@id="var_10"]/span', 'German'+'\n'+'French')


'Leader marketing : Leader Country'
functions.I.VerifyMatchText('//*[@id="var_166"]', 'Leader Country')


'Leader country : Germany'
functions.I.VerifyMatchText('//*[@id="var_71"]', 'Germany')

'Approver countries/zones : Switzerland'
functions.I.VerifyMatchText('//*[@id="var_72"]/span', 'Switzerland')

'Notified countries/zones :Zone Western Europe'
functions.I.VerifyMatchText('//*[@id="var_74"]/span', 'Zone Western Europe')

'Artwork approval date : 30/11/2021'
functions.I.VerifyMatchText('//*[@id="var_89"]', '30/11/2021')

'BAG approval date : 14/12/2021'
functions.I.VerifyMatchText('//*[@id="var_90"]', '14/12/2021')


//PLANT - Repro information
'Verify Printer/supplier : 00002001 - ESSENTRA PACKAGING | POL, Lublin'
functions.I.VerifyMatchText('//*[@id="var_48"]', '00002001 - ESSENTRA PACKAGING | POL, Lublin')



WebUI.delay(1)

'Click on the view parent button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_view_ref_parent"]']))

'Screenshot: Parent Project'
WebUI.takeScreenshot()

'User is redirected to the parent reference'
String parent_ref_daughter1 = functions.I.RefID_tag()
WebUI.verifyMatch('23229', parent_ref_daughter1, false)


'LHS click the project tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="menu_2"]/a']))

'Search project no'
functions.I.SearchProjectNo_xpath(Project_No2, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[8]/button')


WebUI.delay(3)

'Screenshot: Parent Project'
WebUI.takeScreenshot()


//Name of ref & GET REF id
functions.I.SearchRefNo_xpath('Copy 1 of LOTION TANNING OIL 200ML_FG_Label back_200ML___DE_FR', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')

 
'Click on submit - daughter'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[15]/a[2]']))


'Click on submit - daughter'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

WebUI.delay(2)


'Screenshot: ref list page'
WebUI.takeScreenshot()

//Name of ref & GET REF id
functions.I.SearchRefNo_xpath('LOTION TANNING OIL 200ML_FG_Label back_200ML__Bilingual_DE_FR___', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[3]/button')


'Verify the reference lifecycle status: '
functions.I.status_lifecycle(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[13]/span[1]']), 'Leader MKT: Brief completion')


WebUI.closeBrowser()