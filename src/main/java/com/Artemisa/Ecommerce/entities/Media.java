package com.riwi.Artemisa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "media")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Media {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private String id;

    @Column (name = "url", nullable = false)
    private String url;

    @Column ( name = "type", nullable = false)
    private String type;

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "product_id")
    private Product productId;

    @ManyToOne(targetEntity = Medication.class)
    @JoinColumn(name = "medication_id")
    private Medication medication;

}
