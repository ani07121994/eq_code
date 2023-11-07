<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">  
	<xsl:template match="/">
	<html>
 
 
        
		<body >
                   <b ><h2 align="center" style="border: 5px solid black;
        color: black;
        text-align: center;
        text-decoration: underline;
        text-decoration-color: black;font-size:15px">Invoice Details</h2></b>
		
		
			<font size="1">
			
			 <xsl:for-each select="invoice">
			 
			   <table   align="center"  width="90%" border="0" style="outline:thin solid black;border-left: none; border-right: none;">
				
				
				
                    <tr>
					  <td  nowrap="nowrap"  align="center" colspan="5" size="2">
						
						<br/>
					  </td>
					</tr>
				
				
					  <tr>
					    
						<td  nowrap="nowrap"  colspan="2" align="left">
						<font color="#BA0C07"><b>Document Type :&#160;&#160;</b></font><b><xsl:value-of select="documentType"/></b></td>
						
					   <td colspan="1" nowrap="nowrap">&#160;</td>
					   <td colspan="2" nowrap="nowrap"><font color="#BA0C07" ><b>Invoice Type :&#160;&#160;</b></font><b><xsl:value-of select="invType"/></b></td>
					    
					   
					</tr>
					<tr><td  nowrap="nowrap"  align="center" colspan="5" size="2">
						<br/>
					  </td></tr>
					
					<tr>
                                            <td  colspan="2" align="left"  nowrap="nowrap">
						<font color="#BA0C07" ><b>Supplier Name :&#160;&#160;</b></font><b><xsl:value-of select="supplierName"/></b> </td>
						<td colspan="1"  nowrap="nowrap">&#160;</td>
					    <td colspan="2"><font color="#BA0C07" ><b>Supplier No :&#160;&#160;</b></font><b><xsl:value-of select="supplierNo"/></b></td>
						
					</tr>
					
                     <tr>
					 <td nowrap="nowrap"  align="left" colspan="5"><br/>
					</td>
					 </tr>
					 
					 <tr>
						<td  colspan="2" align="left"  nowrap="nowrap">
						<font color="#BA0C07"><b>Site Id :&#160;&#160;</b></font><b><xsl:value-of select="siteId"/>	</b> </td>
						
						<td colspan="1"  nowrap="nowrap">&#160;</td>
					    <td colspan="2"><font color="#BA0C07"><b>Site Name :&#160;&#160;</b></font><b><xsl:value-of select="siteName"/></b></td>

					</tr>
                                        
                                         <tr>
					 <td nowrap="nowrap"  align="left" colspan="5"><br/>
					</td>
					 </tr>
                                         
                                         
                     <tr>
						<td  colspan="2" align="left"  nowrap="nowrap">
						<font color="#BA0C07"><b>Invoice Number :&#160;&#160;</b></font><b><xsl:value-of select="invNumber"/>	</b> </td>
						<td colspan="1"  nowrap="nowrap">&#160;</td>
						<td colspan="2"><font color="#BA0C07"><b>Operating Unit :&#160;&#160;</b></font><b><xsl:value-of select="operatingUnit"/></b></td>

					</tr>
                                         
					
                                        <tr>
					 <td nowrap="nowrap"  align="left" colspan="5"><br/>
					</td>
					 </tr>
					 
					 
					 <tr>
						<td  colspan="2" align="left"  nowrap="nowrap">
						<font color="#BA0C07"><b>Tax Registration Number :&#160;&#160;</b></font><b><xsl:value-of select="taxRegistrationNumber"/>	</b> </td>
						
						<td colspan="1"  nowrap="nowrap">&#160;</td>
					    <td colspan="2"><font color="#BA0C07"><b>Line Total :&#160;&#160;</b></font><b><xsl:value-of select="lineTotal"/></b></td>

					</tr>
					
                     <tr>
					 <td nowrap="nowrap"  align="left" colspan="5"><br/>
					</td>
					 </tr>
					 
					 
					 <tr>
						<td  colspan="2" align="left"  nowrap="nowrap">
						<font color="#BA0C07"><b>PO Number :&#160;&#160;</b></font> <b><xsl:value-of select="poNumber"/></b></td>
						
						<td colspan="1"  nowrap="nowrap">&#160;</td>
					    <td colspan="2"><font color="#BA0C07"><b>Tax Total :&#160;&#160;</b></font><b><xsl:value-of select="taxTotal"/></b></td>
					</tr>
					
                     <tr>
					 <td nowrap="nowrap"  align="left" colspan="5"><br/>
					</td>
					 </tr>
					 
					 <tr>
						<td  colspan="2" align="left"  nowrap="nowrap">
						<font color="#BA0C07"><b>Currency :&#160;&#160;</b></font><b><xsl:value-of select="currency"/></b> </td>
						
						<td colspan="1"  nowrap="nowrap">&#160;</td>
					   <td colspan="2"><font color="#BA0C07"><b>Header Total :&#160;&#160;</b></font><b><xsl:value-of select="headerTotal"/></b></td>
					</tr>
					
                                         <tr>
					 <td nowrap="nowrap"  align="left" colspan="5"><br/>
					</td>
					 </tr>
					 
					 <tr>
						<td  colspan="2" align="left"  nowrap="nowrap">
						<font color="#BA0C07"><b>Certifier Name	:&#160;&#160;</b></font> <b><xsl:value-of select="certifierName"/></b></td>
						
						<td colspan="1"  nowrap="nowrap">&#160;</td>
					   <td colspan="2"><font color="#BA0C07"><b>Employee No :&#160;&#160;</b></font><b><xsl:value-of select="employeeNo"/></b></td>
					
					</tr>
					
                     <tr>
					 <td nowrap="nowrap"  align="left" colspan="5"><br/>
					</td>
					 </tr>
					 
					 <tr>
						<td  colspan="2" align="left"  nowrap="nowrap">
                                                
						<font color="#BA0C07"><b>Certifier Email Id :&#160;&#160;</b></font> <b><xsl:value-of select="certEmailAddress"/></b></td>
						
						<td colspan="1"  nowrap="nowrap">&#160;</td>
					     <td colspan="2"><font color="#BA0C07"><b>Invoice Date :&#160;&#160;</b></font><b><xsl:value-of select="invoiceDate"/></b></td>

					</tr>
					
                     <tr>
					 <td nowrap="nowrap"  align="left" colspan="5"><br/>
					</td>
					 </tr>
					 
					 <tr>
						<td  colspan="2" align="left"  nowrap="nowrap">
						<font color="#BA0C07"><b>Alternate Approver :&#160;&#160;</b></font><b><xsl:value-of select="alternateApprover"/></b> </td>
						
						<td colspan="1"  nowrap="nowrap">&#160;</td>
					    <td colspan="2"></td>
						
					</tr>
					
                    
				         <tr>
					 <td nowrap="nowrap"  align="left" colspan="5"><br/><br/><br/>
					</td>
					 </tr>	
					
				
					<tr>
				<td nowrap="nowrap"  align="left" colspan="5" style="font-size:9px;">

					<ul style="list-style: none;">
                                        
                                        <xsl:if test="requestFlag='true'">
                                                <li><b> Request for payment without an invoice – Nature of this expense does not permit the retention of a Tax Invoice</b></li>
                                                <br/>
                                       </xsl:if>
                                       <xsl:if test="paymentMan='true'">
                                                <li><b>Manual payment Allocation</b></li> 
                                                <br/>
                                                <xsl:if test="paymentWithInv='true'">
                                                    <li><b>pay method CHEQUE pay group MANUAL </b></li>
                                                    <br/>
                                                    <li><b>Payment CHEQUE no :&#160;&#160;</b><b><xsl:value-of select="paymentChequeNo"/></b></li>
                                                </xsl:if>
                                                <xsl:if test="paymentWired='true'">
                                                    <li><b>pay method WIRE pay group MANUAL </b></li>
                                                    <br/>
                                                </xsl:if>
					</xsl:if>	
					</ul>
				</td>

			</tr>
						
				</table>
								
			 </xsl:for-each>
			 
			 
			
			 
			</font>
			
			
			</body>		
	  </html>
	
	</xsl:template>
</xsl:stylesheet>