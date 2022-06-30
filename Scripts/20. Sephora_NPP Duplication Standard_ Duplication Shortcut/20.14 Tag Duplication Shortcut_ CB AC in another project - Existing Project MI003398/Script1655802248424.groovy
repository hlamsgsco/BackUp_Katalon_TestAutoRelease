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

/*
 * jedun,diadeis,dchi,1
rrowland,diadeis,dchi,2
stest,diadeis,dchi,3
itroin,diadeis,dchi,4
igedik,diadeis,dchi,5
mderdour,diadeis,dchi,6
achatin,diadeis,dchi,7
tliu,diadeis,dchi,8
ccaramella,diadeis,dchi,9
achay,diadeis,dchi,10
cbono,diadeis,dchi,11
pmareri,diadeis,dchi,12
qeuzen,diadeis,dchi,13
alanglois,diadeis,dchi,14
bde_villeneuve,dchi,dchi,15
scai,dchi,dchi,16
bzavaglia,dchi,dchi,17
mraoul,dchi,dchi,18
idiaz,dchi,dchi,19
asalama,dchi,dchi,20
suser,dchi,dchi,21
etaraskin,dchi,dchi,22
avieu_brasseur,dchi,dchi,23
sguy,dchi,dchi,24
asch,dchi,dchi,25
bmartin,dchi,dchi,26
icoindeau,dchi,dchi,27,DO NOT USE
alafon,dchi,dchi,28,DO NOT USE
aamiot,dchi,dchi,29
daguirre,dchi,dchi,30
aomoto,dchi,dchi,31
apetit,dchi,dchi,32
asamyn,dchi,dchi,33
mcazeaux,dchi,dchi,34
kmullen,dchi,dchi,35

 */

//CLEAR FROM NOTEPAD TC 20.14
functions.I.clearnotepad('D:\\Upoad_File\\Projet_ Login\\Tag\\20.14 Tag _Project_No\\20.14_Tag_ProjectNo.txt')

functions.I.clearnotepad('D:\\Upoad_File\\Projet_ Login\\Tag\\20.14 Tag _Project_No\\20.14_Tag_refID1.txt')


//DATA FIELD USERNAME_PASSWORD (TAG)
def data_Tag = TestDataFactory.findTestData('Data Files/Username_Password/Tag')

String password_hmaziere = data_Tag.getValue(3, 36) //R
	
//DATA FIELD URL
def data_urlRELAUTO = TestDataFactory.findTestData('Data Files/URL/URL_relauto')

String Url_Tag = data_urlRELAUTO.getValue(2, 3)


String Project_No ='MI003398'
///////////////////////////// TEST BEGIN /////////////////////////////////////////


//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Tag Release'
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

'Screenshot: Navigate to URL Tag Release'
WebUI.takeScreenshot()

'Login as hmaziere '
functions.I.Login_password('hmaziere', password_hmaziere)

'LHS click the project tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="menu_2"]/a']))

'Search project no'
functions.I.SearchProjectNo_xpath(Project_No, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[8]/button')

WebUI.delay(1)


//REF LIST PAGE
'Click on the duplicate button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[2]/span/div[1]/button']))

'Screenshot: ref List page '
WebUI.takeScreenshot()

WebUI.delay(1)

//SELECT DUPLI
'Select dupli option CB AC in another project'
String dupli_option1 = 'Duplicate CB + AC in another project'

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


'Select all refs '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_"]/th[1]/label']))

WebUI.delay(1)

'Screenshot: ref List page '
WebUI.takeScreenshot()



'Click on confirm  '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="action_btnduplicatereference"]']))

WebUI.delay(1)



'Screenshot: Dupli popup'
WebUI.takeScreenshot()

WebUI.delay(1)

'Click on new project option'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="list_project_type"]/label[2]']))

WebUI.delay(1)

//PROJ TEMP:ATE
'Verify that Project template = Marketing project is selected'
functions.I.VerifyMatchText('//*[@id="select2-project_template-container"]', 'Marketing project (Pack)')

//MOTHER REF
'Verify that ref template = Marketing project is selected'
functions.I.VerifyMatchText('//*[@id="select2-ref_tpl5-container"]', 'Multiple artworks with a master design')

'Verify that lifecycle template = Marketing project is selected'
functions.I.VerifyMatchText('//*[@id="select2-lfc_tpl5-container"]', '0 - Common Brief with Master Design')


//DAUGHTER REF
'Verify that ref template = Artwork Brief (AC) is selected'
functions.I.VerifyMatchText('//*[@id="select2-ref_tpl7-container"]', 'Artwork Brief (AC)')

'Verify that lifecycle template = Marketing project is selected'
functions.I.VerifyMatchText('//*[@id="select2-lfc_tpl7-container"]', 'D - Create an Artwork - Repro document (by printer)')

//Name of the Duplicate button
'Verify that name of the duplication'
functions.I.VerifyMatchText('//*[@id="btn_submit_duplication"]', 'Duplicate CB + AC in another project')

'Click Duplicate'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_submit_duplication"]']))

//USER IS REDIRECTED TO THE DUPLICATED PROJECT
WebUI.delay(2)

'Get the project no.'
String Project_No2 = functions.I.ProjectNo()

WebUI.verifyNotMatch(Project_No2, Project_No, false)

'Screenshot: USER IS REDIRECTED TO THE DUPLICATED PROJECT'
WebUI.takeScreenshot()

'Verify no of ref in the project'
functions.I.VerifyMatchText('//*[@id="kt_content"]/div[3]/div/div[2]/div[1]/div[1]/h1/span', '5')
 
//Name of ref & GET REF id

//1. MOTHER REF
'Verify the mother name of the ref'
functions.I.VerifyMatchText('/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[8]/a[1]', 'Copy 1 of SAS_PART_4_Other_Bottom_100OZ_')
 
String refID1 = functions.I.href_RefID_Tag('/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[8]/a[1]')

'Verify the 1 name of daughter ref'
String daughterref_name2 = WebUI.getText(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[8]/a']))

if (daughterref_name2.contains('Copy 1 of SAS_PART_4_Other_Bottom_100OZ'))
{
	WebUI.verifyEqual('1', '1')
}

String refID2 = functions.I.href_RefID_Tag('/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[8]/a')

//VIEW PROJECT LEVEL

'Click view Project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_project"]/div[2]/div/div[3]/a[3]']))

WebUI.delay(2)

'Screenshot:view Project '
WebUI.takeScreenshot()

//PROJECT INFO
'Verify that Project name field is not copied'
functions.I.VerifyMatchText('//*[@id="var_141"]', '')

'Verify that Magellan project number field is not copied'
functions.I.VerifyMatchText('//*[@id="var_8"]', '')


'Verify that Project type field is not copied'
functions.I.VerifyMatchText('//*[@id="var_12"]', '')

'Verify that Project description field is not copied'
functions.I.VerifyMatchText('//*[@id="var_229"]', '')

//
'Verify that Domain field is not copied'
functions.I.VerifyMatchText('//*[@id="var_116"]', '')

'Verify that Development zone field is not copied'
functions.I.VerifyMatchText('//*[@id="var_262"]', '')

'Verify that PAD is not copied'
functions.I.VerifyMatchText('//*[@id="var_14"]', '')

'Verify that PIPO / FIFO project field is not copied'
functions.I.VerifyMatchText('//*[@id="var_258"]', '')

'Verify that YEAR field is 2021'
functions.I.VerifyMatchText('//*[@id="var_98"]', '2021')

//PROJECT HIERARCHY
'Verify that Division field is not copied'
functions.I.VerifyMatchText('//*[@id="var_15"]', '')

'Verify that Signature field is not copied'
functions.I.VerifyMatchText('//*[@id="var_16"]', '')

'Verify that Franchise field is not copied'
functions.I.VerifyMatchText('//*[@id="var_17"]', '')

'Verify that Brand field is not copied'
functions.I.VerifyMatchText('//*[@id="var_18"]', '')

'Verify that Subbrand field is not copied'
functions.I.VerifyMatchText('//*[@id="var_19"]', '')

'Verify that Axis field is not copied'
functions.I.VerifyMatchText('//*[@id="var_20"]', '')

'Verify that Sub Axis is not copied'
functions.I.VerifyMatchText('//*[@id="var_21"]', '')

'Verify that Metier field is not copied'
functions.I.VerifyMatchText('//*[@id="var_22"]', '')

//Project contacts
'Verify that DMI is emptied'
functions.I.VerifyMatchText('//*[@id="var_23"]', '')

'Verify that C&A contact is emptied'
functions.I.VerifyMatchText('//*[@id="var_24"]', '')

'Verify that Coordinator contacts is emptied'
functions.I.VerifyMatchText('//*[@id="var_259"]', '')


//NNorth American Specific Contacts
'Verify that Leader Marketing field is Leader Country'
functions.I.VerifyMatchText('//*[@id="var_166"]', 'Leader Country')

'Verify that Local marketing contacts field is not copied'
functions.I.VerifyMatchText('//*[@id="var_269"]', '')

'Verify that North America APM Contacts  field is not copied'
functions.I.VerifyMatchText('//*[@id="var_270"]', '')


'Go back to the ref list page'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="kt_subheader"]/div/nav/ol/li[2]/a']))
 
WebUI.delay(1)

'Screenshot:Ref list page'
WebUI.takeScreenshot()

//MODIFY THE PROJECT
'Click on Modify this project'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="card_project"]/div[2]/div/div[3]/a[2]']))

WebUI.delay(1)

'Screenshot: Modify Project'
WebUI.takeScreenshot()

'Set text : Project name'
def project_name = (('AutoTest_Chrome_' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(5)) + '_') + functions.I.gettimedate()

WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_141"]']),   project_name)


'Select Project type: LAUNCH: New range, new product'
functions.I.SelectFromList_Value('//*[@id="var_12"]', '1025')


'Select Development zone: Europe'
functions.I.SelectFromList_Value('//*[@id="var_262"]', '16352')


'Select PAD : 22/08/2022'
WebUI.setText(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="var_14"]']),   '22/08/2022')
 

'Select Brand: La Provençale BIO'
functions.I.SelectFromList_Value('//*[@id="var_18"]', '12375')

'Select Axis: Fragrance'
functions.I.SelectFromList_Value('//*[@id="var_20"]', '3773')


'Select C&A'
functions.I.select_multiplelist('//*[@id="selSource_24"]', '//*[@id="btnAdd_24"]', 'afatoux')

functions.I.Pagedown()

'Click on Update'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button']))


//MOTHER REF
'Click on mother ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID1+'"]/td[8]/a[1]']))

'Screenshot: Mother ref'
WebUI.takeScreenshot()

//VERIFY FIELD OF MOTHER REF
//MKT - Reference information
'Verify Marketing product name: SAS_PART_4'
functions.I.VerifyMatchText('//*[@id="var_117"]', 'SAS_PART_4')

'Verify Product category: Other'
functions.I.VerifyMatchText('//*[@id="var_57"]', 'Other')

'Verify Packaging family: Bottom'
functions.I.VerifyMatchText('//*[@id="var_28"]', 'Bottom')

'Verify Packaging type :Primary only'
functions.I.VerifyMatchText('//*[@id="var_228"]', 'Primary only')

'Verify Capacity: 100'
functions.I.VerifyMatchText('//*[@id="var_54"]', '100')

'Verify Capacity unit: OZ'
functions.I.VerifyMatchText('//*[@id="var_55"]', 'OZ')

//MKT - Artwork information
'Verify International artwork agency: Klak & Son'
functions.I.VerifyMatchText('//*[@id="var_50"]', 'Klak & Son')

'Click on the view parent button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_view_ref_parent"]']))

WebUI.delay(1)

'User is redirected to the parent reference'
String parent_ref_mother1 = functions.I.RefID_tag()
WebUI.verifyMatch('24391', parent_ref_mother1, false)

'Screenshot: Parent Project'
WebUI.takeScreenshot()


'LHS click the project tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="menu_2"]/a']))

'Search project no'
functions.I.SearchProjectNo_xpath(Project_No2, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[8]/button')

//DAUGHTER REF

'Click on daughter ref link'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID2+'"]/td[8]/a']))

'Screenshot: Daughter ref'
WebUI.takeScreenshot()

//VERIFY FIELD OF Daughter REF
//MKT - Artwork informations
'Verify Local artwork agency: L’Oréal Internal Agency (Creative)'
functions.I.VerifyMatchText('//*[@id="var_67"]', 'L’Oréal Internal Agency (Creative)')

'Verify Languages :Albanian/ Arabic/ Azerbaijani'
////*[@id="var_10"]
functions.I.VerifyMatchText('//*[@id="var_10"]/span', 'Albanian'+'\n'+'Arabic'+ '\n'+ 'Azerbaijani')

//MKT - Contact information
'Verify Approver countries/zones : Albania/ Algeria /American Samoa'
functions.I.VerifyMatchText('//*[@id="var_72"]/span', 'Albania'+'\n'+'Algeria'+ '\n'+ 'American Samoa')

//CC&A - Artwork/Repro informations
'Verify Artwork approval date: 15/07/2021'
functions.I.VerifyMatchText('//*[@id="var_89"]', '15/07/2021')

'Verify BAG approval date: 30/07/2021'
functions.I.VerifyMatchText('//*[@id="var_90"]', '30/07/2021')

WebUI.delay(1)

'Click on the view parent button'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="btn_view_ref_parent"]']))

'Screenshot: Parent Project'
WebUI.takeScreenshot()

'User is redirected to the parent reference'
String parent_ref_daughter1 = functions.I.RefID_tag()
WebUI.verifyMatch('24392', parent_ref_daughter1, false)


'LHS click the project tab'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="menu_2"]/a']))

'Search project no'
functions.I.SearchProjectNo_xpath(Project_No2, '//*[@id="keynum_project"]', '//*[@id="form_filters"]/div[8]/button')


WebUI.delay(3)

'Screenshot: Parent Project'
WebUI.takeScreenshot()

'Click on submit - daughter'
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[15]/a[2]']))


WebUI.delay(2)


'Click on submit '
WebUI.click(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button[2]']))
WebUI.delay(2)

'Screenshot: ref list page'
WebUI.takeScreenshot()

'Verify the reference lifecycle status: '
functions.I.status_lifecycle(findTestObject('1. Constant/xpath', [('xpath') : '//*[@id="source_'+refID2+'"]/td[13]/span[1]']), 'Agency: Artwork production')


WebUI.closeBrowser()