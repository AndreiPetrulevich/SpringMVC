package ru.gb.entity;

import lombok.*;
import org.hibernate.dialect.InnoDBStorageEngine;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Manufacturer")
@NamedQueries({
        @NamedQuery(name = "Manufacturer.findAll",
        query = "select m from Manufacturer m"),
        @NamedQuery(name = "Manufacturer.findById",
        query = "select m from Manufacturer m where m.id = :id"),
        @NamedQuery(name = "Manufacturer.findNameById",
        query = "select m.name from Manufacturer m where m.id = :id")
})
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Product> products;

    public boolean addProduct(Product product) {
        if (products == null) {
            products = new HashSet<>();
        }
        return products.add(product);
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
