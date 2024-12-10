package vn.iuh.edu.fit.labweek05.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.iuh.edu.fit.labweek05.backend.repositories.AddressRepository;
import vn.iuh.edu.fit.labweek05.backend.services.AddressServices;
import vn.iuh.edu.fit.labweek05.backend.models.Address;

@Service
public class AddressServiceImpl implements AddressServices {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }
}
