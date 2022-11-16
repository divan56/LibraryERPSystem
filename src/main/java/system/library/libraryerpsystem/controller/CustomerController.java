package system.library.libraryerpsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import system.library.libraryerpsystem.dto.CustomerDto;
import system.library.libraryerpsystem.entity.Customer;
import system.library.libraryerpsystem.service.RegistrationService;

import java.rmi.NoSuchObjectException;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/id/{id}")
    public CustomerDto getCustomer(@PathVariable UUID id) throws NoSuchObjectException {
        return registrationService.getCustomerDetails(id);
    }

    @GetMapping("/{username}")
    public CustomerDto getCustomerByName(@PathVariable String username) {
        return registrationService.getCustomerDetailsByUsername(username);
    }

    @PostMapping("/")
    public CustomerDto registerNewCustomer(@RequestBody Customer customer) {
        return registrationService.registerNewCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable UUID id) {
        registrationService.deleteCustomer(id);
    }
}
