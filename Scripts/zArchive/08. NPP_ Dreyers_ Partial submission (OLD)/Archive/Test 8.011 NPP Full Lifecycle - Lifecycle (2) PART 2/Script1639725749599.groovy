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

/////////////////////////////SCENARIO NPP : LSS LIFECYCLE (2) /////////////////////
//STEP 1: CREATION > On test case 8.01

//Step 2 : Approval
//Phase 1
//Added Phase for Roads
//Phase 2" PX approval

//Step3 : Translation
//Step 4 : Ready for use
//Step 5 : Effective
//Step 6 : Deactive
///////////////////////////USERNAME - PASSWORD - URL////////////////////////////////////
//USERNAME & PASSWORD  - NPP
def data_Npp = TestDataFactory.findTestData('Data Files/Username_Password/Npp')

String password_ncur = data_Npp.getValue(2, 1)

String password_akim = data_Npp.getValue(2, 2)

String password_sschunke = data_Npp.getValue(2, 3)

String password_abrazhnikovapx = data_Npp.getValue(2, 4)

String password_afrappaz = data_Npp.getValue(2, 5)

String password_alarkins = data_Npp.getValue(2, 6)

String password_cdemonchy = data_Npp.getValue(2, 7)

String password_agaudin	= data_Npp.getValue(2,8)

String password_achaves	= data_Npp.getValue(2,9)

///
def data_urlRELAUTO = TestDataFactory.findTestData('Data Files/URL/URL_relauto')

String Url_Npp = data_urlRELAUTO.getValue(2, 5)

////////////////////////////NAVIGATE TO NPP ///////////////////////////////////
String Project_No = functions.I.readnotepad('C:\\Users\\lamhe\\Desktop\\Upoad_File\\Projet NPP\\8.01_NPP_part1_ProjectNo.txt')

'Navigate to NPP'
WebUI.openBrowser(Url_Npp)


WebUI.maximizeWindow()

'Screenshot: Navigate to Npp'
WebUI.takeScreenshot()

////////////////////////////STEP 2: APPROVAL///////////////////////////////////
///////////////////////////PHASE 1 : PP APPROVAL > Refuse /////////////
'Log in as Product Platform – All users'
functions.I.Login_password('agaudin', password_agaudin)

'Screenshot: Log as Product manager'
WebUI.takeScreenshot()

'Go to the project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

WebUI.delay(1)
'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[19]/button')

WebUI.delay(5)

'Screenshot: Ref list page - Step 2 : Approva; / Phase 1: Prefill  '
WebUI.takeScreenshot()

'Question phase: Click on Submit - Roads'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[12]/div[2]/button']))
WebUI.delay(2)
'Screenshot: Question phase  '
WebUI.takeScreenshot()

WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[12]/div[2]/div/a[2]']))

'Screenshot: Roads  '
WebUI.takeScreenshot()

WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[12]/div[2]/div/a[2]']))
 
'Enter text'
WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="var_101"]']), 'Reason for refusal - PP Specialist - text')
 
'Click on refuse LSS'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

'Screenshot: Ref List page - Lifecycle LSS Edition'
WebUI.takeScreenshot()

'Logout'
functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[2]')


////////////////////////////STEP 2: APPROVAL///////////////////////////////////
///////////////////////////ADDED PHASE  : LSS Edition PP /////////////

'Log in as akim'
functions.I.Login_password('akim', password_akim)

'Screenshot: Log as ana kim'
WebUI.takeScreenshot()

'Go to the project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

WebUI.delay(1)
'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[19]/button')

WebUI.delay(5)

'Screenshot: Ref list page - Step 2 : Approval /Phase: LSS Edition PP '
WebUI.takeScreenshot()

'Ref List page: Click on Submit '
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[9]/a']))
WebUI.delay(2)

'Select Value from texture'
functions.I.select_multiplelist('//*[@id="selSource_108"]', '//*[@id="btnAdd_108"]', '2357')

'Ref modif page: Click on Submit '
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))

////////////////////////////STEP 2: APPROVAL///////////////////////////////////
///////////////////////////PHASE 1 : PP APPROVAL > Approve /////////////
'Log in as Product Platform – All users'
functions.I.Login_password('agaudin', password_agaudin)

'Screenshot: Log as Product manager'
WebUI.takeScreenshot()

'Go to the project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

WebUI.delay(1)
'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[19]/button')

WebUI.delay(5)

'Screenshot: Ref list page - Step 2 : Approval / Phase 1: Prefill  '
WebUI.takeScreenshot()

'Question phase: Click on Submit'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[12]/div[2]/button']))
WebUI.delay(2)
'Screenshot: Question phase  '
WebUI.takeScreenshot()

'agaudin approve'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="fiches"]/table/tbody/tr/td[12]/div[2]/div/a[1]']))

'Screenshot: ref modif page  '
WebUI.takeScreenshot()

'On the modif ref page, click on approve'
functions.I.submitquesiton_ref(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/button']), findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/div/a[1]']))

'Screenshot: Ref List page - PX Approval'
WebUI.takeScreenshot()

'Logout'
functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[2]')

////////////////////////////STEP 2: APPROVAL///////////////////////////////////
///////////////////////////PHASE 2 : PX Approval > Approve /////////////

'Log in as akim'
functions.I.Login_password('afrappaz', password_afrappaz)

'Screenshot: Log as afrappaz'
WebUI.takeScreenshot()

'Go to the project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

WebUI.delay(1)
'search for the project number'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[19]/button')

WebUI.delay(5)

'Screenshot: Ref list page - Step 2 : Approval /Phase 2 : PX Approval '
WebUI.takeScreenshot()

'Ref List page: Click on Submit '
functions.I.submitquesiton_ref(findTestObject('xxx Todelete/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[14]/div[2]/button']), findTestObject('xxx Todelete/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[14]/div[2]/div/a[1]']))

'Screenshot: ref modif page  '
WebUI.takeScreenshot()

'On the modif ref page, click on approve'
functions.I.submitquesiton_ref(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/button']), findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/div/div/a[1]']))

'Screenshot: Ref List page - Nutritionist Approval'
WebUI.takeScreenshot()

'Logout'
functions.I.Logout_xpath('//*[@id="kt_header"]/div/div[2]/div[2]/div[1]/div/span/img', '//*[@id="kt_header"]/div/div[2]/div[2]/div[2]/a[2]')

////////////////////////////STEP 2: APPROVAL///////////////////////////////////
///////////////////////////PHASE 3 : PX Approval > Approve /////////////

functions.I.Login_password('achaves', password_achaves)