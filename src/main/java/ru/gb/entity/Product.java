package ru.gb.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Product")
@NamedQueries({
        @NamedQuery(name = "Product.findAllProducts",
        query = "select p from Product p"),
        @NamedQuery(name = "Product.findProductByID",
        query = "select p from Product p where p.id = :id")
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "manufacture_date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @ManyToMany
    @JoinTable(name = "cart_product",
    joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "cart_id"))
    private Set<Cart> carts;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ", date=" + date +
                ", manufacturer=" + manufacturer.getName() +
                '}';
    }
}
