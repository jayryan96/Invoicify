package com.el.ally.invoicify.models;

public class InvoiceView {

    private String invoiceDescription;
    private int[] recordIds;

    public InvoiceView(String invoiceDescription, int[] recordIds) {
        this.invoiceDescription = invoiceDescription;
        this.recordIds = recordIds;
    }

    public InvoiceView() {
    	
    }
    
    public String getInvoiceDescription() {
        return invoiceDescription;
    }

    public int[] getRecordIds() {
        return recordIds;
    }
}