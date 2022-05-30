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

////////////////////SCENARIO 1 : EXISTING PROJECT (MI002230) CONTROL TAG ON PROJECT IS DISPLAYED FOR ADMIN USER////////////////
///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//USERNAME & PASSWORD  - tag
def data_Tag = TestDataFactory.findTestData('Data Files/Username_Password/Tag')

String password_stest = data_Tag.getValue(3, 3)

String password_itroin = data_Tag.getValue(3, 4)

String password_igedik = data_Tag.getValue(3, 5)

String password_mderdour = data_Tag.getValue(3, 6)

//URL
def data_urlRELAUTO = TestDataFactory.findTestData('Data Files/URL/URL_relauto')

String Url_Tag = data_urlRELAUTO.getValue(2, 3)

///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag Release'
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

'Screenshot: Navigate to URL Tag Release'
WebUI.takeScreenshot()

///////////////////////////VERIFY TASK /////////////////////////////
//USER1 itroin
'Verify Task User1 -  itroin '
functions.I.Login_password('itroin', password_itroin)

String itroin_task_bf = WebUI.getText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]']))

functions.I.print('itroin_task_bf ' + itroin_task_bf)

double user1_bf

if (itroin_task_bf == '') {
    user1_bf = 0
} else {
    user1_bf = Double.parseDouble(itroin_task_bf)
}

'Screnshot: Task before submitting > itroin '
WebUI.takeScreenshot()

'Logout as user1- itroin'
functions.I.Logout()

//USER2 igedik
'Verify Task User1 -  igedik '
functions.I.Login_password('igedik', password_igedik)

String igedik_task_bf = WebUI.getText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]']))

functions.I.print('itroin_task_bf ' + igedik_task_bf)

double user2_bf

if (igedik_task_bf == '') {
    user2_bf = 0
} else {
    user2_bf = Double.parseDouble(igedik_task_bf)
}

'Screnshot: Task before submitting > igedik '
WebUI.takeScreenshot()

'Logout as user2- itroin'
functions.I.Logout()

//////////////////////////// LOGIN AS adminf F  ///////////////////////////////////
String Project_No = 'MI002233'

'Log in as ADMIN – stest'
functions.I.Login_password('stest', password_stest)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

'Screenshot: Ref list page of Project MI002233'
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on ref link'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr[3]/td[8]/a[1]']))

//REF LIST PAGE 
'Click on Document'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[2]/a']))

WebUI.delay(1)

'Screenshot: Document > Preview'
WebUI.takeScreenshot()

'Click on Approval Doc'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="aff_doc_AW"]']))

'Screenshot: Document > Approval workflow'
WebUI.takeScreenshot()

//TOOLTIP ADD APPROVER
'Hover over add approver'
WebUI.mouseOver(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="level_apl_0"]/div[1]/div[2]/a[1]']))

'Tooltip: Add approval user'
String tooltip_adduser_actual = WebUI.getText(findTestObject('xxx Todelete/xpath', 
        [('xpath') : '/html/body/div[9]/div[2]']))

'Verify that the tooltip - Add approval users'
WebUI.verifyMatch(tooltip_adduser_actual, 'Add approval users', false)

//POPUP
'Click add approver'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="level_apl_0"]/div[1]/div[2]/a[1]']))

'Screenshot : Popup (Add approvers)'
WebUI.takeScreenshot()

WebUI.delay(1)

/// TOASTR  Please select a group
'46 Click on add approver'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="modal_addvalideur"]/div/div/div[3]/button[2]']))

'Verify toastr for Please select a group'
String toastr1 = WebUI.getText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']))

WebUI.verifyMatch('Please select a group', toastr1, false)

'Screenshot: Please select a group'
WebUI.takeScreenshot()

// TOASTR 2 Please select a new user approver
'50 Select approve for group/ field'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="added_group_approval"]']), 
    '15', false)

'Click on add approver'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="modal_addvalideur"]/div/div/div[3]/button[2]']))

'Verify toastr for Please select a group'
String toastr2 = WebUI.getText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']))

WebUI.verifyMatch('Please select a new user approver', toastr2, false)

'Screenshot: Please select a new user approver'
WebUI.takeScreenshot()

//ADD ALL APPROVER
'Select approve for group/ field'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="added_group_approval"]']), 
    '15', false)

'Select new approvers - add all'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="btnAddAll0"]']))

'Screenshot: Add all'
WebUI.takeScreenshot()

//REMOVE ALLL
'Select new appover - remove all'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="btnRemoveAll0"]']))

'Screenshot: Remove all'
WebUI.takeScreenshot()

'Verify option is empty'
WebUI.verifyOptionPresentByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="selDestUsers"]']), 
    '', false, 20, FailureHandling.OPTIONAL)

//ADD MULITPLE USER
'Add approver'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="selSourceUsers"]']), 
    'itroin', false)

WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="selSourceUsers"]']), 
    'igedik', false)

functions.I.select_multiplelist('//*[@id="selSourceUsers"]', '//*[@id="btnAdd0"]', 'mderdour')

WebUI.delay(1)

'Screenshot: Selected approver'
WebUI.takeScreenshot()

'Remove an approver'
functions.I.select_multiplelist('//*[@id="selDestUsers"]', '//*[@id="btnRemove0"]', 'mderdour')

'Screenshot: 1 approver removed'
WebUI.takeScreenshot()

'Click on add approver'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="modal_addvalideur"]/div/div/div[3]/button[2]']))

functions.I.Logout()

////////VERIFY TASK AFTER ADDING USER
//USER1 itroin
'Verify Task User1 -  itroin '
functions.I.Login_password('itroin', password_itroin)

String itroin_task_af = WebUI.getText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]']))

functions.I.print('itroin_task_af ' + itroin_task_af)

double user1_af

if (itroin_task_af == '') {
    user1_af = 0
} else {
    user1_af = Double.parseDouble(itroin_task_af)
}

'Screnshot: Task before submitting > itroin '
WebUI.takeScreenshot()

'Logout as user1- itroin'
functions.I.Logout()

//USER2 igedik
'Verify Task User1 -  igedik '
functions.I.Login_password('igedik', password_igedik)

String igedik_task_af = WebUI.getText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]']))

functions.I.print('itroin_task_af ' + igedik_task_af)

double user2_af

if (igedik_task_af == '') {
    user2_af = 0
} else {
    user2_af = Double.parseDouble(igedik_task_af)
}

'Screnshot: Task before submitting > igedik '
WebUI.takeScreenshot()

'Logout as user2- itroin'
WebUI.verifyEqual(user1_af, user1_bf + 1)

'Verify the task for igedik'
WebUI.verifyEqual(user2_af, user2_bf + 1)

WebUI.closeBrowser()

