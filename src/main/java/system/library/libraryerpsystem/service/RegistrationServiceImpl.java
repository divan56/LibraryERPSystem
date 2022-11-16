package system.library.libraryerpsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.library.libraryerpsystem.dto.CustomerDto;
import system.library.libraryerpsystem.entity.Customer;
import system.library.libraryerpsystem.mapper.CustomerMapper;
import system.library.libraryerpsystem.repository.CustomerRepository;

import java.rmi.NoSuchObjectException;
import java.util.UUID;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDto getCustomerDetails(UUID id) throws NoSuchObjectException {
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new NoSuchObjectException("No customer with id " + id));
        return CustomerMapper.INSTANCE.customerToCustomerDto(customer);
    }

    @Override
    public CustomerDto getCustomerDetailsByUsername(String username) {
        Customer customer = customerRepository.findByUsername(username);
        return CustomerMapper.INSTANCE.customerToCustomerDto(customer);
    }

    @Override
    public CustomerDto registerNewCustomer(Customer customer) {
        customer = customerRepository.saveAndFlush(customer);
        return CustomerMapper.INSTANCE.customerToCustomerDto(customer);
    }

    @Override
    public void deleteCustomer(UUID id) {
        customerRepository.deleteById(id);
    }
}
