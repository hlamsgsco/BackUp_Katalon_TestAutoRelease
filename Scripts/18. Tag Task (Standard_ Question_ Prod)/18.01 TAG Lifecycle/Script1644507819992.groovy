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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

//DATA FIELD USERNAME_PASSWORD (TAG)
def data_Tag = TestDataFactory.findTestData('Data Files/Username_Password/Tag')

String password_jedun = data_Tag.getValue(3, 1)

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

String password_qeuzen = data_Tag.getValue(3, 13)

String password_alanglois = data_Tag.getValue(3, 14)

String password_bde_villeneuve = data_Tag.getValue(3, 15)

String password_scai = data_Tag.getValue(3, 16)

String password_bzavaglia = data_Tag.getValue(3, 17)

String password_mraoul = data_Tag.getValue(3, 18)

String password_idiaz = data_Tag.getValue(3, 19)

String password_asalama = data_Tag.getValue(3, 20)

String password_suser = data_Tag.getValue(3, 21)

String password_etaraskin = data_Tag.getValue(3, 22)

String password_avieu_brasseur = data_Tag.getValue(3, 23)

String password_sguy = data_Tag.getValue(3, 24)

String password_asch = data_Tag.getValue(3, 25)

String password_bmartin = data_Tag.getValue(3, 26)

String password_icoindeau = data_Tag.getValue(3, 27)

String password_alafon = data_Tag.getValue(3, 28)

String password_aamiot = data_Tag.getValue(3, 29)

String password_daguirre = data_Tag.getValue(3, 30)

String password_aomoto = data_Tag.getValue(3, 31)

String password_apetit = data_Tag.getValue(3, 32)

String password_asamyn = data_Tag.getValue(3, 33)

//DATA FIELD URL
def data_urlRELAUTO = TestDataFactory.findTestData('Data Files/URL/URL_relauto')

String Url_Tag = data_urlRELAUTO.getValue(2, 3)

/* icoindeau / alafon - task 0 before starting 
 * 
 * TO CONTINUE WITH 3405
 * SCENARIO TESTED: FULLL LIFECYCLE : 0 - Common Brief only
 

VERIFICATION OF TASK
SCENARIO 1: CREATION OF REF > TASK ADDED & REMOVED - STANDARD PHASE
SCENARIO 2: QUESTION PHASE > TASK ADDED & REMOVED - TAKING ROADS
SCENARIO 3 : QUESTION PHASE > PROCEED TO NEXT PHASE 
 */
/*
String Project_No = 'MI003406'
String refID = '24436'
Double task1=4
def Project_name = 'AutoTag_FullLifecyle_' 
*/
//CLEAR NOTEPAD
functions.I.clearnotepad('D:\\Upoad_File\\Projet_ Login\\Tag\\18.01 Tag _Project_No\\18.01_Tag_ProjectNo.txt')

functions.I.clearnotepad('D:\\Upoad_File\\Projet_ Login\\Tag\\18.01 Tag _Project_No\\18.01_Tag_refID1.txt')

functions.I.clearnotepad('D:\\Upoad_File\\Projet_ Login\\Tag\\18.01 Tag _Project_No\\18.01_Tag_refID2.txt')

///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag Release'
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

'Screenshot: Navigate to URL Tag Release'
WebUI.takeScreenshot()

'Login as aomoto '
functions.I.Login_password('aomoto', password_aomoto)

'Get task no'
Double task1_aomoto = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

if (task1_aomoto >= 5) {
    WebUI.verifyEqual(task1_aomoto, '4', false)
} else {
    WebUI.verifyEqual(task1_aomoto, task1_aomoto)
}

'Logout'
functions.I.Logout()

'Login as apetit '
functions.I.Login_password('apetit', password_apetit)

'Get task no'
Double task1_apetit = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

if (task1_apetit >= 4) {
    WebUI.verifyEqual(task1_apetit, '5', false)
} else {
    WebUI.verifyEqual(task1_apetit, task1_apetit)
}

'Logout'
functions.I.Logout()

// DMI ACE CEREAVE CREATION OF PROJECT
'Login as dmi_acd_cerave : daguirre '
functions.I.Login_password('daguirre', password_daguirre)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///CREATION OF PROJECT
'Click on + to create project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/a[1]']))

WebUI.delay(1)

'Screenshot: Modify  a project'
WebUI.takeScreenshot()

'Enter Project name'
def Project_name = (('AutoTag_FullLifecyle_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(3)) + '_') + 
functions.I.gettimedate()

WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_141"]']), Project_name)

'Project type - LAUNCH: New range, new product'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_12"]']), '1025', false)

'Verify that domain is Packaging'
String Domain_Packaging = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="select2-var_116-container"]']))

WebUI.verifyMatch(Domain_Packaging, ('×' + '\n') + 'Packaging', false)

'Development zone - Zone Europe'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_262"]']), '16352', false)

'Enter PAD date'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_14"]']), '10/10/2020')

WebUI.delay(2)

'Division - ACD'
String Division_ACD = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="select2-var_15-container"]']))

WebUI.verifyMatch(Division_ACD, ('×' + '\n') + 'ACD', false)

'Signature - CeraVe'
String Signature_CeraVe = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="select2-var_16-container"]']))

WebUI.verifyMatch(Signature_CeraVe, ('×' + '\n') + 'CeraVe', false)

'Franchise  - CeraVe'
String Franchise_CeraVe = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="select2-var_17-container"]']))

WebUI.verifyMatch(Franchise_CeraVe, ('×' + '\n') + 'CeraVe', false)

WebUI.delay(3)

'Brand - Acne'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_18"]']), '14527', false)

WebUI.delay(1)

'SubBrand - Acne Body Wash'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_19"]']), '15641', false)

WebUI.delay(1)

'Axis - Fragrance'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_20"]']), '3773', false)

WebUI.delay(1)

'SubAxis - Men Fragrance'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_21"]']), '246', false)

WebUI.delay(1)

'Metier - Men fragrances '
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_22"]']), '3854', false)

WebUI.delay(1)

'VErify DMI contact is selected'
String DMI_David = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="selDest_23"]']))

WebUI.verifyMatch(DMI_David, 'David Aguirre', false)

'Select another dmi'
functions.I.select_multiplelist('//*[@id="selSource_23"]', '//*[@id="btnAdd_23"]', 'aomoto')

WebUI.delay(1)

'C&A contacts'
functions.I.select_multiplelist('//*[@id="selSource_24"]', '//*[@id="btnAdd_24"]', 'apetit')

WebUI.delay(5)

'Click on update project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))

WebUI.delay(2)

'Get project no.'
String Project_No = functions.I.ProjectNo()

'Screenshot: Ref List page '
WebUI.takeScreenshot()

WebUI.delay(2)

'Click on create ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

WebUI.delay(1)

'Click on 1st option create ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a[1]']))

WebUI.delay(1)

'Screenshot: Ref creation page '
WebUI.takeScreenshot()

'Select Reference Template - Multiple artwork without master design '
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ref_type"]']), '8', false)

WebUI.delay(1)

'Click on Update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="createRefBottom"]']))

'Screenshot: Ref modif page '
WebUI.takeScreenshot()

'Enter mkt product name'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_117"]']), 'TC18_AUTO_MOTHERREF')

'Select Product category -Fake '
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_57"]']), '134', false)

'Select Packaging Family - Beauty Seal '
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_28"]']), '1194', false)

'Select Packaging type -  Secondary'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_228"]']), '15723', false)

'Enter Capacity'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_54"]']), '100')

'Select Capacity Unit - CM2'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_55"]']), '122', false)

'Get the Ref id'
String refID = functions.I.RefID_tag()

WebUI.delay(2)

WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_91"]']), 2)

'Click on Update'
functions.I.click_button_javascriptS('/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/form/div[3]/div[1]/button')

WebUI.delay(2)

'Screenshot: Ref List page '
WebUI.takeScreenshot()

'Logout'
functions.I.Logout()


'Login as jedun '
functions.I.Login_password('jedun', password_jedun)

'LHS click the project tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="menu_2"]/a']))

'Search project no'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[7]/button')

WebUI.delay(1)

'Screenshot: ref List page '
WebUI.takeScreenshot()

'super edit'
functions.I.superedit_ref(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID+'"]/td[15]/div[2]/button']), findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID+'"]/td[15]/div[2]/div/a[4]']))

//'136 Set text : 200192562A'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_27"]']), '200192562A')

'Click update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button']))

'Logout'
functions.I.Logout()

///STEP 1  Brief only  >  PHASE 1 DMI: Brief completion
// LOG IN AS DEMI ACD 
'Login as aomoto '
functions.I.Login_password('aomoto', password_aomoto)

'Screenshot: Dashboard page '
WebUI.takeScreenshot()

'Get task no'
Double task2_aomoto = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

WebUI.verifyEqual(task2_aomoto - 1, task1_aomoto)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div']))

WebUI.delay(1)

double n = 1

while (n <= task2_aomoto) {
    result = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[2]/a[' + 
                n) + ']']), FailureHandling.OPTIONAL)

    if (result.contains('COMPLETE & SEND Common Brief: ____ - CeraVe_Acne_2022_' + Project_name)) {
        WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[2]/a[' + 
                    n) + ']']))

        break
    } else {
        n = (n + 1)
    }
}

'Screenshot: Ref List page '
WebUI.takeScreenshot()

'ref list page : Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[13]/a[3]']))

'Screenshot: Ref List page '
WebUI.takeScreenshot()

'ref modif page: submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'delay'
WebUI.delay(1)

'Screenshot: Control Tag page '
WebUI.takeScreenshot()

//VERIFY CONTROl TAG
String CT_actual1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[2]/div/div/div/p']))

WebUI.verifyMatch(CT_actual1, 'International artwork agency is missing', false)

'Click on modify ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[3]/div/a']))

'delay'
WebUI.delay(1)

'Screenshot: Ref modif page '
WebUI.takeScreenshot()

//


'137 Select International artwork agency - L’Oréal Internal Agency (Creative)'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_50"]']), '16548', false)

'delay'
WebUI.delay(1)

'Pagedown'
functions.I.Pagedown()

'Click on save'
functions.I.click_button_javascriptS('//*[@id="type_save"]')

'Screenshot: Ref List page '
WebUI.takeScreenshot()


 
'ref list page : Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[13]/a[3]']))

'Screenshot: Ref List page '
WebUI.takeScreenshot()

'ref modif page: submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'delay'
WebUI.delay(1)

'Get task no'
Double task3_aomoto = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

WebUI.verifyEqual(task3_aomoto + 1, task2_aomoto)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div']))

WebUI.delay(1)

double k = 1

while (k <= task3_aomoto) {
    result2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[2]/a[' + 
                k) + ']']), FailureHandling.OPTIONAL)

    WebUI.verifyNotMatch(result2, 'COMPLETE & SEND Common Brief: ____ - CeraVe_Acne_2022_' + Project_name, false)

    k = (k + 1)
}

'Screenshot: Ref List page '
WebUI.takeScreenshot()

'ref  page: click on + button to create a ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[13]/a']))

'Screenshot:Daughter  Ref creation page '
WebUI.takeScreenshot()

'Select Lifecycle'
WebUI.selectOptionByValue(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="lfc_tpl"]']), '94', false)

'click on create ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="createRefTop"]']))

'delay'
WebUI.delay(1)

'Screenshot: Ref modif page '
WebUI.takeScreenshot()

'ref modif page: click save'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div[1]/a']))

'VErify ref id daughter'
String refID_1 = Integer.parseInt(refID) + 1

'Get task no'
Double task4_aomoto = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

WebUI.verifyEqual(task4_aomoto - 1, task3_aomoto)

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div']))

WebUI.delay(1)

int i = 1

while (i <= task4_aomoto) {
    result3 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[2]/a[' + 
                i) + ']']))

    if (result3.contains('COMPLETE & SEND Artwork Brief: TC18_AUTO_MOTHERREF_Fake_Beauty Seal_100CM2______')) {
        WebUI.verifyMatch('1', '1', false)

        i = (i + 1)

        break
    } else {
        i = (i + 1)
    }
}

'Logout'
functions.I.Logout()

/////////////////////////////QUESTION : Step : Brief only > Phase : C&A: Brief completion
'Login as apetit '
functions.I.Login_password('apetit', password_apetit)

'Screenshot: Ref modif page '
WebUI.takeScreenshot()

'Get task no'
Double task2_apetit = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

WebUI.verifyEqual(task2_apetit - 1, task1_apetit)

int a = 1

//DAshboard 
while (a <= task2_apetit) {
    b = (a + 1)

    result = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="widg_20200728_091929_587E6645P"]/div/div[2]/div/div/table/tbody/tr[' + 
                b) + ']/td[1]/a']), FailureHandling.OPTIONAL)

    if (result.contains('COMPLETE & SEND Common Brief: TC18_AUTO_MOTHERREF_Fake_Beauty Seal_100CM2_ - CeraVe_Acne_2022_' + 
        Project_name)) {
        WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="widg_20200728_091929_587E6645P"]/div/div[2]/div/div/table/tbody/tr[' + 
                    b) + ']/td[1]/a']))

        break
    } else {
        a = (a + 1)
    }
}

'Screenshot: Ref list page '
WebUI.takeScreenshot()

WebUI.delay(1)

'click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[15]/a[2]']))

WebUI.delay(1)

'Screenshot: Ref modif page '
WebUI.takeScreenshot()

'Question: refuse '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/button']))

WebUI.delay(1)

'Click on 2nd option'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/div/a[2]']))

WebUI.delay(1)

'Screenshot: Ref modif page '
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[2]']))

'Screenshot: Toastr '
WebUI.takeScreenshot()

'Toastr: REFERENCE BRIEF VALIDATION ERRORS : AUTO_MOTHERREF_Fake_Beauty Seal_100CM2_ '
String Actual_toastr1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="toast-container"]/div']))

String Expected_toastr1 = ((((('×' + '\n') + 'Error') + '\n\n') + 'REFERENCE BRIEF VALIDATION ERRORS : TC18_AUTO_MOTHERREF_Fake_Beauty Seal_100CM2_') + 
'\n') + 'Reason for sending back to MKT is missing'

WebUI.verifyMatch(Actual_toastr1, Expected_toastr1, false)

'Click on cancel'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/a']))

WebUI.delay(1)

'Screenshot: Ref list page '
WebUI.takeScreenshot()

'click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[15]/a[2]']))

WebUI.delay(1)

'Screenshot: Ref modif page '
WebUI.takeScreenshot()

'Question: refuse '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/button']))

WebUI.delay(1)

'Click on 2nd option'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/div/a[2]']))

WebUI.delay(1)

'Screenshot: Ref modif page '
WebUI.takeScreenshot()

WebUI.delay(1)

'Set text: Reason for sending back to MKT'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_151"]']), 'Reason for sending back to MKT > Test')

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[2]']))

'Get task no'
Double task3_apetit = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

WebUI.verifyEqual(task3_apetit + 1, task2_apetit)

'Logout'
functions.I.Logout()

///////////////////////////Mother ref > RESFUSE DMI: Brief completion
'Login as aomoto '
functions.I.Login_password('aomoto', password_aomoto)

'Screenshot: Dashboard page '
WebUI.takeScreenshot()

Double task5_aomoto = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div']))

WebUI.delay(1)

int c = 1

//COMPLETE & SEND Common Brief: TC18_AUTO_MOTHERREF_Fake_Beauty Seal_100CM2_ - CeraVe_Acne_2022_AutoTag_FullLifecyle_iSK_mars032022_075344
while (c <= task5_aomoto) {
    result10 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[2]/a[' + 
                c) + ']']))

    if (result10.contains('COMPLETE & SEND Common Brief: TC18_AUTO_MOTHERREF_Fake_Beauty Seal_100CM2_ - CeraVe_Acne_2022_' + 
        Project_name)) {
        WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[2]/a[' + 
                    c) + ']']))

        c = (c + 1)

        break
    } else {
        c = (c + 1)
    }
}

'Screenshot: ref list page '
WebUI.takeScreenshot()

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[15]/a[3]']))

WebUI.delay(1)

'Screenshot: ref modif page '
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

Double task6_aomoto = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

WebUI.verifyEqual(task6_aomoto + 1, task5_aomoto)

'Logout'
functions.I.Logout()

///////////////////////QUESTION OPTION 1
'Login as apetit '
functions.I.Login_password('apetit', password_apetit)

'Screenshot: Ref modif page '
WebUI.takeScreenshot()

'Get task no'
Double task10_apetit = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

int pl = 1

while (pl <= task10_apetit) {
    zz = (pl + 1)

    result = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('/html/body/div[1]/div[2]/div[4]/div[3]/div/div[5]/div[2]/div[1]/div/div[2]/div/div/table/tbody/tr[' + 
                zz) + ']/td[1]/a']), FailureHandling.OPTIONAL)

    if (result.contains('COMPLETE & SEND Common Brief: TC18_AUTO_MOTHERREF_Fake_Beauty Seal_100CM2_ - CeraVe_Acne_2022_' + 
        Project_name)) {
        WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('/html/body/div[1]/div[2]/div[4]/div[3]/div/div[5]/div[2]/div[1]/div/div[2]/div/div/table/tbody/tr[' + 
                    zz) + ']/td[1]/a']))

        break
    } else {
        pl = (pl + 1)
    }
}

'Screenshot: Ref list page '
WebUI.takeScreenshot()

WebUI.delay(1)

'click on submit'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[15]/a[2]']))

WebUI.delay(1)

'Screenshot: Ref modif page '
WebUI.takeScreenshot()

'Question: Submit '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/button']))

WebUI.delay(1)

'Click on 1st option'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/div/a[1]']))

WebUI.delay(1)

'Get task no'
Double task9_apetit = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]')

WebUI.verifyEqual(task9_apetit, task10_apetit - 1)

WebUI.delay(1)

String lifecycle_1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + 
            '"]/td[14]/span']))

WebUI.verifyMatch(lifecycle_1, 'Complete', false)

//Write NOTEPAD
functions.I.writenotepad('D:\\Upoad_File\\Projet_ Login\\Tag\\18.01 Tag _Project_No\\18.01_Tag_ProjectNo.txt', Project_No)

functions.I.writenotepad('D:\\Upoad_File\\Projet_ Login\\Tag\\18.01 Tag _Project_No\\18.01_Tag_refID1.txt', refID)

functions.I.writenotepad('D:\\Upoad_File\\Projet_ Login\\Tag\\18.01 Tag _Project_No\\18.01_Tag_refID2.txt', refID_1)

