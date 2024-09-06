package com.riwi.Artemisa.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Entity(name = "purchase_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private String id;

    @Column(name = "order_date", nullable = false)
    private Date orderDate;

    @Column(name = "total_order", nullable = false)
    private float totalOrder;

    @OneToMany(mappedBy = "purchase_order", fetch = FetchType.EAGER)
    private List<OrderDetails> orderDetails;

    @ManyToOne(targetEntity = PetshopPayments.class)
    @JoinColumn(name = "petshop_payments")
    private PetshopPayments petshopPayments;

    @ManyToOne(targetEntity = StatusOrder.class)
    @JoinColumn(name = "status_order")
    private StatusOrder statusOrder;

}
