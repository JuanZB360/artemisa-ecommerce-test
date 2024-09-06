package com.riwi.Artemisa.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "medication")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Medication {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "medication", fetch = FetchType.LAZY)
    private List<Media> medias;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id")
    private Category categoryId;

    @ManyToOne(targetEntity = MedicationInventory.class)
    @JoinColumn(name = "medication_inventory")
    private MedicationInventory medicationInventory;

    @ManyToOne(targetEntity = OrderDetails.class)
    @JoinColumn(name = "order_detail_id")
    private OrderDetails orderDetails;

}
