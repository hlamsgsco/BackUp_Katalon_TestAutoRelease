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
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement

//USERNAME & PASSWORD FOR LOGIN
//Username for Admin = suser/dchi
String password_adelamatanieves = 'dchi' //Packaging_1

String password_suser = 'dchi' //suser
String password_aherms ='dchi' //supplier
String password_agluszczynska = 'dchi'//agency_2
String password_jmaciaszczyk ='dchi' //agency1
String password_aterreshernandez = 'dchi' //Packaging_1
String password_amartin_arbol = 'dchi' // Buyer

///////////////////////////////////////////////////////////////
//Keyword log
KeywordLogger log = new KeywordLogger()
/*
 String Project_No = 'MI000412'
String refID = 4904

String refID_PTS = Integer.parseInt(refID)+1
String refID_PS = Integer.parseInt(refID) +2
String refID_TD = Integer.parseInt(refID)+3
 */


//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Starpack Release >  http://mdb-release.diadeis.lan/Mediabox-independence/?MBI_datasource=REL_STARPACK'
WebUI.openBrowser('http://mdb-release.diadeis.lan/Mediabox-independence/?MBI_datasource=REL_STARPACK')

WebUI.maximizeWindow()


//LOG IN AS Packaging_1: adelamatanieves	 ~ dchi
'Log in as Packaging_1: adelamatanieves/ dchi'
functions.I.Login_password('adelamatanieves', password_adelamatanieves)

'Screenshot: Log as adelamatanieves'
WebUI.takeScreenshot()


//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

//CLICK ON CREATE PROJECT BUTTON
'Packaging_1: Click on + icon to create project '
WebUI.click(findTestObject('xxx Todelete/3 ProjectListPage_Create_Project_Button'))


'Screenshot: Creation project page'
WebUI.takeScreenshot()

//DEFINE PROJECT NAME
def project_name = (('AutoTest_Chrome_Starpack' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(10)) + '_') + functions.I.gettimedate()

//NAME THE PROJECT
WebUI.setText(findTestObject('HL Full Lifecycle/4 CreateProjPage_inputProjectname'), project_name)

//CLICK ON CREATE PROJECT
WebUI.click(findTestObject('HL Full Lifecycle/4 CreateProjPage_Create Project_Bluebutton'))

WebUI.delay(1)

'Screenshot: Modify project page'
WebUI.takeScreenshot()

'Select from list Enseña: Dia'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_98']), '122', false)

'Select from list Buyer:Alejandro Martin Arbol'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : "var_9"]), 'amartin_arbol', false)

'Select from list Packaging Manager: ANAISABEL TERRÉSHERNÁNDEZ'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : "var_10"]), 'aterreshernandez', false)


'Add options > Multiple field list Ingeniero de Packaging'
WebUI.selectOptionByValue(findTestObject('Object Repository/xxx Todelete/1.4 ModifyProPage_MF(IDP)'), 'nalonsobermejo', true)

WebUI.click(findTestObject('Object Repository/xxx Todelete/1.41 ModifyProPage_AddMF'))

'Select from list Código del proveedor: 0075022'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : "var_15"]), '292', false)

'Verify if the text box Nombre del proveedor is not blank'
value = WebUI.getAttribute(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/1.6 ModifyProPage _NDP'), 'value')
if (value == 'MCBRIDE, S.A.') {
		
	'Nombre del proveedor is not empty'
	System.out.println( 'Value is filled with  value  MCBRIDE, S.A.- Test ok')
	assert true
	
	}


else
	{log.logFailed('Warning! Field Empty- Test KO')
		
	}
	

'SPACE OF AD - All - Att: Marcin Lewandowski ul. Śląska 14 60-614 Poznań POLAND +48 884 801 485'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : "var_26"]), '94', false)


'SPACE OF AD - All - Att: Marcin Lewandowski ul. Śląska 14 60-614 Poznań POLAND +48 884 801 485'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : "var_12"]), '94', false)

'Select from list Agencia de producción: "SPACE OF AD - Anna Gluszczynska - Att: Anna Gluszczynska ul. Śląska 14 60-614 Poznań POLAND +48 884 801 485"'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : "var_27"]), '734', false)

'Select from list Agencia de Validador externo: EurofinsEspaña Food'
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : "var_71"]), 'efood', false)

'Screenshot: Modify project page - completed'
WebUI.takeScreenshot()


WebUI.click(findTestObject('HL Full Lifecycle/5 ModifyProjPage_button_Update'))

WebUI.waitForPageLoad(10)

//END OF MODIFY PROJECT PAGE

// GET PROJECT NO.
String Project_No = functions.I.ProjectNo()


//CREATE REFERENCE
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPage_createrefbutton'))


WebUI.click(findTestObject('HL Full Lifecycle/6 ReferenceListPaga_Create a component_button'))

WebUI.waitForPageLoad(10)

'Screenshot: Creation Reference Page'
WebUI.takeScreenshot()

//CHOOSE LIFECYCLE : 
//*[@id="ref_type"]
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : "ref_type"]),, '6', false)


//CLICK ON CREATE REF BUTTON
WebUI.click(findTestObject('HL Full Lifecycle/6 ReferencePg_Create a component_bluebutton'))



//GET THE ID OF THE REF
String refID = functions.I.RefID()
System.out.println( refID)

'Screenshot: Modification Reference Page'
WebUI.takeScreenshot()

'Input text code: 209293'
//*[@id="var_28"]
WebUI.sendKeys(findTestObject('1. Constant/01_id_field_id', [('field_id') : "var_28"]), '209293')



'Input Vínculo con boceto: test Submarca'
//[@id="var_30"]
WebUI.sendKeys(findTestObject('1. Constant/01_id_field_id', [('field_id') : "var_30"]), 'test Submarca')

'Input Vínculo con bulto: test Submarca'
WebUI.sendKeys(findTestObject('1. Constant/01_id_field_id', [('field_id') : "var_31"]), 'test Submarca Vínculo con bulto: test Submarca')

'Select from list Tipo de trabajo: title="AA.FF. cambio de proveedor /  Alterações da arte final pelo fornecedor /  Change of supplier artwork"'
//*[@id="var_30"]
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : "var_38"]), '24', false)

'Input Código de barras: Código de barras: 8480017155061'
//*[@id="var_39"]
WebUI.sendKeys(findTestObject('1. Constant/01_id_field_id', [('field_id') : "var_39"]), '8480017155061')

'Multiple list Select from list País'
//*[@id="selSource_19"]
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : "selSource_19"]), '22', false)
WebUI.click(findTestObject('Object Repository/xxx Todelete/2.01 ModifyRef_Pais'))

'Multiple list Select from list Idioma(s)'
//*[@id="var_75"]
WebUI.selectOptionByValue(findTestObject('1. Constant/01_id_field_id', [('field_id') : "var_75"]), '26', false)

//CLICK SAVE
WebUI.click(findTestObject('HL Full Lifecycle/7 ModifyRefPage_button_Save'))

'Logout as Ana'
functions.I.Logout()

'Log in as Setup: suser/ dchi'
functions.I.Login_password('suser', password_suser)

'Screenshot: Log as suser'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))


//Super Edit ref
functions.I.superedit_ref(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.02 Suser super edit', [('refID'):'source_'+ refID]), findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.03 Suser super edit (option)', [('refID'):'source_'+ refID]))



'Screenshot: Suser modification page '
WebUI.takeScreenshot()

//Modification od field SUPER EDIT
//Gluten free picto -yes
//*[@id="field_var_40"]/div/div/label[1]
//*[@id="${field_ID}"]/div/div/label[1]

functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.04 Suser select option button(yes)',  [('field_ID') : "field_var_40"]))

//Lactose free picto - yes
//*[@id="field_var_41"]/div/div/label[1]
functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.04 Suser select option button(yes)',  [('field_ID') : "field_var_41"]))


//ADILAC picto - yes
//*[@id="field_var_42"]/div/div/label[1]
functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.04 Suser select option button(yes)',  [('field_ID') : "field_var_42"]))

//MSC picto - yes
//*[@id="field_var_43"]/div/div/label[1]
functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.04 Suser select option button(yes)',  [('field_ID') : "field_var_43"]))


//Veggie picto - No
//*[@id="field_var_44"]/div/div/label[2]
functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.04 Suser select option button(No)',  [('field_ID') : "field_var_44"]))


//BIO-ECO picto -No
//*[@id="field_var_45"]/div/div/label[2]

functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.04 Suser select option button(No)',  [('field_ID') : "field_var_45"]))

//Spain Origin picto -No
//*[@id="field_var_99"]/div/div/label[2]
functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.04 Suser select option button(No)', [('field_ID') : "field_var_99"]))


//save when superedit
//*[@id="ModifFiche"]/div[3]/div/button
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.05 Suser saves for super edit ref'))

'Logout as Suser'
functions.I.Logout()


//LOG IN AS Packaging_1: adelamatanieves	 ~ dchi
'Log in as Packaging_1: adelamatanieves/ dchi'
functions.I.Login_password('adelamatanieves', password_adelamatanieves)

'Screenshot: Log as Ana'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))



'Ref List page: Ana click on proceed to next phase (1)'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[10]/a[3]']))



'Ana submit next phase on ref page (1)'
//*[@id="ModifFiche"]/div[1]/div/button[2]
//*[@id="ModifFiche"]/div['${id}']/div/button[2]
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/2.031 RefPg_AnnaSubmit',[('id'): '1']))



'Ana submit next phase on ref LIST page (2) '
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/2.03 Block anna'))

//To generate daughter ref PTS
//[@id="card_phase_group_2464_ModifFiche"]/div[2]/div[1]/div/div/label[1]
//[@id="card_phase_group_2464_ModifFiche"]/div[2]/div[1]/div/div

//WebElement element = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/2.04 Field yes_No (Auto Daughter ref)',[('id') : "1"]),30)
functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/2.04 Field yes_No (Auto Daughter ref)',  [('id') : "1"]))

//To generate daughter ref Sample
//*[@id="card_phase_group_2464_ModifFiche"]/div[2]/div[2]/div/div/label[1]
functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/2.04 Field yes_No (Auto Daughter ref)',  [('id') : "2"]))

//To generate daughter ref GTD
//[@id="card_phase_group_2464_ModifFiche"]/div[2]/div[3]/div/div/label[1]
functions.I.click_button_javascript(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/2.04 Field yes_No (Auto Daughter ref)',  [('id') : "3"]))


//Scroll down
functions.I.Pagedown()

//Submit to next phase
'Ana submit next phase Ref Pg(2)'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/2.05 RefPg_submit'))

WebUI.delay(2)

'Screenshot: Reference list page > Automatic creation of 3 daughter ref PTS /Product Sample/Technical Drawing '
WebUI.takeScreenshot()


//Packaging Ana Logout.
'Packaging_1 Ana: log out'
functions.I.Logout()

//Ref id for the daughter ref
String refID_PTS = Integer.parseInt(refID)+1
String refID_PS = Integer.parseInt(refID) +2
String refID_TD = Integer.parseInt(refID)+3



//LOG IN AS setup: suser	 ~ dchi
'Log in as Setup: suser/ dchi'
functions.I.Login_password('suser', password_suser)

'Screenshot: Log as suser'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))


//VERIFICATION OF DAUGHTER REF
'Screenshot: Verification of 3 daughter refs created'
WebUI.takeScreenshot()

//Verify that Daughter ref PTS has been created
//*[@id='${refID_PTS}']/td[4]/a/span
functions.I.verifyDaughterrefCreated(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.01 Suser Ref Daughter verification', [('refID_PTS'): 'source_'+refID_PTS]), 'PTS', log)

//Verify that Daughter ref Product Sample has been created
//*[@id="source_4872"]/td[4]/a/span
functions.I.verifyDaughterrefCreated(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.01 Suser Ref Daughter verification', [('refID_PTS'): 'source_'+refID_PS]), 'Product Sample', log)

//Verify that Daughter ref Technical Drawing has been created
//*[@id="source_4873"]/td[4]/a/span
functions.I.verifyDaughterrefCreated(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/3.01 Suser Ref Daughter verification', [('refID_PTS'): 'source_'+refID_TD]), 'Technical Drawing', log)
//END VERIFICATION OF DAUGHTER REF

'logout as suser'
functions.I.Logout()

////////////////////////////////////DAUGHTER REFERNCE PTS PHASE 1///////////////////////////////////////////


'Login as Supplier 0075022 Herms - Anna Carrascoca - aherms '
functions.I.Login_password('aherms', password_aherms)

'Screenshot: Login as Supplier'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

////////////////////////////////////DAUGHTER PTS >PHASE 1: PTS SUBMIT NEXT PHASE

'Daughter ref PTS: submit PTS briefing - Phase 1'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/4.01 Supplier proceed to next phase(PTS)', [('field_id') : 'ancre_'+refID_TD]))

'Supplier modifies the daughter ref pts - part A'
WebUI.takeScreenshot()

//PTS upload field
//[@id="card_phase_group_2623_ModifFiche"]/div[2]/div[1]/div/label
functions.I.UploadDoc('C:\\Users\\lamhe\\Desktop\\Upoad_File\\testdata1.pdf', findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/4.01 Supplier Upload field'))

//PTS Text field Datos de contacto del proveedor
//[@id="var_46"]
//[@id="${field_id}"]
WebUI.setText(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_46']), 'Datos de contacto del proveedor - Text Field')


'REFERNCE PG: Supplier: PTS send to next phase '
//[@id="ModifFiche"]/div[3]/div/button[2]
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/2.031 RefPg_AnnaSubmit', [('id') : '3']))

'Supplier send PTS - Phase 1 (Complete)'
WebUI.takeScreenshot()



/////////////////////////////////DAUGHTER PS >PHASE 1: PS SUBMIT NEXT PHASE
'Daughter ref PTS: submit PS  - Phase 1'
//*[@id="source_4906"]/td[9]/a[2]
//[@id='${refID}']/td[9]/a[2]
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/4.012 Supploer proceed to next phase (PS)', [('refID') : 'source_'+refID_PS]))

'Supplier modifies the daughter ref PS - part A'
WebUI.takeScreenshot()

//PS Text field Número de seguimiento del envío de la muestra de producto
//[@id="var_24"]
WebUI.setText(findTestObject('1. Constant/01_id_field_id', [('field_id') : 'var_24']), 'Número de seguimiento del envío de la muestra de producto- Text Field')


//Supplier send to next phase
//*[@id="ModifFiche"]/div[3]/div/button[2]
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[2]']))


'REFERNCE PG: Supplier send PS - Phase 1 (Complete)'
WebUI.takeScreenshot()

////////////////////////////////////DAUGHTER TD >PHASE 1: TD SUBMIT NEXT PHASE
'Daughter ref TD: submit TD  - Phase 1'
//[@id="source_4877"]/td[9]/a[2]
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/4.012 Supploer proceed to next phase (PS)', [('refID') : 'source_'+refID_TD]))

'Supplier Upload doc for production phase'
WebUI.takeScreenshot()

//Supplier upload doc
//[@id="${field_id}"]
//[@id="dropZoneinit"]
functions.I.UploadDoc('C:\\Users\\lamhe\\Desktop\\Upoad_File\\testdataaddition1.pdf', findTestObject('1. Constant/01_id_field_id', [('field_id') : 'dropZoneinit']))

//Suplier proceed next phase
//[@id="ModifFiche"]/div[1]/div/button
//[@id="ModifFiche"]/div[1]/div/button
//[@id="ModifFiche"]/div[1]/div/button
WebUI.delay(3)
functions.I.click_button_javascript( findTestObject('Object Repository/HL Full Lifecycle/12 ReferncePage_Button_Updatensenddoc'))

'Logout as Supplier'
functions.I.Logout()


//LOGIN AS AGENCY2 Anna Gluszczynska
'Login as AGENCY2 Anna Gluszczynska : agluszczynska/dchi'
functions.I.Login_password('agluszczynska',password_agluszczynska)

'Screenshot :Login as AGENCY2 Anna Gluszczynska'
WebUI.takeScreenshot()


//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))


//////////////////////////////////// FOR DAUGHTER TD
//Click on REVIEW BUTTON(EYE)
//[@id="source_4887"]/td[8]/a
//[@id="${refID}"]/td[8]/a
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.01 agency_2 RefPg_Prodbutton(Eye)', [('refID') : 'source_' +refID_TD]))


//functions.I.AWF_approve()
functions.I.AWF_approve_view()

WebUI.delay(1)

//AGENCY2 CLICK ON SUBMIT FOR DAUGHER TD
'agency2 asumit next phase for daughter ref TD'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.01 agency_2 RefPg_Prodbutton(Eye)', [('refID') : 'source_' +refID_TD]))


//VERIFICATION OF REF COMPLETED FOR TD
//[@id="source_4887"]/td[5]/span
functions.I.status(findTestObject('HL Full Lifecycle/Status', [('refID') : 'source_' + refID_TD]))

'Status: Completed for Daughter TD \r\n'
WebUI.takeScreenshot()

//////////////////////////////////// FOR DAUGHTER PTS PHASE 2

//Agency2 clciks on question button
'Agency2 clicks on question button'
//*[@id="ancre_4907"]/div/button> //*[@id="${ref_ID}"]/div/button 
//*[@id="ancre_4907"]/div/div/a[1] > //*[@id="${ref_ID}"]/div/div/a[1]

WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.02 Agency_2_refPg_questionbutton', [('ref_ID') : 'ancre_'+refID_TD]))
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.021 Agency_2_RefPg_question_approve', [('ref_ID') : 'ancre_'+refID_TD]))

WebUI.delay(1)
'Screenshot: Popup for the question phase'
WebUI.takeScreenshot()

'Agency2 clicks OK'
//*[@id="kt_body"]/div[8]/div/div/div[2]/button[2]
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="kt_body"]/div[8]/div/div/div[2]/button[2]']))

WebUI.delay(1)


//////////////////////////////////// FOR DAUGHTER PTS - PHASE 3 (LAST)
'Agency2 clic submit on the ref listk'
//*[@id="ancre_4887"]/a > //*[@id="${refID}"]/a
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.03 id_refID_a', [('refID') : 'ancre_'+refID_TD]))

//VERIFICATION OF REF COMPLETED FOR PTS
//*[@id="source_4885"]/td[5]/span
'Verification of status: Completed'
functions.I.status(findTestObject('HL Full Lifecycle/Status', [('refID') : 'source_' + refID_PTS]))

'Status: Completed for Daughter PTS \r\n'
WebUI.takeScreenshot()


//////////////////////////////////// FOR DAUGHTER PS - PHASE 2
//*[@id="source_4906"]/td[8]/a > //*[@id="${refID}"]/td[8]/a

//*[@id="source_4906"]/td[8]/a> //*[@id="${refID}"]/a
 WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.07 Agency1 id_refID_td8', [('refID') : 'source_'+refID_PS]))


//*[@id="source_4904"]/td[6]/span[2]
'verify if the lifecycle of the mother ref is Wait for PTS/Sample/Tech drawing '
functions.I.status_lifecycle(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.08 Agency2 Lifecycle status id_refID_td6_span2', [('refID'):'source_'+refID]),'Wait for PTS/Sample/Tech drawing')

//////////////////////////////////// FOR DAUGHTER PS - PHASE 3 (LAST)
//*[@id="source_4906"]/td[9]/a[2]
'Agency click on proceed to next phase - PS'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.04 Agency1 id_refID_td9_a2', [('refID'):'source_'+refID_PS]))

//*[@id="card_phase_group_1825_ModifFiche"]/div[2]/div/div/label
'Agency upload doc'
functions.I.UploadDoc('C:\\Users\\lamhe\\Desktop\\Upoad_File\\testdata1.pdf', findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="card_phase_group_1825_ModifFiche"]/div[2]/div/div/label']))

//CLICK  on Submit button
'Agency clicks submit'
//*[@id="ModifFiche"]/div[3]/div/button[2]
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[2]']))


////*[@id="source_4904"]/td[5]/span[2]
'verify the mother ref has proceeded to the next phase automatially: The lifecycle of the mother ref is PAF '
functions.I.status_lifecycle(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.05 Agency1 id_refID_td5_span2', [('refID'):'source_'+refID]),'PAF')


//////MOTHER REF
//Agency click on upload button
//*[@id="ancre_4906"]/a
'Agency click on upload button'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/5.06 Agency1 id_refID_a', [('refID'):'ancre_'+refID_PS]))

//Agency upload doc for production phase
'Agency upload doc for production phase '
functions.I.UploadDoc('C:\\Users\\lamhe\\Desktop\\Upoad_File\\testdata1.pdf', findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="dropZoneinit"]']))

//Agency click on next pahse
//*[@id="ModifFiche"]/div[1]/div/button
'Agency click on next phase'
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[1]/div/button']))



'Logout as Agency'
functions.I.Logout()


//ANAISABEL TERRÉSHERNÁNDEZ
'Login as ANAISABEL TERRÉSHERNÁNDEZ '
functions.I.Login_password('aterreshernandez', password_aterreshernandez)


'Screenshot :Login as ANAISABEL TERRÉSHERNÁNDEZ'
WebUI.takeScreenshot()


//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('xxx Todelete/xpath',[('xpath'):'//*[@id="form_filters"]/div[7]/button']))

//////////////////FOR MOTHER REF 
//Click on review button(eye)
//*[@id="ancre_4906"]/a[2] > //*[@id="${refID}"]/a[2]
'Anaisabel click on the review button'
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.01 Anais id_refID_a2', [('refID') : 'ancre_' +refID_PS]))


//functions.I.AWF_approve()
functions.I.AWF_approve_view()


'Logout as Anais'
functions.I.Logout()

//LOGIN AS SUSER
'Login as suser'
functions.I.Login_password('suser', password_suser)

'Screenshot: Log as suser'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//APPROVE PERMANENTLY FOR OTHERS - PART 1
//CLICK ON REF LINK
//*[@id="source_4904"]/td[4]/a[1] > //*[@id="${refID}"]/td[4]/a[1]
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.02 suser id_source_refID__td4_a1', [('refID') : 'source_' +refID]))

//Click on ? approve permanently for others
'suser: Click on ? approve permanently for others'
functions.I.Approvepermanentlyforothers(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="level_apl_1"]/div[2]/div[1]/div/div/div[3]/a[2]/span']))
WebUI.delay(1)

//APPROVE FOR OTHERS - PART 2

//CLICK ON REF LINK
//*[@id="source_4904"]/td[4]/a[1] > //*[@id="${refID}"]/td[4]/a[1]
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.02 suser id_source_refID__td4_a1', [('refID') : 'source_' +refID]))

//Click on ? approve permanently for others
'suser: Click on ? approve for others'
functions.I.Approveforothers(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="level_apl_1"]/div[2]/div[2]/div/div/div[3]/a[2]/span']))
WebUI.delay(1)


//APPROVE FOR OTHERS - PART 3
//CLICK ON REF LINK
//*[@id="source_4904"]/td[4]/a[1] > //*[@id="${refID}"]/td[4]/a[1]
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.02 suser id_source_refID__td4_a1', [('refID') : 'source_' +refID]))

//Click on ? approve permanently for others
'suser: Click on ? approve for others'
functions.I.Approveforothers(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="level_apl_2"]/div[2]/div/div/div/div[3]/a[2]']))
WebUI.delay(1)

//Logout as suser
'logout as suser'
functions.I.Logout()

//Log in as Anna Gluszczynska
'Login as Anna Gluszczynska'
functions.I.Login_password('agluszczynska', password_agluszczynska)


'Screenshot: Log s Anna Gluszczynska'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//agency 2 click on submit
//*[@id="ancre_4906"]/a[2]
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.01 Anais id_refID_a2', [('refID') : 'ancre_' +refID_PS]))

//agency2 upload doc
//Object Repository/StarPack - Full Lifecycle (AWIS)/1.0 ModifyProPage_List(Ensena)
//*[@id="card_phase_group_1238_ModifFiche"]/div[2]/div/div/label
functions.I.UploadDoc('C:\\Users\\lamhe\\Desktop\\Upoad_File\\testdata1.pdf', findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="card_phase_group_1238_ModifFiche"]/div[2]/div/div/label']))

//agency 2 click on submit
//*[@id="ModifFiche"]/div[3]/div/button[2]
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifFiche"]/div[3]/div/button[2]']))


//Logout as Anna
'logout as Ana Agency 2r'
functions.I.Logout()

//Log in as aherms
'Login as aherms'
functions.I.Login_password('aherms', password_aherms)


'Screenshot: Log as Anna Gluszczynska'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//Click on upload doc
'Aherm click on upload button'
//*[@id="ancre_4906"]/a[2]
WebUI.click(findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.01 Anais id_refID_a2', [('refID') : 'ancre_' +refID_PS]))

//Upload doc
//*[@id="dropZoneinit"]
'Aherm uploads doc'
functions.I.UploadDoc('C:\\Users\\lamhe\\Desktop\\Upoad_File\\testdata1.pdf', findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="dropZoneinit"]']))

//Send to next phase
//*[@id="ModifFiche"]/div[1]/div/button
'Aherm send to next phase'
functions.I.click_button_javascript( findTestObject('xxx Todelete/xpath',[('xpath'): '//*[@id="ModifFiche"]/div[1]/div/button']))


//Logout as Anna Gluszczynska
'logout as Anna Gluszczynska'
functions.I.Logout()

// LOG IN AS ANAISABEL TERRÉSHERNÁNDEZ
'Login as aterreshernandez	'
functions.I.Login_password('aterreshernandez', password_aterreshernandez)


'Screenshot :Login as ANAISABEL TERRÉSHERNÁNDEZ'
WebUI.takeScreenshot()


//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('xxx Todelete/xpath',[('xpath'):'//*[@id="form_filters"]/div[7]/button']))

//CLICK ON REVIEW BUTTON
//*[@id="ancre_4906"]/a[2]
'Ana clicks on review button'
WebUI.click( findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.01 Anais id_refID_a2',[('refID'):'ancre_' +refID_PS]))


//functions.I.AWF_approve()
functions.I.AWF_approve_view()


//Logout as ANAISABEL TERRÉSHERNÁNDEZ
'logout as ANAISABEL TERRÉSHERNÁNDEZ'
functions.I.Logout()


//Log in as aherms
'Login as aherms'
functions.I.Login_password('aherms', password_aherms)


'Screenshot: Log as Anna Gluszczynska'
WebUI.takeScreenshot()

//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('HL Full Lifecycle/9 Filter_Button_Apply'))

//CLICK ON NEXT PHASE 
//*[@id="ancre_4906"]/a[2]
'Ana clicks on next phase'
WebUI.click( findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.01 Anais id_refID_a2',[('refID'):'ancre_' +refID_PS]))

//Input text
//*[@id="var_48"]
'Ana input text in field: Número de seguimiento del envío de la muestra de packagingmandatory'
WebUI.setText(findTestObject('1. Constant/01_id_field_id',[('field_id'):'var_48']), 'Número de seguimiento del envío de la muestra de packagingmandatory')


//Click on next phase
//*[@id="ModifFiche"]/div[3]/div/button[2]
'Ana click on next phase'
WebUI.click(findTestObject('xxx Todelete/xpath',[('xpath'):'//*[@id="ModifFiche"]/div[3]/div/button[2]']))


//Logout as Anna Gluszczynska
'logout as Anna Gluszczynska'
functions.I.Logout()



//ANAISABEL TERRÉSHERNÁNDEZ
'Login as ANAISABEL TERRÉSHERNÁNDEZ '
functions.I.Login_password('aterreshernandez', password_aterreshernandez)


'Screenshot :Login as ANAISABEL TERRÉSHERNÁNDEZ'
WebUI.takeScreenshot()


//CLICK ON THE SIDE MENU: PROJECTS
WebUI.click(findTestObject('1. Constant/02_LHSMenu_Projects'))

///SEARCH FOR PROJECT
functions.I.SearchProjectNo(Project_No, findTestObject('xxx Todelete/xpath',[('xpath'):'//*[@id="form_filters"]/div[7]/button']))

//CLICK ON NEXT PHASE
//*[@id="ancre_4906"]/a[2]
'ANAISABEL TERRÉSHERNÁNDEZ clicks on next phase'
WebUI.click( findTestObject('Object Repository/StarPack - Full Lifecycle (AWIS)/6.01 Anais id_refID_a2',[('refID'):'ancre_' +refID_PS]))

'Verify if status is complete for the mother ref'
//   /html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[7]/span
////html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[7]/span
functions.I.status_lifecycle(findTestObject('xxx Todelete/xpath',[('xpath'):'/html/body/div[1]/div[2]/div[4]/div[3]/div/div[2]/div[2]/div[1]/table/tbody/tr[2]/td[7]/span']), 'Completado')

'Screenshot : Mother Ref completed'
WebUI.takeScreenshot()

WebUI.closeBrowser()

