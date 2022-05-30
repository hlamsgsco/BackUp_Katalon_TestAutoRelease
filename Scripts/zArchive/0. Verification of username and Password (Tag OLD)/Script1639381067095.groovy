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

/*
 
THIS TESTCASE SHOULD NE RUN BEFORE RUNNING THE OTHER TEST SUITE SO THAT IT DOES NOT MAKE CONFLICT WITH THE TESTING.

IN THIS TESTCASE, IT WILL VERIFY THE PASSWORD OF THE USERS USED IN THE TESTSUITE. [TAG]
FOR TAG THE VERIFICATION OF USERS ARE DIFFERENCT BCOZ OF THE DUMP

PART 1: CHANGING THE PASSWORD OF THE USER
PART 2:VERIFICATION OF PASSWORD

*/
//PART 1: DATA FIELD: USERNAME_PASSWORD
def data_Tag = TestDataFactory.findTestData('Data Files/Username_Password/Tag')

String password_jedun = data_Tag.getValue(2, 1)

// Change to
String password_rrowland = data_Tag.getValue(2, 2)

String password_stest = data_Tag.getValue(2, 3)

String password_itroin = data_Tag.getValue(2, 4)

String password_igedik = data_Tag.getValue(2, 5)

String password_mderdour = data_Tag.getValue(2, 6)

String password_achatin = data_Tag.getValue(2, 7)

String password_tliu = data_Tag.getValue(2, 8)

String password_ccaramella = data_Tag.getValue(2, 9)

String password_achay = data_Tag.getValue(2, 10)

String password_cbono = data_Tag.getValue(2, 11)

String password_pmareri = data_Tag.getValue(2, 12)

String password_qeuzen = data_Tag.getValue(2, 13)

String password_alanglois = data_Tag.getValue(2, 14)

// DATA FIELD: URL
def data_urlRELAUTO = TestDataFactory.findTestData('Data Files/URL/URL_relauto')

String Url_Tag = data_urlRELAUTO.getValue(2, 3)

//////////////////////////////////////////////////////////////////////TEST START ///////////////////////////////////////////////////
//BROWSE & MAXIMIZE BROWSER
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()

//VPART 1 : CHANGES OF PASSWORD
//1 jedun
functions.I.Login_password('jedun', password_jedun)

if (WebUI.verifyTextPresent('Change your password - jedun', false)) {
    password_jedun = data_Tag.getValue(3, 1)

    WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="new_password"]']), 
        password_jedun)

    WebUI.delay(1)

    WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="passwordConfirm"]']), 
        password_jedun)

    WebUI.delay(1)

    WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifPassword"]/div[4]/button']))
}

functions.I.Logout()

//2 rrowland
functions.I.Login_password('rrowland', password_rrowland)

if (WebUI.verifyTextPresent('Change your password - rrowland', false)) {
    password_rrowland = data_Tag.getValue(3, 2)

    WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="new_password"]']), 
        password_rrowland)

    WebUI.delay(1)

    WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="passwordConfirm"]']), 
        password_rrowland)

    WebUI.delay(1)

    WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifPassword"]/div[4]/button']))
}

functions.I.Logout()

//3 stest
functions.I.Login_password('stest', password_stest)

if (WebUI.verifyTextPresent('Change your password - stest', false)) {
    password_stest = data_Tag.getValue(3, 3)

    WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="new_password"]']), 
        password_stest)

    WebUI.delay(1)

    WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="passwordConfirm"]']), 
        password_stest)

    WebUI.delay(1)

    WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifPassword"]/div[4]/button']))
}

functions.I.Logout()

//4 itroin
functions.I.Login_password('itroin', password_itroin)

if (WebUI.verifyTextPresent('Change your password - itroin', false)) {
    password_stest = data_Tag.getValue(3, 4)

    WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="new_password"]']), 
        password_itroin)

    WebUI.delay(1)

    WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="passwordConfirm"]']), 
        password_itroin)

    WebUI.delay(1)

    WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifPassword"]/div[4]/button']))
}

functions.I.Logout()

//5 igedik
functions.I.Login_password('igedik', password_igedik)

if (WebUI.verifyTextPresent('Change your password - igedik', false)) {
    password_igedik = data_Tag.getValue(3, 5)

    WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="new_password"]']), 
        password_igedik)

    WebUI.delay(1)

    WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="passwordConfirm"]']), 
        password_igedik)

    WebUI.delay(1)

    WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifPassword"]/div[4]/button']))
}

functions.I.Logout()

//6 mderdour
functions.I.Login_password('mderdour', password_mderdour)

'36'
if (WebUI.verifyTextPresent('Change your password - mderdour', false)) {
    password_mderdour = data_Tag.getValue(3, 6)

    WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="new_password"]']), 
        password_mderdour)

    WebUI.delay(1)

    WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="passwordConfirm"]']), 
        password_mderdour)

    WebUI.delay(1)

    WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifPassword"]/div[4]/button']))
}
WebUI.delay(1)
functions.I.Logout()

//7 achatin
functions.I.Login_password('achatin', password_achatin)

if (WebUI.verifyTextPresent('Change your password - achatin', false)) {
    password_achatin = data_Tag.getValue(3, 7)

    WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="new_password"]']), 
        password_achatin)

    WebUI.delay(1)

    WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="passwordConfirm"]']), 
        password_achatin)

    WebUI.delay(1)

    WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifPassword"]/div[4]/button']))
}

functions.I.Logout()

//8 tliu
functions.I.Login_password('tliu', password_tliu)

if (WebUI.verifyTextPresent('Change your password - tliu', false)) {
    password_tliu = data_Tag.getValue(3, 8)

    WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="new_password"]']), 
        password_tliu)

    WebUI.delay(1)

    WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="passwordConfirm"]']), 
        password_tliu)

    WebUI.delay(1)

    WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifPassword"]/div[4]/button']))
}

functions.I.Logout()

//9 ccaramella
functions.I.Login_password('ccaramella', password_ccaramella)

if (WebUI.verifyTextPresent('Change your password - ccaramella', false)) {
    password_ccaramella = data_Tag.getValue(3, 9)

    WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="new_password"]']), 
        password_ccaramella)

    WebUI.delay(1)

    WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="passwordConfirm"]']), 
        password_ccaramella)

    WebUI.delay(1)

    WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifPassword"]/div[4]/button']))
}

functions.I.Logout()

//10 achay
functions.I.Login_password('achay', password_achay)

if (WebUI.verifyTextPresent('Change your password - achay', false)) {
    password_achay = data_Tag.getValue(3, 10)

    WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="new_password"]']), 
        password_achay)

    WebUI.delay(1)

    WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="passwordConfirm"]']), 
        password_achay)

    WebUI.delay(1)

    WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifPassword"]/div[4]/button']))
}

functions.I.Logout()

//11 cbono
functions.I.Login_password('cbono', password_cbono)

if (WebUI.verifyTextPresent('Change your password - cbono', false)) {
    password_achay = data_Tag.getValue(3, 11)

    WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="new_password"]']), 
        password_cbono)

    WebUI.delay(1)

    WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="passwordConfirm"]']), 
        password_cbono)

    WebUI.delay(1)

    WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifPassword"]/div[4]/button']))
}

functions.I.Logout()

//12 pmareri
functions.I.Login_password('pmareri', password_pmareri)

if (WebUI.verifyTextPresent('Change your password - pmareri', false)) {
    password_pmareri = data_Tag.getValue(3, 12)

    WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="new_password"]']), 
        password_pmareri)

    WebUI.delay(1)

    WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="passwordConfirm"]']), 
        password_pmareri)

    WebUI.delay(1)

    WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifPassword"]/div[4]/button']))
}

functions.I.Logout()

//13 qeuzen
functions.I.Login_password('qeuzen', password_qeuzen)

if (WebUI.verifyTextPresent('Change your password - qeuzen', false)) {
    password_qeuzen = data_Tag.getValue(3, 13)

    WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="new_password"]']), 
        password_qeuzen)

    WebUI.delay(1)

    WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="passwordConfirm"]']), 
        password_qeuzen)

    WebUI.delay(1)

    WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifPassword"]/div[4]/button']))
}

functions.I.Logout()

//14 alanglois
functions.I.Login_password('alanglois', password_alanglois)

if (WebUI.verifyTextPresent('Change your password - alanglois', false)) {
    password_alanglois = data_Tag.getValue(3, 14)

    WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="new_password"]']), 
        password_alanglois)

    WebUI.delay(1)

    WebUI.setText(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="passwordConfirm"]']), 
        password_alanglois)

    WebUI.delay(1)

    WebUI.click(findTestObject('xxx Todelete/xpath', [('xpath') : '//*[@id="ModifPassword"]/div[4]/button']))
}

functions.I.Logout()

//PART 2: VERIFICATION OF PASWORD
//PART 2: DATA FIELD: USERNAME_PASSWORD
password_jedun = data_Tag.getValue(3, 1)

// Change to 
password_rrowland = data_Tag.getValue(3, 2)

password_stest = data_Tag.getValue(3, 3)

password_itroin = data_Tag.getValue(3, 4)

password_igedik = data_Tag.getValue(3, 5)

password_mderdour = data_Tag.getValue(3, 6)

password_achatin = data_Tag.getValue(3, 7)

password_tliu = data_Tag.getValue(3, 8)

password_ccaramella = data_Tag.getValue(3, 9)

password_achay = data_Tag.getValue(3, 10)

password_cbono = data_Tag.getValue(3, 11)

password_pmareri = data_Tag.getValue(3, 12)

password_qeuzen = data_Tag.getValue(3, 13)

password_alanglois = data_Tag.getValue(3, 14)

/*
 ///////////////TEST ONLY
def data_Tag = TestDataFactory.findTestData("Data Files/Username_Password/Tag")
String password_jedun = data_Tag.getValue(3,1)

// Change to
String password_rrowland = data_Tag .getValue(3, ,2)
String password_stest = data_Tag.getValue(3, 3)

String password_itroin = data_Tag.getValue(3, 4)

String password_igedik = data_Tag.getValue(3, 5)

String password_mderdour = data_Tag.getValue(3, 6)
String password_achatin = data_Tag .getValue(3, 7)
String password_tliu = data_Tag.getValue(3, 8)

String password_ccaramella = data_Tag.getValue(3, 9)

String password_achay = data_Tag.getValue(3, 10)
String password_cbono = data_Tag.getValue(3,11)
String password_pmareri = data_Tag.getValue(3,12)
String password_qeuzen = data_Tag.getValue(3,13)
String password_alanglois = data_Tag.getValue(3,14)


def data_urlRELAUTO = TestDataFactory.findTestData('Data Files/URL/URL_relauto')

String Url_Tag = data_urlRELAUTO.getValue(2, 3)

//BROWSE & MAXIMIZE BROWSER
WebUI.openBrowser(Url_Tag)

WebUI.maximizeWindow()
 ////TEST ONLY
 */
//VERIFICATION OF PASSSWORD FOR:
//1 jedun
functions.I.Login_password('jedun', password_jedun)

functions.I.Logout()

//2 rrowland
functions.I.Login_password('rrowland', password_rrowland)

functions.I.Logout()

//3 stest
functions.I.Login_password('stest', password_stest)

functions.I.Logout()

//4 itroin
functions.I.Login_password('itroin', password_itroin)

functions.I.Logout()

//5 igedik
functions.I.Login_password('igedik', password_igedik)

functions.I.Logout()

//6 mderdour
functions.I.Login_password('mderdour', password_mderdour)

functions.I.Logout()

//7 achatin
functions.I.Login_password('achatin', password_achatin)

functions.I.Logout()

//8 tliu
functions.I.Login_password('tliu', password_tliu)

functions.I.Logout()

//9 ccaramella
functions.I.Login_password('ccaramella', password_ccaramella)

functions.I.Logout()

//10 achay
functions.I.Login_password('achay', password_achay)

functions.I.Logout()

//11cbono
functions.I.Login_password('cbono', password_cbono)

functions.I.Logout()

//12 pmareri
functions.I.Login_password('pmareri', password_pmareri)

functions.I.Logout()

//13  qeuzen
functions.I.Login_password('qeuzen', password_qeuzen)

functions.I.Logout()

//14  alanglois
functions.I.Login_password('alanglois', password_alanglois)

functions.I.Logout()

WebUI.closeBrowser()

