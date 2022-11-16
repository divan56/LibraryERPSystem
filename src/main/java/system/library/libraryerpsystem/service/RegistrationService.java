package system.library.libraryerpsystem.service;

import system.library.libraryerpsystem.dto.CustomerDto;
import system.library.libraryerpsystem.entity.Customer;

import java.rmi.NoSuchObjectException;
import java.util.UUID;

public interface RegistrationService {
    CustomerDto getCustomerDetails(UUID id) throws NoSuchObjectException;

    CustomerDto getCustomerDetailsByUsername(String username);

    CustomerDto registerNewCustomer(Customer customer);

    void deleteCustomer(UUID id);
}
