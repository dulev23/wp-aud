package mk.ukim.finki.wpaud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Manufacturer {

    @Id
    private Long id;

    private String name;

    private String address;

    public Manufacturer(String name, String address) {
        this.id = (long) (Math.random() * 1000);
        this.name = name;
        this.address = address;
    }
}
