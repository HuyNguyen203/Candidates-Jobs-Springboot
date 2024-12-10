package vn.iuh.edu.fit.labweek05.backend.services;

import org.springframework.stereotype.Service;
import vn.iuh.edu.fit.labweek05.backend.models.Company;

@Service
public interface CompanyService {
    public Company addCompany(Company company);
}
