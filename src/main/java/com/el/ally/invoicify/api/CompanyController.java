package com.el.ally.invoicify.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.ally.invoicify.models.Company;
import com.el.ally.invoicify.repositories.BillingRecordRepository;
import com.el.ally.invoicify.repositories.CompanyRepository;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
	
	@Autowired
	private CompanyRepository companyRepo;

	public CompanyController(BillingRecordRepository recordRepository, CompanyRepository companyRepository) {
		this.companyRepo = companyRepository;
	}
	public CompanyController() {}
	
	@GetMapping("")
	public List<Company> list() {
		return companyRepo.findAll();
	}
	@GetMapping("{id}")
	public Company getOne(@PathVariable int id) {
		return companyRepo.findOne(id);
	}
	@PostMapping("")
	public Company create(@RequestBody Company company) {
	    return companyRepo.save(company);
	}

	@PutMapping("{id}")
	public Company update(@RequestBody Company company, @PathVariable int id) {
	    company.setId(id);
	    return companyRepo.save(company);
	  }
	
	  @DeleteMapping("{id}")
	  public Company delete(@PathVariable int id) {
	    Company company = companyRepo.findOne(id);
	    companyRepo.delete(id);
	    return company;
	  }
	  
	
}
