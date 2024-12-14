package vn.iuh.edu.fit.labweek05.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import vn.iuh.edu.fit.labweek05.backend.models.Candidate;
import vn.iuh.edu.fit.labweek05.backend.models.Company;
import vn.iuh.edu.fit.labweek05.backend.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByCandidate(Candidate candidate);
    User findByCompany(Company company);
}
