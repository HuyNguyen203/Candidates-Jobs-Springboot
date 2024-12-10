package vn.iuh.edu.fit.labweek05.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.iuh.edu.fit.labweek05.backend.models.Company;
import vn.iuh.edu.fit.labweek05.backend.repositories.CompanyRepository;
import vn.iuh.edu.fit.labweek05.backend.services.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }
}
