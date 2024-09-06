package com.Artemisa.Ecommerce.entities;


import com.Artemisa.Ecommerce.utils.StatesOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "status_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatusOrder {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private String id;

    @Enumerated()
    private StatesOrder state;

    @OneToMany(mappedBy = "statusOrder")
    private List<Order> purchase_order;
}
