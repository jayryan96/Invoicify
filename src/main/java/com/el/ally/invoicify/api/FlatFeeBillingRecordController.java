package com.el.ally.invoicify.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.el.ally.invoicify.models.Company;
import com.el.ally.invoicify.models.FlatFeeBillingRecord;
import com.el.ally.invoicify.repositories.BillingRecordRepository;
import com.el.ally.invoicify.repositories.CompanyRepository;

@Controller
@RequestMapping("/api/billing-record/flat-fee")
public class FlatFeeBillingRecordController {

	@Autowired
	private BillingRecordRepository recordRepository;
	@Autowired
	private CompanyRepository companyRepository;

	public FlatFeeBillingRecordController(BillingRecordRepository recordRepository, CompanyRepository companyRepository) {
		this.recordRepository = recordRepository;
		this.companyRepository = companyRepository;
	}

	@PostMapping("{custId}")
	public FlatFeeBillingRecord create(@RequestBody FlatFeeBillingRecord record, @PathVariable int custId) {
		
		Company company = companyRepository.findOne(custId);
		record.setCompany(company);
		recordRepository.save(record);

		return recordRepository.save(record);
	}

}