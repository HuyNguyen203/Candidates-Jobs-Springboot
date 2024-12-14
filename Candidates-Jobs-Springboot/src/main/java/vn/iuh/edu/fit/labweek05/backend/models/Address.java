package vn.iuh.edu.fit.labweek05.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "street", length = 150)
    private String street;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "number", length = 100)
    private String number;

    @Column(name = "zipcode", length = 7)
    private String zipcode;

    public Address(String city, String country, String street, String number, String zipcode) {
        this.city = city;
        this.country = country;
        this.street = street;
        this.number = number;
        this.zipcode = zipcode;
    }
}