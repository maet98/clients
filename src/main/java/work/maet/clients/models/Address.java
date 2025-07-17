package work.maet.clients.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    private String line1;
    private String line2;
    private String city;
    private String province;
    private String postalCode;
    private String country;
}
