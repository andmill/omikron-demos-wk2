import com.katalon.KatalonHelper
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestSuite

import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.context.TestCaseContext

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.AfterTestCase

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import groovy.time.TimeCategory

class TestListener {
	
	String startTime, endTime;
		
	/**
	 * Executes before every test suite starts.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@BeforeTestSuite
	def beforeTestSuite(TestSuiteContext testSuiteContext) {
		KatalonHelper.updateInfo()
		
		println("**** in @BeforeTestSuite")
		
		// stop suite on failure, setup var as false
		GlobalVariable.skip_remaining_tests=false
	}
	
	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		def dateTime = new Date();
		startTime = dateTime.format('yyyy-MM-dd') + 'T' + dateTime.format('HH:mm:ss');
		println("start time: " + startTime)
				
		// skip test cases if marked as failed
		if (GlobalVariable.skip_remaining_tests) {
			testCaseContext.skipThisTestCase()
			println("Test Case Skipped")
		}
		
		// open browser
	}
	
	@AfterTestCase
	def afterCase(TestCaseContext testCaseContext) {
		println("**** in @AfterTestCase")
		
		// Set skip var as true if  
		if(testCaseContext.testCaseStatus=="FAILED") {
			GlobalVariable.skip_remaining_tests = true
		}
		WebUI.closeBrowser()
		
		def dateTime = new Date();
		endTime = dateTime.format('yyyy-MM-dd') + 'T' + dateTime.format('HH:mm:ss');
		println("end time: " + endTime)
		
		String status = "PASS";
		if (testCaseContext.testCaseStatus=="FAILED") status = "FAIL";
		String testKey = testCaseContext.getTestCaseVariables().get("testKey").toString();
		
		// Xray reporting
		WS.sendRequest(findTestObject('Xray/POST-test-result', [('testKey') : testKey, ('status') : status, ('startTime') : startTime, ('endTime') : endTime]))
//		WebUI.callTestCase(findTestCase('Common Test Cases/Xray-post-result'), [('testKey') : testKey, ('status') : status, ('startTime') : startTime, ('endTime') : endTime])
	}
	
	@AfterTestSuite
	def afterSuite() {
		WebUI.closeBrowser()
	}
	
	
	
	
}