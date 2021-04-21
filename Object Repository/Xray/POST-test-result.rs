<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>POST-test-result</name>
   <tag></tag>
   <elementGuidId>663f7210-a4c8-4c82-853c-9be4526e24d0</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n\t\&quot;tests\&quot; : [\n\t\t{\n            \&quot;testKey\&quot; : \&quot;${testKey}\&quot;,\n            \&quot;start\&quot; : \&quot;${startTime}\&quot;,\n            \&quot;finish\&quot; : \&quot;${endTime}\&quot;,\n            \&quot;comment\&quot; : \&quot;Demo comment 1.\&quot;,\n            \&quot;status\&quot; : \&quot;${status}\&quot;\n        }\n    ]\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Basic dXNlcjM3OmJsYS0xMjM0</value>
   </httpHeaderProperties>
   <katalonVersion>7.9.1</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://sandbox.xpand-it.com/rest/raven/1.0/import/execution</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'OMI-1'</defaultValue>
      <description></description>
      <id>aa9febf7-21a9-4cfa-b85d-44b2344850d7</id>
      <masked>false</masked>
      <name>testKey</name>
   </variables>
   <variables>
      <defaultValue>'FAIL'</defaultValue>
      <description></description>
      <id>1a0f2bbf-db99-46ea-8bc3-d3d55f531012</id>
      <masked>false</masked>
      <name>status</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>8b387182-693d-43f5-a917-4062cced4ab2</id>
      <masked>false</masked>
      <name>startTime</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>36e95ab5-bdbe-49a8-b5e6-b2660788209f</id>
      <masked>false</masked>
      <name>endTime</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
