package com.microservices.companyMS.service;


import com.microservices.companyMS.dao.CompanyRepository;
import com.microservices.companyMS.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceIMPL implements CompanyService
{
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id)
    {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if ((companyOptional.isPresent()))
        {
            Company companytoUpdate = companyOptional.get();
            companytoUpdate.setDescription(company.getDescription());
            companytoUpdate.setName(company.getName());
            companyRepository.save(companytoUpdate);
            return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company)
    {
        companyRepository.save(company);

    }

    public boolean deleteCompanyById(Long id)
    {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }
}
