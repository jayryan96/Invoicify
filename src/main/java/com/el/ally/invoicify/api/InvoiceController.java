package com.el.ally.invoicify.api;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.ally.invoicify.models.BillingRecord;
import com.el.ally.invoicify.models.Invoice;
import com.el.ally.invoicify.models.InvoiceLineItem;
import com.el.ally.invoicify.models.InvoiceView;
import com.el.ally.invoicify.repositories.BillingRecordRepository;
import com.el.ally.invoicify.repositories.CompanyRepository;
import com.el.ally.invoicify.repositories.InvoiceRepository;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {
    
    @Autowired
    private BillingRecordRepository recordRepository;
    
    @Autowired
    private InvoiceRepository invoiceRepository;
    
    @Autowired
    private CompanyRepository companyRepository;
    
    public InvoiceController(BillingRecordRepository recordRepository, InvoiceRepository invoiceRepository,
			CompanyRepository companyRepository) {
		this.recordRepository = recordRepository;
		this.invoiceRepository = invoiceRepository;
		this.companyRepository = companyRepository;
	}
    
    public InvoiceController() {}
    

	@PostMapping("{clientId}")
    public Invoice createInvoice(@RequestBody InvoiceView invoiceView, @PathVariable int clientId) {
        List<BillingRecord> records = recordRepository.findByIdIn(invoiceView.getRecordIds());
        long nowish = Calendar.getInstance().getTimeInMillis();
        Date now = new Date(nowish);
        Invoice invoice = new Invoice();
        invoice.setInvoiceDescription(invoiceView.getInvoiceDescription());
        
        List<InvoiceLineItem> items = new ArrayList<InvoiceLineItem>();
        for (BillingRecord record : records) {
            InvoiceLineItem lineItem = new InvoiceLineItem();
            lineItem.setBillingRecord(record);
            lineItem.setCreatedOn(now);
            lineItem.setInvoice(invoice);
            items.add(lineItem);
        }
        
        invoice.setLineItems(items);

        invoice.setCreatedOn(now);
        invoice.setCompany(companyRepository.findOne(clientId));
        
        return invoiceRepository.save(invoice);
    }
    

    @GetMapping
    public List<Invoice> list() {
        return invoiceRepository.findAll();
    }
    
}
