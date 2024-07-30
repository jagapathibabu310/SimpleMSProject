package com.microservices.companyMS.service;


import com.microservices.companyMS.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService
{
    List<Company> getAllCompanies();
    boolean updateCompany(Company company, Long id);
    void createCompany(Company company);

    boolean deleteCompanyById(Long id);

    Company getCompanyById(Long id);
}
