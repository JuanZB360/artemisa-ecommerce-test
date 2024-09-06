package com.riwi.Artemisa.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "order_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private String id;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "unit_price", nullable = false)
    private float unitPrice;

    @Column(name = "total_price_product", nullable = false)
    private float totalPriceProduct;

    @OneToMany(mappedBy = "orderDetails", fetch = FetchType.LAZY)
    private List<Product> products;

    @OneToMany(mappedBy = "orderDetails", fetch = FetchType.LAZY)
    private List<Medication> medications;

    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name = "purchase_order")
    private Order purchase_order;

}
