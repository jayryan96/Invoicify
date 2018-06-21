package com.el.ally.invoicify.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.ally.invoicify.models.BillingRecord;
import com.el.ally.invoicify.repositories.BillingRecordRepository;
import com.el.ally.invoicify.repositories.CompanyRepository;

@RestController
@RequestMapping("/api/billing-record")
public class BillingRecordController {
	
	@Autowired
	private BillingRecordRepository billingRecordRepository;

	public BillingRecordController(BillingRecordRepository recordRepository, CompanyRepository companyRepository) {
		this.billingRecordRepository = recordRepository;
	}
	public BillingRecordController() {}
	
	@GetMapping
	public List<BillingRecord> list() {
		return billingRecordRepository.findAll();
	}
	
}
