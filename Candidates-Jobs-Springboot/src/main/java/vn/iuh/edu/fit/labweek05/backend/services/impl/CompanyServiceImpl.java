package vn.iuh.edu.fit.labweek05.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.iuh.edu.fit.labweek05.backend.models.Company;
import vn.iuh.edu.fit.labweek05.backend.models.Job;
import vn.iuh.edu.fit.labweek05.backend.repositories.CompanyRepository;
import vn.iuh.edu.fit.labweek05.backend.services.CompanyService;

import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Page<Company> findAll(int page, String sortField, String sortDirection) {
        Sort sort = Sort.by(sortField);
        sort = sortDirection.equalsIgnoreCase("asc") ? sort.ascending() : sort.descending();

        Pageable pageable = PageRequest.of(page, 10, sort);
        return companyRepository.findAll(pageable);
    }

    @Override
    public Company save(long id, Company companyDetails) {
        Optional<Company> company = companyRepository.findById(id);
        Company newCompany = company.get();
        if(company != null){
            newCompany.setId(id);
            newCompany.setAbout(companyDetails.getAbout());
            newCompany.setPhone(companyDetails.getPhone());
            newCompany.setCompName(companyDetails.getCompName());
            newCompany.setWebUrl(companyDetails.getWebUrl());
            newCompany.setAddress(companyDetails.getAddress());

            return companyRepository.save(newCompany);
        }
        return null;
    }
}
