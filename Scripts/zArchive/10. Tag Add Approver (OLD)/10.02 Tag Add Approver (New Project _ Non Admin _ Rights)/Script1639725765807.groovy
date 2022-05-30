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

String password_jedun = data_Tag.getValue(3, 1)

String password_stest = data_Tag.getValue(3, 3)

String password_itroin = data_Tag.getValue(3, 4)

String password_igedik = data_Tag.getValue(3, 5)

String password_mderdour = data_Tag.getValue(3, 6)

String password_tliu = data_Tag.getValue(3, 8)

String password_ccaramella = data_Tag.getValue(3, 9)

String password_achay = data_Tag.getValue(3, 10)

//////////////////////////////URL
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

'Login as jedun '
functions.I.Login_password('jedun', password_jedun)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

/////////////////////////////////////CREATION OF PROJECT
'Click on + to create project'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/div[1]/button']))

WebUI.delay(1)

'Screenshot: create a project'
WebUI.takeScreenshot()

'Click on create a project'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/div[1]/div/a[2]']))

'Select project template'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="project_template"]']), 
    '11', false)

'Click on create the project'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))

WebUI.delay(2)

'Screenshot: Modify  a project'
WebUI.takeScreenshot()

'Enter Project name'
def Project_name = (('AutoTest_Tag_AddApprover_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(10)) + '_') + 
functions.I.gettimedate()

WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_141"]']), 
    Project_name)

'Project type'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_12"]']), 
    '1025', false)

'Enter PAD date'
WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_14"]']), 
    '10/10/2020')

'Division '
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_15"]']), 
    '57', false)
WebUI.delay(1)


'Signature '
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_16"]']), 
    '46', false)
WebUI.delay(3)
'Franchise '
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_17"]']), 
    '12174', false)
WebUI.delay(1)
'30. \r\nBrand'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_18"]']), 
    '12414', false)
WebUI.delay(1)
'Fragrance'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_20"]']), 
    '3773', false)

WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_21"]']), 
    '246', false)
WebUI.delay(1)
'Metier'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_22"]']), 
    '3853', false)
WebUI.delay(1)
'34 DMI contacts '
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="selSource_23"]']), 
    'achatin', false)

functions.I.select_multiplelist('//*[@id="selSource_23"]', '//*[@id="btnAdd_23"]', 'tliu')

WebUI.scrollToElement(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="selSource_24"]']), 
    0)
WebUI.delay(1)
'C&A contacts'
functions.I.select_multiplelist('//*[@id="selSource_24"]', '//*[@id="btnAdd_24"]', 'asamyn')

'Click on update project'
WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Update'))

WebUI.delay(1)

'Get project no.'
String Project_No = functions.I.ProjectNo()

'Screenshot: Ref List page '
WebUI.takeScreenshot()

////////////////////////////////////////////CREATION OF MOTHER REF 
'Click on + to create a ref'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

'Click on create a brief'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a[1]']))

'Screenshot: Ref creation page '
WebUI.takeScreenshot()

'Select ref template'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ref_type"]']), 
    '5', false)

'Click on create a brief'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button']))

WebUI.delay(1)

'Get the Ref id'
String refID = functions.I.RefID_tag()



'Click cancel'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div[1]/a']))

WebUI.delay(1)

/////////////////////////////////////////////////////////CREATION OF DAUGHTER REF
'Screenshot: Ref list page '
WebUI.takeScreenshot()

'Click+ to create daughter ref'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[17]/div[1]/button']))

WebUI.delay(1)

'Click create AC'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[17]/div[1]/div/a[1]']))

WebUI.delay(1)

'Select Lifecycle'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="lfc_tpl"]']), 
    '65', false)

'Click create ref'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button']))

WebUI.delay(1)

'Get the Ref id'
String refID_AC = functions.I.RefID_tag()

'Select form languages'
functions.I.select_multiplelist('//*[@id="selSource_10"]', '//*[@id="btnAdd_10"]', '1303')

'Select Leader marketing'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_166"]']), 
    '1190', false)

functions.I.Pagedown()

'60 Click save'
functions.I.click_button_javascript(findTestObject('xxx Todelete/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/form/div[3]/div[1]/button']))

WebUI.delay(1)

'Screenshot: Ref list page '
WebUI.takeScreenshot()

/////
//////COLLAPSE
WebUI.delay(1)
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr[1]/td[8]/a[2]']))
WebUI.delay(1)

WebUI.verifyElementNotVisible(findTestObject('xxx Todelete/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr[2]/td[8]/a']), FailureHandling.STOP_ON_FAILURE)

'Screenshot: Collapse'
 WebUI.takeScreenshot()
 
 
 //////EXPAND
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr[1]/td[8]/a[2]']))
WebUI.delay(1)

WebUI.verifyElementVisible(findTestObject('xxx Todelete/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr[2]/td[8]/a']), FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)

'Screenshot: Expand'
WebUI.takeScreenshot()

//////COLLAPSE ALL //*[@id="all_a"]
WebUI.delay(1)
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="all_a"]']))
WebUI.delay(1)
WebUI.verifyElementVisible(findTestObject('xxx Todelete/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr[1]/td[8]/a[1]']), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotVisible(findTestObject('xxx Todelete/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr[2]/td[8]/a']), FailureHandling.STOP_ON_FAILURE)

'Screenshot: Collapse'
 WebUI.takeScreenshot()
 
 
 //////EXPAND ALL
WebUI.delay(1)
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="all_a"]']))
WebUI.delay(1)
WebUI.verifyElementVisible(findTestObject('xxx Todelete/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr[1]/td[8]/a[1]']), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('xxx Todelete/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/table/tbody/tr[2]/td[8]/a']), FailureHandling.STOP_ON_FAILURE)

'Screenshot: Expand'
WebUI.takeScreenshot()

WebUI.delay(1)

////*[@id="source_15102"]/td[19]/a[2]
'Click submit'
WebUI.click(findTestObject('Object Repository/TAG/id_refid_td19_a2', [('refID') : 'source_' + refID]))

WebUI.delay(1)

'Screenshot: Ref modif page '
WebUI.takeScreenshot()

'Click submit'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

WebUI.delay(1)

String color1 = WebUI.getCSSValue(findTestObject('Object Repository/TAG/id_refid_td19_a2', [('refID') : 'source_' + refID]), 
    'color', FailureHandling.OPTIONAL)

WebUI.delay(1)

functions.I.print(color1)

while (color1 == 'rgba(255, 255, 255, 1)') {
    WebUI.click(findTestObject('Object Repository/TAG/id_refid_td19_a2', [('refID') : 'source_' + refID]))

    ' Upload doc for production phase'
    WebUI.takeScreenshot()

    //UPLOAD A DOC
    functions.I.UploadDoc_sendkey_Prod(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_body"]/input[2]']), 
        'D:\\Upoad_File\\Upload doc\\testdataaddition1.jpg', 'testdataaddition1.jpg')

    'Screenshot: Production phase Field Upload doc'
    WebUI.takeScreenshot()

    WebUI.delay(10)

    //REF PAGE: CLICK ON PROCEED TO NEXT PHASE
    functions.I.click_button_javascript(findTestObject('Object Repository/HL Full Lifecycle/12 ReferncePage_Button_Updatensenddoc'))

    WebUI.delay(5)

    if (WebUI.verifyElementPresent(findTestObject('Object Repository/TAG/id_refid_td19_a2', [('refID') : 'source_' + refID]), 
        10, FailureHandling.OPTIONAL)) {
        color1 = WebUI.getCSSValue(findTestObject('Object Repository/TAG/id_refid_td19_a2', [('refID') : 'source_' + refID]), 
            'color', FailureHandling.OPTIONAL)
    } else {
        color1 = 'white'
    }
}

'Logout as jedun'
functions.I.Logout()

/////////////////////////////////////LOG IN AS C&A ///////////////////
/////////////VERIFICATION OF NO RIGHTS /////////////////////////////////////
'Login as c&a - ccaramella'
functions.I.Login_password('ccaramella', password_ccaramella)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

WebUI.delay(5)

'Screenshot: Ref list page '
WebUI.takeScreenshot()

'Click on the ref link'
WebUI.click(findTestObject('Object Repository/TAG/id_refid_td8_a', [('refID') : 'source_' + refID]))

'Click on doc tab'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[2]/a']))

'Click on approval workflow'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="aff_doc_AW"]']))

WebUI.delay(1)

'Verify that element is not present'
WebUI.verifyElementNotVisible(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="level_apl_0"]/div[1]/div[2]/a[1]']))

'Screenshot: Add approver button is not displayed'
WebUI.takeScreenshot()

'Logout as ccaramella'
functions.I.Logout()

/////////////////////////////////////LOG IN AS C&A ///////////////////
'Login as c&a - tliu'
functions.I.Login_password('tliu', password_tliu)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

WebUI.delay(5)

'Screenshot: Ref list page '
WebUI.takeScreenshot()

'Click on the ref link'
WebUI.click(findTestObject('Object Repository/TAG/id_refid_td8_a', [('refID') : 'source_' + refID]))

'Click on doc tab'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/ul/li[2]/a']))

'Click on approval workflow'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="aff_doc_AW"]']))

WebUI.delay(1)

'Screenshot: Add approver button is displayed'
WebUI.takeScreenshot()

'Click on add approver button'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="level_apl_0"]/div[1]/div[2]/a[1]']))

'102 Select a group'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="added_group_approval"]']), 
    '82', false)

'Select from multiple user list'
functions.I.select_multiplelist('//*[@id="selSourceUsers"]', '//*[@id="btnAdd0"]', 'achay')

WebUI.takeScreenshot()

'Click add'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="modal_addvalideur"]/div/div/div[3]/button[2]']))

WebUI.delay(1)

'Verify message is displayed'
String Amsg_success = WebUI.getText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="toast-container"]/div/div[2]']))

WebUI.verifyMatch(Amsg_success, 'A new user approver Abigail Chay has been added to level Leader MKT: Artwork approval', 
    false, FailureHandling.OPTIONAL)

'Logout'
functions.I.Logout()

///////////////////////////////////////LOGIN AS ABIGAIL
'Login as achay'
functions.I.Login_password('achay', password_achay)

'click on task notif'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]']))

WebUI.delay(1)

'Screenshot: task '
WebUI.takeScreenshot()

'Click on task notification'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[2]/a']))

WebUI.delay(5)

'Screenshot: Document > Preview '
WebUI.takeScreenshot()

'USer approve'
functions.I.AWF_approve_view()
WebUI.closeBrowser()


