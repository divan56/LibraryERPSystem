package system.library.libraryerpsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import system.library.libraryerpsystem.entity.Customer;

import java.util.UUID;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    Customer findByUsername(String Username);

}
