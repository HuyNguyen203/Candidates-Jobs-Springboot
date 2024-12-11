package vn.iuh.edu.fit.labweek05.backend.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import vn.iuh.edu.fit.labweek05.backend.models.Company;
import vn.iuh.edu.fit.labweek05.backend.models.Job;

import java.util.List;

@Service
public interface CompanyService {
    Page<Company> findAll(int page, String sortField, String sortDirection);
    Company save(long id, Company company);
}
