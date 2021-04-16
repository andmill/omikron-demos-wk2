package com.tm

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class retries extends WebUICustomKeywords {
	
	/**
	 * Method to retry click on elements that are possibly slow to load or hidden in the DOM.
	 * @param to TestObject to find and try click
	 * @return null
	 */
	@Keyword
	def retryClick(TestObject to){
		int i = 0, max = 5
		if (isElementPresent(to, 5)) {
			while(i < max) {
				try {
					WebUI.click(to)
					break
				} catch (Exception e) {
					println("some error message: stack: " + e.getMessage())
					WebUI.delay(1)
					i++
				}
			}
		}
	}
	
	
}
