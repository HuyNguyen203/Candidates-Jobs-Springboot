package vn.iuh.edu.fit.labweek05.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.iuh.edu.fit.labweek05.backend.models.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
