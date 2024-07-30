package com.microservices.companyMS.dao;

import com.microservices.companyMS.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository <Company, Long>
{

}
