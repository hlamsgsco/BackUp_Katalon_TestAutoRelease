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

//DATA FIELD USERNAME_PASSWORD (TAG)
def data_Tag = TestDataFactory.findTestData('Data Files/Username_Password/Tag')

String password_jedun = data_Tag.getValue(3, 1)

String password_rrowland = data_Tag.getValue(3, 2)

String password_stest = data_Tag.getValue(3, 3)

String password_itroin = data_Tag.getValue(3, 4)

String password_igedik = data_Tag.getValue(3, 2)

String password_mderdour = data_Tag.getValue(3, 6)

String password_achatin = data_Tag.getValue(3, 7)

String password_tliu = data_Tag.getValue(3, 8)

String password_ccaramella = data_Tag.getValue(3, 9)

String password_achay = data_Tag.getValue(3, 10)

String password_cbono = data_Tag.getValue(3, 11)

String password_pmareri = data_Tag.getValue(3, 12)

String password_qeuzen = data_Tag.getValue(3, 13)

String password_alanglois = data_Tag.getValue(3, 14)

String password_bde_villeneuve = data_Tag.getValue(3, 12)

String password_scai = data_Tag.getValue(3, 16)

String password_bzavaglia = data_Tag.getValue(3, 17)

String password_asamyn = data_Tag.getValue(3, 18)

String password_idiaz = data_Tag.getValue(3, 19)

String password_asalama = data_Tag.getValue(3, 20)

String password_suser = data_Tag.getValue(3, 21)

String password_etaraskin = data_Tag.getValue(3, 22)

String task_alafon_after1 = data_Tag.getValue(3, 23)

String password_sguy = data_Tag.getValue(3, 24)

String password_asch = data_Tag.getValue(3, 25)

String password_bmartin = data_Tag.getValue(3, 26)

String password_icoindeau = data_Tag.getValue(3, 27 // DO NOT USE THIS USER IN OTHER TC
    )

String password_alafon = data_Tag.getValue(3, 28 // DO NOT USE THIS USER IN OTHER TC
    )

//DATA FIELD URL
def data_urlRELAUTO = TestDataFactory.findTestData('Data Files/URL/URL_relauto')

String Url_Tag = data_urlRELAUTO.getValue(2, 3)

/* icoindeau / alafon - task 0 before starting 
 * 
 * TO CONTINUE WITH 3405
 * SCENARIO TESTED: FULLL LIFECYCLE 
 

VERIFICATION OF TASK
SCENARIO 1: CREATION OF REF > TASK ADDED & REMOVED - STANDARD PHASE
SCENARIO 2: QUESTION PHASE > TASK ADDED & REMOVED - TAKING ROADS
SCENARIO 3 : QUESTION PHASE > PROCEED TO NEXT PHASE 
 */


///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag Release'
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

'Screenshot: Navigate to URL Tag Release'
WebUI.takeScreenshot()

'Login as Isabelle '
functions.I.Login_password('icoindeau', password_icoindeau)

'Verify task before creation of ref'
double task_isa_before1 = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div')

functions.I.print('task_isa_before1 > ' + task_isa_before1)

WebUI.verifyEqual(0, task_isa_before1)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///CREATION OF PROJECT
'Click on + to create project'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/a[1]']))

WebUI.delay(1)

'Screenshot: Modify  a project'
WebUI.takeScreenshot()

'Enter Project name'
def Project_name = (('AutoTag_FullLifecyle_Task_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(3)) + '_') + 
functions.I.gettimedate()

WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_141"]']), 
    Project_name)

'Project type - LAUNCH: New range, new product'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_12"]']), 
    '1025', false)

'Domain - Coffrets'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_116"]']), 
    '15711', false)

'Development zone - Zone Europe'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_262"]']), 
    '16352', false)

'Enter PAD date'
WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_14"]']), 
    '10/10/2020')

WebUI.delay(2)

'Franchise - Biotherm Homme '
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_17"]']), 
    '6343', false)

WebUI.delay(3)

'Brand - Ancien Soin Homme'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_18"]']), 
    '7582', false)

WebUI.delay(1)

'Axis - Fragrance'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_20"]']), 
    '3773', false)

WebUI.delay(1)

'34 DMI contacts '
functions.I.select_multiplelist('//*[@id="selSource_23"]', '//*[@id="btnAdd_23"]', 'jyaiche')

WebUI.delay(1)

'C&A contacts'
functions.I.select_multiplelist('//*[@id="selSource_24"]', '//*[@id="btnAdd_24"]', 'alafon')

WebUI.delay(5)

'Click on update project'
WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Update'))

WebUI.delay(2)

'Get project no.'
String Project_No = functions.I.ProjectNo()

'Screenshot: Ref List page '
WebUI.takeScreenshot()

//SCENARIO 1: CREATION OF REF : TASK ADDED & REMOVED - STANDARD PHASE
//CREATE REF
'Click on + to create a ref'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

'Click on create a brief'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a']))

'Screenshot: Ref creation page '
WebUI.takeScreenshot()

'Select ref template - Multiple artworks with a master design (for TR and Coffrets)'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ref_type"]']), 
    '14', false)

'Click on create a brief'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="createRefTop"]']))

WebUI.delay(1)

'Get the Ref id'
String refID = functions.I.RefID_tag()

WebUI.delay(1)

//MODIF OF THE REF
'Screenshot: modif Ref  page '
WebUI.takeScreenshot()

'Delay 1'
WebUI.delay(1)

'Enter Marketing Product name'
WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_117"]']), 
    'MKT_AUTOTEST_REF_MOTHER_1')

'Delay 1'
WebUI.delay(1)

'Select Product Category - Fake'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_57"]']), 
    '134', false)

'Delay 1'
WebUI.delay(1)

'Select Product Category - Fake'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_57"]']), 
    '134', false)

'Delay 1'
WebUI.delay(1)

'Select Packaging family - Accessory'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_28"]']), 
    '15738', false)

'Delay 1'
WebUI.delay(1)

'Select International Artwork Agency - Agence - Shadow Production'
WebUI.selectOptionByValue(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_50"]']), 
    '15917', false)

'Delay 1'
WebUI.delay(1)

functions.I.Pagedown()

'85 Click on update'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="type_save"]']))

'Delay 1'
WebUI.delay(1)

'Screenshot: modif Ref  page '
WebUI.takeScreenshot()

'Verify task before creation of ref'
double task_isa_after1 = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div')

'Verify that the no of task has increased by 1'
WebUI.verifyEqual(task_isa_before1, task_isa_after1 - 1)

'Go to Dashboard'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_aside_menu"]/ul/li[1]/a/span[2]']))

'Delay 1'
WebUI.delay(1)

'Click on task'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div']))

'Delay 1'
WebUI.delay(1)

'Click 1st task'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div']))

'Delay 1'
WebUI.delay(1)

//REF LIST PAGE
'Screenshot: Ref list page '
WebUI.takeScreenshot()

'Click on submit'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : ('//*[@id="source_' + 
            refID) + '"]/td[13]/a[3]']))

'Delay 1'
WebUI.delay(1)

'Click on submit'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'Verify task before creation of ref'
double task_isa_after2 = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div')

WebUI.verifyMatch(0, task_isa_before1, false)

'Logout'
functions.I.Logout()

/////////////////////////////////////////////////////////
// SCENARIO 2: QUESTION PHASE > TASK ADDED & REMOVED - TAKING ROADS
'Login as alafon '
functions.I.Login_password('alafon', password_alafon)

'Delay 1'
WebUI.delay(1)

'Verify task before creation of ref'
double task_alafon_before1 = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div')

'Click on task'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div']))

'Delay 1'
WebUI.delay(1)

'Click 1st task'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div']))

'Delay 1'
WebUI.delay(1)

//REF LIST PAGE
'Screenshot: ref list page'
WebUI.takeScreenshot()

'Click on submit'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : ('//*[@id="source_' + 
            refID) + '"]/td[13]/a[2]']))

'Delay 1'
WebUI.delay(1)

'Screenshot: modif ref page'
WebUI.takeScreenshot()

'Click on submit'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/button']))

'Delay 1'
WebUI.delay(1)

'Screenshot: Question pahse'
WebUI.takeScreenshot()

'Delay 1'
WebUI.delay(1)

'Click on submit -road 1'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/div/a[2]']))

'Delay 1'
WebUI.delay(1)

'Screenshot: Question pahse - road 1'
WebUI.takeScreenshot()

WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_151"]']), 
    (Project_name + 'Reason for sending back ') + refID)

'Click on refuse button'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[2]']))

'Delay 1'
WebUI.delay(1)

'Screenshot: ref listp page'
WebUI.takeScreenshot()

'Verify task before creation of ref'
double task_alafon_after2 = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div')

WebUI.verifyMatch(task_alafon_after2, task_alafon_before1, false)

'Logout'
functions.I.Logout()

//ROADS 1
'Login as Isabelle '
functions.I.Login_password('icoindeau', password_icoindeau)

'Verify task before creation of ref'
double task_isa_b1 = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div')

'Click on task'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div']))

'Delay 1'
WebUI.delay(1)

'Get Text '
String task1 = WebUI.getText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[2]/a/div[2]/span[1]']))

WebUI.verifyMatch(task1, 'COMPLETE & SEND Common Brief: MKT_AUTOTEST_REF_MOTHER_1_Fake_Accessory_ - +Biotherm_Ancien Soin Homme_2022_' + 
    Project_name, false)

'Delay 1'
WebUI.delay(1)

'Click 1st task'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div']))

'Delay 1'
WebUI.delay(1)

//REF LIST PAGE
'Screenshot: ref list page'
WebUI.takeScreenshot()

'Click on submit'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : ('//*[@id="source_' + 
            refID) + '"]/td[13]/a[3]']))

'Delay 1'
WebUI.delay(1)

'Click on submit'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'Verify task before creation of ref'
double task_isa_aft1 = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div')

WebUI.verifyMatch(task_isa_aft1 - 1, task_isa_b1, false)

'Logout'
functions.I.Logout()

//SCENARIO 3 : QUESTION PHASE - PROCEED TO NEXT PHASE
'Login as alafon '
functions.I.Login_password('alafon', password_alafon)

'Delay 1'
WebUI.delay(1)

'Verify task before creation of ref'
double task_alafon_bb1 = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div')

'Click on task'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div']))

'Delay 1'
WebUI.delay(1)

'Get Text '
String task2 = WebUI.getText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[2]/form/div[2]/a/div[2]/span[1]']))

WebUI.verifyMatch(task2, 'COMPLETE & SEND Common Brief: MKT_AUTOTEST_REF_MOTHER_1_Fake_Accessory_ - +Biotherm_Ancien Soin Homme_2022_' + 
    Project_name, false)

'Delay 1'
WebUI.delay(1)

'Click 1st task'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div']))

'Delay 1'
WebUI.delay(1)

//REF LIST PAGE
'Screenshot: ref list page'
WebUI.takeScreenshot()

'Click on submit'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : ('//*[@id="source_' + 
            refID) + '"]/td[13]/a[2]']))

'Delay 1'
WebUI.delay(1)

'Screenshot: modif ref page'
WebUI.takeScreenshot()

'Click on submit'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/button']))

'Delay 1'
WebUI.delay(1)

'Screenshot: Question pahse'
WebUI.takeScreenshot()

'Delay 1'
WebUI.delay(1)

'Click on submit - 1ST OPTION'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/div/a[1]']))

'Verify task before creation of ref'
double task_alafon_AA1 = functions.I.Get_Task_No('//*[@id="kt_header"]/div/div[2]/div[1]/div[1]/div')

WebUI.verifyMatch(task_alafon_AA1 - 1, task_alafon_bb1, false)

