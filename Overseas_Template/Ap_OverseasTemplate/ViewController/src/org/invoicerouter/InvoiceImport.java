
package org.invoicerouter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="header" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="documentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="invoiceType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="orgID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="invoiceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="invoiceDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="vendorId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="vendorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="vendorNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="vendorSiteID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="InvoiceSiteID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="PONumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="tax" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *                   &lt;element name="withholdingTax" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *                   &lt;element name="invoiceTotalAmount" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *                   &lt;element name="currencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Certifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="invalidReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="invalidCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ABN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Subtotal" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *                   &lt;element name="accountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Freight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="misc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="currencyEquivalent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="WHTAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Inv_Filename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Certifier_number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Certifier_email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Certification_Flag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Payment_group" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Payment_method" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Payment_allocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Payment_without_Inv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="UserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="AlternateApproverName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="AlternateApproverNote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="header1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="header2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="header3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="header4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="header5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="header6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="header7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="header8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="header9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="header10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="OriginalfilePath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Operating_unit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="additionalinfo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="docID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="imageURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Priority" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DocScanDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="BatchID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DueDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="srcSystem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="lineItems" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="lineItem" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="lineNumber" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                             &lt;element name="linePONumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="linePOLineNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *                             &lt;element name="materialNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="UOM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="unitPrice" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *                             &lt;element name="lineTotalAmount" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *                             &lt;element name="lineType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TaxAmount" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *                             &lt;element name="TaxRate" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *                             &lt;element name="GLCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ProjectCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TaskNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ExpDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ExpType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="RecCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Line1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Line2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Line3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Line4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Line5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Line6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Line7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Line8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Line9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Line10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "header",
    "additionalinfo",
    "lineItems"
})
@XmlRootElement(name = "invoiceImport")
public class InvoiceImport {

    protected InvoiceImport.Header header;
    protected InvoiceImport.Additionalinfo additionalinfo;
    protected InvoiceImport.LineItems lineItems;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceImport.Header }
     *     
     */
    public InvoiceImport.Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceImport.Header }
     *     
     */
    public void setHeader(InvoiceImport.Header value) {
        this.header = value;
    }

    /**
     * Gets the value of the additionalinfo property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceImport.Additionalinfo }
     *     
     */
    public InvoiceImport.Additionalinfo getAdditionalinfo() {
        return additionalinfo;
    }

    /**
     * Sets the value of the additionalinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceImport.Additionalinfo }
     *     
     */
    public void setAdditionalinfo(InvoiceImport.Additionalinfo value) {
        this.additionalinfo = value;
    }

    /**
     * Gets the value of the lineItems property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceImport.LineItems }
     *     
     */
    public InvoiceImport.LineItems getLineItems() {
        return lineItems;
    }

    /**
     * Sets the value of the lineItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceImport.LineItems }
     *     
     */
    public void setLineItems(InvoiceImport.LineItems value) {
        this.lineItems = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="docID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="imageURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Priority" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DocScanDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="BatchID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="DueDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="srcSystem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "docID",
        "imageURL",
        "priority",
        "docScanDate",
        "batchID",
        "dueDate",
        "srcSystem"
    })
    public static class Additionalinfo {

        protected String docID;
        protected String imageURL;
        @XmlElement(name = "Priority")
        protected String priority;
        @XmlElement(name = "DocScanDate")
        protected String docScanDate;
        @XmlElement(name = "BatchID")
        protected String batchID;
        @XmlElement(name = "DueDate")
        protected String dueDate;
        protected String srcSystem;

        /**
         * Gets the value of the docID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDocID() {
            return docID;
        }

        /**
         * Sets the value of the docID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDocID(String value) {
            this.docID = value;
        }

        /**
         * Gets the value of the imageURL property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getImageURL() {
            return imageURL;
        }

        /**
         * Sets the value of the imageURL property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setImageURL(String value) {
            this.imageURL = value;
        }

        /**
         * Gets the value of the priority property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPriority() {
            return priority;
        }

        /**
         * Sets the value of the priority property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPriority(String value) {
            this.priority = value;
        }

        /**
         * Gets the value of the docScanDate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDocScanDate() {
            return docScanDate;
        }

        /**
         * Sets the value of the docScanDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDocScanDate(String value) {
            this.docScanDate = value;
        }

        /**
         * Gets the value of the batchID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBatchID() {
            return batchID;
        }

        /**
         * Sets the value of the batchID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBatchID(String value) {
            this.batchID = value;
        }

        /**
         * Gets the value of the dueDate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDueDate() {
            return dueDate;
        }

        /**
         * Sets the value of the dueDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDueDate(String value) {
            this.dueDate = value;
        }

        /**
         * Gets the value of the srcSystem property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSrcSystem() {
            return srcSystem;
        }

        /**
         * Sets the value of the srcSystem property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSrcSystem(String value) {
            this.srcSystem = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="documentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="invoiceType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="orgID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="invoiceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="invoiceDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="vendorId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="vendorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="vendorNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="vendorSiteID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="InvoiceSiteID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="PONumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="tax" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
     *         &lt;element name="withholdingTax" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
     *         &lt;element name="invoiceTotalAmount" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
     *         &lt;element name="currencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Certifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="invalidReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="invalidCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ABN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Subtotal" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
     *         &lt;element name="accountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Freight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *         &lt;element name="misc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="currencyEquivalent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="WHTAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Inv_Filename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Certifier_number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Certifier_email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Certification_Flag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Payment_group" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Payment_method" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Payment_allocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Payment_without_Inv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="UserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="AlternateApproverName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="AlternateApproverNote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="header1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="header2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="header3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="header4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="header5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="header6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="header7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="header8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="header9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="header10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="OriginalfilePath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Operating_unit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "documentType",
        "invoiceType",
        "orgID",
        "invoiceNumber",
        "invoiceDate",
        "vendorId",
        "vendorName",
        "vendorNumber",
        "vendorSiteID",
        "invoiceSiteID",
        "poNumber",
        "tax",
        "withholdingTax",
        "invoiceTotalAmount",
        "currencyCode",
        "certifier",
        "invalidReason",
        "invalidCode",
        "abn",
        "subtotal",
        "accountNumber",
        "freight",
        "misc",
        "currencyEquivalent",
        "whtAmount",
        "invFilename",
        "certifierNumber",
        "certifierEmail",
        "certificationFlag",
        "paymentGroup",
        "paymentMethod",
        "paymentAllocation",
        "paymentWithoutInv",
        "userName",
        "userId",
        "alternateApproverName",
        "alternateApproverNote",
        "header1",
        "header2",
        "header3",
        "header4",
        "header5",
        "header6",
        "header7",
        "header8",
        "header9",
        "header10",
        "originalfilePath",
        "operatingUnit",
        "electRemittence" //923018 Start UI Change for New Field
    })
    public static class Header {

        protected String documentType;
        protected String invoiceType;
        protected String orgID;
        protected String invoiceNumber;
        protected String invoiceDate;
        protected String vendorId;
        protected String vendorName;
        protected String vendorNumber;
        protected String vendorSiteID;
        @XmlElement(name = "InvoiceSiteID")
        protected String invoiceSiteID;
        @XmlElement(name = "PONumber")
        protected String poNumber;
        protected BigDecimal tax;
        protected BigDecimal withholdingTax;
        protected BigDecimal invoiceTotalAmount;
        protected String currencyCode;
        @XmlElement(name = "Certifier")
        protected String certifier;
        protected String invalidReason;
        protected String invalidCode;
        @XmlElement(name = "ABN")
        protected String abn;
        @XmlElement(name = "Subtotal")
        protected BigDecimal subtotal;
        protected String accountNumber;
        @XmlElement(name = "Freight")
        protected BigDecimal freight;
        protected String misc;
        protected String currencyEquivalent;
        @XmlElement(name = "WHTAmount")
        protected String whtAmount;
        @XmlElement(name = "Inv_Filename")
        protected String invFilename;
        @XmlElement(name = "Certifier_number")
        protected String certifierNumber;
        @XmlElement(name = "Certifier_email")
        protected String certifierEmail;
        @XmlElement(name = "Certification_Flag")
        protected String certificationFlag;
        @XmlElement(name = "Payment_group")
        protected String paymentGroup;
        @XmlElement(name = "Payment_method")
        protected String paymentMethod;
        @XmlElement(name = "Payment_allocation")
        protected String paymentAllocation;
        @XmlElement(name = "Payment_without_Inv")
        protected String paymentWithoutInv;
        @XmlElement(name = "UserName")
        protected String userName;
        @XmlElement(name = "UserId")
        protected String userId;
        @XmlElement(name = "AlternateApproverName")
        protected String alternateApproverName;
        @XmlElement(name = "AlternateApproverNote")
        protected String alternateApproverNote;
        protected String header1;
        protected String header2;
        protected String header3;
        protected String header4;
        protected String header5;
        protected String header6;
        protected String header7;
        protected String header8;
        protected String header9;
        protected String header10;
        @XmlElement(name = "OriginalfilePath")
        protected String originalfilePath;
        @XmlElement(name = "Operating_unit")
        protected String operatingUnit;
        //923018 Start UI Change for New Field 
        @XmlElement(name = "Elect_Remittance")
        protected String electRemittence;
        //923018 End UI Change for New Field 

        /**
         * Gets the value of the documentType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDocumentType() {
            return documentType;
        }

        /**
         * Sets the value of the documentType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDocumentType(String value) {
            this.documentType = value;
        }

        /**
         * Gets the value of the invoiceType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInvoiceType() {
            return invoiceType;
        }

        /**
         * Sets the value of the invoiceType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInvoiceType(String value) {
            this.invoiceType = value;
        }

        /**
         * Gets the value of the orgID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOrgID() {
            return orgID;
        }

        /**
         * Sets the value of the orgID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOrgID(String value) {
            this.orgID = value;
        }

        /**
         * Gets the value of the invoiceNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInvoiceNumber() {
            return invoiceNumber;
        }

        /**
         * Sets the value of the invoiceNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInvoiceNumber(String value) {
            this.invoiceNumber = value;
        }

        /**
         * Gets the value of the invoiceDate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInvoiceDate() {
            return invoiceDate;
        }

        /**
         * Sets the value of the invoiceDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInvoiceDate(String value) {
            this.invoiceDate = value;
        }

        /**
         * Gets the value of the vendorId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVendorId() {
            return vendorId;
        }

        /**
         * Sets the value of the vendorId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVendorId(String value) {
            this.vendorId = value;
        }

        /**
         * Gets the value of the vendorName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVendorName() {
            return vendorName;
        }

        /**
         * Sets the value of the vendorName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVendorName(String value) {
            this.vendorName = value;
        }

        /**
         * Gets the value of the vendorNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVendorNumber() {
            return vendorNumber;
        }

        /**
         * Sets the value of the vendorNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVendorNumber(String value) {
            this.vendorNumber = value;
        }

        /**
         * Gets the value of the vendorSiteID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVendorSiteID() {
            return vendorSiteID;
        }

        /**
         * Sets the value of the vendorSiteID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVendorSiteID(String value) {
            this.vendorSiteID = value;
        }

        /**
         * Gets the value of the invoiceSiteID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInvoiceSiteID() {
            return invoiceSiteID;
        }

        /**
         * Sets the value of the invoiceSiteID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInvoiceSiteID(String value) {
            this.invoiceSiteID = value;
        }

        /**
         * Gets the value of the poNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPONumber() {
            return poNumber;
        }

        /**
         * Sets the value of the poNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPONumber(String value) {
            this.poNumber = value;
        }

        /**
         * Gets the value of the tax property.
         * 
         * @return
         *     possible object is
         *     {@link Float }
         *     
         */
        public BigDecimal getTax() {
            return tax;
        }

        /**
         * Sets the value of the tax property.
         * 
         * @param value
         *     allowed object is
         *     {@link Float }
         *     
         */
        public void setTax(BigDecimal value) {
            this.tax = value;
        }

        /**
         * Gets the value of the withholdingTax property.
         * 
         * @return
         *     possible object is
         *     {@link Float }
         *     
         */
        public BigDecimal getWithholdingTax() {
            return withholdingTax;
        }

        /**
         * Sets the value of the withholdingTax property.
         * 
         * @param value
         *     allowed object is
         *     {@link Float }
         *     
         */
        public void setWithholdingTax(BigDecimal value) {
            this.withholdingTax = value;
        }

        /**
         * Gets the value of the invoiceTotalAmount property.
         * 
         * @return
         *     possible object is
         *     {@link Float }
         *     
         */
        public BigDecimal getInvoiceTotalAmount() {
            return invoiceTotalAmount;
        }

        /**
         * Sets the value of the invoiceTotalAmount property.
         * 
         * @param value
         *     allowed object is
         *     {@link Float }
         *     
         */
        public void setInvoiceTotalAmount(BigDecimal value) {
            this.invoiceTotalAmount = value;
        }

        /**
         * Gets the value of the currencyCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCurrencyCode() {
            return currencyCode;
        }

        /**
         * Sets the value of the currencyCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCurrencyCode(String value) {
            this.currencyCode = value;
        }

        /**
         * Gets the value of the certifier property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCertifier() {
            return certifier;
        }

        /**
         * Sets the value of the certifier property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCertifier(String value) {
            this.certifier = value;
        }

        /**
         * Gets the value of the invalidReason property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInvalidReason() {
            return invalidReason;
        }

        /**
         * Sets the value of the invalidReason property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInvalidReason(String value) {
            this.invalidReason = value;
        }

        /**
         * Gets the value of the invalidCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInvalidCode() {
            return invalidCode;
        }

        /**
         * Sets the value of the invalidCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInvalidCode(String value) {
            this.invalidCode = value;
        }

        /**
         * Gets the value of the abn property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getABN() {
            return abn;
        }

        /**
         * Sets the value of the abn property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setABN(String value) {
            this.abn = value;
        }

        /**
         * Gets the value of the subtotal property.
         * 
         * @return
         *     possible object is
         *     {@link Float }
         *     
         */
        public BigDecimal getSubtotal() {
            return subtotal;
        }

        /**
         * Sets the value of the subtotal property.
         * 
         * @param value
         *     allowed object is
         *     {@link Float }
         *     
         */
        public void setSubtotal(BigDecimal value) {
            this.subtotal = value;
        }

        /**
         * Gets the value of the accountNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAccountNumber() {
            return accountNumber;
        }

        /**
         * Sets the value of the accountNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAccountNumber(String value) {
            this.accountNumber = value;
        }

        /**
         * Gets the value of the freight property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFreight() {
            return freight;
        }

        /**
         * Sets the value of the freight property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFreight(BigDecimal value) {
            this.freight = value;
        }

        /**
         * Gets the value of the misc property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMisc() {
            return misc;
        }

        /**
         * Sets the value of the misc property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMisc(String value) {
            this.misc = value;
        }

        /**
         * Gets the value of the currencyEquivalent property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCurrencyEquivalent() {
            return currencyEquivalent;
        }

        /**
         * Sets the value of the currencyEquivalent property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCurrencyEquivalent(String value) {
            this.currencyEquivalent = value;
        }

        /**
         * Gets the value of the whtAmount property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getWHTAmount() {
            return whtAmount;
        }

        /**
         * Sets the value of the whtAmount property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setWHTAmount(String value) {
            this.whtAmount = value;
        }

        /**
         * Gets the value of the invFilename property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInvFilename() {
            return invFilename;
        }

        /**
         * Sets the value of the invFilename property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInvFilename(String value) {
            this.invFilename = value;
        }

        /**
         * Gets the value of the certifierNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCertifierNumber() {
            return certifierNumber;
        }

        /**
         * Sets the value of the certifierNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCertifierNumber(String value) {
            this.certifierNumber = value;
        }

        /**
         * Gets the value of the certifierEmail property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCertifierEmail() {
            return certifierEmail;
        }

        /**
         * Sets the value of the certifierEmail property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCertifierEmail(String value) {
            this.certifierEmail = value;
        }

        /**
         * Gets the value of the certificationFlag property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCertificationFlag() {
            return certificationFlag;
        }

        /**
         * Sets the value of the certificationFlag property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCertificationFlag(String value) {
            this.certificationFlag = value;
        }

        /**
         * Gets the value of the paymentGroup property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaymentGroup() {
            return paymentGroup;
        }

        /**
         * Sets the value of the paymentGroup property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaymentGroup(String value) {
            this.paymentGroup = value;
        }

        /**
         * Gets the value of the paymentMethod property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaymentMethod() {
            return paymentMethod;
        }

        /**
         * Sets the value of the paymentMethod property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaymentMethod(String value) {
            this.paymentMethod = value;
        }

        /**
         * Gets the value of the paymentAllocation property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaymentAllocation() {
            return paymentAllocation;
        }

        /**
         * Sets the value of the paymentAllocation property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaymentAllocation(String value) {
            this.paymentAllocation = value;
        }

        /**
         * Gets the value of the paymentWithoutInv property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaymentWithoutInv() {
            return paymentWithoutInv;
        }

        /**
         * Sets the value of the paymentWithoutInv property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaymentWithoutInv(String value) {
            this.paymentWithoutInv = value;
        }

        /**
         * Gets the value of the userName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUserName() {
            return userName;
        }

        /**
         * Sets the value of the userName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUserName(String value) {
            this.userName = value;
        }

        /**
         * Gets the value of the userId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUserId() {
            return userId;
        }

        /**
         * Sets the value of the userId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUserId(String value) {
            this.userId = value;
        }

        /**
         * Gets the value of the alternateApproverName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAlternateApproverName() {
            return alternateApproverName;
        }

        /**
         * Sets the value of the alternateApproverName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAlternateApproverName(String value) {
            this.alternateApproverName = value;
        }

        /**
         * Gets the value of the alternateApproverNote property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAlternateApproverNote() {
            return alternateApproverNote;
        }

        /**
         * Sets the value of the alternateApproverNote property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAlternateApproverNote(String value) {
            this.alternateApproverNote = value;
        }

        /**
         * Gets the value of the header1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHeader1() {
            return header1;
        }

        /**
         * Sets the value of the header1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHeader1(String value) {
            this.header1 = value;
        }

        /**
         * Gets the value of the header2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHeader2() {
            return header2;
        }

        /**
         * Sets the value of the header2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHeader2(String value) {
            this.header2 = value;
        }

        /**
         * Gets the value of the header3 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHeader3() {
            return header3;
        }

        /**
         * Sets the value of the header3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHeader3(String value) {
            this.header3 = value;
        }

        /**
         * Gets the value of the header4 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHeader4() {
            return header4;
        }

        /**
         * Sets the value of the header4 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHeader4(String value) {
            this.header4 = value;
        }

        /**
         * Gets the value of the header5 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHeader5() {
            return header5;
        }

        /**
         * Sets the value of the header5 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHeader5(String value) {
            this.header5 = value;
        }

        /**
         * Gets the value of the header6 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHeader6() {
            return header6;
        }

        /**
         * Sets the value of the header6 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHeader6(String value) {
            this.header6 = value;
        }

        /**
         * Gets the value of the header7 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHeader7() {
            return header7;
        }

        /**
         * Sets the value of the header7 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHeader7(String value) {
            this.header7 = value;
        }

        /**
         * Gets the value of the header8 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHeader8() {
            return header8;
        }

        /**
         * Sets the value of the header8 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHeader8(String value) {
            this.header8 = value;
        }

        /**
         * Gets the value of the header9 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHeader9() {
            return header9;
        }

        /**
         * Sets the value of the header9 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHeader9(String value) {
            this.header9 = value;
        }

        /**
         * Gets the value of the header10 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHeader10() {
            return header10;
        }

        /**
         * Sets the value of the header10 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHeader10(String value) {
            this.header10 = value;
        }

        /**
         * Gets the value of the originalfilePath property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOriginalfilePath() {
            return originalfilePath;
        }

        /**
         * Sets the value of the originalfilePath property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOriginalfilePath(String value) {
            this.originalfilePath = value;
        }

        /**
         * Gets the value of the operatingUnit property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOperatingUnit() {
            return operatingUnit;
        }

        /**
         * Sets the value of the operatingUnit property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOperatingUnit(String value) {
            this.operatingUnit = value;
        }
        //923018 Start UI Change for New Field
        public void setElectRemittence(String electRemittence) {
            this.electRemittence = electRemittence;
        }

        public String getElectRemittence() {
            return electRemittence;
        }
        //923018 End UI Change for New Field
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="lineItem" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="lineNumber" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *                   &lt;element name="linePONumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="linePOLineNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
     *                   &lt;element name="materialNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="UOM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="unitPrice" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
     *                   &lt;element name="lineTotalAmount" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
     *                   &lt;element name="lineType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TaxAmount" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
     *                   &lt;element name="TaxRate" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
     *                   &lt;element name="GLCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ProjectCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TaskNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ExpDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ExpType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="RecCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Line1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Line2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Line3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Line4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Line5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Line6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Line7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Line8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Line9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Line10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "lineItem"
    })
    public static class LineItems {

        protected List<InvoiceImport.LineItems.LineItem> lineItem;

        /**
         * Gets the value of the lineItem property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the lineItem property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLineItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link InvoiceImport.LineItems.LineItem }
         * 
         * 
         */
        public List<InvoiceImport.LineItems.LineItem> getLineItem() {
            if (lineItem == null) {
                lineItem = new ArrayList<InvoiceImport.LineItems.LineItem>();
            }
            return this.lineItem;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="lineNumber" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
         *         &lt;element name="linePONumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="linePOLineNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
         *         &lt;element name="materialNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="UOM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="unitPrice" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
         *         &lt;element name="lineTotalAmount" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
         *         &lt;element name="lineType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TaxAmount" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
         *         &lt;element name="TaxRate" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
         *         &lt;element name="GLCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ProjectCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TaskNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ExpDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ExpType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="RecCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Line1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Line2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Line3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Line4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Line5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Line6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Line7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Line8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Line9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Line10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "lineNumber",
            "linePONumber",
            "linePOLineNumber",
            "description",
            "quantity",
            "materialNumber",
            "uom",
            "unitPrice",
            "lineTotalAmount",
            "lineType",
            "taxAmount",
            "taxRate",
            "glCode",
            "projectCode",
            "taskNo",
            "expDate",
            "expType",
            "recCode",
        "suspenseAccFlag",
            "line1",
            "line2",
            "line3",
            "line4",
            "line5",
            "line6",
            "line7",
            "line8",
            "line9",
            "line10"
        })
        public static class LineItem {

            protected BigInteger lineNumber;
            protected String linePONumber;
            protected String linePOLineNumber;
            protected String description;
            protected BigDecimal quantity;
            @XmlElement(required = true)
            protected String materialNumber;
            @XmlElement(name = "UOM")
            protected String uom;
            protected BigDecimal unitPrice;
            protected BigDecimal lineTotalAmount;
            protected String lineType;
            @XmlElement(name = "TaxAmount")
            protected BigDecimal taxAmount;
            @XmlElement(name = "TaxRate")
            protected BigDecimal taxRate;
            @XmlElement(name = "GLCode")
            protected String glCode;
            @XmlElement(name = "ProjectCode")
            protected String projectCode;
            @XmlElement(name = "TaskNo")
            protected String taskNo;
            @XmlElement(name = "ExpDate")
            protected String expDate;
            @XmlElement(name = "ExpType")
            protected String expType;
            @XmlElement(name = "RecCode")
            protected String recCode;
            @XmlElement(name = "SuspenseAccFlag")
            protected String suspenseAccFlag;
            @XmlElement(name = "Line1")
            protected String line1;
            @XmlElement(name = "Line2")
            protected String line2;
            @XmlElement(name = "Line3")
            protected String line3;
            @XmlElement(name = "Line4")
            protected String line4;
            @XmlElement(name = "Line5")
            protected String line5;
            @XmlElement(name = "Line6")
            protected String line6;
            @XmlElement(name = "Line7")
            protected String line7;
            @XmlElement(name = "Line8")
            protected String line8;
            @XmlElement(name = "Line9")
            protected String line9;
            @XmlElement(name = "Line10")
            protected String line10;

            /**
             * Gets the value of the lineNumber property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getLineNumber() {
                return lineNumber;
            }

            /**
             * Sets the value of the lineNumber property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setLineNumber(BigInteger value) {
                this.lineNumber = value;
            }

            /**
             * Gets the value of the linePONumber property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLinePONumber() {
                return linePONumber;
            }

            /**
             * Sets the value of the linePONumber property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLinePONumber(String value) {
                this.linePONumber = value;
            }

            /**
             * Gets the value of the linePOLineNumber property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLinePOLineNumber() {
                return linePOLineNumber;
            }

            /**
             * Sets the value of the linePOLineNumber property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLinePOLineNumber(String value) {
                this.linePOLineNumber = value;
            }

            /**
             * Gets the value of the description property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDescription() {
                return description;
            }

            /**
             * Sets the value of the description property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDescription(String value) {
                this.description = value;
            }

            /**
             * Gets the value of the quantity property.
             * 
             * @return
             *     possible object is
             *     {@link Float }
             *     
             */
            public BigDecimal getQuantity() {
                return quantity;
            }

            /**
             * Sets the value of the quantity property.
             * 
             * @param value
             *     allowed object is
             *     {@link Float }
             *     
             */
            public void setQuantity(BigDecimal value) {
                this.quantity = value;
            }

            /**
             * Gets the value of the materialNumber property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMaterialNumber() {
                return materialNumber;
            }

            /**
             * Sets the value of the materialNumber property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMaterialNumber(String value) {
                this.materialNumber = value;
            }

            /**
             * Gets the value of the uom property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUOM() {
                return uom;
            }

            /**
             * Sets the value of the uom property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUOM(String value) {
                this.uom = value;
            }

            /**
             * Gets the value of the unitPrice property.
             * 
             * @return
             *     possible object is
             *     {@link Float }
             *     
             */
            public BigDecimal getUnitPrice() {
                return unitPrice;
            }

            /**
             * Sets the value of the unitPrice property.
             * 
             * @param value
             *     allowed object is
             *     {@link Float }
             *     
             */
            public void setUnitPrice(BigDecimal value) {
                this.unitPrice = value;
            }

            /**
             * Gets the value of the lineTotalAmount property.
             * 
             * @return
             *     possible object is
             *     {@link Float }
             *     
             */
            public BigDecimal getLineTotalAmount() {
                return lineTotalAmount;
            }

            /**
             * Sets the value of the lineTotalAmount property.
             * 
             * @param value
             *     allowed object is
             *     {@link Float }
             *     
             */
            public void setLineTotalAmount(BigDecimal value) {
                this.lineTotalAmount = value;
            }

            /**
             * Gets the value of the lineType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLineType() {
                return lineType;
            }

            /**
             * Sets the value of the lineType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLineType(String value) {
                this.lineType = value;
            }

            /**
             * Gets the value of the taxAmount property.
             * 
             * @return
             *     possible object is
             *     {@link Float }
             *     
             */
            public BigDecimal getTaxAmount() {
                return taxAmount;
            }

            /**
             * Sets the value of the taxAmount property.
             * 
             * @param value
             *     allowed object is
             *     {@link Float }
             *     
             */
            public void setTaxAmount(BigDecimal value) {
                this.taxAmount = value;
            }

            /**
             * Gets the value of the taxRate property.
             * 
             * @return
             *     possible object is
             *     {@link Float }
             *     
             */
            public BigDecimal getTaxRate() {
                return taxRate;
            }

            /**
             * Sets the value of the taxRate property.
             * 
             * @param value
             *     allowed object is
             *     {@link Float }
             *     
             */
            public void setTaxRate(BigDecimal value) {
                this.taxRate = value;
            }

            /**
             * Gets the value of the glCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getGLCode() {
                return glCode;
            }

            /**
             * Sets the value of the glCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setGLCode(String value) {
                this.glCode = value;
            }

            /**
             * Gets the value of the projectCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProjectCode() {
                return projectCode;
            }

            /**
             * Sets the value of the projectCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProjectCode(String value) {
                this.projectCode = value;
            }

            /**
             * Gets the value of the taskNo property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTaskNo() {
                return taskNo;
            }

            /**
             * Sets the value of the taskNo property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTaskNo(String value) {
                this.taskNo = value;
            }

            /**
             * Gets the value of the expDate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getExpDate() {
                return expDate;
            }

            /**
             * Sets the value of the expDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setExpDate(String value) {
                this.expDate = value;
            }

            /**
             * Gets the value of the expType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getExpType() {
                return expType;
            }

            /**
             * Sets the value of the expType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setExpType(String value) {
                this.expType = value;
            }

            /**
             * Gets the value of the recCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRecCode() {
                return recCode;
            }

            /**
             * Sets the value of the recCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRecCode(String value) {
                this.recCode = value;
            }
            
            /**
             * Gets the value of the suspenseAccFlag property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSuspenseAccFlag() {
                return suspenseAccFlag;
            }

            /**
             * Sets the value of the suspenseAccFlag property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSuspenseAccFlag(String value) {
                this.suspenseAccFlag = value;
            }
            
            
            

            /**
             * Gets the value of the line1 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLine1() {
                return line1;
            }

            /**
             * Sets the value of the line1 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLine1(String value) {
                this.line1 = value;
            }

            /**
             * Gets the value of the line2 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLine2() {
                return line2;
            }

            /**
             * Sets the value of the line2 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLine2(String value) {
                this.line2 = value;
            }

            /**
             * Gets the value of the line3 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLine3() {
                return line3;
            }

            /**
             * Sets the value of the line3 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLine3(String value) {
                this.line3 = value;
            }

            /**
             * Gets the value of the line4 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLine4() {
                return line4;
            }

            /**
             * Sets the value of the line4 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLine4(String value) {
                this.line4 = value;
            }

            /**
             * Gets the value of the line5 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLine5() {
                return line5;
            }

            /**
             * Sets the value of the line5 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLine5(String value) {
                this.line5 = value;
            }

            /**
             * Gets the value of the line6 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLine6() {
                return line6;
            }

            /**
             * Sets the value of the line6 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLine6(String value) {
                this.line6 = value;
            }

            /**
             * Gets the value of the line7 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLine7() {
                return line7;
            }

            /**
             * Sets the value of the line7 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLine7(String value) {
                this.line7 = value;
            }

            /**
             * Gets the value of the line8 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLine8() {
                return line8;
            }

            /**
             * Sets the value of the line8 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLine8(String value) {
                this.line8 = value;
            }

            /**
             * Gets the value of the line9 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLine9() {
                return line9;
            }

            /**
             * Sets the value of the line9 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLine9(String value) {
                this.line9 = value;
            }

            /**
             * Gets the value of the line10 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLine10() {
                return line10;
            }

            /**
             * Sets the value of the line10 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLine10(String value) {
                this.line10 = value;
            }

        }

    }

}
