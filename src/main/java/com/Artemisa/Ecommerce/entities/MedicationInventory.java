package com.riwi.Artemisa.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Entity(name = "medication_inventory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicationInventory {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private String id;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "prescribed", nullable = false)
    private boolean prescribed;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "method_use", nullable = false)
    private String methodUse;

    @Column(name = "supplier", nullable = false)
    private String supplier;


    @Column(name = "supplier_price", nullable = false)
    private float supplierPrice;

    @Column(name = "selling_price", nullable = false)
    private float sellingPrice;

    @Column(name="due_date", nullable = false)
    private Date dueDate;

    @Column(name="state_medication", nullable = false)
    private boolean stateMedication;

    @OneToMany(mappedBy="medicationInventory", fetch = FetchType.EAGER)
    private List<Medication> medication;

}
