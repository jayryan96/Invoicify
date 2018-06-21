package com.el.ally.invoicify.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.el.ally.invoicify.models.Company;
import com.el.ally.invoicify.models.RateBasedBillingRecord;
import com.el.ally.invoicify.repositories.BillingRecordRepository;
import com.el.ally.invoicify.repositories.CompanyRepository;

@Controller
@RequestMapping("/api/billing-record/rate-based")
public class RateBasedBillingRecordController {

	private BillingRecordRepository recordRepository;
	private CompanyRepository companyRepository;

	public RateBasedBillingRecordController(BillingRecordRepository recordRepository, CompanyRepository companyRepository) {
		this.recordRepository = recordRepository;
		this.companyRepository = companyRepository;
	}
	public RateBasedBillingRecordController() {}
	
	@PostMapping()
	public RateBasedBillingRecord create(RateBasedBillingRecord record, int companyID) {
		Company company = companyRepository.findOne(companyID);
		record.setCompany(company);

		return recordRepository.save(record);
	}

}
