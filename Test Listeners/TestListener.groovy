import com.katalon.KatalonHelper
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestSuite

import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.context.TestCaseContext

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.AfterTestCase

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

class TestListener {
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
		println("**** in @BeforeTestCase")
		
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
	}
	
	@AfterTestSuite
	def afterSuite() {
		WebUI.closeBrowser()
	}
	
	
	
	
}