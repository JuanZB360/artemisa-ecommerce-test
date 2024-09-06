package com.riwi.Artemisa.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private String id;

    @Column( name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(targetEntity = ProductInventory.class)
    @JoinColumn(name = "product_inventory_id")
    private ProductInventory productInventory;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id")
    private Category categoryId;

    @OneToMany(mappedBy = "productId", fetch = FetchType.LAZY)
    private List<Media> media;

    @ManyToOne(targetEntity = OrderDetails.class)
    @JoinColumn(name = "order_detail_id")
    private OrderDetails orderDetails;
}
