<?xml version = '1.0' encoding = 'UTF-8'?>
<xsl:stylesheet version="1.0" xmlns:bpws="http://schemas.xmlsoap.org/ws/2003/03/business-process/" xmlns:xp20="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.Xpath20" xmlns:ns0="http://www.MetaDataECM.org" xmlns:mhdr="http://www.oracle.com/XSL/Transform/java/oracle.tip.mediator.service.common.functions.MediatorExtnFunction" xmlns:bpel="http://docs.oasis-open.org/wsbpel/2.0/process/executable" xmlns:oraext="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.ExtFunc" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:dvm="http://www.oracle.com/XSL/Transform/java/oracle.tip.dvm.LookupValue" xmlns:hwf="http://xmlns.oracle.com/bpel/workflow/xpath" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:med="http://schemas.oracle.com/mediator/xpath" xmlns:ids="http://xmlns.oracle.com/bpel/services/IdentityService/xpath" xmlns:bpm="http://xmlns.oracle.com/bpmn20/extensions" xmlns:xdk="http://schemas.oracle.com/bpel/extension/xpath/function/xdk" xmlns:xref="http://www.oracle.com/XSL/Transform/java/oracle.tip.xref.xpath.XRefXPathFunctions" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:bpmn="http://schemas.oracle.com/bpm/xpath" xmlns:ora="http://schemas.oracle.com/xpath/extension" xmlns:socket="http://www.oracle.com/XSL/Transform/java/oracle.tip.adapter.socket.ProtocolTranslator" xmlns:tns="http://imaging.oracle/" xmlns:ldap="http://schemas.oracle.com/xpath/extension/ldap" exclude-result-prefixes="xsi xsl ns0 xsd tns bpws xp20 mhdr bpel oraext dvm hwf med ids bpm xdk xref bpmn ora socket ldap" xmlns:oracle-xsl-mapper="http://www.oracle.com/xsl/mapper/schemas">
  <oracle-xsl-mapper:schema>
      <!--SPECIFICATION OF MAP SOURCES AND TARGETS, DO NOT MODIFY.-->
      <oracle-xsl-mapper:mapSources>
         <oracle-xsl-mapper:source type="XSD">
            <oracle-xsl-mapper:schema location="../xsd/MetaDataECM.xsd"/>
            <oracle-xsl-mapper:rootElement name="MetaDataECMData" namespace="http://www.MetaDataECM.org"/>
            <oracle-xsl-mapper:param name="ECMDataPDO"/>
         </oracle-xsl-mapper:source>
      </oracle-xsl-mapper:mapSources>
      <oracle-xsl-mapper:mapTargets>
         <oracle-xsl-mapper:target type="XSD">
            <oracle-xsl-mapper:schema location="http://eqdev-capture1:16033/imaging/ws/DocumentService?xsd=1"/>
            <oracle-xsl-mapper:rootElement name="updateDocument" namespace="http://imaging.oracle/"/>
         </oracle-xsl-mapper:target>
      </oracle-xsl-mapper:mapTargets>
      <oracle-xsl-mapper:mapShowPrefixes type="true"/>
      <!--GENERATED BY ORACLE XSL MAPPER 12.2.1.3.0(XSLT Build 170820.1700.2557) AT [FRI SEP 09 21:33:38 AEST 2022].-->
   </oracle-xsl-mapper:schema>
   <!--User Editing allowed BELOW this line - DO NOT DELETE THIS LINE-->
   <xsl:template match="/">
    <tns:updateDocument>
      <documentId>
        <xsl:value-of select="/ns0:MetaDataECMData/ns0:MetaDataECMData/ns0:DocID"/>
      </documentId>
       <xsl:for-each select="/ns0:MetaDataECMData/ns0:MetaDataECMData/ns0:Username">
        <fieldValues>
          <xsl:attribute name="name">
            <xsl:text disable-output-escaping="no">Username</xsl:text>
          </xsl:attribute>
          <value>
            <xsl:attribute name="type">
              <xsl:text disable-output-escaping="no">TEXT</xsl:text>
            </xsl:attribute>
            <xsl:value-of select="/ns0:MetaDataECMData/ns0:MetaDataECMData/ns0:Username"/>
          </value>
        </fieldValues>
      </xsl:for-each>
      
      <xsl:for-each select="/ns0:MetaDataECMData/ns0:MetaDataECMData/ns0:VENDORNAME">
        <fieldValues>
          <xsl:attribute name="name">
            <xsl:text disable-output-escaping="no">VENDORNAME</xsl:text>
          </xsl:attribute>
          <value>
            <xsl:attribute name="type">
              <xsl:text disable-output-escaping="no">TEXT</xsl:text>
            </xsl:attribute>
            <xsl:value-of select="/ns0:MetaDataECMData/ns0:MetaDataECMData/ns0:VENDORNAME"/>
          </value>
        </fieldValues>
      </xsl:for-each>
  
    </tns:updateDocument>
  </xsl:template>
</xsl:stylesheet>