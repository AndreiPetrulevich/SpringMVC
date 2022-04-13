package ru.gb.model;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    Integer id;
    String title;
    BigDecimal cost;
}
