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


/*
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag Release'
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

'Screenshot: Navigate to URL Tag Release'
WebUI.takeScreenshot()

//////////////////////SCENARIO 1 EXISTING PROJECT (MI002232)IS DISPLAYED FOR ADMIN USER ///////////////////////////////
//////////////////////////// LOGIN   ///////////////////////////////////
'Log in as ADMIN ??? rrowland'
functions.I.Login_password('jedun', password_jedun)

'Screenshot: Log in '
WebUI.takeScreenshot()

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

/////////////////////////PROJECTION CREATION
////*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/div[1]/button
'Click on + to create project'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/div[1]/button']))

WebUI.delay(1)

'Click on C TExhnical Proj'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/div[1]/div/a[1]']))

'Screenshot: Create Project page'
WebUI.takeScreenshot()

'Select Project template '
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="project_template"]']), 
    '12', false)

'Click on create project'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))

'Screenshot: creation project page'
WebUI.takeScreenshot()

///

 
'Project name: Project name mass submit'
WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_141"]']), 
    'Project:MASS SUBMIT (Empty Group)')

//'Project type: Animation '
//WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_12"]']), '16291', false)
//'PAD: 10/10/2030 '
//WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_14"]']), '10/10/2030 ')
'Select Division :CPD'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_15"]']), 
    '57', false)

WebUI.delay(2)

'Select Signature: Garnier '
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_16"]']), 
    '58', false)

WebUI.scrollToElement(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_15"]']),
	 5)
WebUI.delay(4)
/*
'Select Franchise: Amb.Solaire+Uv Ski '
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_17"]']),
	'365', false)




WebUI.scrollToElement(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_18"]']), 
    5)
'Select Brand: Ambre Solaire'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_18]']),
	'723', false)

'Sub Brand: Ambre Sol.Gold.Protect'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_20"]']),
	'12857', false)

//'Brand: Acne'
///WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_18"]']), '14527', false)
'Axis: Skin Care'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_20"]']), 
    '40', false)

'SubAxis: Sun care '
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_21"]']), 
    '197', false)

WebUI.scrollToElement(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="selSource_24"]']), 
    5)

'C&A contacts: pmareri'
functions.I.select_multiplelist('//*[@id="selSource_24"]', '//*[@id="btnAdd_24"]', 'pmareri')

String Project_No = functions.I.ProjectNo()

'Screenshot: Project modif page'
WebUI.takeScreenshot()

'Click on Update'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button/i']))

WebUI.delay(1)

'Screenshot: ref list page'
WebUI.takeScreenshot()

///////////////////////////////////CREATION OF MOTHER REF
'Click on + to create ref'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

'Click on ref'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a[1]']))

'Select ref template'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ref_type"]']), 
    '11', false)

WebUI.delay(1)

'Select Lifecycle template'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="lfc_tpl"]']), 
    '43', false)

WebUI.delay(1)

'Screenshot: creation ref page'
WebUI.takeScreenshot()

'Click on create ref'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button']))

WebUI.delay(2)

String refID = functions.I.RefID_tag()

functions.I.print(refID)

'Screenshot: Edit ref page'
WebUI.takeScreenshot()

'Click cancel'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div[1]/a']))

WebUI.delay(1)

//////////////////////////REF Modif page
////*[@id="source_15177"]/td[17]/div[1]/button
'58 create daughter ref'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : ('//*[@id="source_' + 
            refID) + '"]/td[17]/div[1]/button']))

WebUI.delay(1)

WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : ('//*[@id="source_' + 
            refID) + '"]/td[17]/div[1]/div/a[1]']))

'Screenshot: Ref creation page'
WebUI.takeScreenshot()

'Select lifecycle'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="lfc_tpl"]']), 
    '65', false)

'C&A click on create ref'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button']))

'Screenshot: Ref modif page'
WebUI.takeScreenshot()

String refId_d1 = functions.I.RefID_tag()

functions.I.print(refId_d1)

'Select languages: Afirkaans'
functions.I.select_multiplelist('//*[@id="selSource_10"]', '//*[@id="btnAdd_10"]', '1303')

'Select leader marketing : leader country'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_166"]']), 
    '1191', false)

'Select leader  country:Afghanistan'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_71"]']), 
    '1366', false)

'Select Approver countries/zones: Afghanistan'
functions.I.select_multiplelist('//*[@id="selSource_72"]', '//*[@id="btnAdd_72"]', '1366')

WebUI.scrollToElement(findTestObject('xxx Todelete/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/form/div[3]/div[1]/button']), 
    20)

'72 Click save'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/form/div[3]/div[1]/button']))

functions.I.Logout()

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

'Check checkbox 1'
WebUI.check(findTestObject('xxx Todelete/xpath', [('xpath') : ('//*[@id="source_' + 
            refId_d1) + '"]/td[1]/label']))

'Click confirm selection'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="action_btnMassSubmit"]']))

'Screenshot: Popup mass submit'
WebUI.takeScreenshot()

'Verify error message'
String Actual_text1 = WebUI.getText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="tablecontentNOK"]/table/tbody/tr/td[2]']))

functions.I.print(Actual_text1)

WebUI.verifyMatch(Actual_text1, ('Missing mandatory information at reference level' + '\n') + 'empty groups', false)

'verify that cutton is not clickable'
WebUI.verifyElementNotClickable(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="btn_submit_mass_submit"]']))

'Click cancel'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="modal_mass_submit"]/div/div/div[2]/div[2]/div/button[1]']))

'Screenshot'
WebUI.takeScreenshot()

//////////////////////FILL IN MANDATORY FIELDS
'Update ref'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : ('//*[@id="source_' + 
            refId_d1) + '"]/td[16]/a']))

'approval date'
WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_89"]']), 
    '12/12/2030')

WebUI.scrollToElement(findTestObject('xxx Todelete/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[5]/div[3]/div/div[2]/div[2]/form/div[3]/div/button[1]']), 
    20)

'95 Update ref'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[5]/div[3]/div/div[2]/div[2]/form/div[3]/div/button[1]']))

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

'Check checkbox 1'
WebUI.check(findTestObject('xxx Todelete/xpath', [('xpath') : ('//*[@id="source_' + 
            refId_d1) + '"]/td[1]/label']))

'Click confirm selection'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="action_btnMassSubmit"]']))

'Screenshot: Popup mass submit'
WebUI.takeScreenshot()

'Verify error message'
String Actual_text2 = WebUI.getText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="tablecontentNOK"]/table/tbody/tr/td[2]']))

functions.I.print(Actual_text2)

WebUI.verifyMatch(Actual_text2, 'empty groups', false)

'verify that cutton is not clickable'
WebUI.verifyElementNotClickable(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="btn_submit_mass_submit"]']))

'Click cancel'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="modal_mass_submit"]/div/div/div[2]/div[2]/div/button[1]']))

'Screenshot'
WebUI.takeScreenshot()

'Update ref'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : ('//*[@id="source_' + 
            refId_d1) + '"]/td[16]/a']))

'Select languages: Spainish'
functions.I.select_multiplelist('//*[@id="selSource_10"]', '//*[@id="btnAdd_10"]', '1040')

'Select leader  country:Afghanistan'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_71"]']), 
    '1055', false)

'Select Approver countries/zones: Spain'
functions.I.select_multiplelist('//*[@id="selSource_72"]', '//*[@id="btnAdd_72"]', '1055')

WebUI.scrollToElement(findTestObject('xxx Todelete/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[5]/div[3]/div/div[2]/div[2]/form/div[3]/div/button[1]']),
	20)

'95 Update ref'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[5]/div[3]/div/div[2]/div[2]/form/div[3]/div/button[1]']))

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

'Check checkbox 1'
WebUI.check(findTestObject('xxx Todelete/xpath', [('xpath') : ('//*[@id="source_' + 
            refId_d1) + '"]/td[1]/label']))

'Click confirm selection'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="action_btnMassSubmit"]']))

'Screenshot: Popup mass submit'
WebUI.takeScreenshot()

'Verify  message'

String Actual_text3 = WebUI.getText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="tablecontentOK"]/table/tbody/tr/td[2]']))

functions.I.print(Actual_text3)

WebUI.verifyMatch(Actual_text3, 'Leader MKT: Brief completion', false)
*/
WebUI.disableSmartWait()
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="btn_submit_mass_submit"]']))

'Screenshot: Popup mass submit'
WebUI.takeScreenshot()
while (WebUI.verifyElementVisible(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="modal_submit_progress"]']),1000))
{

String Actual_text = WebUI.getText(findTestObject('xxx Todelete/xpath', [('xpath') : ('//*[@id="modal_submit_progress"]')]))

functions.I.print(Actual_text)
}

'Verify Lifecycle stauts'
String Actual_text4 = WebUI.getText(findTestObject('xxx Todelete/xpath', [('xpath') : ('//*[@id="source_' + 
            refId_d1) + '"]/td[14]/span[1]']))

functions.I.print(Actual_text4)

WebUI.verifyMatch(Actual_text4, 'Leader MKT: Brief completion', false)

WebUI.closeBrowser()