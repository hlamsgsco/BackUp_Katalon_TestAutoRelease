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

//USERNAME & PASSWORD
String password_suser = 'dchi'
//String login = 'flnhfy135718'
String login = functions.I.readnotepad('C:\\Users\\lamhe\\Desktop\\Upoad_File\\login.txt')
functions.I.print(login)

String FLName = functions.I.readnotepad('C:\\Users\\lamhe\\Desktop\\Upoad_File\\Name.txt')


//GMAIL: Mediabox.Creation@gmail.com
String password_mediaboxCreation = 'Diadeis*1'

//BROWSE & MAXIMIZE BROWSER
'Navigate to URL Starpack Release >  http://mdb-release.diadeis.lan/Mediabox-independence/?MBI_datasource=REL_STARPACK'
WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.waitForPageLoad(30)

WebUI.takeScreenshot()



'Login in gmail'
functions.I.Login_gmail('Mediabox.Creation@gmail.com ', password_mediaboxCreation)


'search mail'
WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="gs_lc50"]/input[1]']), 'Your login information '+ login)

WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="aso_search_form_anchor"]/button[4]']))

WebUI.verifyTextPresent('RELEASE-StarPack [Mediabox] Your login information', false)

WebUI.takeScreenshot()

WebUI.delay (5)
'Click on email'
////*[@id=":5y"]/span
//*[@id=":5q"]
//*[@id=":8i"]/div[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/a
// /html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[2]/div[5]/div[2]/div/table/tbody/tr
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[2]/div[5]/div[2]/div/table/tbody/tr']))


'Verify the login and password is present'

String password_new = WebUI.getText(findTestObject('xxx Todelete/xpath', [('xpath') : '/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[3]/div/table/tr/td[1]/div[2]/div[2]/div/div[3]/div[1]/div/div/div/div/div[1]/div[2]/div[3]/div[3]/div/div[2]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]']))
functions.I.print('password - ' + password_new)

String url_new = WebUI.getText(findTestObject('xxx Todelete/xpath', [('xpath') : '/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[3]/div/table/tr/td[1]/div[2]/div[2]/div/div[3]/div[1]/div/div/div/div/div[1]/div[2]/div[3]/div[3]/div/div[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/a']))


functions.I.print('url - ' + url_new)

WebUI.navigateToUrl(url_new)




functions.I.Login_password(login ,password_new)


WebUI.delay(1)
//VERIFICATION OF THE PAGE "CHANGE PASSWORD"
'Verification of the page "Change password"'
String changepassword_page = WebUI.getText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifPassword"]/h3']))
functions.I.print('change password - ' + changepassword_page)

String Expected_changepassword = 'Change your password - '+ login
WebUI.verifyEqual(changepassword_page, Expected_changepassword )

'Screenshot for change password page'
WebUI.takeScreenshot()

//S1: VERIFY 2 EMPTY PASSWORD -PASSWORD & CONFIRM PASSWORD FIELDS
'Verification Password and confirm password are empty (2 empty fields)'

WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifPassword"]/div[4]/button']))

////*[@id="toast-container"]/div/div
String Expected_ErrormsgPass1 = 'Invalid password - Minimum of 3 characters'
String Actual_Errormsg1 = WebUI.getText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="toast-container"]/div/div']))
WebUI.verifyEqual(Actual_Errormsg1, Expected_ErrormsgPass1 )

'Screenshot 1 for 2 empty password fields'
WebUI.takeScreenshot()

WebUI.delay(2)

//S2: VERIFY 1 EMPTY PASSWORD - COMFIRM PASSWORD EMPTY
//*[@id="new_password"]
'Verification confirm password is empty (1 empty fields)'
WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="new_password"]']), 'dchi')

//*[@id="ModifPassword"]/div[4]/button
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifPassword"]/div[4]/button']))

////*[@id="toast-container"]/div/div
 String Expected_ErrormsgPass2 = 'Please enter same password'
 
 String Actual_Errormsg2 = WebUI.getText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="toast-container"]/div/div']))
 
 WebUI.verifyEqual(Actual_Errormsg2, Expected_ErrormsgPass2)
 
 'Screenshot 2 for 2 empty password fields'
 WebUI.takeScreenshot()
 WebUI.delay(2)
 
//S3 VERIFY 1 EMPTY PASSWORD - PASSWORD FIELD
'Verification password is empty (1 empty fields)'
WebUI.clearText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="new_password"]']))

////*[@id="passwordConfirm"]
WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="passwordConfirm"]']), 'test1')
WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifPassword"]/div[4]/button']))
 
String Expected_ErrormsgPass3 = 'Invalid password - Minimum of 3 characters'
String Actual_Errormsg3 = WebUI.getText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="toast-container"]/div/div']))
WebUI.verifyEqual(Actual_Errormsg3, Expected_ErrormsgPass3)

'Screenshot for 2 empty password fields'
WebUI.takeScreenshot()

WebUI.delay(2)

//S4 VERIFY DIFFERENT PASSWORD
'Verification password & confirm password are different'

functions.I.Change_password('test1', 'test2')

 String Expected_ErrormsgPass4 = 'Please enter same password'
  String Actual_Errormsg4 = WebUI.getText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="toast-container"]/div/div']))
  WebUI.verifyEqual(Actual_Errormsg4, Expected_ErrormsgPass4)
  
  'Screenshot 4  for 2 empty password fields'
  WebUI.takeScreenshot()
  WebUI.delay(2)
  
//S5 VERIFY Less than 3 char
'Verification password & confirm password less than 3 char'
WebUI.clearText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="new_password"]']))
 WebUI.clearText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="passwordConfirm"]']))
 
functions.I.Change_password('te', 'te')
String Expected_ErrormsgPass5 = 'Invalid password - Minimum of 3 characters'
String Actual_Errormsg5 = WebUI.getText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="toast-container"]/div/div']))
WebUI.verifyEqual(Actual_Errormsg5, Expected_ErrormsgPass5)

WebUI.delay(2)

'Screenshot 5: password & confirm password less than 3 char'
WebUI.takeScreenshot()

//VERIFY SAME PASSWORD > LOGIN
'Verification password & confirm password are same'
WebUI.clearText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="new_password"]']))
WebUI.clearText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="passwordConfirm"]']))
 
functions.I.Change_password('dchi', 'dchi')


WebUI.verifyElementVisible(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="menu_2"]/a']))



functions.I.Logout()
functions.I.Login_password(login, 'dchi')

functions.I.Login_gmail('Mediabox.Creation@gmail.com ', password_mediaboxCreation)

'search mail'
WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="gs_lc50"]/input[1]']), 'Password successfully changed')

WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="aso_search_form_anchor"]/button[4]']))

WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[2]/div[5]/div[2]/div/table/tbody/tr']))


'Verify the login and password is present'

///html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[3]/div/table/tr/td[1]/div[2]/div[2]/div/div[3]/div/div/div/div/div/div[1]/div[2]/div[3]/div[3]/div/div[2]/table/tbody/tr[2]/td
String password_mail = WebUI.getText(findTestObject('xxx Todelete/xpath', [('xpath') : '/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[3]/div/table/tr/td[1]/div[2]/div[2]/div/div[3]/div/div/div/div/div/div[1]/div[2]/div[3]/div[3]/div/div[2]/table/tbody/tr[2]/td']))
functions.I.print('password mail - ' + password_mail)

String mail_ExpectedMail = 'Hello '+ FLName + ',' +'\n'+'\n'+ 'Your password has been successfully changed.'+ '\n'+'\n'+ 'Best regards,'+'\n'+ 'The Diadeis Team'
functions.I.print(mail_ExpectedMail)

WebUI.verifyEqual(password_mail, mail_ExpectedMail)
//WebUI.closeBrowser()
