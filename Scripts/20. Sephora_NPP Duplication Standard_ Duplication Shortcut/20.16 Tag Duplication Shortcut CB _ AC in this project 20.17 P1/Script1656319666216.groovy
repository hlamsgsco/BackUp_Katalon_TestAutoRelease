import org.apache.commons.collections.map.ReferenceIdentityMap as ReferenceIdentityMap
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
import jdk.nashorn.internal.codegen.FunctionSignature as FunctionSignature
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
functions.I.clearnotepad('D:\\Upoad_File\\Projet_ Login\\Tag\\20.16 Tag _Project_No\\20.16_Tag_ProjectNo.txt')

functions.I.clearnotepad('D:\\Upoad_File\\Projet_ Login\\Tag\\20.16 Tag _Project_No\\20.16_Tag_refID1.txt')

functions.I.clearnotepad('D:\\Upoad_File\\Projet_ Login\\Tag\\20.16 Tag _Project_No\\20.16_Tag_refID2.txt')


functions.I.clearnotepad('D:\\Upoad_File\\Projet_ Login\\Tag\\20.16 Tag _Project_No\\20.16_Tagdupli_refID1.txt') // Dupli mother

functions.I.clearnotepad('D:\\Upoad_File\\Projet_ Login\\Tag\\20.16 Tag _Project_No\\20.16_Tagdupli_refID2.txt') // Dupli daughter

///////////////////////////// TEST BEGIN /////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag Release'
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

'Screenshot: Navigate to URL Tag Release'
WebUI.takeScreenshot()

// DMI ACE CEREAVE CREATION OF PROJECT
'Login as jedun '
functions.I.Login_password('jedun', password_jedun)

'Click on the lhs menu - project tab'
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///CREATION OF PROJECT
'Click on + to create project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div/div[1]/div[2]/a[1]']))

WebUI.delay(1)

'Select project template'
functions.I.SelectFromList_Value('//*[@id="project_template"]', '11')

'Click create project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))

WebUI.delay(1)

//Modif Project
'Screenshot: Modify  a project'
WebUI.takeScreenshot()

def Project_name = (('AutoTag_Duplication_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(3)) + '_') + 
functions.I.gettimedate()

'Enter Project name'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_141"]']), 'TC20.16_' + Project_name)

'Project type - LAUNCH: New range, new product'
functions.I.SelectFromList_Value('//*[@id="var_12"]', '1025')

'domain: Packaging'
functions.I.SelectFromList_Value('//*[@id="var_116"]', '1070')

'Development zone - Zone Europe'
functions.I.SelectFromList_Value('//*[@id="var_262"]', '16352')

'Enter PAD date 10/10/2020'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_14"]']), '10/10/2020')

WebUI.delay(2)

'Verify that Division - ACD'
functions.I.SelectFromList_Value('//*[@id="var_15"]', '19')

WebUI.delay(2)

' Verify that Signature - CeraVe'
functions.I.SelectFromList_Value('//*[@id="var_16"]', '555')

WebUI.delay(2)

'VErify that Franchise  - CeraVe'
functions.I.VerifyMatchText('//*[@id="select2-var_17-container"]', ('×' + '\n') + 'CeraVe')

WebUI.delay(2)

'Select Brand - Acne'
functions.I.SelectFromList_Value('//*[@id="var_18"]', '14527')

'Select SubBrand - Acne Body Wash'
functions.I.SelectFromList_Value('//*[@id="var_19"]', '15641')

'Select Axis - Fragrance'
functions.I.SelectFromList_Value('//*[@id="var_20"]', '3773')

'Select SubAxis - Men Fragrance'
functions.I.SelectFromList_Value('//*[@id="var_21"]', '246')

'Select Metier - Men fragrances '
functions.I.SelectFromList_Value('//*[@id="var_22"]', '3854')

'Verify DMI contact is selected - David Aguirre'
functions.I.select_multiplelist('//*[@id="selSource_23"]', '//*[@id="btnAdd_23"]', 'daguirre')

'Select another dmi - aomoto'
functions.I.select_multiplelist('//*[@id="selSource_23"]', '//*[@id="btnAdd_23"]', 'aomoto')

WebUI.delay(1)

'Select C&A contacts - apetit'
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

'Click on + create ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/button']))

WebUI.delay(1)

'Click on 1st option: create ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="create_ref_btn"]/div/a[1]']))

WebUI.delay(1)

'Screenshot: Ref creation page '
WebUI.takeScreenshot()

'Select Reference Template - Multiple artwork without master design '
functions.I.SelectFromList_Value('//*[@id="ref_type"]', '8')

'Click on save'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="createRefBottom"]']))

'Screenshot: Ref modif page '
WebUI.takeScreenshot()

'Enter mkt product name'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_117"]']), 'TC_AUTO_MOTHERREF')

'Select Product category -Fake '
functions.I.SelectFromList_Value('//*[@id="var_57"]', '134')

'Select Packaging Family - Beauty Seal '
functions.I.SelectFromList_Value('//*[@id="var_28"]', '1194')

'Select Packaging type -  Secondary'
functions.I.SelectFromList_Value('//*[@id="var_228"]', '15723')

'Enter Capacity: 100'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_54"]']), '100')

'Select Capacity Unit - CM2'
functions.I.SelectFromList_Value('//*[@id="var_55"]', '122')

'Get the Ref id'
String refID = functions.I.RefID_tag()

WebUI.delay(2)

WebUI.scrollToElement(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_91"]']), 2)

'Click on save'
functions.I.click_button_javascriptS('/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/form/div[3]/div[1]/button')

WebUI.delay(2)

'super edit'
functions.I.superedit_ref(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[15]/div[2]/button']), 
    findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[15]/div[2]/div/a[4]']))

'Screenshot: ref modif page '
WebUI.takeScreenshot()

'Select 00002309 - AUTAJON LABELS | FRA, Clermont-Ferrand'
functions.I.SelectFromList_Value('//*[@id="var_48"]', '925')

'Enter Printer : 200192562A'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_27"]']), '200192562A')

'124 Click update'
functions.I.click_button_javascriptS('//*[@id="ModifFiche"]/div[1]/div/button')

WebUI.delay(2)

//CREATE DAUGHTER REF
'ref  page: click on + button to create a daughter ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[15]/div[1]/button']))

WebUI.delay(1)

'Select AC as daughter ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID) + '"]/td[15]/div[1]/div/a[1]']))

WebUI.delay(1)

'Select Lifecycle'
functions.I.SelectFromList_Value('//*[@id="lfc_tpl"]', '94')

'Screenshot:Daughter  Ref creation page '
WebUI.takeScreenshot()

'click on create ref'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="createRefTop"]']))

'delay'
WebUI.delay(1)

'Screenshot: Ref modif page '
WebUI.takeScreenshot()

'Select local artwork agency - Agence - Shadow Production '
functions.I.SelectFromList_Value('//*[@id="var_67"]', '15917')

'Select Language - Arabic'
functions.I.select_multiplelist('//*[@id="selSource_10"]', '//*[@id="btnAdd_10"]', '1305')

'ref modif page: click save'
functions.I.click_button_javascriptS('//*[@id="type_save"]')

'Click on ref id of the daughter ref'
String refID1 = functions.I.href_RefID_Tag('/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[8]/a')

functions.I.Logout()

'Login as suser '
functions.I.Login_password('suser', password_suser)

'LHS click the project tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="menu_2"]/a']))

'Search project no'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[4]/button')

WebUI.delay(1)

//REF LIST PAGE
'Click on the duplicate button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/div[1]/button']))

'Screenshot: ref List page '
WebUI.takeScreenshot()

WebUI.delay(1)

//SELECT DUPLI
'Select dupli option Duplicate CB + AC in this project'
String dupli_option1 = 'Duplicate CB + AC in this project'

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

'Select all '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_"]/th[1]/label']))

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
WebUI.verifyElementNotPresent(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="list_project_type"]/label[2]']), 
    3)

//MOTHER REF
int u = 1

while (u <= 2) {
    String ref_template1 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : ('/html/body/div[1]/div[2]/div[5]/form/div/div/div/div[2]/div/div[10]/div[2]/div/div[' + 
                u) + ']/div/span']))

    if (ref_template1 == 'Artwork Brief (AC)') {
        'Verify that ref template = Marketing project is selected'
        functions.I.VerifyMatchText('//*[@id="select2-ref_tpl7-container"]', 'Artwork Brief (AC)')

        'Verify that lifecycle template = Marketing project is selected'
        functions.I.VerifyMatchText('//*[@id="select2-lfc_tpl7-container"]', 'G - Create an US Artwork - Repro document (managed by C&A Europe)')

        u = (u + 1) //DAUGHTER REF
    } else {
        'Verify that ref template = Multiple artwork without master design is selected'
        functions.I.VerifyMatchText('//*[@id="select2-ref_tpl8-container"]', 'Multiple artwork without master design')

        'Verify that lifecycle template = Marketing project is selected'
        functions.I.VerifyMatchText('//*[@id="select2-lfc_tpl8-container"]', '0 - Common Brief only')

        u = (u + 1)
    }
}

//Name of the Duplicate button
'Verify that name of the duplication'
functions.I.VerifyMatchText('//*[@id="btn_submit_duplication"]', 'Duplicate CB + AC in this project')

'Click Duplicate'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_submit_duplication"]']))

//USER IS REDIRECTED TO THE DUPLICATED PROJECT
WebUI.delay(2)

'Get the project no.'
String Project_No2 = functions.I.ProjectNo()

WebUI.verifyMatch(Project_No2, Project_No, false)

'Verify no of ref in the project'
functions.I.VerifyMatchText('//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[1]/h1/span', '4')

//Name of ref & GET REF id
'117'
functions.I.SearchRefNo_xpath('Copy 1', '//*[@id="fiche_filter_keywords11"]', '//*[@id="form_filters"]/div[4]/button')

String refID_Mother_Dupli = functions.I.href_RefID_Tag('/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[8]/a[1]')

String refID_daughter_Dupli = functions.I.href_RefID_Tag('/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[8]/a')

//MOTHER REF
'Click on the mother ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_Mother_Dupli) + '"]/td[8]/a[1]']))

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

WebUI.verifyMatch(refIDA, refID, false)

'Click on the breadcrum'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))

WebUI.delay(1)

//DAUGHTER REF
'Click on the daughter ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : ('//*[@id="source_' + refID_daughter_Dupli) + '"]/td[8]/a[1]']))

WebUI.delay(1)

'Click on  parent link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_view_ref_parent"]']))

WebUI.delay(1)

'Screenshot: Parent daughter ref '
WebUI.takeScreenshot()

WebUI.delay(1)

String refIDB = functions.I.RefID_tag()

WebUI.verifyMatch(refIDB, refID1, false)

////write notepad
functions.I.writenotepad('D:\\Upoad_File\\Projet_ Login\\Tag\\20.16 Tag _Project_No\\20.16_Tag_ProjectNo.txt', Project_No) //Project no

functions.I.writenotepad('D:\\Upoad_File\\Projet_ Login\\Tag\\20.16 Tag _Project_No\\20.16_Tag_refID1.txt', refID) //Mother ref

functions.I.writenotepad('D:\\Upoad_File\\Projet_ Login\\Tag\\20.16 Tag _Project_No\\20.16_Tag_refID2.txt', refID1) // Daughter ref

functions.I.writenotepad('D:\\Upoad_File\\Projet_ Login\\Tag\\20.16 Tag _Project_No\\20.16_Tagdupli_refID1.txt', refID_Mother_Dupli) // Dupli mother

functions.I.writenotepad('D:\\Upoad_File\\Projet_ Login\\Tag\\20.16 Tag _Project_No\\20.16_Tagdupli_refID2.txt', refID_daughter_Dupli ) // Dupli daughter



WebUI.closeBrowser()

