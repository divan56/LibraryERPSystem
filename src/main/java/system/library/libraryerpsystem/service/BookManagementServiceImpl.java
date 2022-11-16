package system.library.libraryerpsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.library.libraryerpsystem.entity.Book;
import system.library.libraryerpsystem.entity.Customer;
import system.library.libraryerpsystem.entity.Order;
import system.library.libraryerpsystem.repository.BookRepository;
import system.library.libraryerpsystem.repository.OrderRepository;

import java.rmi.NoSuchObjectException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class BookManagementServiceImpl implements BookManagementService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book findBookById(UUID id) throws NoSuchObjectException {
        return bookRepository.findById(id).orElseThrow(() -> new NoSuchObjectException("There is no book with id " + id));
    }

    @Override
    public void removeBookFromTheLibraryById(UUID id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void removeBookFromTheLibrary(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public List<Book> getAllBooksList() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getAllUnrentedBooks() {
        return bookRepository.findAll().stream().filter((book) -> !book.isRented()).toList();
    }

    @Override
    public Order createNewOrder(Book book, Customer customer, int daysToRent) {
        Order order = new Order();
        order.setBook(book);
        order.setCustomer(customer);
        order.setDateOfCreation(LocalDateTime.now());
        order.setDateOfExpiration(order.getDateOfCreation().plusDays(daysToRent));
        order.setActive(true);
        return orderRepository.saveAndFlush(order);
    }

    @Override
    public Order completeTheOrder(Order order) {
        order.setActive(false);
        Book rentedBook = order.getBook();
        rentedBook.setRented(false);
        bookRepository.save(rentedBook);
        return orderRepository.saveAndFlush(order);
    }
}
