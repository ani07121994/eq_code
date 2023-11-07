
package org.invoicerouter;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.invoicerouter package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.invoicerouter
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InvoiceImport }
     * 
     */
    public InvoiceImport createInvoiceImport() {
        return new InvoiceImport();
    }

    /**
     * Create an instance of {@link InvoiceImport.LineItems }
     * 
     */
    public InvoiceImport.LineItems createInvoiceImportLineItems() {
        return new InvoiceImport.LineItems();
    }

    /**
     * Create an instance of {@link InvoiceImport.Header }
     * 
     */
    public InvoiceImport.Header createInvoiceImportHeader() {
        return new InvoiceImport.Header();
    }

    /**
     * Create an instance of {@link InvoiceImport.Additionalinfo }
     * 
     */
    public InvoiceImport.Additionalinfo createInvoiceImportAdditionalinfo() {
        return new InvoiceImport.Additionalinfo();
    }

    /**
     * Create an instance of {@link InvoiceImport.LineItems.LineItem }
     * 
     */
    public InvoiceImport.LineItems.LineItem createInvoiceImportLineItemsLineItem() {
        return new InvoiceImport.LineItems.LineItem();
    }

}
