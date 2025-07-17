package work.maet.clients.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "client")
@Table(name = "client")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @JoinColumn(name = "client_id")
    private List<Address> addresses;
}
