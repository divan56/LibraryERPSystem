package system.library.libraryerpsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import system.library.libraryerpsystem.entity.Book;

import java.util.UUID;
@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
}
