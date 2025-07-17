package work.maet.clients.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@Builder
public class Client {
    @Id
    @GeneratedValue
    private long id;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String nationalId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;
}
