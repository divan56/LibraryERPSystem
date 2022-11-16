package system.library.libraryerpsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import system.library.libraryerpsystem.enums.BookGenre;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue()
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "author_name")
    private String authorName;

    @ElementCollection(targetClass = BookGenre.class)
    @Enumerated(EnumType.STRING)
    @Column(name = "genres")
    private List<BookGenre> genres;

    @Column(name = "is_rented")
    private boolean isRented;

}
