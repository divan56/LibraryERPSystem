package system.library.libraryerpsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import system.library.libraryerpsystem.dto.CustomerDto;
import system.library.libraryerpsystem.entity.Customer;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerDto customerToCustomerDto(Customer customer);
}
