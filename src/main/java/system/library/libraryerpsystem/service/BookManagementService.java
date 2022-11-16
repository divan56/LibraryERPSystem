package system.library.libraryerpsystem.service;

import system.library.libraryerpsystem.entity.Book;
import system.library.libraryerpsystem.entity.Customer;
import system.library.libraryerpsystem.entity.Order;

import java.rmi.NoSuchObjectException;
import java.util.List;
import java.util.UUID;

public interface BookManagementService {

    Book findBookById(UUID id) throws NoSuchObjectException;

    void removeBookFromTheLibraryById(UUID id);

    void removeBookFromTheLibrary(Book book);

    List<Book> getAllBooksList();

    List<Book> getAllUnrentedBooks();

    Order createNewOrder(Book book, Customer customer, int daysToRent);

    Order completeTheOrder(Order order);

}
