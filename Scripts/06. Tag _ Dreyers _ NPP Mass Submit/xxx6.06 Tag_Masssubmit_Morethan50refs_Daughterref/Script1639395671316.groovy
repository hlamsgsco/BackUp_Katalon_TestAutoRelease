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
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

//////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//USERNAME & PASSWORD  - tag
def data_Tag = TestDataFactory.findTestData('Data Files/Username_Password/Tag')

String password_jedun = data_Tag.getValue(3, 1)

// Change to
String password_rrowland = data_Tag.getValue(3, 2)

String password_stest = data_Tag.getValue(3, 3)

String password_itroin = data_Tag.getValue(3, 4)

String password_igedik = data_Tag.getValue(3, 5)

String password_mderdour = data_Tag.getValue(3, 6)

String password_achatin = data_Tag.getValue(3, 7)

String password_tliu = data_Tag.getValue(3, 8)

String password_ccaramella = data_Tag.getValue(3, 9)

String password_achay = data_Tag.getValue(3, 10)

String password_cbono = data_Tag.getValue(3, 11)

String password_pmareri = data_Tag.getValue(3, 12)

//URL
def data_urlRELAUTO = TestDataFactory.findTestData('Data Files/URL/URL_relauto')

String Url_Tag = data_urlRELAUTO.getValue(2, 3)

String Project_No = 'MI003389'

String refID1 = '24307'

String refID2 = '24308'

String refID3 = '24309'

String refID4 = '24310'

String refID5 = '24311'

/////////////////////////////////EMPTY GROUP///////////////////////////////////////////
/////////////////////////////////EXISTING PROJECT : 'MI003389' ////////////////////////
/////////////
///////////////////S1 EMPTY GROUP - EMPTY FIELD (FILTERED GROUP : PRINTER- 1 FIELD)/////////////////////
///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag Release'
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

'Screenshot: Navigate to URL Tag Release'
WebUI.takeScreenshot()

//////////////LOGIN AS C&A
'Log in as C&A - pmareri'
functions.I.Login_password('pmareri', password_pmareri)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[8]/button')

'Screenshot: Ref List page'
WebUI.takeScreenshot()

WebUI.delay(1)

///////////////////////////////////////DUPLICATE 4 REFS
'Click on dupplicate'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="btnduplicatereference"]']))

WebUI.delay(2)

///*[@id="source_14930"]/td[1]/label
'Check checkbox1'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : ('//*[@id="source_' + 
            refID2) + '"]/td[1]/label']))

WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : ('//*[@id="source_' + 
            refID3) + '"]/td[1]/label']))

WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : ('//*[@id="source_' + 
            refID4) + '"]/td[1]/label']))

WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : ('//*[@id="source_' + 
            refID5) + '"]/td[1]/label']))

WebUI.delay(3)

WebUI.scrollToElement(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="card_project"]/div[1]/div[1]/h3']), 5)
'38 Click on confirm ref'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="action_btnduplicatereference"]']))

WebUI.delay(2)

'Select ref template'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ref_tpl7"]']), 
    '7', false)
WebUI.delay(1)

'Select lifecycle  template'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="lfc_tpl7"]']),
	'65', false)

WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="btn_submit_duplication"]']))

WebUI.delay(1)
'Screenshot'
WebUI.takeScreenshot()

///////////////////////////////MASS SUBMIT
'Click mass submit'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/div/button']))

'Screenshot'
WebUI.takeScreenshot()

WebUI.delay(1)

'Choose 1 SEND (a-cpd)'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[1]/div[2]/span/div/div/a[1]']))

'Screenshot'
WebUI.takeScreenshot()

'Check all checkbox '
WebUI.check(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="source_"]/th[1]/label']))

'Click confirm selection'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="action_btnMassSubmit"]']))

'Screenshot: Popup mass submit'
WebUI.takeScreenshot()

WebUI.scrollToElement(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="btn_submit_mass_submit"]']), 
    5)

WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="btn_submit_mass_submit"]']))


//*[@id="id_progress_masssubmit"]
////*[@id="id_progress_masssubmit"]
String percentage = WebUI.getAttribute(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="id_progress_masssubmit"]']), 'aria-valuenow')

functions.I.print(percentage)
while (percentage == '0' )
{
	
	percentage = WebUI.getAttribute(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="id_progress_masssubmit"]']), 'aria-valuenow')
		if (percentage !='0')
	break
	 
	
}

while (percentage != '0' )
{
	WebUI.verifyTextPresent('Sending references', false)
	String text = WebUI.getText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="submit-progress"]/h6']))
	functions.I.print(text)
	percentage = WebUI.getAttribute(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="id_progress_masssubmit"]']), 'aria-valuenow')
	 
	if (percentage =='100')
	break
	
}
'Screenshot: Popup mass submit'
WebUI.takeScreenshot()

WebUI.delay(1)

//*[@id="source_14931"]/td[14]/span[1]
'Verify Lifecycle stauts'
String Actual_text4 = WebUI.getText(findTestObject('xxx Todelete/xpath', [('xpath') : ('//*[@id="source_' + 
            refID3) + '"]/td[14]/span[1]']))

functions.I.print(Actual_text4)

WebUI.verifyMatch(Actual_text4, 'Leader MKT: Brief completion', false)

