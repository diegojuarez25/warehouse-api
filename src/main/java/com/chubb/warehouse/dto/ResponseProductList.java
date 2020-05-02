package com.chubb.warehouse.dto;

import com.chubb.warehouse.entity.Product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ResponseProductList extends ModelDto {
    List<Product> products;
}
