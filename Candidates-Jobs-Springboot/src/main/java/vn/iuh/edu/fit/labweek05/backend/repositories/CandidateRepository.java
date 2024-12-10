package vn.iuh.edu.fit.labweek05.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.iuh.edu.fit.labweek05.backend.models.Candidate;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    List<Candidate> findAll();
    Candidate findById(long id);
    Candidate save(Candidate candidate);


}
