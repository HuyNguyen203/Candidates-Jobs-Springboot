package vn.iuh.edu.fit.labweek05.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.iuh.edu.fit.labweek05.backend.models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
