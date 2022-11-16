package system.library.libraryerpsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue()
    @Column(name = "id")
    private UUID id;

    @Column(name = "username")
    private String username;

    @Email
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "telegram_username", unique = true)
    private String telegramUsername;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

}
