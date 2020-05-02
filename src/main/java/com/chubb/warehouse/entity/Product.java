package com.chubb.warehouse.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name="TBL_PRODUCT")
@Data
@NoArgsConstructor
public class Product {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="ITEM_NO")
    Long itemNo;
    @Column(name="NAME")
    String name;
    @Column(name="AMOUNT")
    Long amount;
    @Column(name="INVENTORY_CODE")
    Long inventoryCode;

    public Product(Product product) {
    }
}
