package vn.iuh.edu.fit.labweek05.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.iuh.edu.fit.labweek05.backend.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Address save(Address address);
}
