package vn.iuh.edu.fit.labweek05.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.iuh.edu.fit.labweek05.backend.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
