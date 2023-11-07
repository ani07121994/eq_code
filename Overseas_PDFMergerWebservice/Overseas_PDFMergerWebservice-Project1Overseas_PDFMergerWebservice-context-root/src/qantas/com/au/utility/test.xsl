<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">  
	<xsl:template match="/">
	<html>
		<body>
         
		
		
			<font size="1">
			
			 <xsl:for-each select="invoice">
			 
			   <table  align="center" cellpadding="2" cellspacing="2" width="90%" border="0" style="outline:thin solid black;border-left: none; border-right: none;">
				
				
				
                    <tr>
					  <td  nowrap="nowrap"  align="center" colspan="5" size="2">
					   <!-- <font color="#BA0C07" size="2" ><b><u><xsl:value-of select="appTyp"/> Application: (Staff Number: <xsl:value-of select="staffNum"/>)</u></b></font> -->
						
						<!--<font color="#BA0C07" size="2" ><b><u><xsl:value-of select="appTyp"/> Application: (Staff Number: <xsl:value-of select="staffNum"/>)</u></b></font>-->
						
						<br/>
					  </td>
					</tr>
				
				
					  <tr>
					    
						<td  nowrap="nowrap"  colspan="1" align="left">
						<font color="#BA0C07" ><b><u>documentType :</u></b></font> </td>
						
					   <td colspan="1"  nowrap="nowrap" ><b>&#160;<xsl:value-of select="documentType"/></b> </td>
					   <td colspan="3" nowrap="nowrap"></td>
					</tr>
					
					
					<tr>
						<td  colspan="1" align="left"  nowrap="nowrap">
						<font color="#BA0C07"><b><u>Name :</u></b></font> </td>
						<td colspan="2"  nowrap="nowrap">
							<b><xsl:value-of select="givenName"/> &#160; <xsl:value-of select="supplierName"/>  &#160; <xsl:value-of select="familyName"/></b>
						</td>
					    <td colspan="2"></td>
					</tr>
					
                     <tr>
					 <td nowrap="nowrap"  align="left" colspan="5"><br/>
					</td>
					 </tr>
					
					
						
				
					
						
				</table>
								
			 </xsl:for-each>
			 
			 
			 
			 
			</font>
			
			
			</body>		
	  </html>
	
	</xsl:template>
</xsl:stylesheet>